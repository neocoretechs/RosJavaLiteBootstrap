package shape_msgs;

public class MeshTriangle implements org.ros.internal.message.Message, java.io.Serializable {
	private static final long serialVersionUID = -1L;
	public static final java.lang.String _TYPE = "shape_msgs/MeshTriangle";
	public static final java.lang.String _DEFINITION = "# Definition of a triangle\'s vertices\nuint32[3] vertex_indices\n";
	public MeshTriangle() {}
	private int[] vertex_indices;
	public int[] getVertexIndices() { return vertex_indices; }
	public void setVertexIndices(int[] value) { vertex_indices = value; }
}
