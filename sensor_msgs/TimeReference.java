package sensor_msgs;

public class TimeReference implements org.ros.internal.message.Message, java.io.Serializable {
	private static final long serialVersionUID = -1L;
	public static final java.lang.String _TYPE = "sensor_msgs/TimeReference";
	public static final java.lang.String _DEFINITION = "# Measurement from an external time source not actively synchronized with the system clock.\n\nHeader header    # stamp is system time for which measurement was valid\n                 # frame_id is not used \n\ntime   time_ref  # corresponding time from this external source\nstring source    # (optional) name of time source\n";
	public TimeReference() {}
	private std_msgs.Header header;
	public std_msgs.Header getHeader() { return header; }
	public void setHeader(std_msgs.Header value) { header = value; }
	private org.ros.message.Time time_ref;
	public org.ros.message.Time getTimeRef() { return time_ref; }
	public void setTimeRef(org.ros.message.Time value) { time_ref = value; }
	private java.lang.String source;
	public java.lang.String getSource() { return source; }
	public void setSource(java.lang.String value) { source = value; }
}
