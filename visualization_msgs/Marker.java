package visualization_msgs;

public class Marker implements org.ros.internal.message.Message, java.io.Serializable {
	private static final long serialVersionUID = -1L;
	public static final java.lang.String _TYPE = "visualization_msgs/Marker";
	public static final java.lang.String _DEFINITION = "# See http://www.ros.org/wiki/rviz/DisplayTypes/Marker and http://www.ros.org/wiki/rviz/Tutorials/Markers%3A%20Basic%20Shapes for more information on using this message with rviz\n\nuint8 ARROW=0\nuint8 CUBE=1\nuint8 SPHERE=2\nuint8 CYLINDER=3\nuint8 LINE_STRIP=4\nuint8 LINE_LIST=5\nuint8 CUBE_LIST=6\nuint8 SPHERE_LIST=7\nuint8 POINTS=8\nuint8 TEXT_VIEW_FACING=9\nuint8 MESH_RESOURCE=10\nuint8 TRIANGLE_LIST=11\n\nuint8 ADD=0\nuint8 MODIFY=0\nuint8 DELETE=2\n\nHeader header                        # header for time/frame information\nstring ns                            # Namespace to place this object in... used in conjunction with id to create a unique name for the object\nint32 id \t\t                         # object ID useful in conjunction with the namespace for manipulating and deleting the object later\nint32 type \t\t                       # Type of object\nint32 action \t                       # 0 add/modify an object, 1 (deprecated), 2 deletes an object\ngeometry_msgs/Pose pose                 # Pose of the object\ngeometry_msgs/Vector3 scale             # Scale of the object 1,1,1 means default (usually 1 meter square)\nstd_msgs/ColorRGBA color             # Color [0.0-1.0]\nduration lifetime                    # How long the object should last before being automatically deleted.  0 means forever\nbool frame_locked                    # If this marker should be frame-locked, i.e. retransformed into its frame every timestep\n\n#Only used if the type specified has some use for them (eg. POINTS, LINE_STRIP, ...)\ngeometry_msgs/Point[] points\n#Only used if the type specified has some use for them (eg. POINTS, LINE_STRIP, ...)\n#number of colors must either be 0 or equal to the number of points\n#NOTE: alpha is not yet used\nstd_msgs/ColorRGBA[] colors\n\n# NOTE: only used for text markers\nstring text\n\n# NOTE: only used for MESH_RESOURCE markers\nstring mesh_resource\nbool mesh_use_embedded_materials\n";
	public Marker() {}
	public static final byte ARROW = 0;
	public static final byte CUBE = 1;
	public static final byte SPHERE = 2;
	public static final byte CYLINDER = 3;
	public static final byte LINE_STRIP = 4;
	public static final byte LINE_LIST = 5;
	public static final byte CUBE_LIST = 6;
	public static final byte SPHERE_LIST = 7;
	public static final byte POINTS = 8;
	public static final byte TEXT_VIEW_FACING = 9;
	public static final byte MESH_RESOURCE = 10;
	public static final byte TRIANGLE_LIST = 11;
	public static final byte ADD = 0;
	public static final byte MODIFY = 0;
	public static final byte DELETE = 2;
	private std_msgs.Header header;
	public std_msgs.Header getHeader() { return header; }
	public void setHeader(std_msgs.Header value) { header = value; }
	private java.lang.String ns;
	public java.lang.String getNs() { return ns; }
	public void setNs(java.lang.String value) { ns = value; }
	private int id;
	public int getId() { return id; }
	public void setId(int value) { id = value; }
	private int type;
	public int getType() { return type; }
	public void setType(int value) { type = value; }
	private int action;
	public int getAction() { return action; }
	public void setAction(int value) { action = value; }
	private geometry_msgs.Pose pose;
	public geometry_msgs.Pose getPose() { return pose; }
	public void setPose(geometry_msgs.Pose value) { pose = value; }
	private geometry_msgs.Vector3 scale;
	public geometry_msgs.Vector3 getScale() { return scale; }
	public void setScale(geometry_msgs.Vector3 value) { scale = value; }
	private std_msgs.ColorRGBA color;
	public std_msgs.ColorRGBA getColor() { return color; }
	public void setColor(std_msgs.ColorRGBA value) { color = value; }
	private org.ros.message.Duration lifetime;
	public org.ros.message.Duration getLifetime() { return lifetime; }
	public void setLifetime(org.ros.message.Duration value) { lifetime = value; }
	private boolean frame_locked;
	public boolean getFrameLocked() { return frame_locked; }
	public void setFrameLocked(boolean value) { frame_locked = value; }
	private java.util.List<geometry_msgs.Point> points;
	public java.util.List<geometry_msgs.Point> getPoints() { return points; }
	public void setPoints(java.util.List<geometry_msgs.Point> value) { points = value; }
	private java.util.List<std_msgs.ColorRGBA> colors;
	public java.util.List<std_msgs.ColorRGBA> getColors() { return colors; }
	public void setColors(java.util.List<std_msgs.ColorRGBA> value) { colors = value; }
	private java.lang.String text;
	public java.lang.String getText() { return text; }
	public void setText(java.lang.String value) { text = value; }
	private java.lang.String mesh_resource;
	public java.lang.String getMeshResource() { return mesh_resource; }
	public void setMeshResource(java.lang.String value) { mesh_resource = value; }
	private boolean mesh_use_embedded_materials;
	public boolean getMeshUseEmbeddedMaterials() { return mesh_use_embedded_materials; }
	public void setMeshUseEmbeddedMaterials(boolean value) { mesh_use_embedded_materials = value; }
}
