package sensor_msgs;

public class RegionOfInterest implements org.ros.internal.message.Message, java.io.Serializable {
	private static final long serialVersionUID = -1L;
	public static final java.lang.String _TYPE = "sensor_msgs/RegionOfInterest";
	public static final java.lang.String _DEFINITION = "# This message is used to specify a region of interest within an image.\n#\n# When used to specify the ROI setting of the camera when the image was\n# taken, the height and width fields should either match the height and\n# width fields for the associated image; or height = width = 0\n# indicates that the full resolution image was captured.\n\nuint32 x_offset  # Leftmost pixel of the ROI\n                 # (0 if the ROI includes the left edge of the image)\nuint32 y_offset  # Topmost pixel of the ROI\n                 # (0 if the ROI includes the top edge of the image)\nuint32 height    # Height of ROI\nuint32 width     # Width of ROI\n\n# True if a distinct rectified ROI should be calculated from the \"raw\"\n# ROI in this message. Typically this should be False if the full image\n# is captured (ROI not used), and True if a subwindow is captured (ROI\n# used).\nbool do_rectify\n";
	public RegionOfInterest() {}
	private int x_offset;
	public int getXOffset() { return x_offset; }
	public void setXOffset(int value) { x_offset = value; }
	private int y_offset;
	public int getYOffset() { return y_offset; }
	public void setYOffset(int value) { y_offset = value; }
	private int height;
	public int getHeight() { return height; }
	public void setHeight(int value) { height = value; }
	private int width;
	public int getWidth() { return width; }
	public void setWidth(int value) { width = value; }
	private boolean do_rectify;
	public boolean getDoRectify() { return do_rectify; }
	public void setDoRectify(boolean value) { do_rectify = value; }
}
