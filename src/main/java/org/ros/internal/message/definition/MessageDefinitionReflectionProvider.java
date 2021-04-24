package org.ros.internal.message.definition;

import org.ros.exception.RosRuntimeException;
import org.ros.message.MessageDefinitionProvider;
import org.ros.message.MessageIdentifier;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * A {@link MessageDefinitionProvider} that uses reflection to load the message
 * definition {@link String} from a generated interface {@link Class}.
 * <p>
 * Note that this {@link MessageDefinitionProvider} does not support enumerating
 * messages by package.
 * 
 * @author Jonathan Groff Copyright (C) NeoCoreTechs 2015,2021
 */
public class MessageDefinitionReflectionProvider implements MessageDefinitionProvider {

  private static final String DEFINITION_FIELD = "_DEFINITION";

  private final Map<String, String> cache;

  public MessageDefinitionReflectionProvider() {
    cache = new ConcurrentHashMap<String, String>();
  }

  @Override
  public String get(String messageType) {
    String messageDefinition = cache.get(messageType);
    if (messageDefinition == null) {
      String className = messageType.replace("/", ".");
      try {
        Class<?> loadedClass = getClass().getClassLoader().loadClass(className);
        messageDefinition = (String) loadedClass.getDeclaredField(DEFINITION_FIELD).get(null);
        cache.put(messageType, messageDefinition);
      } catch (Exception e) {
        throw new RosRuntimeException(e);
      }
    }
    return messageDefinition;
  }

  @Override
  public boolean has(String messageType) {
    try {
      get(messageType);
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  @Override
  public Collection<String> getPackages() {
    throw new UnsupportedOperationException();
  }

  @Override
  public Collection<MessageIdentifier> getMessageIdentifiersByPackage(String pkg) {
    throw new UnsupportedOperationException();
  }

  public void add(String messageType, String messageDefinition) {
    cache.put(messageType, messageDefinition);
  }
}
