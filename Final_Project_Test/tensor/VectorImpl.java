package tensor;

import java.util.ArrayList;

class VectorImpl implements Vector , Cloneable {

	private ArrayList<ScalarImpl> scalar;
	private int ListSize;
	
	public VectorImpl() {
		scalar = new ArrayList<ScalarImpl>();
	}
	
	public VectorImpl(int length) {
		ListSize = length;
		scalar = new ArrayList<ScalarImpl>(length);
		ScalarImpl zero = new ScalarImpl();
		zero.ScalarSet(0);
		for(int i=0;i<length;i++) {
			scalar.add(i, zero);
		}
	}
	
	public VectorImpl(int length,double value) {
		ListSize = length;
		scalar = new ArrayList<ScalarImpl>(length);
		ScalarImpl scl = new ScalarImpl(value);
		for(int i=0;i<length;i++) {
			scalar.add(i, scl);
		}
	}
	public VectorImpl(double[] arr) {
		ListSize = arr.length;
		scalar = new ArrayList<ScalarImpl>(arr.length);
		for(int i=0;i<arr.length;i++) {
			ScalarImpl s = new ScalarImpl(arr[i]);
			scalar.add(i, s);
		}
	}
//	생성자 part 정의
	
	public VectorImpl clone() throws CloneNotSupportedException{
		VectorImpl v = (VectorImpl)super.clone();
		v.scalar = (ArrayList<ScalarImpl>) scalar.clone();
		return v;
	}
	
	public ScalarImpl SetScalarInVector(int index,ScalarImpl s) {
		this.scalar.add(index,s);
		return (ScalarImpl) this.scalar.get(index);
 	}
//	34번 을 풀기위해 추가한 코드. 벡터의 index번째 스칼라는 특정 스칼라 값을 넣은후 index번째 스칼라 리턴, 즉 i개 스칼라 넣어서 벡터 만들기 위함
	
	static VectorImpl VectorAdd(Vector vector1, Vector vector2) {
		return vector1.AddVector(vector2);
	}
//	26번 디폴트 스태틱 벡터 합
	static VectorImpl VectorMultiply(Vector vector1, Scalar scalar1) {
		return vector1.MultiplyVector(scalar1);
	}
//	27번 디폴트 스태틱 벡터 곱
	@Override
	public ScalarImpl InquireElement(int index)throws MyException {
		if(index > this.ListSize)
			throw new MyException("지정한 범위내에서 하십시오");
		return (ScalarImpl)scalar.get(index-1);
	}
//	11번 특정 위치 조회
	@Override
	public String toString() {
		String vector="Vector 는 ";
		double[] arr = new double[ListSize];
		for(int i=0;i<ListSize;i++) {
			arr[i] = scalar.get(i).ScalarGet();
			vector += arr[i]+"\t";
		}
		return vector;
	}
//	14번v toString() 오버라이드 
	@Override
	public boolean equals(Object vcl) {
		VectorImpl vc = (VectorImpl)vcl;
		for(int i=0;i<ListSize;i++) {
			if(scalar.get(i).ScalarGet() != vc.VectorGetsScalar(i))
				return false;
		}
		return true;
	}
//	15번v equals()오버라이드
	
//	Vector인터페이스의 오버라이드 메소드
	@Override
	public void VectorRandomSet(int length, double start, double end)throws MyException {
		if(start > end || length <0)
			throw new MyException("size는 0보다 커야하며 , 첫번째 인자가 두번째 인자보다 작아야함");
		for(int i=0;i<ListSize;i++) {
			double random = (double)((Math.random()*(end-start))+start);
			ScalarImpl temp = new ScalarImpl();
			temp.ScalarSet(random);
			scalar.add(i, temp);
		}
	}
//	4번 무작위 값 벡터
	@Override
	public int GetVectorLength() {
		return this.ListSize;
	}
//	Vector의 Scalar길이 return
	@Override
	public double VectorGetsScalar(int index) {
		return scalar.get(index).ScalarGet();
	}
	
	@Override
	public void show() {
		System.out.println("Vector의 차원이 "+ListSize+"인  Vector");
		for(int i=0;i<ListSize;i++) {
			System.out.print(scalar.get(i).ScalarGet()+"\t");
		}
		System.out.println();
	}
	@Override
	public VectorImpl AddVector(Object vcl) throws MyException {
		VectorImpl vc = (VectorImpl)vcl;
		if(this.ListSize == vc.GetVectorLength()) {
			for(int i=0;i<ListSize;i++) {
				ScalarImpl s = new ScalarImpl();
				double Fvalue = this.scalar.get(i).ScalarGet();
				double SValue = vc.scalar.get(i).ScalarGet();
				s.ScalarSet(Fvalue+SValue);
				this.scalar.set(i, s);
			}
			return this;
		}
		else {
			throw new MyException("size가 같아야 합니다.");
		}
	}
//	20번 벡터 합구하기
	@Override
	public VectorImpl MultiplyVector(Scalar scl) {
		double tmp=scl.ScalarGet();
		for(int i=0;i<this.ListSize;i++) {
			ScalarImpl temp = new ScalarImpl();
			double FValue = this.scalar.get(i).ScalarGet();
			temp.ScalarSet(FValue*tmp);
			this.scalar.add(i, temp);
		}
		return this;
	}
//	21번 벡터 다른 스칼라와 곱
	
	
}
