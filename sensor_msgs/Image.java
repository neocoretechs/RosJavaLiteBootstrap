package sensor_msgs;

public class Image implements org.ros.internal.message.Message, java.io.Serializable {
	private static final long serialVersionUID = -1L;
	public static final java.lang.String _TYPE = "sensor_msgs/Image";
	public static final java.lang.String _DEFINITION = "# This message contains an uncompressed image\n# (0, 0) is at top-left corner of image\n#\n\nHeader header        # Header timestamp should be acquisition time of image\n                     # Header frame_id should be optical frame of camera\n                     # origin of frame should be optical center of cameara\n                     # +x should point to the right in the image\n                     # +y should point down in the image\n                     # +z should point into to plane of the image\n                     # If the frame_id here and the frame_id of the CameraInfo\n                     # message associated with the image conflict\n                     # the behavior is undefined\n\nuint32 height         # image height, that is, number of rows\nuint32 width          # image width, that is, number of columns\n\n# The legal values for encoding are in file src/image_encodings.cpp\n# If you want to standardize a new string format, join\n# ros-users@lists.sourceforge.net and send an email proposing a new encoding.\n\nstring encoding       # Encoding of pixels -- channel meaning, ordering, size\n                      # taken from the list of strings in include/sensor_msgs/image_encodings.h\n\nuint8 is_bigendian    # is this data bigendian?\nuint32 step           # Full row length in bytes\nuint8[] data          # actual matrix data, size is (step * rows)\n";
	public Image() {}
	private std_msgs.Header header;
	public std_msgs.Header getHeader() { return header; }
	public void setHeader(std_msgs.Header value) { header = value; }
	private int height;
	public int getHeight() { return height; }
	public void setHeight(int value) { height = value; }
	private int width;
	public int getWidth() { return width; }
	public void setWidth(int value) { width = value; }
	private java.lang.String encoding;
	public java.lang.String getEncoding() { return encoding; }
	public void setEncoding(java.lang.String value) { encoding = value; }
	private byte is_bigendian;
	public byte getIsBigendian() { return is_bigendian; }
	public void setIsBigendian(byte value) { is_bigendian = value; }
	private int step;
	public int getStep() { return step; }
	public void setStep(int value) { step = value; }
	private transient io.netty.buffer.ByteBuf data=null;
	private byte[] bytesdata;
	public io.netty.buffer.ByteBuf getData() { if( data != null ) return data; else data = io.netty.buffer.ByteBufs.wrappedBuffer(bytesdata); return data; }
	public void setData(io.netty.buffer.ByteBuf value) { data = value;  bytesdata = data.array(); }
}
