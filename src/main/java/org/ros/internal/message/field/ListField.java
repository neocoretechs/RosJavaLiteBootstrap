package org.ros.internal.message.field;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jonathan Groff Copyright (C) NeoCoreTechs 2015,2021
 * 
 * @param <T>
 *          the value type
 */
public class ListField<T> extends Field implements Serializable {
  private static final long serialVersionUID = -4024530569460884480L;
  private List<T> value;

  public static <T> ListField<T> newVariable(FieldType type, String name) {
    return new ListField<T>(type, name);
  }

  public ListField() {}
  
  private ListField(FieldType type, String name) {
    super(type, name, false);
    value = new ArrayList<T>();
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<T> getValue() {
    return value;
  }

  @SuppressWarnings("unchecked")
  @Override
  public void setValue(Object value) {
    assert(value != null);
    this.value = (List<T>) value;
  }

  @Override
  public void serialize(ByteBuffer buffer) {
    buffer.putInt(value.size());
    for (T v : value) {
      type.serialize(v, buffer);
    }
  }

  @Override
  public void deserialize(ByteBuffer buffer) {
    value.clear();
    int size = buffer.getInt();
    for (int i = 0; i < size; i++) {
      value.add(type.<T>deserialize(buffer));
    }
  }

  @Override
  public String getMd5String() {
    return String.format("%s %s\n", type, name);
  }

  @Override
  public String getJavaTypeName() {
    return String.format("java.util.List<%s>", type.getJavaTypeName());
  }

  @Override
  public String toString() {
    return "ListField<" + type + ", " + name + ">";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((value == null) ? 0 : value.hashCode());
    return result;
  }

  @SuppressWarnings("rawtypes")
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!super.equals(obj))
      return false;
    if (getClass() != obj.getClass())
      return false;
    ListField other = (ListField) obj;
    if (value == null) {
      if (other.value != null)
        return false;
    } else if (!value.equals(other.value))
      return false;
    return true;
  }
}
