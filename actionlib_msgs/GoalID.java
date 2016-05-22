package actionlib_msgs;

public class GoalID implements org.ros.internal.message.Message, java.io.Serializable {
	private static final long serialVersionUID = -1L;
	public static final java.lang.String _TYPE = "actionlib_msgs/GoalID";
	public static final java.lang.String _DEFINITION = "# The stamp should store the time at which this goal was requested.\n# It is used by an action server when it tries to preempt all\n# goals that were requested before a certain time\ntime stamp\n\n# The id provides a way to associate feedback and\n# result message with specific goal requests. The id\n# specified must be unique.\nstring id\n\n";
	public GoalID() {}
	private org.ros.message.Time stamp;
	public org.ros.message.Time getStamp() { return stamp; }
	public void setStamp(org.ros.message.Time value) { stamp = value; }
	private java.lang.String id;
	public java.lang.String getId() { return id; }
	public void setId(java.lang.String value) { id = value; }
}
