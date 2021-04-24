package org.ros.message;

import java.util.Collection;

/**
 * @author Jonathan Groff Copyright (C) NeoCoreTechs 2015,2021
 */
public interface MessageDefinitionProvider {

  /**
   * @param messageType the type of message definition to provide
   * @return the message definition for the specified type
   */
  String get(String messageType);

  /**
   * @param messageType  the type of message definition to provide
   * @return {@code true} if the definition for the specified type is available, {@code false} otherwise
   */
  boolean has(String messageType);

  Collection<String> getPackages();

  /**
   * @param pkg the name of the package to filter
   * @return the {@link MessageIdentifier}s for all messages defined in the specified package
   */
  Collection<MessageIdentifier> getMessageIdentifiersByPackage(String pkg);
}
