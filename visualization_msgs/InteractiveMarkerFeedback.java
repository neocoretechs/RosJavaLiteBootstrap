package visualization_msgs;

public class InteractiveMarkerFeedback implements org.ros.internal.message.Message, java.io.Serializable {
	private static final long serialVersionUID = -1L;
	public static final java.lang.String _TYPE = "visualization_msgs/InteractiveMarkerFeedback";
	public static final java.lang.String _DEFINITION = "# Time/frame info.\nHeader header\n\n# Identifying string. Must be unique in the topic namespace.\nstring client_id\n\n# Feedback message sent back from the GUI, e.g.\n# when the status of an interactive marker was modified by the user.\n\n# Specifies which interactive marker and control this message refers to\nstring marker_name\nstring control_name\n\n# Type of the event\n# KEEP_ALIVE: sent while dragging to keep up control of the marker\n# MENU_SELECT: a menu entry has been selected\n# BUTTON_CLICK: a button control has been clicked\n# POSE_UPDATE: the pose has been changed using one of the controls\nuint8 KEEP_ALIVE = 0\nuint8 POSE_UPDATE = 1\nuint8 MENU_SELECT = 2\nuint8 BUTTON_CLICK = 3\n\nuint8 MOUSE_DOWN = 4\nuint8 MOUSE_UP = 5\n\nuint8 event_type\n\n# Current pose of the marker\n# Note: Has to be valid for all feedback types.\ngeometry_msgs/Pose pose\n\n# Contains the ID of the selected menu entry\n# Only valid for MENU_SELECT events.\nuint32 menu_entry_id\n\n# If event_type is BUTTON_CLICK, MOUSE_DOWN, or MOUSE_UP, mouse_point\n# may contain the 3 dimensional position of the event on the\n# control.  If it does, mouse_point_valid will be true.  mouse_point\n# will be relative to the frame listed in the header.\ngeometry_msgs/Point mouse_point\nbool mouse_point_valid\n";
	public InteractiveMarkerFeedback() {}
	public static final byte KEEP_ALIVE = 0;
	public static final byte POSE_UPDATE = 1;
	public static final byte MENU_SELECT = 2;
	public static final byte BUTTON_CLICK = 3;
	public static final byte MOUSE_DOWN = 4;
	public static final byte MOUSE_UP = 5;
	private std_msgs.Header header;
	public std_msgs.Header getHeader() { return header; }
	public void setHeader(std_msgs.Header value) { header = value; }
	private java.lang.String client_id;
	public java.lang.String getClientId() { return client_id; }
	public void setClientId(java.lang.String value) { client_id = value; }
	private java.lang.String marker_name;
	public java.lang.String getMarkerName() { return marker_name; }
	public void setMarkerName(java.lang.String value) { marker_name = value; }
	private java.lang.String control_name;
	public java.lang.String getControlName() { return control_name; }
	public void setControlName(java.lang.String value) { control_name = value; }
	private byte event_type;
	public byte getEventType() { return event_type; }
	public void setEventType(byte value) { event_type = value; }
	private geometry_msgs.Pose pose;
	public geometry_msgs.Pose getPose() { return pose; }
	public void setPose(geometry_msgs.Pose value) { pose = value; }
	private int menu_entry_id;
	public int getMenuEntryId() { return menu_entry_id; }
	public void setMenuEntryId(int value) { menu_entry_id = value; }
	private geometry_msgs.Point mouse_point;
	public geometry_msgs.Point getMousePoint() { return mouse_point; }
	public void setMousePoint(geometry_msgs.Point value) { mouse_point = value; }
	private boolean mouse_point_valid;
	public boolean getMousePointValid() { return mouse_point_valid; }
	public void setMousePointValid(boolean value) { mouse_point_valid = value; }
}
