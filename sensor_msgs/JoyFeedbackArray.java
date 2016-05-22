package sensor_msgs;

public class JoyFeedbackArray implements org.ros.internal.message.Message, java.io.Serializable {
	private static final long serialVersionUID = -1L;
	public static final java.lang.String _TYPE = "sensor_msgs/JoyFeedbackArray";
	public static final java.lang.String _DEFINITION = "# This message publishes values for multiple feedback at once. \nJoyFeedback[] array";
	public JoyFeedbackArray() {}
	private java.util.List<sensor_msgs.JoyFeedback> array;
	public java.util.List<sensor_msgs.JoyFeedback> getArray() { return array; }
	public void setArray(java.util.List<sensor_msgs.JoyFeedback> value) { array = value; }
}
