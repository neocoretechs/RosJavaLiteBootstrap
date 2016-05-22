package diagnostic_msgs;

public class KeyValue implements org.ros.internal.message.Message, java.io.Serializable {
	private static final long serialVersionUID = -1L;
	public static final java.lang.String _TYPE = "diagnostic_msgs/KeyValue";
	public static final java.lang.String _DEFINITION = "string key # what to label this value when viewing\nstring value # a value to track over time\n";
	public KeyValue() {}
	private java.lang.String key;
	public java.lang.String getKey() { return key; }
	public void setKey(java.lang.String value) { key = value; }
	private java.lang.String value;
	public java.lang.String getValue() { return value; }
	public void setValue(java.lang.String xvalue) { value = xvalue; }
}
