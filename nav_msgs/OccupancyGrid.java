package nav_msgs;

public class OccupancyGrid implements org.ros.internal.message.Message, java.io.Serializable {
	private static final long serialVersionUID = -1L;
	public static final java.lang.String _TYPE = "nav_msgs/OccupancyGrid";
	public static final java.lang.String _DEFINITION = "# This represents a 2-D grid map, in which each cell represents the probability of\n# occupancy.\n\nHeader header \n\n#MetaData for the map\nMapMetaData info\n\n# The map data, in row-major order, starting with (0,0).  Occupancy\n# probabilities are in the range [0,100].  Unknown is -1.\nint8[] data\n";
	public OccupancyGrid() {}
	private std_msgs.Header header;
	public std_msgs.Header getHeader() { return header; }
	public void setHeader(std_msgs.Header value) { header = value; }
	private nav_msgs.MapMetaData info;
	public nav_msgs.MapMetaData getInfo() { return info; }
	public void setInfo(nav_msgs.MapMetaData value) { info = value; }
	private transient io.netty.buffer.ByteBuf data=null;
	private byte[] bytesdata;
	public io.netty.buffer.ByteBuf getData() { if( data != null ) return data; else data = io.netty.buffer.ByteBufs.wrappedBuffer(bytesdata); return data; }
	public void setData(io.netty.buffer.ByteBuf value) { data = value;  bytesdata = data.array(); }
}
