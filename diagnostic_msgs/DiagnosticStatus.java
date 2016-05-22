package diagnostic_msgs;

public class DiagnosticStatus implements org.ros.internal.message.Message, java.io.Serializable {
	private static final long serialVersionUID = -1L;
	public static final java.lang.String _TYPE = "diagnostic_msgs/DiagnosticStatus";
	public static final java.lang.String _DEFINITION = "# This message holds the status of an individual component of the robot.\n# \n\n# Possible levels of operations\nbyte OK=0\nbyte WARN=1\nbyte ERROR=2\n\nbyte level # level of operation enumerated above \nstring name # a description of the test/component reporting\nstring message # a description of the status\nstring hardware_id # a hardware unique string\nKeyValue[] values # an array of values associated with the status\n\n";
	public DiagnosticStatus() {}
	public static final byte OK = 0;
	public static final byte WARN = 1;
	public static final byte ERROR = 2;
	private byte level;
	public byte getLevel() { return level; }
	public void setLevel(byte value) { level = value; }
	private java.lang.String name;
	public java.lang.String getName() { return name; }
	public void setName(java.lang.String value) { name = value; }
	private java.lang.String message;
	public java.lang.String getMessage() { return message; }
	public void setMessage(java.lang.String value) { message = value; }
	private java.lang.String hardware_id;
	public java.lang.String getHardwareId() { return hardware_id; }
	public void setHardwareId(java.lang.String value) { hardware_id = value; }
	private java.util.List<diagnostic_msgs.KeyValue> values;
	public java.util.List<diagnostic_msgs.KeyValue> getValues() { return values; }
	public void setValues(java.util.List<diagnostic_msgs.KeyValue> value) { values = value; }
}
