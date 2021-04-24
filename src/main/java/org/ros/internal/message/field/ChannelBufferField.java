package org.ros.internal.message.field;

import org.ros.internal.message.MessageBuffers;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * @author Jonathan Groff Copyright (C) NeoCoreTechs 2015,2021
 */
public class ChannelBufferField extends Field implements Serializable {

  private static final long serialVersionUID = -2957462396867754799L;

  private int size;

  private transient ByteBuffer value;

  public static ChannelBufferField newVariable(FieldType type, String name, int size) {
    return new ChannelBufferField(type, name, size);
  }
  public ChannelBufferField() {}
  
  private ChannelBufferField(FieldType type, String name, int size) {
    super(type, name, false);
    this.size = size;
    value = MessageBuffers.dynamicBuffer();
  }

  @SuppressWarnings("unchecked")
  @Override
  public ByteBuffer getValue() {
    // Return a defensive duplicate. Unlike with copy(), duplicated
    // ChannelBuffers share the same backing array, so this is relatively cheap.
    return value.duplicate();
  }

  @Override
  public void setValue(Object value) {
    assert(((ByteBuffer) value).order() == ByteOrder.LITTLE_ENDIAN);
    assert(size < 0 || ((ByteBuffer) value).limit() == size);
    this.value = (ByteBuffer) value;
  }

  @Override
  public void serialize(ByteBuffer buffer) {
    if (size < 0) {
      buffer.putInt(value.limit());
    }
    // By specifying the start index and length we avoid modifying value's
    // indices and marks.
    buffer.put(value.array(), 0, value.limit());
  }

  @Override
  public void deserialize(ByteBuffer buffer) {
    int currentSize = size;
    if (currentSize < 0) {
      currentSize = buffer.getInt();
    }
    buffer.position(currentSize);
    value = buffer.slice();
  }

  @Override
  public String getMd5String() {
    return String.format("%s %s\n", type, name);
  }

  @Override
  public String getJavaTypeName() {
    return "java.nio.ByteBuffer";
  }

  @Override
  public String toString() {
    return "ChannelBufferField<" + type + ", " + name + ">";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((value == null) ? 0 : value.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!super.equals(obj))
      return false;
    if (getClass() != obj.getClass())
      return false;
    ChannelBufferField other = (ChannelBufferField) obj;
    if (value == null) {
      if (other.value != null)
        return false;
    } else if (!value.equals(other.value))
      return false;
    return true;
  }
}
