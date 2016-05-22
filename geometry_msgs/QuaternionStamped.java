package geometry_msgs;

public class QuaternionStamped implements org.ros.internal.message.Message, java.io.Serializable {
	private static final long serialVersionUID = -1L;
	public static final java.lang.String _TYPE = "geometry_msgs/QuaternionStamped";
	public static final java.lang.String _DEFINITION = "# This represents an orientation with reference coordinate frame and timestamp.\n\nHeader header\nQuaternion quaternion\n";
	public QuaternionStamped() {}
	private std_msgs.Header header;
	public std_msgs.Header getHeader() { return header; }
	public void setHeader(std_msgs.Header value) { header = value; }
	private geometry_msgs.Quaternion quaternion;
	public geometry_msgs.Quaternion getQuaternion() { return quaternion; }
	public void setQuaternion(geometry_msgs.Quaternion value) { quaternion = value; }
}
