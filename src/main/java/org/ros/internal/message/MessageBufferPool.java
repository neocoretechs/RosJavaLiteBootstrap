package org.ros.internal.message;

import java.nio.ByteBuffer;

import org.apache.commons.pool.ObjectPool;
import org.apache.commons.pool.PoolableObjectFactory;
import org.apache.commons.pool.impl.StackObjectPool;
import org.ros.exception.RosRuntimeException;

/**
 * A pool of {@link ByteBuffer}s for serializing and deserializing messages.
 * <p>
 * By contract, {@link ByteBuffer}s provided by {@link #acquire()} must be
 * returned using {@link #release(ByteBuffer)}.
 * 
 * @author jg
 */
public class MessageBufferPool {

  private final ObjectPool<ByteBuffer> pool;

  public MessageBufferPool() {
	  
    pool = new StackObjectPool<ByteBuffer>(new PoolableObjectFactory<ByteBuffer>() {
      @Override
      public ByteBuffer makeObject() throws Exception {
        return MessageBuffers.dynamicBuffer();
      }

      @Override
      public void destroyObject(ByteBuffer channelBuffer) throws Exception {
      }

      @Override
      public boolean validateObject(ByteBuffer channelBuffer) {
        return true;
      }

      @Override
      public void activateObject(ByteBuffer channelBuffer) throws Exception {
      }

      @Override
      public void passivateObject(ByteBuffer channelBuffer) throws Exception {
        channelBuffer.clear();
      }
    });
    
	 
  }

  /**
   * Acquired {@link ByteBuf}s must be returned using
   * {@link #release(ByteBuf)}.
   * 
   * @return an unused {@link ByteBuf}
   */
  public ByteBuffer acquire() {
    try {
      return pool.borrowObject();   	
    } catch (Exception e) {
      throw new RosRuntimeException(e);
    }
  }

  /**
   * Release a previously acquired {@link ByteBuffer}.
   * 
   * @param channelBuffer
   *          the {@link ByteBuffer} to release
   */
  public void release(ByteBuffer channelBuffer) {
    try {
      pool.returnObject(channelBuffer);  	
    } catch (Exception e) {
      throw new RosRuntimeException(e);
    }
  }
}
