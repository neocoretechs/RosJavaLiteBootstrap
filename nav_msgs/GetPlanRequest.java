package nav_msgs;

public class GetPlanRequest implements org.ros.internal.message.Message, java.io.Serializable {
	private static final long serialVersionUID = -1L;
	public static final java.lang.String _TYPE = "nav_msgs/GetPlanRequest";
	public static final java.lang.String _DEFINITION = "# Get a plan from the current position to the goal Pose \n\n# The start pose for the plan\ngeometry_msgs/PoseStamped start\n\n# The final pose of the goal position\ngeometry_msgs/PoseStamped goal\n\n# If the goal is obstructed, how many meters the planner can \n# relax the constraint in x and y before failing. \nfloat32 tolerance\n";
	public GetPlanRequest() {}
	private geometry_msgs.PoseStamped start;
	public geometry_msgs.PoseStamped getStart() { return start; }
	public void setStart(geometry_msgs.PoseStamped value) { start = value; }
	private geometry_msgs.PoseStamped goal;
	public geometry_msgs.PoseStamped getGoal() { return goal; }
	public void setGoal(geometry_msgs.PoseStamped value) { goal = value; }
	private float tolerance;
	public float getTolerance() { return tolerance; }
	public void setTolerance(float value) { tolerance = value; }
}
