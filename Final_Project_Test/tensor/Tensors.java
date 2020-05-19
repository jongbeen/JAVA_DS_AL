package tensor;

public class Tensors {

	public static ScalarImpl ScalarAdd(Scalar a, Scalar b) {
		return ScalarImpl.ScalarAdd(a, b);
	}
//	24번
	public static ScalarImpl ScalarMultiply(Scalar a, Scalar b) {
		return ScalarImpl.ScalarMultiply(a, b);
	}
//	25번
	
	public static VectorImpl VectorAdd(Vector a, Vector b) {
		return VectorImpl.VectorAdd(a, b);
	}
//	26번
	public static VectorImpl VectorMultiply(Vector a, Scalar b) {
		return VectorImpl.VectorMultiply(a, b);
	}
//	27번
	public static MatrixImpl MatrixAdd(Matrix a, Matrix b) {
		return MatrixImpl.AddMatrix(a, b);
	}
//	28번
	public static MatrixImpl MatrixMultiply(Matrix a, Matrix b) {
		return MatrixImpl.MultiplyMatrix(a, b);
	}
//	29번
	public static MatrixImpl AddMatrixInRow(Matrix a, Matrix b) {
		return MatrixImpl.AddMatrixInRow(a, b);
	}
//	32번
	public static MatrixImpl AddMatrixInCol(Matrix a, Matrix b) {
		return MatrixImpl.AddMatrixInCol(a, b);
	}
//	33번
	
}
