package geometry_msgs;

public class TwistStamped implements org.ros.internal.message.Message, java.io.Serializable {
	private static final long serialVersionUID = -1L;
	public static final java.lang.String _TYPE = "geometry_msgs/TwistStamped";
	public static final java.lang.String _DEFINITION = "# A twist with reference coordinate frame and timestamp\nHeader header\nTwist twist\n";
	public TwistStamped() {}
	private std_msgs.Header header;
	public std_msgs.Header getHeader() { return header; }
	public void setHeader(std_msgs.Header value) { header = value; }
	private geometry_msgs.Twist twist;
	public geometry_msgs.Twist getTwist() { return twist; }
	public void setTwist(geometry_msgs.Twist value) { twist = value; }
}
