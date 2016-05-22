package geometry_msgs;

public class Twist implements org.ros.internal.message.Message, java.io.Serializable {
	private static final long serialVersionUID = -1L;
	public static final java.lang.String _TYPE = "geometry_msgs/Twist";
	public static final java.lang.String _DEFINITION = "# This expresses velocity in free space broken into its linear and angular parts.\nVector3  linear\nVector3  angular\n";
	public Twist() {}
	private geometry_msgs.Vector3 linear;
	public geometry_msgs.Vector3 getLinear() { return linear; }
	public void setLinear(geometry_msgs.Vector3 value) { linear = value; }
	private geometry_msgs.Vector3 angular;
	public geometry_msgs.Vector3 getAngular() { return angular; }
	public void setAngular(geometry_msgs.Vector3 value) { angular = value; }
}
