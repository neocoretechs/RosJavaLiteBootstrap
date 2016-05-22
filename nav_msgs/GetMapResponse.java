package nav_msgs;

public class GetMapResponse implements org.ros.internal.message.Message, java.io.Serializable {
	private static final long serialVersionUID = -1L;
	public static final java.lang.String _TYPE = "nav_msgs/GetMapResponse";
	public static final java.lang.String _DEFINITION = "nav_msgs/OccupancyGrid map";
	public GetMapResponse() {}
	private nav_msgs.OccupancyGrid map;
	public nav_msgs.OccupancyGrid getMap() { return map; }
	public void setMap(nav_msgs.OccupancyGrid value) { map = value; }
}
