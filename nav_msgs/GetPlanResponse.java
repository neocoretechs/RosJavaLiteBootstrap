package nav_msgs;

public class GetPlanResponse implements org.ros.internal.message.Message, java.io.Serializable {
	private static final long serialVersionUID = -1L;
	public static final java.lang.String _TYPE = "nav_msgs/GetPlanResponse";
	public static final java.lang.String _DEFINITION = "nav_msgs/Path plan";
	public GetPlanResponse() {}
	private nav_msgs.Path plan;
	public nav_msgs.Path getPlan() { return plan; }
	public void setPlan(nav_msgs.Path value) { plan = value; }
}
