package org.ros.internal.message.field;


import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * @author Jonathan Groff Copyright (C) NeoCoreTechs 2015,2021
 */
public class DoubleArrayField extends Field implements Serializable {
  private static final long serialVersionUID = 8846745882588147842L;

  private int size;

  private double[] value;

  public static DoubleArrayField newVariable(String name, int size) {
    return new DoubleArrayField(PrimitiveFieldType.FLOAT64, name, size);
  }

  public DoubleArrayField() {}
  
  private DoubleArrayField(FieldType type, String name, int size) {
    super(type, name, false);
    this.size = size;
    setValue(new double[Math.max(0, size)]);
  }

  @SuppressWarnings("unchecked")
  @Override
  public double[] getValue() {
    return value;
  }

  @Override
  public void setValue(Object value) {
    assert(size < 0 || ((double[]) value).length == size);
    this.value = (double[]) value;
  }

  @Override
  public void serialize(ByteBuffer buffer) {
    if (size < 0) {
      buffer.putInt(value.length);
    }
    for (double v : value) {
      type.serialize(v, buffer);
    }
  }

  @Override
  public void deserialize(ByteBuffer buffer) {
    int currentSize = size;
    if (currentSize < 0) {
      currentSize = buffer.getInt();
    }
    value = new double[currentSize];
    for (int i = 0; i < currentSize; i++) {
      value[i] = buffer.getDouble();
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
    return "DoubleArrayField<" + type + ", " + name + ">";
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
    DoubleArrayField other = (DoubleArrayField) obj;
    if (value == null) {
      if (other.value != null)
        return false;
    } else if (!Arrays.equals(value, other.value))
      return false;
    return true;
  }
}
