package org.ros.internal.message;
import java.nio.ByteBuffer;
public class ByteBufferPool extends AbstractBufferPool<ByteBuffer> {

	public ByteBufferPool() {}
	  @Override
	    protected ByteBuffer allocate(int capacity) {
	        return ByteBuffer.allocate(capacity);
	    }

	    /**
	     * {@inheritDoc}
	     *
	     * @throws IllegalArgumentException if {@code buffer} is direct.
	     */
	    @Override
	    public void give(ByteBuffer buffer) {
	        if (buffer.isDirect()) {
	            throw new IllegalArgumentException("A direct ByteBuffer cannot be given to a ByteBufferPool!");
	        }
	        
	        super.give(buffer);
	    }
}
