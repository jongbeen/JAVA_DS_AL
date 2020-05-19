package tensor;

public interface Matrix {
	
	ScalarImpl GetScalarfromMatrix(int row,int col) throws MyException;
//	11번 특정 위치 조회
	int GetMatrixRow();
//	13번m
	int GetMatrixCol();
//	13번m
	String toString();
//	14번m
	boolean equals(Object mxl);
//	15번
	void show();
	boolean CheckMatrixLength(Matrix mxl);
//	13번m
	MatrixImpl AddMatrix(Matrix mxl) throws MyException;
//	22번
	Matrix MultiplyMatrix(Matrix mxl) throws MyException;
//	23번
	VectorImpl ExtractRowVectorFromMatrix(int row) throws MyException;
//	34번
	VectorImpl ExtractColVectorFromMatrix(int col) throws MyException;
//	35번
	MatrixImpl ExtractPartialFromMatrix(int start_row,int start_col,int end_row,int end_col) throws MyException;
//	36번
	MatrixImpl ExtractUnPartialFromMatrix(int row,int col) throws MyException;
//	37번
	MatrixImpl TransposeMatrix() throws MyException;
//	38번
	double TraceMatrix();
//	39번
	boolean CheckSquareMatrix();
//	40번
	boolean CheckUpperTriangleMatrix();
//	41번
	boolean CheckLowerTriangleMatrix();
//	42번
	boolean CheckIdentityMatrix();
//	43번
	boolean CheckZeroMatrix();
//	44번
	MatrixImpl TradeSelectRowInMatrix(int row1,int row2) throws MyException;
//	45번
	MatrixImpl TradeSelectColInMatrix(int col1, int col2) throws MyException;
//	46번
	MatrixImpl MulSelectRowInMatrix(int srow,Scalar s) throws MyException;
//	47번
	MatrixImpl MulSelectColInMatrix(int scol,Scalar s) throws MyException;
//	48번
	MatrixImpl MulSelectRowFromOtherRowInMatrix(int row1,int row2,Scalar s) throws MyException;
//	49번
	MatrixImpl MulSelectColFromOtherColInMatrix(int col1,int col2,Scalar s) throws MyException;
//	50번
	MatrixImpl ExtractRREFMatrix();
//	51번
	boolean CheckRREFMatrix();
//	52번
	double Determinant();
//	53번
	MatrixImpl ReverseMatrix() throws MyException;
//	54번
	MatrixImpl clone() throws CloneNotSupportedException;
//	17번
}
