package org.ros.internal.message.topic;

import java.io.Serializable;

import org.ros.message.MessageDeclaration;
import org.ros.message.MessageIdentifier;

/**
 * The description of a ROS topic.
 * 
 * @author Jonathan Groff Copyright (C) NeoCoreTechs 2015,2021
 */
public class TopicDescription extends MessageDeclaration implements Serializable {
  private static final long serialVersionUID = 3394970154727447134L;
  private String md5Checksum;

  public TopicDescription(String type, String definition, String md5Checksum) {
    super(MessageIdentifier.of(type), definition);
    this.md5Checksum = md5Checksum;
  }

  public TopicDescription() {}
  
  public String getMd5Checksum() {
    return md5Checksum;
  }

  @Override
  public String toString() {
    return "TopicDescription<" + getType() + ", " + md5Checksum + ">";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((md5Checksum == null) ? 0 : md5Checksum.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!super.equals(obj))
      return false;
    if (getClass() != obj.getClass())
      return false;
    TopicDescription other = (TopicDescription) obj;
    if (md5Checksum == null) {
      if (other.md5Checksum != null)
        return false;
    } else if (!md5Checksum.equals(other.md5Checksum))
      return false;
    return true;
  }
}
