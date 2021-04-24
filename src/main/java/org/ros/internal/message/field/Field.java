package org.ros.internal.message.field;

import java.io.Serializable;
import java.nio.ByteBuffer;

/**
 * @author Jonathan Groff Copyright (C) NeoCoreTechs 2015,2021
 */
public abstract class Field implements Serializable {
  private static final long serialVersionUID = 2147925628455327757L;
  protected  FieldType type;
  protected  String name;
  protected  boolean isConstant;
  
  public Field() {}
  
  protected Field(FieldType type, String name, boolean isConstant) {
    this.name = name;
    this.type = type;
    this.isConstant = isConstant;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @return the type
   */
  public FieldType getType() {
    return type;
  }

  /**
   * @return <code>true</code> if this {@link ListField} represents a constant
   */
  public boolean isConstant() {
    return isConstant;
  }

  /**
   * @return the textual representation of this field used for computing the MD5
   *         of a message definition
   */
  public String getMd5String() {
    if (isConstant()) {
      return String.format("%s %s=%s\n", getType().getMd5String(), getName(), getValue());
    }
    return String.format("%s %s\n", getType().getMd5String(), getName());
  }

  public abstract void serialize(ByteBuffer buffer);

  public abstract void deserialize(ByteBuffer buffer);

  public abstract <T> T getValue();

  // TODO(damonkohler): Why not make Field generic?
  public abstract void setValue(Object value);

  public abstract String getJavaTypeName();

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (isConstant ? 1231 : 1237);
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((type == null) ? 0 : type.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Field other = (Field) obj;
    if (isConstant != other.isConstant)
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (type == null) {
      if (other.type != null)
        return false;
    } else if (!type.equals(other.type))
      return false;
    return true;
  }
}
