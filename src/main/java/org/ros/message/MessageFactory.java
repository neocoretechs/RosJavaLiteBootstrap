
package org.ros.message;

/**
 * @author Jonathan Groff Copyright (C) NeoCoreTechs 2015,2021
 */
public interface MessageFactory {

  /**
   * @param messageType the type of message to create
   * @return a new message of the stated type
   */
  <T> T newFromType(String messageType);
}
