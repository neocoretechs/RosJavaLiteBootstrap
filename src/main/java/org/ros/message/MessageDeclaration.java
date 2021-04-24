package org.ros.message;

import java.io.Serializable;

/**
 * An {@link MessageIdentifier} and definition pair from which all qualities of
 * the message uniquely identifiable by the {@link MessageIdentifier} can be
 * derived.
 * 
 * @author Jonathan Groff Copyright (C) NeoCoreTechs 2015,2021
 */
public class MessageDeclaration implements Serializable {

  private static final long serialVersionUID = -7946120273324308112L;
  private MessageIdentifier messageIdentifier = null;
  private String definition = null;

  public MessageDeclaration() {}
  
  public static MessageDeclaration of(String type, String definition) {
    assert(type != null);
    assert(definition != null);
    return new MessageDeclaration(MessageIdentifier.of(type), definition);
  }

  /**
   * @param messageIdentifier
   *          the {@link MessageIdentifier}
   * @param definition
   *          the message definition
   */
  public MessageDeclaration(MessageIdentifier messageIdentifier, String definition) {
    assert(messageIdentifier != null);
    assert(definition != null);
    this.messageIdentifier = messageIdentifier;
    this.definition = definition;
  }

  public MessageIdentifier getMessageIdentifier() {
    return messageIdentifier;
  }

  public String getType() {
    return messageIdentifier.getType();
  }

  public String getPackage() {
    return messageIdentifier.getPackage();
  }

  public String getName() {
    return messageIdentifier.getName();
  }

  public String getDefinition() {
    assert(definition != null);
    return definition;
  }

  @Override
  public String toString() {
    return String.format("MessageDeclaration<%s>", messageIdentifier.toString());
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((definition == null) ? 0 : definition.hashCode());
    result = prime * result + ((messageIdentifier == null) ? 0 : messageIdentifier.hashCode());
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
    MessageDeclaration other = (MessageDeclaration) obj;
    if (definition == null) {
      if (other.definition != null)
        return false;
    } else if (!definition.equals(other.definition))
      return false;
    if (messageIdentifier == null) {
      if (other.messageIdentifier != null)
        return false;
    } else if (!messageIdentifier.equals(other.messageIdentifier))
      return false;
    return true;
  }
}