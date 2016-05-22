package visualization_msgs;

public class InteractiveMarkerInit implements org.ros.internal.message.Message, java.io.Serializable {
	private static final long serialVersionUID = -1L;
	public static final java.lang.String _TYPE = "visualization_msgs/InteractiveMarkerInit";
	public static final java.lang.String _DEFINITION = "# Identifying string. Must be unique in the topic namespace\n# that this server works on.\nstring server_id\n\n# Sequence number.\n# The client will use this to detect if it has missed a subsequent\n# update.  Every update message will have the same sequence number as\n# an init message.  Clients will likely want to unsubscribe from the\n# init topic after a successful initialization to avoid receiving\n# duplicate data.\nuint64 seq_num\n\n# All markers.\nInteractiveMarker[] markers\n";
	public InteractiveMarkerInit() {}
	private java.lang.String server_id;
	public java.lang.String getServerId() { return server_id; }
	public void setServerId(java.lang.String value) { server_id = value; }
	private long seq_num;
	public long getSeqNum() { return seq_num; }
	public void setSeqNum(long value) { seq_num = value; }
	private java.util.List<visualization_msgs.InteractiveMarker> markers;
	public java.util.List<visualization_msgs.InteractiveMarker> getMarkers() { return markers; }
	public void setMarkers(java.util.List<visualization_msgs.InteractiveMarker> value) { markers = value; }
}
