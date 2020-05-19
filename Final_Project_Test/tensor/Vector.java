package tensor;

public interface Vector {

	void show();
	void VectorRandomSet(int length, double start, double end)throws MyException;
//	4번 랜덤생성
	int GetVectorLength();
//	13번v 크기조회
	double VectorGetsScalar(int index);
	ScalarImpl InquireElement(int index) throws MyException;
//	11번v 지정/조회
	String toString();
//	14번s
	boolean equals(Object vcl);
//	15번s
	VectorImpl AddVector(Object vcl) throws MyException;
//	20번
	VectorImpl MultiplyVector(Scalar as);
//	21번
	VectorImpl clone() throws CloneNotSupportedException;
//	17번
}
