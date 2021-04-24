package org.ros.internal.message.field;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * @author Jonathan Groff Copyright (C) NeoCoreTechs 2015,2021
 */
public class LongArrayField extends Field implements Serializable {
  private static final long serialVersionUID = 7377367721418490002L;

  private int size;

  private long[] value;

  public static LongArrayField newVariable(FieldType type, String name, int size) {
    assert(type.equals(PrimitiveFieldType.UINT32)
        || type.equals(PrimitiveFieldType.INT64) || type.equals(PrimitiveFieldType.UINT64));
    return new LongArrayField(type, name, size);
  }
  
  public LongArrayField() {}
  
  private LongArrayField(FieldType type, String name, int size) {
    super(type, name, false);
    this.size = size;
    setValue(new long[Math.max(0, size)]);
  }

  @SuppressWarnings("unchecked")
  @Override
  public long[] getValue() {
    return value;
  }

  @Override
  public void setValue(Object value) {
    assert(size < 0 || ((long[]) value).length == size);
    this.value = (long[]) value;
  }

  @Override
  public void serialize(ByteBuffer buffer) {
    if (size < 0) {
      buffer.putInt(value.length);
    }
    for (long v : value) {
      type.serialize(v, buffer);
    }
  }

  @Override
  public void deserialize(ByteBuffer buffer) {
    int currentSize = size;
    if (currentSize < 0) {
      currentSize = buffer.getInt();
    }
    value = new long[currentSize];
    for (int i = 0; i < currentSize; i++) {
      value[i] = buffer.getLong();
    }
  }

  @Override
  public String getMd5String() {
    return String.format("%s %s\n", type, name);
  }

  @Override
  public String getJavaTypeName() {
    return type.getJavaTypeName() + "[]";
  }

  @Override
  public String toString() {
    return "LongArrayField<" + type + ", " + name + ">";
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
    LongArrayField other = (LongArrayField) obj;
    if (value == null) {
      if (other.value != null)
        return false;
    } else if (!Arrays.equals(value, other.value))
      return false;
    return true;
  }
}
