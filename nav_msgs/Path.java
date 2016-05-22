package nav_msgs;

public class Path implements org.ros.internal.message.Message, java.io.Serializable {
	private static final long serialVersionUID = -1L;
	public static final java.lang.String _TYPE = "nav_msgs/Path";
	public static final java.lang.String _DEFINITION = "#An array of poses that represents a Path for a robot to follow\nHeader header\ngeometry_msgs/PoseStamped[] poses\n";
	public Path() {}
	private std_msgs.Header header;
	public std_msgs.Header getHeader() { return header; }
	public void setHeader(std_msgs.Header value) { header = value; }
	private java.util.List<geometry_msgs.PoseStamped> poses;
	public java.util.List<geometry_msgs.PoseStamped> getPoses() { return poses; }
	public void setPoses(java.util.List<geometry_msgs.PoseStamped> value) { poses = value; }
}
