package org.ros.message;

import java.io.Serializable;

/**
 * Uniquely identifies a message.
 * 
 * @author Jonathan Groff Copyright (C) NeoCoreTechs 2015,2021
 */
public class MessageIdentifier implements Serializable {

  private static final long serialVersionUID = -5005028641439142380L;
  
  private String type;
  private String pkg;
  private String name;

  public MessageIdentifier() {}
  
  public static MessageIdentifier of(String pkg, String name) {
    assert(pkg != null);
    assert(name != null);
    return new MessageIdentifier(pkg, name);
  }

  public static MessageIdentifier of(String type) {
    assert(type != null);
    // We're not using Preconditions.checkArgument() here because we want a
    // useful error message without paying the performance penalty of
    // constructing it every time.
    if (!type.contains("/")) {
      throw new IllegalArgumentException(String.format(
          "Type name is invalid or not fully qualified: \"%s\"", type));
    }
    return new MessageIdentifier(type);
  }

  private MessageIdentifier(String type) {
    this.type = type;
  }

  private MessageIdentifier(String pkg, String name) {
    this.pkg = pkg;
    this.name = name;
  }

  public String getType() {
    if (type == null) {
      // Using StringBuilder like this is about 40% faster than using the +
      // operator.
      StringBuilder stringBuilder = new StringBuilder(pkg.length() + name.length() + 1);
      stringBuilder.append(pkg);
      stringBuilder.append("/");
      stringBuilder.append(name);
      type = stringBuilder.toString();
    }
    return type;
  }

  private void splitType() {
    String[] packageAndName = type.split("/", 2);
    pkg = packageAndName[0];
    name = packageAndName[1];
  }

  public String getPackage() {
    if (pkg == null) {
      splitType();
    }
    return pkg;
  }

  public String getName() {
    if (name == null) {
      splitType();
    }
    return name;
  }

  @Override
  public String toString() {
    return String.format("MessageIdentifier<%s>", type);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
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
    MessageIdentifier other = (MessageIdentifier) obj;
    if (type == null) {
      if (other.type != null)
        return false;
    } else if (!type.equals(other.type))
      return false;
    return true;
  }
}
