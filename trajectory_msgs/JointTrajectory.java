package trajectory_msgs;

public class JointTrajectory implements org.ros.internal.message.Message, java.io.Serializable {
	private static final long serialVersionUID = -1L;
	public static final java.lang.String _TYPE = "trajectory_msgs/JointTrajectory";
	public static final java.lang.String _DEFINITION = "Header header\nstring[] joint_names\nJointTrajectoryPoint[] points";
	public JointTrajectory() {}
	private std_msgs.Header header;
	public std_msgs.Header getHeader() { return header; }
	public void setHeader(std_msgs.Header value) { header = value; }
	private java.util.List<java.lang.String> joint_names;
	public java.util.List<java.lang.String> getJointNames() { return joint_names; }
	public void setJointNames(java.util.List<java.lang.String> value) { joint_names = value; }
	private java.util.List<trajectory_msgs.JointTrajectoryPoint> points;
	public java.util.List<trajectory_msgs.JointTrajectoryPoint> getPoints() { return points; }
	public void setPoints(java.util.List<trajectory_msgs.JointTrajectoryPoint> value) { points = value; }
}
