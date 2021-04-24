package org.ros.internal.message.field;

import java.nio.ByteBuffer;

/**
 * @author Jonathan Groff Copyright (C) NeoCoreTechs 2015,2021
 */
public interface FieldType {

  public <T> T getDefaultValue();

  public String getName();

  public <T> T parseFromString(String value);

  public String getMd5String();

  public String getJavaTypeName();

  /**
   * @return the serialized size of this {@link FieldType} in bytes
   */
  public int getSerializedSize();

  public <T> void serialize(T value, ByteBuffer buffer);

  public <T> T deserialize(ByteBuffer buffer);

  public Field newVariableValue(String name);

  public Field newVariableList(String name, int size);

  public <T> Field newConstantValue(String name, T value);
}
