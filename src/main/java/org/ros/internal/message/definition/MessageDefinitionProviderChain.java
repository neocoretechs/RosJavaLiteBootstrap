package org.ros.internal.message.definition;

import org.ros.message.MessageDefinitionProvider;
import org.ros.message.MessageIdentifier;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * @author Jonathan Groff Copyright (C) NeoCoreTechs 2015,2021
 */
public class MessageDefinitionProviderChain implements MessageDefinitionProvider {

  private final Collection<MessageDefinitionProvider> messageDefinitionProviders;

  public MessageDefinitionProviderChain() {
    messageDefinitionProviders = new ArrayList<MessageDefinitionProvider>();
  }

  public void addMessageDefinitionProvider(MessageDefinitionProvider messageDefinitionProvider) {
    messageDefinitionProviders.add(messageDefinitionProvider);
  }

  @Override
  public String get(String messageType) {
    for (MessageDefinitionProvider messageDefinitionProvider : messageDefinitionProviders) {
      if (messageDefinitionProvider.has(messageType)) {
        return messageDefinitionProvider.get(messageType);
      }
    }
    throw new NoSuchElementException("No message definition available for: " + messageType);
  }

  @Override
  public boolean has(String messageType) {
    for (MessageDefinitionProvider messageDefinitionProvider : messageDefinitionProviders) {
      if (messageDefinitionProvider.has(messageType)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public Collection<String> getPackages() {
    Set<String> result = new HashSet<String>();
    for (MessageDefinitionProvider messageDefinitionProvider : messageDefinitionProviders) {
      Collection<String> packages = messageDefinitionProvider.getPackages();
      result.addAll(packages);
    }
    return result;
  }

  @Override
  public Collection<MessageIdentifier> getMessageIdentifiersByPackage(String pkg) {
    Set<MessageIdentifier> result = new HashSet<MessageIdentifier>();
    for (MessageDefinitionProvider messageDefinitionProvider : messageDefinitionProviders) {
      Collection<MessageIdentifier> messageIdentifiers =
          messageDefinitionProvider.getMessageIdentifiersByPackage(pkg);
      if (messageIdentifiers != null) {
        result.addAll(messageIdentifiers);
      }
    }
    return result;
  }
}
