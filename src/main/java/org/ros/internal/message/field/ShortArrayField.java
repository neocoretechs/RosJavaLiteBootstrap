/*
 */

package org.ros.internal.message.field;


import io.netty.buffer.ByteBuf;

import java.io.Serializable;
import java.util.Arrays;

/**
 */
public class ShortArrayField extends Field implements Serializable {
  private static final long serialVersionUID = -1040540702771458698L;

  private int size;

  private short[] value;

  public static ShortArrayField newVariable(FieldType type, String name, int size) {
    return new ShortArrayField(type, name, size);
  }

  public ShortArrayField() {}
  
  private ShortArrayField(FieldType type, String name, int size) {
    super(type, name, false);
    this.size = size;
    setValue(new short[Math.max(0, size)]);
  }

  @SuppressWarnings("unchecked")
  @Override
  public short[] getValue() {
    return value;
  }

  @Override
  public void setValue(Object value) {
    assert(size < 0 || ((short[]) value).length == size);
    this.value = (short[]) value;
  }

  @Override
  public void serialize(ByteBuf buffer) {
    if (size < 0) {
      buffer.writeInt(value.length);
    }
    for (short v : value) {
      type.serialize(v, buffer);
    }
  }

  @Override
  public void deserialize(ByteBuf buffer) {
    int currentSize = size;
    if (currentSize < 0) {
      currentSize = buffer.readInt();
    }
    value = new short[currentSize];
    for (int i = 0; i < currentSize; i++) {
      value[i] = buffer.readShort();
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
    return "ShortArrayField<" + type + ", " + name + ">";
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
    ShortArrayField other = (ShortArrayField) obj;
    if (value == null) {
      if (other.value != null)
        return false;
    } else if (!Arrays.equals(value, other.value))
      return false;
    return true;
  }
}
