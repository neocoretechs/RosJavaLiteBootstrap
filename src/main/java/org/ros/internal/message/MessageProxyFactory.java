package org.ros.internal.message;

import org.ros.exception.RosRuntimeException;
import org.ros.internal.message.context.MessageContext;
import org.ros.internal.message.context.MessageContextProvider;
import org.ros.message.MessageDeclaration;
import org.ros.message.MessageFactory;

import java.lang.reflect.Proxy;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Service requests and responses
 * @author Jonathan Groff Copyright (C) NeoCoreTechs 2015,2021
 */
public class MessageProxyFactory {

  // We can't use the constant here since the rosjava_messages package depends
  // on rosjava_bootstrap.
  private static final String HEADER_MESSAGE_TYPE = "std_msgs/Header";
  private static final String SEQUENCE_FIELD_NAME = "seq";
  private static final AtomicInteger SEQUENCE_NUMBER = new AtomicInteger(0);

  private final MessageContextProvider messageContextProvider;

  public MessageProxyFactory(MessageFactory messageFactory) {
    messageContextProvider = new MessageContextProvider(messageFactory);
  }

  @SuppressWarnings("unchecked")
  public <T> T newMessageProxy(MessageDeclaration messageDeclaration) {
    assert(messageDeclaration != null);
    MessageContext messageContext = messageContextProvider.get(messageDeclaration);
    MessageImpl messageImpl = new MessageImpl(messageContext);
    // Header messages are automatically populated with a monotonically
    // increasing sequence number.
    if (messageImpl.getType().equals(HEADER_MESSAGE_TYPE)) {
      messageImpl.setUInt32(SEQUENCE_FIELD_NAME, SEQUENCE_NUMBER.getAndIncrement());
    }
    Class<T> messageInterfaceClass;
	try {
		messageInterfaceClass = //(Class<T>) messageInterfaceClassProvider.get(messageDeclaration.getType());
		(Class<T>) Class.forName(messageDeclaration.getType().replace('/', '.'));
	} catch (ClassNotFoundException e) {
		System.out.println(e.getMessage());
		e.printStackTrace();
		throw new RosRuntimeException(e);
	}
    try {
		return messageInterfaceClass.newInstance();
	} catch (InstantiationException | IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}//newProxy(messageInterfaceClass, messageImpl);
    return null;
  }

  /**
   * @param interfaceClass the interface class to provide
   * @param messageImpl the instance to proxy
   * @return a new proxy for {@code implementation} that implements {@code interfaceClass}
   */
  @SuppressWarnings("unchecked")
  private <T> T newProxy(Class<T> interfaceClass, final MessageImpl messageImpl) {
    ClassLoader classLoader = messageImpl.getClass().getClassLoader();
    Class<?>[] interfaces = new Class<?>[] { interfaceClass, GetInstance.class };
    MessageProxyInvocationHandler invocationHandler =
        new MessageProxyInvocationHandler(messageImpl);
    return (T) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
  }
}
