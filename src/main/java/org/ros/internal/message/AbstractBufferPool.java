package org.ros.internal.message;
import java.nio.Buffer;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NavigableMap;
import java.util.Objects;
import java.util.Optional;
import java.util.TreeMap;
/**
 * Abstraction of BufferPool for various functions such as ByteBuffer.
 * JAva 8 compatibility required at this crosscut.
 * @author Jonathan Groff Copyright (C) NeoCoreTechs 2015,2021
 *
 * @param <T> Buffer type
 */
public abstract class AbstractBufferPool<T extends Buffer> {

	public AbstractBufferPool() {}
	
	/**
     * A heuristic used for the initial capacity of the backing {@link Deque deques}.
     */
    private static final int HEURISTIC = 3;

    /**
     * The data structure that holds all pooled {@link T buffers}.
     */
    private final NavigableMap<Integer, Deque<T>> buffers = new TreeMap<>();
    
    /**
     * An {@code abstract} method that allocates a new {@link T buffer} with the specified capacity.
     *
     * @param capacity the capacity of the buffer to create.
     * @return a newly-allocated buffer.
     */
    protected abstract T allocate(int capacity);
    
    /**
     * Attempts to take a {@link T buffer} from this {@link AbstractBufferPool<T> pool}.
     * <br><br>
     * If no buffer can be found (with a capacity of at-least {@code capacity}) within this pool, then a new one is
     * created.
     *
     * @param capacity the capacity of the buffer requested, which will be interpreted differently for each
     *                 implementation of this pool. A {@link org.ros.internal.message.ByteBufferPool} measures
     *                 {@code capacity} in bytes
     * @return         a buffer with a capacity greater than or equal to {@code capacity}, a limit set to
     *                 {@code capacity}, and position set to {@code 0}.
     */
    public T take(int capacity) {
        Optional<T> maybeBuffer;

        synchronized (buffers) {
            maybeBuffer = buffers.tailMap(capacity, true)
                .values()
                .stream()
                .map(Deque::poll)
                .filter(Objects::nonNull)
                .findAny();
        }

        return maybeBuffer.map((T buffer) -> {
            buffer.clear().limit(capacity);
            return buffer;
        }).orElseGet(() -> allocate(capacity));
    }
    
    /**
     * Gives the specified {@link T buffer} to this {@link AbstractBufferPool<T> pool}.
     * <br><br>
     * This method should only be invoked with an argument that was returned from a call to {@link #take(int)}.
     *
     * @param buffer the buffer to return to this pool.
     */
    public void give(T buffer) {
        synchronized (buffers) {
            buffers.computeIfAbsent(buffer.capacity(), capacity -> new ArrayDeque<>(HEURISTIC)).offer(buffer);
        }
    }

    public void close() {
        synchronized (buffers) {
            buffers.clear();
        }
    }
}
