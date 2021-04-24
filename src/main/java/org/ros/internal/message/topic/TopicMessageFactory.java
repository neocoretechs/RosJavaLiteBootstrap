package org.ros.internal.message.topic;

import org.ros.internal.message.DefaultMessageFactory;
import org.ros.message.MessageDefinitionProvider;

/**
 * @author Jonathan Groff Copyright (C) NeoCoreTechs 2015,2021
 */
public class TopicMessageFactory extends DefaultMessageFactory {

  public TopicMessageFactory(MessageDefinitionProvider messageDefinitionProvider) {
    super(messageDefinitionProvider);
  }
}
