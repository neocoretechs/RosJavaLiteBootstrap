package sensor_msgs;

public class PointField implements org.ros.internal.message.Message, java.io.Serializable {
	private static final long serialVersionUID = -1L;
	public static final java.lang.String _TYPE = "sensor_msgs/PointField";
	public static final java.lang.String _DEFINITION = "# This message holds the description of one point entry in the\n# PointCloud2 message format.\nuint8 INT8    = 1\nuint8 UINT8   = 2\nuint8 INT16   = 3\nuint8 UINT16  = 4\nuint8 INT32   = 5\nuint8 UINT32  = 6\nuint8 FLOAT32 = 7\nuint8 FLOAT64 = 8\n\nstring name      # Name of field\nuint32 offset    # Offset from start of point struct\nuint8  datatype  # Datatype enumeration, see above\nuint32 count     # How many elements in the field\n";
	public PointField() {}
	public static final byte INT8 = 1;
	public static final byte UINT8 = 2;
	public static final byte INT16 = 3;
	public static final byte UINT16 = 4;
	public static final byte INT32 = 5;
	public static final byte UINT32 = 6;
	public static final byte FLOAT32 = 7;
	public static final byte FLOAT64 = 8;
	private java.lang.String name;
	public java.lang.String getName() { return name; }
	public void setName(java.lang.String value) { name = value; }
	private int offset;
	public int getOffset() { return offset; }
	public void setOffset(int value) { offset = value; }
	private byte datatype;
	public byte getDatatype() { return datatype; }
	public void setDatatype(byte value) { datatype = value; }
	private int count;
	public int getCount() { return count; }
	public void setCount(int value) { count = value; }
}
