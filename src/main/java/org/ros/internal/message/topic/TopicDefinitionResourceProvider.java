package org.ros.internal.message.topic;

import org.ros.internal.message.StringResourceProvider;
import org.ros.message.MessageDefinitionProvider;
import org.ros.message.MessageIdentifier;

import java.util.Collection;

/**
 * @author Jonathan Groff Copyright (C) NeoCoreTechs 2015,2021
 */
public class TopicDefinitionResourceProvider implements MessageDefinitionProvider {

  private final StringResourceProvider stringResourceProvider;

  public TopicDefinitionResourceProvider() {
    stringResourceProvider = new StringResourceProvider();
  }

  private String topicTypeToResourceName(String topicType) {
    MessageIdentifier messageIdentifier = MessageIdentifier.of(topicType);
    return String.format("/%s/msg/%s.msg", messageIdentifier.getPackage(),
        messageIdentifier.getName());
  }

  @Override
  public String get(String topicType) {
    return stringResourceProvider.get(topicTypeToResourceName(topicType));
  }

  @Override
  public boolean has(String topicType) {
    return stringResourceProvider.has(topicTypeToResourceName(topicType));
  }


  public void add(String topicType, String topicDefinition) {
    stringResourceProvider.addStringToCache(topicTypeToResourceName(topicType), topicDefinition);
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
