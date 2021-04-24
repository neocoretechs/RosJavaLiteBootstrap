
package org.ros.internal.message.service;

import org.ros.internal.message.definition.MessageDefinitionTupleParser;
import org.ros.message.MessageDeclaration;
import org.ros.message.MessageIdentifier;

import java.io.Serializable;
import java.util.List;

/**
 * The description of a ROS service.
 * 
 * @author Jonathan Groff Copyright (C) NeoCoreTechs 2015,2021
 */
public class ServiceDescription extends MessageDeclaration implements Serializable {
  private static final long serialVersionUID = 2595078531149391445L;
  private String requestType;
  private String requestDefinition;
  private String responseType;
  private String responseDefinition;
  private String md5Checksum;

  public ServiceDescription(String type, String definition, String md5Checksum) {
    super(MessageIdentifier.of(type), definition);
    this.md5Checksum = md5Checksum;
    List<String> requestAndResponse = MessageDefinitionTupleParser.parse(definition, 2);
    requestType = type + "Request";
    responseType = type + "Response";
    requestDefinition = requestAndResponse.get(0);
    responseDefinition = requestAndResponse.get(1);
  }

  public ServiceDescription() {}
  
  public String getMd5Checksum() {
    return md5Checksum;
  }

  public String getRequestType() {
    return requestType;
  }

  public String getRequestDefinition() {
    return requestDefinition;
  }

  public String getResponseType() {
    return responseType;
  }

  public String getResponseDefinition() {
    return responseDefinition;
  }

  @Override
  public String toString() {
    return "ServiceDescription<" + getType() + ", " + md5Checksum + ">";
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
    ServiceDescription other = (ServiceDescription) obj;
    if (md5Checksum == null) {
      if (other.md5Checksum != null)
        return false;
    } else if (!md5Checksum.equals(other.md5Checksum))
      return false;
    return true;
  }
}
