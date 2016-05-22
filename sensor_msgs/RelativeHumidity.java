package sensor_msgs;

public class RelativeHumidity implements org.ros.internal.message.Message, java.io.Serializable {
	private static final long serialVersionUID = -1L;
	public static final java.lang.String _TYPE = "sensor_msgs/RelativeHumidity";
	public static final java.lang.String _DEFINITION = " # Single reading from a relative humidity sensor.  Defines the ratio of partial\n # pressure of water vapor to the saturated vapor pressure at a temperature.\n\n Header header             # timestamp of the measurement\n                           # frame_id is the location of the humidity sensor\n\n float64 relative_humidity # Expression of the relative humidity\n                           # from 0.0 to 1.0.\n                           # 0.0 is no partial pressure of water vapor\n                           # 1.0 represents partial pressure of saturation\n\n float64 variance          # 0 is interpreted as variance unknown";
	public RelativeHumidity() {}
	private std_msgs.Header header;
	public std_msgs.Header getHeader() { return header; }
	public void setHeader(std_msgs.Header value) { header = value; }
	private double relative_humidity;
	public double getRelativeHumidity() { return relative_humidity; }
	public void setRelativeHumidity(double value) { relative_humidity = value; }
	private double variance;
	public double getVariance() { return variance; }
	public void setVariance(double value) { variance = value; }
}
