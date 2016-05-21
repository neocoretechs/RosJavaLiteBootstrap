package org.ros.internal.message;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * Provides ByteBuffers for serializing and deserializing messages.
 */

public class MessageBuffers {

  static final int ESTIMATED_LENGTH = 256;

  private MessageBuffers() {
    // Utility class.
  }

  /**
   * @return a new {@link ChannelBuffer} for {@link Message} serialization that
   *         grows dynamically
   */
  public static ByteBuffer dynamicBuffer() {
	 ByteBuffer bb =  ByteBuffer.allocate(ESTIMATED_LENGTH);
	 return bb.order(ByteOrder.LITTLE_ENDIAN);
     //return ChannelBuffers.dynamicBuffer(ByteOrder.LITTLE_ENDIAN, ESTIMATED_LENGTH);
  }
}
