package geometry_msgs;

public class PoseArray implements org.ros.internal.message.Message, java.io.Serializable {
	private static final long serialVersionUID = -1L;
	public static final java.lang.String _TYPE = "geometry_msgs/PoseArray";
	public static final java.lang.String _DEFINITION = "# An array of poses with a header for global reference.\n\nHeader header\n\nPose[] poses\n";
	public PoseArray() {}
	private std_msgs.Header header;
	public std_msgs.Header getHeader() { return header; }
	public void setHeader(std_msgs.Header value) { header = value; }
	private java.util.List<geometry_msgs.Pose> poses;
	public java.util.List<geometry_msgs.Pose> getPoses() { return poses; }
	public void setPoses(java.util.List<geometry_msgs.Pose> value) { poses = value; }
}
