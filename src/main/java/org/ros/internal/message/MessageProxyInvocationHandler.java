package org.ros.internal.message;

import org.ros.internal.message.field.Field;
import org.ros.internal.message.field.MessageFields;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Use java reflection to set up message and invoke the desired method on the target.
 * @author Jonathan Groff Copyright (C) NeoCoreTechs 2015,2021
 */
public class MessageProxyInvocationHandler implements InvocationHandler {

  private final MessageImpl messageImpl;

  MessageProxyInvocationHandler(MessageImpl messageImpl) {
    this.messageImpl = messageImpl;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    String methodName = method.getName();
    MessageFields mesageFields = messageImpl.getMessageFields();
    Field getterField = mesageFields.getGetterField(methodName);
    if (getterField != null) {
      return getterField.getValue();
    }
    Field setterField = mesageFields.getSetterField(methodName);
    if (setterField != null) {
      setterField.setValue(args[0]);
      return null;
    }
    return method.invoke(messageImpl, args);
  }
}