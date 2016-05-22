package geometry_msgs;

public class PoseStamped implements org.ros.internal.message.Message, java.io.Serializable {
	private static final long serialVersionUID = -1L;
	public static final java.lang.String _TYPE = "geometry_msgs/PoseStamped";
	public static final java.lang.String _DEFINITION = "# A Pose with reference coordinate frame and timestamp\nHeader header\nPose pose\n";
	public PoseStamped() {}
	private std_msgs.Header header;
	public std_msgs.Header getHeader() { return header; }
	public void setHeader(std_msgs.Header value) { header = value; }
	private geometry_msgs.Pose pose;
	public geometry_msgs.Pose getPose() { return pose; }
	public void setPose(geometry_msgs.Pose value) { pose = value; }
}
