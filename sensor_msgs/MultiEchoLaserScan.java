package sensor_msgs;

public class MultiEchoLaserScan implements org.ros.internal.message.Message, java.io.Serializable {
	private static final long serialVersionUID = -1L;
	public static final java.lang.String _TYPE = "sensor_msgs/MultiEchoLaserScan";
	public static final java.lang.String _DEFINITION = "# Single scan from a multi-echo planar laser range-finder\n#\n# If you have another ranging device with different behavior (e.g. a sonar\n# array), please find or create a different message, since applications\n# will make fairly laser-specific assumptions about this data\n\nHeader header            # timestamp in the header is the acquisition time of \n                         # the first ray in the scan.\n                         #\n                         # in frame frame_id, angles are measured around \n                         # the positive Z axis (counterclockwise, if Z is up)\n                         # with zero angle being forward along the x axis\n                         \nfloat32 angle_min        # start angle of the scan [rad]\nfloat32 angle_max        # end angle of the scan [rad]\nfloat32 angle_increment  # angular distance between measurements [rad]\n\nfloat32 time_increment   # time between measurements [seconds] - if your scanner\n                         # is moving, this will be used in interpolating position\n                         # of 3d points\nfloat32 scan_time        # time between scans [seconds]\n\nfloat32 range_min        # minimum range value [m]\nfloat32 range_max        # maximum range value [m]\n\nLaserEcho[] ranges       # range data [m] (Note: NaNs, values < range_min or > range_max should be discarded)\n                         # +Inf measurements are out of range\n                         # -Inf measurements are too close to determine exact distance.\nLaserEcho[] intensities  # intensity data [device-specific units].  If your\n                         # device does not provide intensities, please leave\n                         # the array empty.";
	public MultiEchoLaserScan() {}
	private std_msgs.Header header;
	public std_msgs.Header getHeader() { return header; }
	public void setHeader(std_msgs.Header value) { header = value; }
	private float angle_min;
	public float getAngleMin() { return angle_min; }
	public void setAngleMin(float value) { angle_min = value; }
	private float angle_max;
	public float getAngleMax() { return angle_max; }
	public void setAngleMax(float value) { angle_max = value; }
	private float angle_increment;
	public float getAngleIncrement() { return angle_increment; }
	public void setAngleIncrement(float value) { angle_increment = value; }
	private float time_increment;
	public float getTimeIncrement() { return time_increment; }
	public void setTimeIncrement(float value) { time_increment = value; }
	private float scan_time;
	public float getScanTime() { return scan_time; }
	public void setScanTime(float value) { scan_time = value; }
	private float range_min;
	public float getRangeMin() { return range_min; }
	public void setRangeMin(float value) { range_min = value; }
	private float range_max;
	public float getRangeMax() { return range_max; }
	public void setRangeMax(float value) { range_max = value; }
	private java.util.List<sensor_msgs.LaserEcho> ranges;
	public java.util.List<sensor_msgs.LaserEcho> getRanges() { return ranges; }
	public void setRanges(java.util.List<sensor_msgs.LaserEcho> value) { ranges = value; }
	private java.util.List<sensor_msgs.LaserEcho> intensities;
	public java.util.List<sensor_msgs.LaserEcho> getIntensities() { return intensities; }
	public void setIntensities(java.util.List<sensor_msgs.LaserEcho> value) { intensities = value; }
}
