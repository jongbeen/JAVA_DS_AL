package tensor;

class ScalarImpl implements Scalar , Cloneable {

	private double value;
	
	public ScalarImpl() {
	}
	public ScalarImpl(double value) {
		this.value = value;
	}
	
//	생성자 part,1번
	
//	디폴트 static 구현명세
	static ScalarImpl ScalarAdd(Scalar a, Scalar b) {
		return  a.AddScalar(b);
	}
	static ScalarImpl ScalarMultiply(Scalar a, Scalar b) {
		return a.MultiplyScalar(b);
	}
	
// Object 클래스 오버라이딩, toString(),equals()은 구현, Comparable(), clone()은 필요	
	
	public String toString() {
		return "Scalar : "+value;
	}
//	toString() 오버라이드
	
	public boolean equals(Object scl) {
		ScalarImpl sc = (ScalarImpl)scl;
		if(value == sc.ScalarGet())
			return true;
		return false;
	}
//	equals() 오버라이드
		
	
//	스칼라 인터페이스 의 오버라이딩 메소드
	@Override
	public void ScalarSet(double value) {
		this.value = value;
	}
	@Override
	public double ScalarGet() {
		return this.value;
	}
	@Override
	public void show() {
		System.out.println(this.value);
	}
	@Override
	public void ScalarRandomSet(double start, double end) throws MyException {
		if(start>end)
			throw new MyException("첫번째 인자가 두번째 인자보다 작아야 함");
		double random = (double)((Math.random()*(end-start))+start);
		this.value = random;
	}
//	2번 start 이상 end 이하 무작위 스칼라 생성
	@Override
	public double InquireElement() {
		return value;
	}
//	12번 스칼라 값 지정/조회
	
	public ScalarImpl clone() throws CloneNotSupportedException{
		return (ScalarImpl)super.clone();
	}
//	17. clone
	
	
	@Override
	public ScalarImpl AddScalar(Object scl) {
		ScalarImpl sc = (ScalarImpl)scl;
		this.value+=sc.value;
		return this;
	}
//	18번 다른 스칼라와 덧셈가능
	@Override
	public ScalarImpl MultiplyScalar(Object scl) {
		ScalarImpl sc = (ScalarImpl)scl;
		this.value *= sc.value;
		return this;
	}
//	19번 다른 스칼라와 곱셈가능
	
	public int compareTo(Scalar s) {
		ScalarImpl a = (ScalarImpl)s;
		
		if(this.value-a.value > 0)
			return 1;
		else if(this.value-a.value ==0)
			return 0;
		else
			return -1;
	}
//	compare 대소비교

}
