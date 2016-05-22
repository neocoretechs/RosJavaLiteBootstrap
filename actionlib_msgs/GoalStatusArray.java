package actionlib_msgs;

public class GoalStatusArray implements org.ros.internal.message.Message, java.io.Serializable {
	private static final long serialVersionUID = -1L;
	public static final java.lang.String _TYPE = "actionlib_msgs/GoalStatusArray";
	public static final java.lang.String _DEFINITION = "# Stores the statuses for goals that are currently being tracked\n# by an action server\nHeader header\nGoalStatus[] status_list\n\n";
	public GoalStatusArray() {}
	private std_msgs.Header header;
	public std_msgs.Header getHeader() { return header; }
	public void setHeader(std_msgs.Header value) { header = value; }
	private java.util.List<actionlib_msgs.GoalStatus> status_list;
	public java.util.List<actionlib_msgs.GoalStatus> getStatusList() { return status_list; }
	public void setStatusList(java.util.List<actionlib_msgs.GoalStatus> value) { status_list = value; }
}
