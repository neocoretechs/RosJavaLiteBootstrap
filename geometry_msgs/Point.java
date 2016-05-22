package geometry_msgs;

public class Point implements org.ros.internal.message.Message, java.io.Serializable {
	private static final long serialVersionUID = -1L;
	public static final java.lang.String _TYPE = "geometry_msgs/Point";
	public static final java.lang.String _DEFINITION = "# This contains the position of a point in free space\nfloat64 x\nfloat64 y\nfloat64 z\n";
	public Point() {}
	private double x;
	public double getX() { return x; }
	public void setX(double value) { x = value; }
	private double y;
	public double getY() { return y; }
	public void setY(double value) { y = value; }
	private double z;
	public double getZ() { return z; }
	public void setZ(double value) { z = value; }
}
