package sensor_msgs;

public class PointCloud implements org.ros.internal.message.Message, java.io.Serializable {
	private static final long serialVersionUID = -1L;
	public static final java.lang.String _TYPE = "sensor_msgs/PointCloud";
	public static final java.lang.String _DEFINITION = "# This message holds a collection of 3d points, plus optional additional\n# information about each point.\n\n# Time of sensor data acquisition, coordinate frame ID.\nHeader header\n\n# Array of 3d points. Each Point32 should be interpreted as a 3d point\n# in the frame given in the header.\ngeometry_msgs/Point32[] points\n\n# Each channel should have the same number of elements as points array,\n# and the data in each channel should correspond 1:1 with each point.\n# Channel names in common practice are listed in ChannelFloat32.msg.\nChannelFloat32[] channels\n";
	public PointCloud() {}
	private std_msgs.Header header;
	public std_msgs.Header getHeader() { return header; }
	public void setHeader(std_msgs.Header value) { header = value; }
	private java.util.List<geometry_msgs.Point32> points;
	public java.util.List<geometry_msgs.Point32> getPoints() { return points; }
	public void setPoints(java.util.List<geometry_msgs.Point32> value) { points = value; }
	private java.util.List<sensor_msgs.ChannelFloat32> channels;
	public java.util.List<sensor_msgs.ChannelFloat32> getChannels() { return channels; }
	public void setChannels(java.util.List<sensor_msgs.ChannelFloat32> value) { channels = value; }
}
