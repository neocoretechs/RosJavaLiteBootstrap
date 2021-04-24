package org.ros.internal.message;

import java.nio.ByteBuffer;

/**
 * Provides ByteBuffers for serializing and deserializing messages.
 * @author Jonathan Groff Copyright (C) NeoCoreTechs 2015,2021
 */

public class MessageBuffers {
  static final int ESTIMATED_LENGTH = 4096000;
  private volatile static MessageBuffers instance;
  private ByteBufferPool bufferPool = null;
  public static MessageBuffers getInstance() { 
    if(instance == null) {
    	synchronized(MessageBuffers.class){ 
    		if(instance == null) {
    			instance = new MessageBuffers();
    		}
    	}
    }
    return instance;
  }
  private MessageBuffers() { bufferPool = new ByteBufferPool(); }
  public ByteBufferPool getbufferPool() { return bufferPool; }
  /**
   * @return a new {@link ByteBuffer} for {@link Message} serialization
   */
  public static ByteBuffer dynamicBuffer() {
	  return getInstance().getbufferPool().take(ESTIMATED_LENGTH);
	 //return ByteBuffer.allocate(ESTIMATED_LENGTH);
	 //return bb.order(ByteOrder.LITTLE_ENDIAN);
  }
  
  public static void returnBuffer(ByteBuffer b) {
	  getInstance().getbufferPool().give(b);
  }
}
