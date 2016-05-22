package sensor_msgs;

public class SetCameraInfoResponse implements org.ros.internal.message.Message, java.io.Serializable {
	private static final long serialVersionUID = -1L;
	public static final java.lang.String _TYPE = "sensor_msgs/SetCameraInfoResponse";
	public static final java.lang.String _DEFINITION = "bool success          # True if the call succeeded\nstring status_message # Used to give details about success";
	public SetCameraInfoResponse() {}
	private boolean success;
	public boolean getSuccess() { return success; }
	public void setSuccess(boolean value) { success = value; }
	private java.lang.String status_message;
	public java.lang.String getStatusMessage() { return status_message; }
	public void setStatusMessage(java.lang.String value) { status_message = value; }
}
