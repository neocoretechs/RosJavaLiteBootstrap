package sensor_msgs;

public class Illuminance implements org.ros.internal.message.Message, java.io.Serializable {
	private static final long serialVersionUID = -1L;
	public static final java.lang.String _TYPE = "sensor_msgs/Illuminance";
	public static final java.lang.String _DEFINITION = " # Single photometric illuminance measurement.  Light should be assumed to be\n # measured along the sensor\'s x-axis (the area of detection is the y-z plane).\n # The illuminance should have a 0 or positive value and be received with\n # the sensor\'s +X axis pointing toward the light source.\n\n # Photometric illuminance is the measure of the human eye\'s sensitivity of the\n # intensity of light encountering or passing through a surface.\n\n # All other Photometric and Radiometric measurements should\n # not use this message.\n # This message cannot represent:\n # Luminous intensity (candela/light source output)\n # Luminance (nits/light output per area)\n # Irradiance (watt/area), etc.\n\n Header header           # timestamp is the time the illuminance was measured\n                         # frame_id is the location and direction of the reading\n\n float64 illuminance     # Measurement of the Photometric Illuminance in Lux.\n\n float64 variance        # 0 is interpreted as variance unknown";
	public Illuminance() {}
	private std_msgs.Header header;
	public std_msgs.Header getHeader() { return header; }
	public void setHeader(std_msgs.Header value) { header = value; }
	private double illuminance;
	public double getIlluminance() { return illuminance; }
	public void setIlluminance(double value) { illuminance = value; }
	private double variance;
	public double getVariance() { return variance; }
	public void setVariance(double value) { variance = value; }
}
