package org.ros.internal.message.field;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * @author Jonathan Groff Copyright (C) NeoCoreTechs 2015,2021
 */
public class IntegerArrayField extends Field implements Serializable {

  private static final long serialVersionUID = -6640518256354198356L;

  private int size;

  private int[] value;

  public static IntegerArrayField newVariable(FieldType type, String name, int size) {
    return new IntegerArrayField(type, name, size);
  }

  public IntegerArrayField() {}
  
  private IntegerArrayField(FieldType type, String name, int size) {
    super(type, name, false);
    this.size = size;
    setValue(new int[Math.max(0, size)]);
  }

  @SuppressWarnings("unchecked")
  @Override
  public int[] getValue() {
    return value;
  }

  @Override
  public void setValue(Object value) {
    assert(size < 0 || ((int[]) value).length == size);
    this.value = (int[]) value;
  }

  @Override
  public void serialize(ByteBuffer buffer) {
    if (size < 0) {
      buffer.getInt(value.length);
    }
    for (int v : value) {
      type.serialize(v, buffer);
    }
  }

  @Override
  public void deserialize(ByteBuffer buffer) {
    int currentSize = size;
    if (currentSize < 0) {
      currentSize = buffer.getInt();
    }
    value = new int[currentSize];
    for (int i = 0; i < currentSize; i++) {
      value[i] = buffer.getInt();
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
    return "IntegerArrayField<" + type + ", " + name + ">";
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
    IntegerArrayField other = (IntegerArrayField) obj;
    if (value == null) {
      if (other.value != null)
        return false;
    } else if (!Arrays.equals(value, other.value))
      return false;
    return true;
  }
}
