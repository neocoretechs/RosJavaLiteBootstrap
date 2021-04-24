package org.ros.message;

/**
 * A callback for asynchronous message-related operations.
 * 
 * @author Jonathan Groff Copyright (C) NeoCoreTechs 2015,2021
 * 
 * @param <T> the type of message 
 */
public interface MessageListener<T> {

  /**
   * Called when a new message arrives.
   * 
   * @param message the new message
   */
  void onNewMessage(T message);
}