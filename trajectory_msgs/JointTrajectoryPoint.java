package trajectory_msgs;

public class JointTrajectoryPoint implements org.ros.internal.message.Message, java.io.Serializable {
	private static final long serialVersionUID = -1L;
	public static final java.lang.String _TYPE = "trajectory_msgs/JointTrajectoryPoint";
	public static final java.lang.String _DEFINITION = "float64[] positions\nfloat64[] velocities\nfloat64[] accelerations\nduration time_from_start";
	public JointTrajectoryPoint() {}
	private double[] positions;
	public double[] getPositions() { return positions; }
	public void setPositions(double[] value) { positions = value; }
	private double[] velocities;
	public double[] getVelocities() { return velocities; }
	public void setVelocities(double[] value) { velocities = value; }
	private double[] accelerations;
	public double[] getAccelerations() { return accelerations; }
	public void setAccelerations(double[] value) { accelerations = value; }
	private org.ros.message.Duration time_from_start;
	public org.ros.message.Duration getTimeFromStart() { return time_from_start; }
	public void setTimeFromStart(org.ros.message.Duration value) { time_from_start = value; }
}
