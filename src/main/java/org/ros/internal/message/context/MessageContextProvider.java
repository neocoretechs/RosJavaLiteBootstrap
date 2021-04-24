package org.ros.internal.message.context;

import org.ros.internal.message.definition.MessageDefinitionParser;
import org.ros.internal.message.definition.MessageDefinitionParser.MessageDefinitionVisitor;
import org.ros.message.MessageDeclaration;
import org.ros.message.MessageFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Jonathan Groff Copyright (C) NeoCoreTechs 2015,2021
 */
public class MessageContextProvider {

  private final Map<MessageDeclaration, MessageContext> cache;
  private final MessageFactory messageFactory;

  public MessageContextProvider(MessageFactory messageFactory) {
    assert(messageFactory != null);
    this.messageFactory = messageFactory;
    cache = new ConcurrentHashMap<MessageDeclaration, MessageContext>();
  }

  public MessageContext get(MessageDeclaration messageDeclaration) {
    MessageContext messageContext = cache.get(messageDeclaration);
    if (messageContext == null) {
      messageContext = new MessageContext(messageDeclaration, messageFactory);
      MessageDefinitionVisitor visitor = new MessageContextBuilder(messageContext);
      MessageDefinitionParser messageDefinitionParser = new MessageDefinitionParser(visitor);
      messageDefinitionParser.parse(messageDeclaration.getType(),
          messageDeclaration.getDefinition());
      cache.put(messageDeclaration, messageContext);
    }
    return messageContext;
  }
}
