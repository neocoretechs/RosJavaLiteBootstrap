
package org.ros.internal.message.field;

import org.ros.exception.RosRuntimeException;
import org.ros.internal.message.context.MessageContext;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jonathan Groff Copyright (C) NeoCoreTechs 2015,2021
 */
public class MessageFields implements Serializable {
  private static final long serialVersionUID = -8375131025949194350L;
  private Map<String, Field> fields;
  private Map<String, Field> setters;
  private Map<String, Field> getters;
  private List<Field> orderedFields;

  public MessageFields(MessageContext messageContext) {
    fields = new HashMap<String, Field>();
    setters = new HashMap<String, Field>();
    getters = new HashMap<String, Field>();
    orderedFields = new ArrayList<Field>();
    for (String name : messageContext.getFieldNames()) {
      Field field = messageContext.getFieldFactory(name).create();
      fields.put(name, field);
      getters.put(messageContext.getFieldGetterName(name), field);
      setters.put(messageContext.getFieldSetterName(name), field);
      orderedFields.add(field);
    }
  }

  public MessageFields() {}
  
  public Field getField(String name) {
    return fields.get(name);
  }

  public Field getSetterField(String name) {
    return setters.get(name);
  }

  public Field getGetterField(String name) {
    return getters.get(name);
  }

  public List<Field> getFields() {
    return Collections.unmodifiableList(orderedFields);
  }

  public Object getFieldValue(String name) {
    Field field = fields.get(name);
    if (field != null) {
      return field.getValue();
    }
    throw new RosRuntimeException("Uknown field: " + name);
  }

  public void setFieldValue(String name, Object value) {
    Field field = fields.get(name);
    if (field != null) {
      field.setValue(value);
    } else {
      throw new RosRuntimeException("Uknown field: " + name);
    }
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fields == null) ? 0 : fields.hashCode());
    result = prime * result + ((orderedFields == null) ? 0 : orderedFields.hashCode());
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
    MessageFields other = (MessageFields) obj;
    if (fields == null) {
      if (other.fields != null)
        return false;
    } else if (!fields.equals(other.fields))
      return false;
    if (orderedFields == null) {
      if (other.orderedFields != null)
        return false;
    } else if (!orderedFields.equals(other.orderedFields))
      return false;
    return true;
  }
}
