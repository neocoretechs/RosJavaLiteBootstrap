package geometry_msgs;

public class Pose2D implements org.ros.internal.message.Message, java.io.Serializable {
	private static final long serialVersionUID = -1L;
	public static final java.lang.String _TYPE = "geometry_msgs/Pose2D";
	public static final java.lang.String _DEFINITION = "# This expresses a position and orientation on a 2D manifold.\n\nfloat64 x\nfloat64 y\nfloat64 theta";
	public Pose2D() {}
	private double x;
	public double getX() { return x; }
	public void setX(double value) { x = value; }
	private double y;
	public double getY() { return y; }
	public void setY(double value) { y = value; }
	private double theta;
	public double getTheta() { return theta; }
	public void setTheta(double value) { theta = value; }
}
