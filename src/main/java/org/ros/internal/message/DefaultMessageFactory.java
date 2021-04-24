package org.ros.internal.message;

import org.ros.message.MessageDeclaration;
import org.ros.message.MessageDefinitionProvider;
import org.ros.message.MessageFactory;

/**
 * @author Jonathan Groff Copyright (C) NeoCoreTechs 2015,2021
 */
public class DefaultMessageFactory implements MessageFactory {

  private final MessageDefinitionProvider messageDefinitionProvider;
  private final MessageProxyFactory messageProxyFactory;

  public DefaultMessageFactory(MessageDefinitionProvider messageDefinitionProvider) {
    this.messageDefinitionProvider = messageDefinitionProvider;
 
    messageProxyFactory = new MessageProxyFactory(this);
  }

  @Override
  public <T> T newFromType(String messageType) {
    String messageDefinition = messageDefinitionProvider.get(messageType);
    MessageDeclaration messageDeclaration = MessageDeclaration.of(messageType, messageDefinition);
    return messageProxyFactory.newMessageProxy(messageDeclaration);
  }

  

}
