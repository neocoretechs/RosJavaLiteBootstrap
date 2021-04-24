package org.ros.internal.message.service;

import org.ros.internal.message.StringResourceProvider;
import org.ros.message.MessageDefinitionProvider;
import org.ros.message.MessageIdentifier;

import java.util.Collection;

/**
 * @author Jonathan Groff Copyright (C) NeoCoreTechs 2015,2021
 */
public class ServiceDefinitionResourceProvider implements MessageDefinitionProvider {

  private final StringResourceProvider stringResourceProvider;

  public ServiceDefinitionResourceProvider() {
    stringResourceProvider = new StringResourceProvider();
  }

  private String serviceTypeToResourceName(String serviceType) {
    assert(serviceType.contains("/")) : "Service type must be fully qualified: "+ serviceType;
    String[] packageAndType = serviceType.split("/", 2);
    return String.format("/%s/srv/%s.srv", packageAndType[0], packageAndType[1]);
  }

  @Override
  public String get(String serviceType) {
    return stringResourceProvider.get(serviceTypeToResourceName(serviceType));
  }

  @Override
  public boolean has(String serviceType) {
    return stringResourceProvider.has(serviceTypeToResourceName(serviceType));
  }

  public void add(String serviceType, String serviceDefinition) {
    stringResourceProvider.addStringToCache(serviceTypeToResourceName(serviceType),
        serviceDefinition);
  }

  @Override
  public Collection<String> getPackages() {
    throw new UnsupportedOperationException();
  }

  @Override
  public Collection<MessageIdentifier> getMessageIdentifiersByPackage(String pkg) {
    throw new UnsupportedOperationException();
  }
}
