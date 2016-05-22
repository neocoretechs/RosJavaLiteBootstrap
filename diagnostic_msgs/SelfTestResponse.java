package diagnostic_msgs;

public class SelfTestResponse implements org.ros.internal.message.Message, java.io.Serializable {
	private static final long serialVersionUID = -1L;
	public static final java.lang.String _TYPE = "diagnostic_msgs/SelfTestResponse";
	public static final java.lang.String _DEFINITION = "string id\nbyte passed\nDiagnosticStatus[] status";
	public SelfTestResponse() {}
	private java.lang.String id;
	public java.lang.String getId() { return id; }
	public void setId(java.lang.String value) { id = value; }
	private byte passed;
	public byte getPassed() { return passed; }
	public void setPassed(byte value) { passed = value; }
	private java.util.List<diagnostic_msgs.DiagnosticStatus> status;
	public java.util.List<diagnostic_msgs.DiagnosticStatus> getStatus() { return status; }
	public void setStatus(java.util.List<diagnostic_msgs.DiagnosticStatus> value) { status = value; }
}
