package org.ros.internal.message;

import org.apache.commons.lang.StringEscapeUtils;
import org.ros.exception.RosRuntimeException;
import org.ros.internal.message.context.MessageContext;
import org.ros.internal.message.context.MessageContextProvider;
import org.ros.internal.message.field.Field;
import org.ros.internal.message.field.FieldType;
import org.ros.internal.message.field.MessageFields;
import org.ros.internal.message.field.PrimitiveFieldType;
import org.ros.message.MessageDeclaration;
import org.ros.message.MessageFactory;

import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.ChannelOption;

import java.util.HashSet;
import java.util.Set;

/**
 * This class generates the actual java class files representing the translated ROS message definitions
 * It is driven by the <see>GenerateClasses</see> module.
 * @author jg
 */
public class MessageInterfaceBuilder {

  private MessageDeclaration messageDeclaration;
  private String packageName;
  private String interfaceName;
  private boolean addConstantsAndMethods;
  private String nestedContent;

  private static String escapeJava(String str) {
    return StringEscapeUtils.escapeJava(str).replace("\\/", "/").replace("'", "\\'");
  }

  public MessageDeclaration getMessageDeclaration() {
    return messageDeclaration;
  }

  public MessageInterfaceBuilder setMessageDeclaration(MessageDeclaration messageDeclaration) {
    assert(messageDeclaration != null);
    this.messageDeclaration = messageDeclaration;
    return this;
  }

  public String getPackageName() {
    return packageName;
  }

  /**
   * @param packageName
   *          the package name of the interface or {@code null} if no package
   *          name should be specified
   * @return this {@link MessageInterfaceBuilder}
   */
  public MessageInterfaceBuilder setPackageName(String packageName) {
    this.packageName = packageName;
    return this;
  }

  public String getInterfaceName() {
    return interfaceName;
  }

  public MessageInterfaceBuilder setInterfaceName(String interfaceName) {
    assert(interfaceName != null);
    this.interfaceName = interfaceName;
    return this;
  }

  public boolean getAddConstantsAndMethods() {
    return addConstantsAndMethods;
  }

  public void setAddConstantsAndMethods(boolean enabled) {
    addConstantsAndMethods = enabled;
  }

  public String getNestedContent() {
    return nestedContent;
  }

  public void setNestedContent(String nestedContent) {
    this.nestedContent = nestedContent;
  }

  public String build(MessageFactory messageFactory) {
    assert(messageDeclaration!=null);
    assert(interfaceName != null);
    StringBuilder builder = new StringBuilder();
    if (packageName != null) {
      builder.append(String.format("package %s;\n\n", packageName));
    }
    builder.append(String.format(
        "public class %s implements org.ros.internal.message.Message, java.io.Serializable {\n", interfaceName));
    builder.append("\tprivate static final long serialVersionUID = -1L;\n");
    builder.append(String.format("\tpublic static final java.lang.String _TYPE = \"%s\";\n",
        messageDeclaration.getType()));
    builder.append(String.format("\tpublic static final java.lang.String _DEFINITION = \"%s\";\n",
        escapeJava(messageDeclaration.getDefinition())));
    // Add no arg default constructor for Java serialization
    builder.append(String.format("\tpublic %s() {}\n", interfaceName));
    if (addConstantsAndMethods) {
      MessageContextProvider messageContextProvider = new MessageContextProvider(messageFactory);
      MessageContext messageContext = messageContextProvider.get(messageDeclaration);
      appendConstants(messageContext, builder);
      appendSettersAndGetters(messageContext, builder);
    }
    if (nestedContent != null) {
      builder.append("\n");
      builder.append(nestedContent);
    }
    builder.append("}\n");
    return builder.toString();
  }

  @SuppressWarnings("deprecation")
  private String getJavaValue(PrimitiveFieldType primitiveFieldType, String value) {
    switch (primitiveFieldType) {
      case BOOL:
        return Boolean.valueOf(!value.equals("0") && !value.equals("false")).toString();
      case FLOAT32:
        return value + "f";
      case STRING:
        return "\"" + escapeJava(value) + "\"";
      case BYTE:
      case CHAR:
      case INT8:
      case UINT8:
      case INT16:
      case UINT16:
      case INT32:
      case UINT32:
      case INT64:
      case UINT64:
      case FLOAT64:
        return value;
      default:
        throw new RosRuntimeException("Unsupported PrimitiveFieldType: " + primitiveFieldType);
    }
  }

  private void appendConstants(MessageContext messageContext, StringBuilder builder) {
    MessageFields messageFields = new MessageFields(messageContext);
    for (Field field : messageFields.getFields()) {
      if (field.isConstant()) {
        assert(field.getType() instanceof PrimitiveFieldType);
        // We use FieldType and cast back to PrimitiveFieldType below to avoid a
        // bug in the Sun JDK: http://gs.sun.com/view_bug.do?bug_id=6522780
        FieldType fieldType = (FieldType) field.getType();
        String value = getJavaValue((PrimitiveFieldType) fieldType, field.getValue().toString());
        builder.append(String.format("\tpublic static final %s %s = %s;\n", fieldType.getJavaTypeName(),
            field.getName(), value));
      }
    }
  }

  private void appendSettersAndGetters(MessageContext messageContext, StringBuilder builder) {
    MessageFields messageFields = new MessageFields(messageContext);
    Set<String> getters = new HashSet<String>();
    for (Field field : messageFields.getFields()) {
      if (field.isConstant()) {
        continue;
      }
      String type = field.getJavaTypeName();
      String getter = messageContext.getFieldGetterName(field.getName());
      String setter = messageContext.getFieldSetterName(field.getName());
      if (getters.contains(getter)) {
        // In the case that two or more message fields have the same name except
        // for capitalization, we only generate a getter and setter pair for the
        // first one.
        continue;
      }
      getters.add(getter);
      //if(type.contains("ChannelBuffer")) {
      if(type.contains("ByteBuf")) {
    	  builder.append(String.format("\tprivate transient %s %s=null;\n", type, field.getName()));
    	  builder.append(String.format("\tprivate byte[] bytes%s;\n", field.getName()));
    	  builder.append(String.format("\tpublic %s %s() { if( %s != null ) return %s; else %s = io.netty.buffer.PooledByteBufAllocator.DEFAULT.buffer().setBytes(0,bytes%s); return %s.order(java.nio.ByteOrder.LITTLE_ENDIAN); }\n", type, getter, 
    			  field.getName(),field.getName(),field.getName(),field.getName(),field.getName()));
    	  // mutator
          String value = "value";
          if( field.getName().equals("value"))
        	  value = "xvalue";
          builder.append(String.format("\tpublic void %s(%s "+value+") { %s = "+value+";  bytes%s = %s.array(); }\n", setter, type, 
        		  field.getName(),field.getName(),field.getName()));
      } else {
    	  builder.append(String.format("\tprivate %s %s;\n", type, field.getName()));
    	  builder.append(String.format("\tpublic %s %s() { return %s; }\n", type, getter, field.getName()));
          String value = "value";
          if( field.getName().equals("value"))
        	  value = "xvalue";
          builder.append(String.format("\tpublic void %s(%s "+value+") { %s = "+value+"; }\n", setter, type, field.getName()));
      }
 

    }
  }
}
