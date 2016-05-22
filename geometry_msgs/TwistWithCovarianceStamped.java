package geometry_msgs;

public class TwistWithCovarianceStamped implements org.ros.internal.message.Message, java.io.Serializable {
	private static final long serialVersionUID = -1L;
	public static final java.lang.String _TYPE = "geometry_msgs/TwistWithCovarianceStamped";
	public static final java.lang.String _DEFINITION = "# This represents an estimated twist with reference coordinate frame and timestamp.\nHeader header\nTwistWithCovariance twist\n";
	public TwistWithCovarianceStamped() {}
	private std_msgs.Header header;
	public std_msgs.Header getHeader() { return header; }
	public void setHeader(std_msgs.Header value) { header = value; }
	private geometry_msgs.TwistWithCovariance twist;
	public geometry_msgs.TwistWithCovariance getTwist() { return twist; }
	public void setTwist(geometry_msgs.TwistWithCovariance value) { twist = value; }
}
