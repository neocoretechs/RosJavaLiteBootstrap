package sensor_msgs;

public class PointCloud2 implements org.ros.internal.message.Message, java.io.Serializable {
	private static final long serialVersionUID = -1L;
	public static final java.lang.String _TYPE = "sensor_msgs/PointCloud2";
	public static final java.lang.String _DEFINITION = "# This message holds a collection of N-dimensional points, which may\n# contain additional information such as normals, intensity, etc. The\n# point data is stored as a binary blob, its layout described by the\n# contents of the \"fields\" array.\n\n# The point cloud data may be organized 2d (image-like) or 1d\n# (unordered). Point clouds organized as 2d images may be produced by\n# camera depth sensors such as stereo or time-of-flight.\n\n# Time of sensor data acquisition, and the coordinate frame ID (for 3d\n# points).\nHeader header\n\n# 2D structure of the point cloud. If the cloud is unordered, height is\n# 1 and width is the length of the point cloud.\nuint32 height\nuint32 width\n\n# Describes the channels and their layout in the binary data blob.\nPointField[] fields\n\nbool    is_bigendian # Is this data bigendian?\nuint32  point_step   # Length of a point in bytes\nuint32  row_step     # Length of a row in bytes\nuint8[] data         # Actual point data, size is (row_step*height)\n\nbool is_dense        # True if there are no invalid points\n";
	public PointCloud2() {}
	private std_msgs.Header header;
	public std_msgs.Header getHeader() { return header; }
	public void setHeader(std_msgs.Header value) { header = value; }
	private int height;
	public int getHeight() { return height; }
	public void setHeight(int value) { height = value; }
	private int width;
	public int getWidth() { return width; }
	public void setWidth(int value) { width = value; }
	private java.util.List<sensor_msgs.PointField> fields;
	public java.util.List<sensor_msgs.PointField> getFields() { return fields; }
	public void setFields(java.util.List<sensor_msgs.PointField> value) { fields = value; }
	private boolean is_bigendian;
	public boolean getIsBigendian() { return is_bigendian; }
	public void setIsBigendian(boolean value) { is_bigendian = value; }
	private int point_step;
	public int getPointStep() { return point_step; }
	public void setPointStep(int value) { point_step = value; }
	private int row_step;
	public int getRowStep() { return row_step; }
	public void setRowStep(int value) { row_step = value; }
	private transient java.nio.ByteBuffer data=null;
	private byte[] bytesdata;
	public java.nio.ByteBuffer getData() { if( data != null ) return data; else data = java.nio.ByteBuffer.wrap(bytesdata); return data.order(java.nio.ByteOrder.LITTLE_ENDIAN); }
	public void setData(java.nio.ByteBuffer value) { data = value;  bytesdata = data.array(); }
	private boolean is_dense;
	public boolean getIsDense() { return is_dense; }
	public void setIsDense(boolean value) { is_dense = value; }
}
