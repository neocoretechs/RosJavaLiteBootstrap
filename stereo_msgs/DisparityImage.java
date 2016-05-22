package stereo_msgs;

public class DisparityImage implements org.ros.internal.message.Message, java.io.Serializable {
	private static final long serialVersionUID = -1L;
	public static final java.lang.String _TYPE = "stereo_msgs/DisparityImage";
	public static final java.lang.String _DEFINITION = "# Separate header for compatibility with current TimeSynchronizer.\n# Likely to be removed in a later release, use image.header instead.\nHeader header\n\n# Floating point disparity image. The disparities are pre-adjusted for any\n# x-offset between the principal points of the two cameras (in the case\n# that they are verged). That is: d = x_l - x_r - (cx_l - cx_r)\nsensor_msgs/Image image\n\n# Stereo geometry. For disparity d, the depth from the camera is Z = fT/d.\nfloat32 f # Focal length, pixels\nfloat32 T # Baseline, world units\n\n# Subwindow of (potentially) valid disparity values.\nsensor_msgs/RegionOfInterest valid_window\n\n# The range of disparities searched.\n# In the disparity image, any disparity less than min_disparity is invalid.\n# The disparity search range defines the horopter, or 3D volume that the\n# stereo algorithm can \"see\". Points with Z outside of:\n#     Z_min = fT / max_disparity\n#     Z_max = fT / min_disparity\n# could not be found.\nfloat32 min_disparity\nfloat32 max_disparity\n\n# Smallest allowed disparity increment. The smallest achievable depth range\n# resolution is delta_Z = (Z^2/fT)*delta_d.\nfloat32 delta_d\n";
	public DisparityImage() {}
	private std_msgs.Header header;
	public std_msgs.Header getHeader() { return header; }
	public void setHeader(std_msgs.Header value) { header = value; }
	private sensor_msgs.Image image;
	public sensor_msgs.Image getImage() { return image; }
	public void setImage(sensor_msgs.Image value) { image = value; }
	private float f;
	public float getF() { return f; }
	public void setF(float value) { f = value; }
	private float T;
	public float getT() { return T; }
	public void setT(float value) { T = value; }
	private sensor_msgs.RegionOfInterest valid_window;
	public sensor_msgs.RegionOfInterest getValidWindow() { return valid_window; }
	public void setValidWindow(sensor_msgs.RegionOfInterest value) { valid_window = value; }
	private float min_disparity;
	public float getMinDisparity() { return min_disparity; }
	public void setMinDisparity(float value) { min_disparity = value; }
	private float max_disparity;
	public float getMaxDisparity() { return max_disparity; }
	public void setMaxDisparity(float value) { max_disparity = value; }
	private float delta_d;
	public float getDeltaD() { return delta_d; }
	public void setDeltaD(float value) { delta_d = value; }
}
