package org.ros.internal.message.service;

import org.ros.internal.message.DefaultMessageFactory;
import org.ros.internal.message.MessageProxyFactory;
import org.ros.message.MessageDeclaration;
import org.ros.message.MessageDefinitionProvider;
import org.ros.message.MessageFactory;

/**
 * @author Jonathan Groff Copyright (C) NeoCoreTechs 2015,2021
 */
public class ServiceResponseMessageFactory implements MessageFactory {

  private final ServiceDescriptionFactory serviceDescriptionFactory;
  private final MessageFactory messageFactory;
  private final MessageProxyFactory messageProxyFactory;

  public ServiceResponseMessageFactory(MessageDefinitionProvider messageDefinitionProvider) {
    serviceDescriptionFactory = new ServiceDescriptionFactory(messageDefinitionProvider);
    messageFactory = new DefaultMessageFactory(messageDefinitionProvider);
    messageProxyFactory =
        new MessageProxyFactory(messageFactory);
  }

  @Override
  public <T> T newFromType(String serviceType) {
    ServiceDescription serviceDescription = serviceDescriptionFactory.newFromType(serviceType);
    MessageDeclaration messageDeclaration =
        MessageDeclaration.of(serviceDescription.getResponseType(),
            serviceDescription.getResponseDefinition());
    return messageProxyFactory.newMessageProxy(messageDeclaration);
  }
}
