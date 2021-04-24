
package org.ros.internal.message.topic;

import org.ros.internal.message.Md5Generator;
import org.ros.message.MessageDefinitionProvider;

/**
 * @author Jonathan Groff Copyright (C) NeoCoreTechs 2015,2021
 */
public class TopicDescriptionFactory {

  private final MessageDefinitionProvider messageDefinitionProvider;
  private final Md5Generator md5Generator;

  public TopicDescriptionFactory(MessageDefinitionProvider messageDefinitionProvider) {
    this.messageDefinitionProvider = messageDefinitionProvider;
    md5Generator = new Md5Generator(messageDefinitionProvider);
  }

  public TopicDescription newFromType(String topicType) {
    String md5Checksum = md5Generator.generate(topicType);
    String topicDefinition = messageDefinitionProvider.get(topicType);
    return new TopicDescription(topicType, topicDefinition, md5Checksum);
  }

  public boolean hasType(String topicType) {
    return messageDefinitionProvider.has(topicType);
  }
}
