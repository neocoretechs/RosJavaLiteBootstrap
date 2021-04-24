package org.ros.internal.message.context;

import org.ros.internal.message.definition.MessageDefinitionParser.MessageDefinitionVisitor;
import org.ros.internal.message.field.Field;
import org.ros.internal.message.field.FieldFactory;
import org.ros.internal.message.field.FieldType;
import org.ros.internal.message.field.MessageFieldType;
import org.ros.internal.message.field.PrimitiveFieldType;
import org.ros.message.MessageIdentifier;

/**
 * @author Jonathan Groff Copyright (C) NeoCoreTechs 2015,2021
 */
class MessageContextBuilder implements MessageDefinitionVisitor {

  private final MessageContext messageContext;

  public MessageContextBuilder(MessageContext context) {
    this.messageContext = context;
  }

  private FieldType getFieldType(String type) {
    assert(!type.equals(messageContext.getType())) : "Message definitions may not be self-referential.";
    FieldType fieldType;
    if (PrimitiveFieldType.existsFor(type)) {
      fieldType = PrimitiveFieldType.valueOf(type.toUpperCase());
    } else {
      fieldType =
          new MessageFieldType(MessageIdentifier.of(type), messageContext.getMessageFactory());
    }
    return fieldType;
  }

  @Override
  public void variableValue(String type, final String name) {
    final FieldType fieldType = getFieldType(type);
    messageContext.addFieldFactory(name, new FieldFactory() {
      @Override
      public Field create() {
        return fieldType.newVariableValue(name);
      }
    });
  }

  @Override
  public void variableList(String type, final int size, final String name) {
    final FieldType fieldType = getFieldType(type);
    messageContext.addFieldFactory(name, new FieldFactory() {
      @Override
      public Field create() {
        return fieldType.newVariableList(name, size);
      }
    });
  }

  @Override
  public void constantValue(String type, final String name, final String value) {
    final FieldType fieldType = getFieldType(type);
    messageContext.addFieldFactory(name, new FieldFactory() {
      @Override
      public Field create() {
        return fieldType.newConstantValue(name, fieldType.parseFromString(value));
      }
    });
  }
}