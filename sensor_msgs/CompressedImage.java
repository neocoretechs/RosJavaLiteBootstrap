package sensor_msgs;

public class CompressedImage implements org.ros.internal.message.Message, java.io.Serializable {
	private static final long serialVersionUID = -1L;
	public static final java.lang.String _TYPE = "sensor_msgs/CompressedImage";
	public static final java.lang.String _DEFINITION = "# This message contains a compressed image\n\nHeader header        # Header timestamp should be acquisition time of image\n                     # Header frame_id should be optical frame of camera\n                     # origin of frame should be optical center of cameara\n                     # +x should point to the right in the image\n                     # +y should point down in the image\n                     # +z should point into to plane of the image\n\nstring format        # Specifies the format of the data\n                     #   Acceptable values:\n                     #     jpeg, png\nuint8[] data         # Compressed image buffer\n";
	public CompressedImage() {}
	private std_msgs.Header header;
	public std_msgs.Header getHeader() { return header; }
	public void setHeader(std_msgs.Header value) { header = value; }
	private java.lang.String format;
	public java.lang.String getFormat() { return format; }
	public void setFormat(java.lang.String value) { format = value; }
	private transient io.netty.buffer.ByteBuf data=null;
	private byte[] bytesdata;
	public io.netty.buffer.ByteBuf getData() { if( data != null ) return data; else data = io.netty.buffer.ByteBufs.wrappedBuffer(bytesdata); return data; }
	public void setData(io.netty.buffer.ByteBuf value) { data = value;  bytesdata = data.array(); }
}
