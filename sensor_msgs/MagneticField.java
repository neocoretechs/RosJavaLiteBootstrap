package sensor_msgs;

public class MagneticField implements org.ros.internal.message.Message, java.io.Serializable {
	private static final long serialVersionUID = -1L;
	public static final java.lang.String _TYPE = "sensor_msgs/MagneticField";
	public static final java.lang.String _DEFINITION = " # Measurement of the Magnetic Field vector at a specific location.\n\n # If the covariance of the measurement is known, it should be filled in\n # (if all you know is the variance of each measurement, e.g. from the datasheet,\n #just put those along the diagonal)\n # A covariance matrix of all zeros will be interpreted as \"covariance unknown\",\n # and to use the data a covariance will have to be assumed or gotten from some\n # other source\n\n\n Header header                        # timestamp is the time the\n                                      # field was measured\n                                      # frame_id is the location and orientation\n                                      # of the field measurement\n\n geometry_msgs/Vector3 magnetic_field # x, y, and z components of the\n                                      # field vector in Tesla\n                                      # If your sensor does not output 3 axes,\n                                      # put NaNs in the components not reported.\n\n float64[9] magnetic_field_covariance # Row major about x, y, z axes\n                                      # 0 is interpreted as variance unknown";
	public MagneticField() {}
	private std_msgs.Header header;
	public std_msgs.Header getHeader() { return header; }
	public void setHeader(std_msgs.Header value) { header = value; }
	private geometry_msgs.Vector3 magnetic_field;
	public geometry_msgs.Vector3 getMagneticField() { return magnetic_field; }
	public void setMagneticField(geometry_msgs.Vector3 value) { magnetic_field = value; }
	private double[] magnetic_field_covariance;
	public double[] getMagneticFieldCovariance() { return magnetic_field_covariance; }
	public void setMagneticFieldCovariance(double[] value) { magnetic_field_covariance = value; }
}
