package sensor_msgs;

public class JoyFeedback implements org.ros.internal.message.Message, java.io.Serializable {
	private static final long serialVersionUID = -1L;
	public static final java.lang.String _TYPE = "sensor_msgs/JoyFeedback";
	public static final java.lang.String _DEFINITION = "# Declare of the type of feedback\nuint8 TYPE_LED    = 0\nuint8 TYPE_RUMBLE = 1\nuint8 TYPE_BUZZER = 2\n\nuint8 type\n\n# This will hold an id number for each type of each feedback.\n# Example, the first led would be id=0, the second would be id=1\nuint8 id\n\n# Intensity of the feedback, from 0.0 to 1.0, inclusive.  If device is\n# actually binary, driver should treat 0<=x<0.5 as off, 0.5<=x<=1 as on.\nfloat32 intensity\n\n";
	public JoyFeedback() {}
	public static final byte TYPE_LED = 0;
	public static final byte TYPE_RUMBLE = 1;
	public static final byte TYPE_BUZZER = 2;
	private byte type;
	public byte getType() { return type; }
	public void setType(byte value) { type = value; }
	private byte id;
	public byte getId() { return id; }
	public void setId(byte value) { id = value; }
	private float intensity;
	public float getIntensity() { return intensity; }
	public void setIntensity(float value) { intensity = value; }
}
