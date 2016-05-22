package nav_msgs;

public class Odometry implements org.ros.internal.message.Message, java.io.Serializable {
	private static final long serialVersionUID = -1L;
	public static final java.lang.String _TYPE = "nav_msgs/Odometry";
	public static final java.lang.String _DEFINITION = "# This represents an estimate of a position and velocity in free space.  \n# The pose in this message should be specified in the coordinate frame given by header.frame_id.\n# The twist in this message should be specified in the coordinate frame given by the child_frame_id\nHeader header\nstring child_frame_id\ngeometry_msgs/PoseWithCovariance pose\ngeometry_msgs/TwistWithCovariance twist\n";
	public Odometry() {}
	private std_msgs.Header header;
	public std_msgs.Header getHeader() { return header; }
	public void setHeader(std_msgs.Header value) { header = value; }
	private java.lang.String child_frame_id;
	public java.lang.String getChildFrameId() { return child_frame_id; }
	public void setChildFrameId(java.lang.String value) { child_frame_id = value; }
	private geometry_msgs.PoseWithCovariance pose;
	public geometry_msgs.PoseWithCovariance getPose() { return pose; }
	public void setPose(geometry_msgs.PoseWithCovariance value) { pose = value; }
	private geometry_msgs.TwistWithCovariance twist;
	public geometry_msgs.TwistWithCovariance getTwist() { return twist; }
	public void setTwist(geometry_msgs.TwistWithCovariance value) { twist = value; }
}
