package diagnostic_msgs;

public class DiagnosticArray implements org.ros.internal.message.Message, java.io.Serializable {
	private static final long serialVersionUID = -1L;
	public static final java.lang.String _TYPE = "diagnostic_msgs/DiagnosticArray";
	public static final java.lang.String _DEFINITION = "# This message is used to send diagnostic information about the state of the robot\nHeader header #for timestamp\nDiagnosticStatus[] status # an array of components being reported on";
	public DiagnosticArray() {}
	private std_msgs.Header header;
	public std_msgs.Header getHeader() { return header; }
	public void setHeader(std_msgs.Header value) { header = value; }
	private java.util.List<diagnostic_msgs.DiagnosticStatus> status;
	public java.util.List<diagnostic_msgs.DiagnosticStatus> getStatus() { return status; }
	public void setStatus(java.util.List<diagnostic_msgs.DiagnosticStatus> value) { status = value; }
}
