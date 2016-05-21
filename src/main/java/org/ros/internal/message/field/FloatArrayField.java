package org.ros.internal.message.field;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * @author jg
 */
public class FloatArrayField extends Field implements Serializable  {
  private static final long serialVersionUID = 1423082568478293473L;

  private int size;

  private float[] value;

  public static FloatArrayField newVariable(String name, int size) {
    return new FloatArrayField(PrimitiveFieldType.FLOAT32, name, size);
  }

  public FloatArrayField() {}
  
  private FloatArrayField(FieldType type, String name, int size) {
    super(type, name, false);
    this.size = size;
    setValue(new float[Math.max(0, size)]);
  }

  @SuppressWarnings("unchecked")
  @Override
  public float[] getValue() {
    return value;
  }

  @Override
  public void setValue(Object value) {
    assert(size < 0 || ((float[]) value).length == size);
    this.value = (float[]) value;
  }

  @Override
  public void serialize(ByteBuffer buffer) {
    if (size < 0) {
      buffer.putInt(value.length);
    }
    for (float v : value) {
      type.serialize(v, buffer);
    }
  }

  @Override
  public void deserialize(ByteBuffer buffer) {
    int currentSize = size;
    if (currentSize < 0) {
      currentSize = buffer.getInt();
    }
    value = new float[currentSize];
    for (int i = 0; i < currentSize; i++) {
      value[i] = buffer.getFloat();
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
    return "FloatArrayField<" + type + ", " + name + ">";
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
    FloatArrayField other = (FloatArrayField) obj;
    if (value == null) {
      if (other.value != null)
        return false;
    } else if (!Arrays.equals(value, other.value))
      return false;
    return true;
  }
}
