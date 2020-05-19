package tensor;

import java.io.File;
import java.io.IOException;

public class Factory {
	
	public static ScalarImpl createScalar(double value) {
		ScalarImpl scalar= new ScalarImpl(value);
		return scalar;
	}
//	1.지정한 double형 value를 가지는 Scalar
	
	public static ScalarImpl createRandomScalar(double start,double end) {
		ScalarImpl scalar= new ScalarImpl();
		scalar.ScalarRandomSet(start, end);
		return scalar;
	}
//	2.지정한 start 부터 end 까지의 수 사이 랜덤의 값을 가지는 Scalar
	
	public static VectorImpl createVector(int length, double one_value) {
		VectorImpl vector = new VectorImpl(length, one_value);
		return vector;
	}
//	3번 지정한 하나의 Scalar값만을 가지는 Vector
	
	public static VectorImpl createVectorfromArr(double[] arr) {
		VectorImpl vector = new VectorImpl(arr);
		return vector;
	}
//	5번 1차원 배열에서 N차원 벡터 생성
	
	public static VectorImpl createRandomVector(int length,double start, double end) {
		VectorImpl vector = new VectorImpl(length);
		vector.VectorRandomSet(length, start, end);
		return vector;
	}
//	4번 지정한 범위의 Random Scalar값을 가지는 Vector
	
	
	public static double[] createNX1ArrayfromVector(Vector vector) {
		double[] temp = new double[vector.GetVectorLength()];
		for(int i=0; i< vector.GetVectorLength();i++) {
			temp[i] = vector.VectorGetsScalar(i);
		}
		return temp;
	}
//	30번 NX1배열 리턴하는 벡터
	
	public static double[][] create1XNArrayfromVector(Vector vector){
		double[][] temp = new double[vector.GetVectorLength()][1];
		for(int i=0;i<vector.GetVectorLength();i++) {
			temp[i][0] = vector.VectorGetsScalar(i);
		}
		return temp;
	}
//	31번 1XN배열 리턴하는 벡터
	
	public static MatrixImpl createMatrix(int row_length,int col_length, double one_value) {
		MatrixImpl matrix = new MatrixImpl(row_length, col_length, one_value);
		return matrix;
	}
//	6.지정한 하나의 Scalar값만 가지는 Matrix
	
	public static MatrixImpl createRandomMatrix(int row_length,int col_length,double start, double end) {
		MatrixImpl matrix = new MatrixImpl(row_length, col_length, start, end);
		return matrix;
	}
//	7.지정범위의 random값을 가지는 Matrix
	
	
	public static MatrixImpl createMatrixfromArr2(double[][] arr) {
		MatrixImpl matrix = new MatrixImpl(arr);
		return matrix;
	}
//	9.2차원 배열로부터 mXn Matrix 행렬을 가짐
	
	public static MatrixImpl createIdentityMatrix(int identity) {
		MatrixImpl matrix = new MatrixImpl(identity);
		return matrix;
	}
//	10.단위행렬을 생성함
	
}
