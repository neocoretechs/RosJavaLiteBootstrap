package shape_msgs;

public class Plane implements org.ros.internal.message.Message, java.io.Serializable {
	private static final long serialVersionUID = -1L;
	public static final java.lang.String _TYPE = "shape_msgs/Plane";
	public static final java.lang.String _DEFINITION = "# Representation of a plane, using the plane equation ax + by + cz + d = 0\n\n# a := coef[0]\n# b := coef[1]\n# c := coef[2]\n# d := coef[3]\n\nfloat64[4] coef\n";
	public Plane() {}
	private double[] coef;
	public double[] getCoef() { return coef; }
	public void setCoef(double[] value) { coef = value; }
}
