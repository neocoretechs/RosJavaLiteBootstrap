package org.ros.internal.message.context;

import org.ros.internal.message.field.FieldFactory;
import org.ros.message.MessageDeclaration;
import org.ros.message.MessageFactory;
import org.ros.message.MessageIdentifier;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Encapsulates the immutable metadata that describes a message type.
 * <p>
 * Note that this class is not thread safe.
 * 
 * @author Jonathan Groff Copyright (C) NeoCoreTechs 2015,2021
 */
public class MessageContext implements Serializable {
  private static final long serialVersionUID = 3890864036659598629L;
  private  MessageDeclaration messageDeclaration;
  private transient MessageFactory messageFactory;
  private transient Map<String, FieldFactory> fieldFactories;
  private  Map<String, String> fieldGetterNames;
  private  Map<String, String> fieldSetterNames;
  private  List<String> fieldNames;
  public MessageContext() {}
  public MessageContext(MessageDeclaration messageDeclaration, MessageFactory messageFactory) {
    this.messageDeclaration = messageDeclaration;
    this.messageFactory = messageFactory;
    this.fieldFactories = new HashMap<String, FieldFactory>();
    this.fieldGetterNames = new HashMap<String, String>();
    this.fieldSetterNames = new HashMap<String, String>();
    this.fieldNames = new ArrayList<String>();
  }

  public MessageFactory getMessageFactory() {
    return messageFactory;
  }

  public MessageIdentifier getMessageIdentifer() {
    return messageDeclaration.getMessageIdentifier();
  }

  public String getType() {
    return messageDeclaration.getType();
  }

  public String getPackage() {
    return messageDeclaration.getPackage();
  }

  public String getName() {
    return messageDeclaration.getName();
  }

  public String getDefinition() {
    return messageDeclaration.getDefinition();
  }

  public void addFieldFactory(String name, FieldFactory fieldFactory) {
    fieldFactories.put(name, fieldFactory);
    fieldGetterNames.put(name, "get" + getJavaName(name));
    fieldSetterNames.put(name, "set" + getJavaName(name));
    fieldNames.add(name);
  }

  private String getJavaName(String name) {
    String[] parts = name.split("_");
    StringBuilder fieldName = new StringBuilder();
    for (String part : parts) {
      fieldName.append(part.substring(0, 1).toUpperCase() + part.substring(1));
    }
    return fieldName.toString();
  }

  public boolean hasField(String name) {
    // O(1) instead of an O(n) check against the list of field names.
    return fieldFactories.containsKey(name);
  }

  public String getFieldGetterName(String name) {
    return fieldGetterNames.get(name);
  }

  public String getFieldSetterName(String name) {
    return fieldSetterNames.get(name);
  }

  public FieldFactory getFieldFactory(String name) {
    return fieldFactories.get(name);
  }

  /**
   * @return a {@link List} of field names in the order they were added
   */
  public List<String> getFieldNames() {
    return Collections.unmodifiableList(fieldNames);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((messageDeclaration == null) ? 0 : messageDeclaration.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    MessageContext other = (MessageContext) obj;
    if (messageDeclaration == null) {
      if (other.messageDeclaration != null)
        return false;
    } else if (!messageDeclaration.equals(other.messageDeclaration))
      return false;
    return true;
  }
}
