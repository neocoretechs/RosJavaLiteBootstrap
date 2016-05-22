package visualization_msgs;

public class InteractiveMarker implements org.ros.internal.message.Message, java.io.Serializable {
	private static final long serialVersionUID = -1L;
	public static final java.lang.String _TYPE = "visualization_msgs/InteractiveMarker";
	public static final java.lang.String _DEFINITION = "# Time/frame info.\n# If header.time is set to 0, the marker will be retransformed into\n# its frame on each timestep. You will receive the pose feedback\n# in the same frame.\n# Otherwise, you might receive feedback in a different frame.\n# For rviz, this will be the current \'fixed frame\' set by the user.\nHeader header\n\n# Initial pose. Also, defines the pivot point for rotations.\ngeometry_msgs/Pose pose\n\n# Identifying string. Must be globally unique in\n# the topic that this message is sent through.\nstring name\n\n# Short description (< 40 characters).\nstring description\n\n# Scale to be used for default controls (default=1).\nfloat32 scale\n\n# All menu and submenu entries associated with this marker.\nMenuEntry[] menu_entries\n\n# List of controls displayed for this marker.\nInteractiveMarkerControl[] controls\n";
	public InteractiveMarker() {}
	private std_msgs.Header header;
	public std_msgs.Header getHeader() { return header; }
	public void setHeader(std_msgs.Header value) { header = value; }
	private geometry_msgs.Pose pose;
	public geometry_msgs.Pose getPose() { return pose; }
	public void setPose(geometry_msgs.Pose value) { pose = value; }
	private java.lang.String name;
	public java.lang.String getName() { return name; }
	public void setName(java.lang.String value) { name = value; }
	private java.lang.String description;
	public java.lang.String getDescription() { return description; }
	public void setDescription(java.lang.String value) { description = value; }
	private float scale;
	public float getScale() { return scale; }
	public void setScale(float value) { scale = value; }
	private java.util.List<visualization_msgs.MenuEntry> menu_entries;
	public java.util.List<visualization_msgs.MenuEntry> getMenuEntries() { return menu_entries; }
	public void setMenuEntries(java.util.List<visualization_msgs.MenuEntry> value) { menu_entries = value; }
	private java.util.List<visualization_msgs.InteractiveMarkerControl> controls;
	public java.util.List<visualization_msgs.InteractiveMarkerControl> getControls() { return controls; }
	public void setControls(java.util.List<visualization_msgs.InteractiveMarkerControl> value) { controls = value; }
}
