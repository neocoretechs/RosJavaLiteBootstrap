package geometry_msgs;

public class Point32 implements org.ros.internal.message.Message, java.io.Serializable {
	private static final long serialVersionUID = -1L;
	public static final java.lang.String _TYPE = "geometry_msgs/Point32";
	public static final java.lang.String _DEFINITION = "# This contains the position of a point in free space(with 32 bits of precision).\n# It is recommeded to use Point wherever possible instead of Point32.  \n# \n# This recommendation is to promote interoperability.  \n#\n# This message is designed to take up less space when sending\n# lots of points at once, as in the case of a PointCloud.  \n\nfloat32 x\nfloat32 y\nfloat32 z";
	public Point32() {}
	private float x;
	public float getX() { return x; }
	public void setX(float value) { x = value; }
	private float y;
	public float getY() { return y; }
	public void setY(float value) { y = value; }
	private float z;
	public float getZ() { return z; }
	public void setZ(float value) { z = value; }
}
