package sensor_msgs;

public class Joy implements org.ros.internal.message.Message, java.io.Serializable {
	private static final long serialVersionUID = -1L;
	public static final java.lang.String _TYPE = "sensor_msgs/Joy";
	public static final java.lang.String _DEFINITION = "# Reports the state of a joysticks axes and buttons.\nHeader header           # timestamp in the header is the time the data is received from the joystick\nfloat32[] axes          # the axes measurements from a joystick\nint32[] buttons         # the buttons measurements from a joystick \n";
	public Joy() {}
	private std_msgs.Header header;
	public std_msgs.Header getHeader() { return header; }
	public void setHeader(std_msgs.Header value) { header = value; }
	private float[] axes;
	public float[] getAxes() { return axes; }
	public void setAxes(float[] value) { axes = value; }
	private int[] buttons;
	public int[] getButtons() { return buttons; }
	public void setButtons(int[] value) { buttons = value; }
}
