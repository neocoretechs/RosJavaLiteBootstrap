package org.ros.internal.message.service;

import org.ros.internal.message.Md5Generator;
import org.ros.message.MessageDefinitionProvider;

/**
 * @author Jonathan Groff Copyright (C) NeoCoreTechs 2015,2021
 */
public class ServiceDescriptionFactory {

  private final MessageDefinitionProvider messageDefinitionProvider;
  private final Md5Generator md5Generator;

  public ServiceDescriptionFactory(MessageDefinitionProvider messageDefinitionProvider) {
    this.messageDefinitionProvider = messageDefinitionProvider;
    md5Generator = new Md5Generator(messageDefinitionProvider);
  }

  public ServiceDescription newFromType(String serviceType) {
    String serviceDefinition = messageDefinitionProvider.get(serviceType);
    String md5Checksum = md5Generator.generate(serviceType);
    return new ServiceDescription(serviceType, serviceDefinition, md5Checksum);
  }

  public boolean hasType(String serviceType) {
    return messageDefinitionProvider.has(serviceType);
  }
}
