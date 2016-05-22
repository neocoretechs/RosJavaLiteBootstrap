package visualization_msgs;

public class ImageMarker implements org.ros.internal.message.Message, java.io.Serializable {
	private static final long serialVersionUID = -1L;
	public static final java.lang.String _TYPE = "visualization_msgs/ImageMarker";
	public static final java.lang.String _DEFINITION = "uint8 CIRCLE=0\nuint8 LINE_STRIP=1\nuint8 LINE_LIST=2\nuint8 POLYGON=3\nuint8 POINTS=4\n\nuint8 ADD=0\nuint8 REMOVE=1\n\nHeader header\nstring ns\t\t# namespace, used with id to form a unique id\nint32 id          \t# unique id within the namespace\nint32 type        \t# CIRCLE/LINE_STRIP/etc.\nint32 action      \t# ADD/REMOVE\ngeometry_msgs/Point position # 2D, in pixel-coords\nfloat32 scale\t \t# the diameter for a circle, etc.\nstd_msgs/ColorRGBA outline_color\nuint8 filled\t\t# whether to fill in the shape with color\nstd_msgs/ColorRGBA fill_color # color [0.0-1.0]\nduration lifetime       # How long the object should last before being automatically deleted.  0 means forever\n\n\ngeometry_msgs/Point[] points # used for LINE_STRIP/LINE_LIST/POINTS/etc., 2D in pixel coords\nstd_msgs/ColorRGBA[] outline_colors # a color for each line, point, etc.";
	public ImageMarker() {}
	public static final byte CIRCLE = 0;
	public static final byte LINE_STRIP = 1;
	public static final byte LINE_LIST = 2;
	public static final byte POLYGON = 3;
	public static final byte POINTS = 4;
	public static final byte ADD = 0;
	public static final byte REMOVE = 1;
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
	private geometry_msgs.Point position;
	public geometry_msgs.Point getPosition() { return position; }
	public void setPosition(geometry_msgs.Point value) { position = value; }
	private float scale;
	public float getScale() { return scale; }
	public void setScale(float value) { scale = value; }
	private std_msgs.ColorRGBA outline_color;
	public std_msgs.ColorRGBA getOutlineColor() { return outline_color; }
	public void setOutlineColor(std_msgs.ColorRGBA value) { outline_color = value; }
	private byte filled;
	public byte getFilled() { return filled; }
	public void setFilled(byte value) { filled = value; }
	private std_msgs.ColorRGBA fill_color;
	public std_msgs.ColorRGBA getFillColor() { return fill_color; }
	public void setFillColor(std_msgs.ColorRGBA value) { fill_color = value; }
	private org.ros.message.Duration lifetime;
	public org.ros.message.Duration getLifetime() { return lifetime; }
	public void setLifetime(org.ros.message.Duration value) { lifetime = value; }
	private java.util.List<geometry_msgs.Point> points;
	public java.util.List<geometry_msgs.Point> getPoints() { return points; }
	public void setPoints(java.util.List<geometry_msgs.Point> value) { points = value; }
	private java.util.List<std_msgs.ColorRGBA> outline_colors;
	public java.util.List<std_msgs.ColorRGBA> getOutlineColors() { return outline_colors; }
	public void setOutlineColors(java.util.List<std_msgs.ColorRGBA> value) { outline_colors = value; }
}
