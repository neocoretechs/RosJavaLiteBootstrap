package org.ros.internal.message.field;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import org.ros.internal.message.Message;
import org.ros.message.MessageFactory;
import org.ros.message.MessageIdentifier;

/**
 */
public class MessageFieldType implements FieldType, Serializable {
  private static final long serialVersionUID = -5991760011444968163L;
  private MessageIdentifier messageIdentifier;
  private transient MessageFactory messageFactory;
 
  public MessageFieldType(MessageIdentifier messageIdentifier, MessageFactory messageFactory) {
    this.messageIdentifier = messageIdentifier;
    this.messageFactory = messageFactory;
  
  }

  public MessageFieldType() {}
  
  public MessageFactory getMessageFactory() {
    return messageFactory;
  }

  @Override
  public Field newVariableValue(String name) {
    return ValueField.newVariable(this, name);
  }

  @Override
  public <T> Field newConstantValue(String name, T value) {
    throw new UnsupportedOperationException();
  }

  @Override
  public Field newVariableList(String name, int size) {
    return ListField.newVariable(this, name);
  }

  @Override
  public <T> T getDefaultValue() {
    return getMessageFactory().newFromType(messageIdentifier.getType());
  }

  @Override
  public String getMd5String() {
    return null;
  }

  @Override
  public String getJavaTypeName() {
    return String.format("%s.%s", messageIdentifier.getPackage(), messageIdentifier.getName());
  }

  @Override
  public int getSerializedSize() {
    throw new UnsupportedOperationException();
  }

  @Override
  public String getName() {
    return messageIdentifier.getType();
  }

  @Override
  public <T> void serialize(T value, ByteBuffer buffer) {
    //serializer.serialize((Message) value, buffer);
	DirectByteArrayOutputStream dbaos = new DirectByteArrayOutputStream();
	ObjectOutputStream oos;
	try {
		oos = new ObjectOutputStream(dbaos);
		oos.writeObject(value);
		oos.flush();
		buffer.put(dbaos.getBuf());
		oos.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
  }

  @SuppressWarnings("unchecked")
  @Override
  public Message deserialize(ByteBuffer buffer) {
    //return deserializer.deserialize(buffer);
	byte[] obuf = buffer.array();
	Object Od = null;
	try {
				ObjectInputStream s;
				ByteArrayInputStream bais = new ByteArrayInputStream(obuf);
				ReadableByteChannel rbc = Channels.newChannel(bais);
				s = new ObjectInputStream(Channels.newInputStream(rbc));
				Od = s.readObject();
				s.close();
				bais.close();
				rbc.close();
	} catch (IOException ioe) {
	} catch (ClassNotFoundException cnf) {
			System.out.println("Class cannot be deserialized, may have been modified beyond version compatibility");
	}
	return (Message) Od;
		
  }

  @SuppressWarnings("unchecked")
  @Override
  public Void parseFromString(String value) {
    throw new UnsupportedOperationException();
  }

  @Override
  public String toString() {
    return "MessageField<" + messageIdentifier + ">";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
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
    MessageFieldType other = (MessageFieldType) obj;
    if (messageIdentifier == null) {
      if (other.messageIdentifier != null)
        return false;
    } else if (!messageIdentifier.equals(other.messageIdentifier))
      return false;
    return true;
  }
}
