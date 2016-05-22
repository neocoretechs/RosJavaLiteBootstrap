package geometry_msgs;

public class Transform implements org.ros.internal.message.Message, java.io.Serializable {
	private static final long serialVersionUID = -1L;
	public static final java.lang.String _TYPE = "geometry_msgs/Transform";
	public static final java.lang.String _DEFINITION = "# This represents the transform between two coordinate frames in free space.\n\nVector3 translation\nQuaternion rotation\n";
	public Transform() {}
	private geometry_msgs.Vector3 translation;
	public geometry_msgs.Vector3 getTranslation() { return translation; }
	public void setTranslation(geometry_msgs.Vector3 value) { translation = value; }
	private geometry_msgs.Quaternion rotation;
	public geometry_msgs.Quaternion getRotation() { return rotation; }
	public void setRotation(geometry_msgs.Quaternion value) { rotation = value; }
}
