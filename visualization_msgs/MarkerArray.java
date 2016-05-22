package visualization_msgs;

public class MarkerArray implements org.ros.internal.message.Message, java.io.Serializable {
	private static final long serialVersionUID = -1L;
	public static final java.lang.String _TYPE = "visualization_msgs/MarkerArray";
	public static final java.lang.String _DEFINITION = "Marker[] markers\n";
	public MarkerArray() {}
	private java.util.List<visualization_msgs.Marker> markers;
	public java.util.List<visualization_msgs.Marker> getMarkers() { return markers; }
	public void setMarkers(java.util.List<visualization_msgs.Marker> value) { markers = value; }
}
