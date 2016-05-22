package geometry_msgs;

public class Pose implements org.ros.internal.message.Message, java.io.Serializable {
	private static final long serialVersionUID = -1L;
	public static final java.lang.String _TYPE = "geometry_msgs/Pose";
	public static final java.lang.String _DEFINITION = "# A representation of pose in free space, composed of postion and orientation. \nPoint position\nQuaternion orientation\n";
	public Pose() {}
	private geometry_msgs.Point position;
	public geometry_msgs.Point getPosition() { return position; }
	public void setPosition(geometry_msgs.Point value) { position = value; }
	private geometry_msgs.Quaternion orientation;
	public geometry_msgs.Quaternion getOrientation() { return orientation; }
	public void setOrientation(geometry_msgs.Quaternion value) { orientation = value; }
}
