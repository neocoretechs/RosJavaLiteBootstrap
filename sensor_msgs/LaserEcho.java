package sensor_msgs;

public class LaserEcho implements org.ros.internal.message.Message, java.io.Serializable {
	private static final long serialVersionUID = -1L;
	public static final java.lang.String _TYPE = "sensor_msgs/LaserEcho";
	public static final java.lang.String _DEFINITION = "# This message is a submessage of MultiEchoLaserScan and is not intended\n# to be used separately.\n\nfloat32[] echoes  # Multiple values of ranges or intensities.\n                  # Each array represents data from the same angle increment.";
	public LaserEcho() {}
	private float[] echoes;
	public float[] getEchoes() { return echoes; }
	public void setEchoes(float[] value) { echoes = value; }
}
