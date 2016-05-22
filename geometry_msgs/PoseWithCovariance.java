package geometry_msgs;

public class PoseWithCovariance implements org.ros.internal.message.Message, java.io.Serializable {
	private static final long serialVersionUID = -1L;
	public static final java.lang.String _TYPE = "geometry_msgs/PoseWithCovariance";
	public static final java.lang.String _DEFINITION = "# This represents a pose in free space with uncertainty.\n\nPose pose\n\n# Row-major representation of the 6x6 covariance matrix\n# The orientation parameters use a fixed-axis representation.\n# In order, the parameters are:\n# (x, y, z, rotation about X axis, rotation about Y axis, rotation about Z axis)\nfloat64[36] covariance\n";
	public PoseWithCovariance() {}
	private geometry_msgs.Pose pose;
	public geometry_msgs.Pose getPose() { return pose; }
	public void setPose(geometry_msgs.Pose value) { pose = value; }
	private double[] covariance;
	public double[] getCovariance() { return covariance; }
	public void setCovariance(double[] value) { covariance = value; }
}
