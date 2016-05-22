package geometry_msgs;

public class Vector3Stamped implements org.ros.internal.message.Message, java.io.Serializable {
	private static final long serialVersionUID = -1L;
	public static final java.lang.String _TYPE = "geometry_msgs/Vector3Stamped";
	public static final java.lang.String _DEFINITION = "# This represents a Vector3 with reference coordinate frame and timestamp\nHeader header\nVector3 vector\n";
	public Vector3Stamped() {}
	private std_msgs.Header header;
	public std_msgs.Header getHeader() { return header; }
	public void setHeader(std_msgs.Header value) { header = value; }
	private geometry_msgs.Vector3 vector;
	public geometry_msgs.Vector3 getVector() { return vector; }
	public void setVector(geometry_msgs.Vector3 value) { vector = value; }
}
