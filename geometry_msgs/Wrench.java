package geometry_msgs;

public class Wrench implements org.ros.internal.message.Message, java.io.Serializable {
	private static final long serialVersionUID = -1L;
	public static final java.lang.String _TYPE = "geometry_msgs/Wrench";
	public static final java.lang.String _DEFINITION = "# This represents force in free space, separated into\n# its linear and angular parts.\nVector3  force\nVector3  torque\n";
	public Wrench() {}
	private geometry_msgs.Vector3 force;
	public geometry_msgs.Vector3 getForce() { return force; }
	public void setForce(geometry_msgs.Vector3 value) { force = value; }
	private geometry_msgs.Vector3 torque;
	public geometry_msgs.Vector3 getTorque() { return torque; }
	public void setTorque(geometry_msgs.Vector3 value) { torque = value; }
}
