package org.ros.internal.message;


import org.ros.internal.message.definition.MessageDefinitionParser;
import org.ros.internal.message.definition.MessageDefinitionTupleParser;
import org.ros.internal.message.definition.MessageDefinitionParser.MessageDefinitionVisitor;
//import org.apache.commons.codec.digest.DigestUtils;
import org.ros.internal.message.field.PrimitiveFieldType;
import org.ros.message.MessageDefinitionProvider;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jonathan Groff Copyright (C) NeoCoreTechs 2015,2021
 */
public class Md5Generator {

  private final MessageDefinitionProvider messageDefinitionProvider;

  public Md5Generator(MessageDefinitionProvider messageDefinitionProvider) {
    this.messageDefinitionProvider = messageDefinitionProvider;
  }

  public String generate(String messageType) {
    String messageDefinition = messageDefinitionProvider.get(messageType);
    assert(messageDefinition != null) : "No definition for message type: " + messageType;
    List<String> parts = MessageDefinitionTupleParser.parse(messageDefinition, -1);
    StringBuilder text = new StringBuilder();
    for (String part : parts) {
      text.append(generateText(messageType, part));
    }
	MessageDigest md = null;
	try {
		md = MessageDigest.getInstance("MD5");
	} catch (NoSuchAlgorithmException e) {
	}
	md.update(text.toString().getBytes());
	byte[] thedigest = md.digest();
	StringBuilder sb = new StringBuilder();
    for (byte b : thedigest) {
        sb.append(String.format("%02X", b));
    }
	return sb.toString();
    //return DigestUtils.md5Hex(text.toString());
  }

  private String generateText(String messageType, String messageDefinition) {
    final List<String> constants = new ArrayList<String>();
    final List<String> variables = new ArrayList<String>();
    MessageDefinitionVisitor visitor = new MessageDefinitionVisitor() {
      @Override
      public void variableValue(String type, String name) {
        if (!PrimitiveFieldType.existsFor(type)) {
          type = generate(type);
        }
        variables.add(String.format("%s %s\n", type, name));
      }

      @Override
      public void variableList(String type, int size, String name) {
        if (!PrimitiveFieldType.existsFor(type)) {
          String md5Checksum = generate(type);
          variables.add(String.format("%s %s\n", md5Checksum, name));
        } else {
          if (size != -1) {
            variables.add(String.format("%s[%d] %s\n", type, size, name));
          } else {
            variables.add(String.format("%s[] %s\n", type, name));
          }
        }
      }

      @Override
      public void constantValue(String type, String name, String value) {
        constants.add(String.format("%s %s=%s\n", type, name, value));
      }
    };
    MessageDefinitionParser messageDefinitionParser = new MessageDefinitionParser(visitor);
    messageDefinitionParser.parse(messageType, messageDefinition);
    String text = "";
    for (String constant : constants) {
      text += constant;
    }
    for (String variable : variables) {
      text += variable;
    }
    return text.trim();
  }
}
