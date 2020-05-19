package tensor;

public interface Scalar extends Comparable<Scalar> {
	void show();
	void ScalarSet(double value);
//	12번
	void ScalarRandomSet(double start, double end)throws MyException;
//	2번
	double ScalarGet();
//	12번
	String toString();
//	14번v
	boolean equals(Object scl);
//	15번v
	double InquireElement();
	ScalarImpl AddScalar(Object scl);
//	18번
	ScalarImpl MultiplyScalar(Object scl);
//	19번
	ScalarImpl clone() throws CloneNotSupportedException; 
//	17번 clone
	int compareTo(Scalar s);
//	16번
}
