package actionlib_msgs;

public class GoalStatus implements org.ros.internal.message.Message, java.io.Serializable {
	private static final long serialVersionUID = -1L;
	public static final java.lang.String _TYPE = "actionlib_msgs/GoalStatus";
	public static final java.lang.String _DEFINITION = "GoalID goal_id\nuint8 status\nuint8 PENDING         = 0   # The goal has yet to be processed by the action server\nuint8 ACTIVE          = 1   # The goal is currently being processed by the action server\nuint8 PREEMPTED       = 2   # The goal received a cancel request after it started executing\n                            #   and has since completed its execution (Terminal State)\nuint8 SUCCEEDED       = 3   # The goal was achieved successfully by the action server (Terminal State)\nuint8 ABORTED         = 4   # The goal was aborted during execution by the action server due\n                            #    to some failure (Terminal State)\nuint8 REJECTED        = 5   # The goal was rejected by the action server without being processed,\n                            #    because the goal was unattainable or invalid (Terminal State)\nuint8 PREEMPTING      = 6   # The goal received a cancel request after it started executing\n                            #    and has not yet completed execution\nuint8 RECALLING       = 7   # The goal received a cancel request before it started executing,\n                            #    but the action server has not yet confirmed that the goal is canceled\nuint8 RECALLED        = 8   # The goal received a cancel request before it started executing\n                            #    and was successfully cancelled (Terminal State)\nuint8 LOST            = 9   # An action client can determine that a goal is LOST. This should not be\n                            #    sent over the wire by an action server\n\n#Allow for the user to associate a string with GoalStatus for debugging\nstring text\n\n";
	public GoalStatus() {}
	public static final byte PENDING = 0;
	public static final byte ACTIVE = 1;
	public static final byte PREEMPTED = 2;
	public static final byte SUCCEEDED = 3;
	public static final byte ABORTED = 4;
	public static final byte REJECTED = 5;
	public static final byte PREEMPTING = 6;
	public static final byte RECALLING = 7;
	public static final byte RECALLED = 8;
	public static final byte LOST = 9;
	private actionlib_msgs.GoalID goal_id;
	public actionlib_msgs.GoalID getGoalId() { return goal_id; }
	public void setGoalId(actionlib_msgs.GoalID value) { goal_id = value; }
	private byte status;
	public byte getStatus() { return status; }
	public void setStatus(byte value) { status = value; }
	private java.lang.String text;
	public java.lang.String getText() { return text; }
	public void setText(java.lang.String value) { text = value; }
}
