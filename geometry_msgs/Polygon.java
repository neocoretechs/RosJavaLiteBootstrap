package geometry_msgs;

public class Polygon implements org.ros.internal.message.Message, java.io.Serializable {
	private static final long serialVersionUID = -1L;
	public static final java.lang.String _TYPE = "geometry_msgs/Polygon";
	public static final java.lang.String _DEFINITION = "#A specification of a polygon where the first and last points are assumed to be connected\nPoint32[] points\n";
	public Polygon() {}
	private java.util.List<geometry_msgs.Point32> points;
	public java.util.List<geometry_msgs.Point32> getPoints() { return points; }
	public void setPoints(java.util.List<geometry_msgs.Point32> value) { points = value; }
}
