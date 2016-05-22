package nav_msgs;

public class MapMetaData implements org.ros.internal.message.Message, java.io.Serializable {
	private static final long serialVersionUID = -1L;
	public static final java.lang.String _TYPE = "nav_msgs/MapMetaData";
	public static final java.lang.String _DEFINITION = "# This hold basic information about the characterists of the OccupancyGrid\n\n# The time at which the map was loaded\ntime map_load_time\n# The map resolution [m/cell]\nfloat32 resolution\n# Map width [cells]\nuint32 width\n# Map height [cells]\nuint32 height\n# The origin of the map [m, m, rad].  This is the real-world pose of the\n# cell (0,0) in the map.\ngeometry_msgs/Pose origin";
	public MapMetaData() {}
	private org.ros.message.Time map_load_time;
	public org.ros.message.Time getMapLoadTime() { return map_load_time; }
	public void setMapLoadTime(org.ros.message.Time value) { map_load_time = value; }
	private float resolution;
	public float getResolution() { return resolution; }
	public void setResolution(float value) { resolution = value; }
	private int width;
	public int getWidth() { return width; }
	public void setWidth(int value) { width = value; }
	private int height;
	public int getHeight() { return height; }
	public void setHeight(int value) { height = value; }
	private geometry_msgs.Pose origin;
	public geometry_msgs.Pose getOrigin() { return origin; }
	public void setOrigin(geometry_msgs.Pose value) { origin = value; }
}
