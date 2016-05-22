package geometry_msgs;

public class TransformStamped implements org.ros.internal.message.Message, java.io.Serializable {
	private static final long serialVersionUID = -1L;
	public static final java.lang.String _TYPE = "geometry_msgs/TransformStamped";
	public static final java.lang.String _DEFINITION = "# This expresses a transform from coordinate frame header.frame_id\n# to the coordinate frame child_frame_id\n#\n# This message is mostly used by the \n# <a href=\"http://www.ros.org/wiki/tf\">tf</a> package. \n# See its documentation for more information.\n\nHeader header\nstring child_frame_id # the frame id of the child frame\nTransform transform\n";
	public TransformStamped() {}
	private std_msgs.Header header;
	public std_msgs.Header getHeader() { return header; }
	public void setHeader(std_msgs.Header value) { header = value; }
	private java.lang.String child_frame_id;
	public java.lang.String getChildFrameId() { return child_frame_id; }
	public void setChildFrameId(java.lang.String value) { child_frame_id = value; }
	private geometry_msgs.Transform transform;
	public geometry_msgs.Transform getTransform() { return transform; }
	public void setTransform(geometry_msgs.Transform value) { transform = value; }
}
