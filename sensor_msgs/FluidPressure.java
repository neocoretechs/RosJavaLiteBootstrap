package sensor_msgs;

public class FluidPressure implements org.ros.internal.message.Message, java.io.Serializable {
	private static final long serialVersionUID = -1L;
	public static final java.lang.String _TYPE = "sensor_msgs/FluidPressure";
	public static final java.lang.String _DEFINITION = " # Single pressure reading.  This message is appropriate for measuring the\n # pressure inside of a fluid (air, water, etc).  This also includes\n # atmospheric or barometric pressure.\n\n # This message is not appropriate for force/pressure contact sensors.\n\n Header header           # timestamp of the measurement\n                         # frame_id is the location of the pressure sensor\n\n float64 fluid_pressure  # Absolute pressure reading in Pascals.\n\n float64 variance        # 0 is interpreted as variance unknown";
	public FluidPressure() {}
	private std_msgs.Header header;
	public std_msgs.Header getHeader() { return header; }
	public void setHeader(std_msgs.Header value) { header = value; }
	private double fluid_pressure;
	public double getFluidPressure() { return fluid_pressure; }
	public void setFluidPressure(double value) { fluid_pressure = value; }
	private double variance;
	public double getVariance() { return variance; }
	public void setVariance(double value) { variance = value; }
}
