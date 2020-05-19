package test;
import tensor.*;

public class Test {

	public static void main(String[] args) {
		
		
		try {
			System.out.print("1번");
			Scalar as = Factory.createScalar(5.0);
			System.out.println(as);
			
			System.out.print("2번");
			Scalar bs = Factory.createRandomScalar(2, 5);
			System.out.println(bs);
			
			System.out.print("3번");
			Vector av = Factory.createVector(5, 7);
			System.out.println(av);
			
			System.out.print("4번");
			Vector bv = Factory.createRandomVector(5, 5, 10);
			System.out.println(bv);
			
			System.out.print("5번");
			double[] arr = {1,2,3,4,5};
			Vector cv = Factory.createVectorfromArr(arr);
			System.out.println(cv);
			
			System.out.print("6번");
			Matrix am = Factory.createMatrix(3, 3, 3);
			System.out.println(am);
			
			System.out.print("7번");
			Matrix bm = Factory.createRandomMatrix(4, 4, 2, 7);
			System.out.println(bm);
			
			
//			8번 공석중
			
			
			System.out.print("9번");
			double[][] array = {{1,2,3,4,5},{2,2,3,4,5},{0,0,3,1,5},{1,2,3,4,5},{1,0,3,4,0}};
			Matrix cm = Factory.createMatrixfromArr2(array);
			System.out.println(cm);
			
			System.out.print("10번");
			Matrix dm = Factory.createIdentityMatrix(4);
			System.out.println(dm);
			
			System.out.print("11번 av (3)번째는 :");
			System.out.println(av.InquireElement(3));
			
			System.out.print("11번 am (2,2)번째는 : ");
			System.out.println(am.GetScalarfromMatrix(2, 2));
			
			System.out.print("12번 as스칼라값 : ");
			System.out.println(as.ScalarGet());
			
			System.out.print("13번 bv Vector차원");
			System.out.println(bv.GetVectorLength());
			
			System.out.print("13번 bm 행개수,열개수 출력");
			System.out.println("행 길이 : "+bm.GetMatrixRow()+"열 길이"+bm.GetMatrixCol());
			
			System.out.print("14번");
			System.out.print("14번 s :");
			System.out.println(as);
			System.out.print("14번 v :");
			System.out.println(av);
			System.out.print("14번 m :");
			System.out.println(am);
			
			System.out.print("15번 (편의상 스칼라,벡터는 같고 행렬은 다른 경우를 증명합니다.)");
			Scalar cs = Factory.createScalar(5);
			Vector dv = Factory.createVector(5, 7);
			Matrix fm = Factory.createIdentityMatrix(5);
			System.out.println(am);
			
			System.out.println("초기 스칼라/벡터/행렬");
			System.out.println(as);
			System.out.println(av);
			System.out.println(am);
			
			System.out.println("임의로 생성한 스칼라/벡터/행렬");
			System.out.println(cs);
			System.out.println(dv);
			System.out.println(fm);
			
			System.out.println("동등성 비교 시작");
			
			System.out.print("15번 s :");
			System.out.println(as.equals(cs));
			System.out.print("15번 v :");
			System.out.println(av.equals(dv));
			System.out.print("15번 m :");
			System.out.println(am.equals(fm));
			
			System.out.print("16번(1번 스칼라와 2번 스칼라 대소 비교를 합니다 ,크면 1 같으면 0 작으면 -1) : ");
			System.out.println(as.compareTo(bs));
			
			System.out.println("17번s (1번 스칼라 복제): ");
			Scalar ds = as.clone();
			System.out.println("복제할 스칼라"+as);
			System.out.println("복제된 스칼라"+ds);
			
			System.out.println("17번v (3번 벡터 복제)");
			Vector ev = av.clone();
			System.out.println("복제할 벡터"+av);
			System.out.println("복제된 벡터"+ev);
			
			System.out.println("17번 m (6번 행렬 복제)");
			bm = am.clone();
			System.out.println("복제할 벡터"+am);
			System.out.println("복제된 벡터"+bm);
			
			System.out.println("18번 두 스칼라간 합(17번 사용한 스칼라 사용)");
			System.out.println(as.AddScalar(ds));
			
			System.out.println("19번 두 스칼라간 곱(18번결과*스칼라(5))");
			System.out.println(as.MultiplyScalar(ds));
			
			System.out.println("20번 두 벡터간의 합(3번 벡터+ 5번 벡터)");
			System.out.println(av.AddVector(cv));
			
			System.out.println("21번 벡터 곱 스칼라(20번 벡터*스칼라 값 2) : ");
			Scalar two = Factory.createScalar(2);
			System.out.println(av.MultiplyVector(two));
			
			System.out.println("22번 다른 행렬과의 합 6번 행렬과 단위행렬을 더할 것");
			Matrix Ethree = Factory.createIdentityMatrix(3);
			System.out.println(am.AddMatrix(Ethree));
			
			System.out.println("23번 다른 행렬과 곱(모든요소 3) , (모든요소1)인 3X3행렬");
			am = Factory.createMatrix(3, 3, 3);
			bm = Factory.createMatrix(3, 3, 1);
			System.out.println("좌곱");
			System.out.println(am.MultiplyMatrix(bm));
			System.out.println("우곱");
			System.out.println(bm.MultiplyMatrix(am));
			
			System.out.print("24번 전달받은 두 스칼라간 덧셈(값 1, 값 4 스칼라)");
			as= Factory.createScalar(1);
			bs= Factory.createScalar(4);
			cs = Tensors.ScalarAdd(as, bs);
			System.out.println(cs);
			
			System.out.print("25번 전달받은 두 스칼라 곱셈(예시값 동일)");
			cs = Tensors.ScalarMultiply(as, bs);
			System.out.println(cs);
			
			System.out.println("26번 전달받은 두 벡터");
			double[] brr = {2,4,6,8};
			double[] crr = {0,1,2,-1};
			
			av = Factory.createVectorfromArr(brr);
			bv = Factory.createVectorfromArr(crr);
			System.out.println("더할 벡터들");
			System.out.println(av);
			System.out.println(bv);
			cv = Tensors.VectorAdd(av, bv);
			System.out.println("벡터 합 결과");
			System.out.println(cv);
			
			
			System.out.println("27번 벡터(26번결과값) X 스칼라(4)");
			av = Tensors.VectorMultiply(cv, bs);
			System.out.println("27 결과");
			System.out.println(av);
			
			System.out.println("28번 전달받은 행렬의 덧셈");
			System.out.println("더할 행렬들");
			
			double[][] sample28_a = { {1,2,3},{2,0,6},{1,5,3} };
			double[][] sample28_b = { {1,1,1},{0,0,1},{2,1,3} };
			
			am = Factory.createMatrixfromArr2(sample28_a);
			bm = Factory.createMatrixfromArr2(sample28_b);
			System.out.println(am);
			System.out.println(bm);
			
			cm = Tensors.MatrixAdd(am, bm);
			System.out.println("28 결과값 : ");
			System.out.println(cm);
			
			System.out.println("29번 두 전달받은 행렬 곱(값은 28번 두행렬)");
			cm = Tensors.MatrixMultiply(am, bm);
			System.out.println(cm);
			
			System.out.println("30번 자신으로부터 NX1행렬 생성 반환");
			double[] sample_30;
			System.out.println("자신 "+av);
			sample_30 = Factory.createNX1ArrayfromVector(av);
			for(int i=0;i<sample_30.length;i++)
				System.out.print(sample_30[i]+"\t");
			System.out.println();
			
			System.out.println("31번 자신(30번)으로부터 1XN행렬 생성 반환");
			double[][] sample_31;
			sample_31 = Factory.create1XNArrayfromVector(av);
			for(int i=0;i<sample_31.length;i++) {
				System.out.println(sample_31[i][0]);
			}
			
			System.out.println("32번 다른 행렬과 가로로 합쳐짐 (1번행렬 + 2번행렬)");
			double[][] sample32_a = { {1,2,3},{1,1,1},{2,2,2} };
			double[][] sample32_b = { {5,6,7},{8,7,1},{3,5,6} };
			am = Factory.createMatrixfromArr2(sample32_a);
			bm = Factory.createMatrixfromArr2(sample32_b);
			System.out.println("1번 행렬");
			System.out.println(am);
			System.out.println("2번 행렬");
			System.out.println(bm);
			
			cm = Tensors.AddMatrixInRow(am, bm);
			System.out.println(cm);
			
			System.out.println("32번 다른 행렬과 세로로 합쳐짐 (31과 동일행렬)");
			cm = Tensors.AddMatrixInCol(am, bm);
			System.out.println(cm);
			
			System.out.println("34번 벡터 행렬에서 추출(1번행렬 2번째 행) ");
			av = am.ExtractRowVectorFromMatrix(2);
			System.out.println(av);
			
			System.out.println("35번 벡터 행렬에서 추출(2번 행렬 1번째 열) ");
			av = bm.ExtractColVectorFromMatrix(1);
			System.out.println(av);
			
			System.out.println("36번 특정 범위의 부분행렬 추출 [ (1,1) ~ [3,3]");
			System.out.println("전체행렬");
			am = Factory.createMatrixfromArr2(array);
			System.out.println(am);
			am = am.ExtractPartialFromMatrix(1, 1, 3, 3);
			System.out.println("추출행렬");
			System.out.println(am);
			
			System.out.println("37번 특정범위 제외 부분행렬 추출 (2행 2열 제외)");
			double[][] sample37 ={ {1,2,3,4},{5,6,7,8},{9,3,4,1} };
			am = Factory.createMatrixfromArr2(sample37);
			am = am.ExtractUnPartialFromMatrix(2, 2);
			System.out.println("추출 행렬");
			System.out.println(am);
			
			System.out.println("38번 전치행렬 구하기");
			
			double[][] sample38 = { {1,2,3,4},{0,1,2,0},{1,3,7,2},{1,0,0,1} };
			am = Factory.createMatrixfromArr2(sample38);
			System.out.println("기존 행렬");
			System.out.println(am);
			am = am.TransposeMatrix();
			System.out.println("전치된 행렬");
			System.out.println(am);
			
			System.out.print("39번 대각요소의 합을 구함(38번 행렬의 대각요소 합) : ");
			System.out.println(am.TraceMatrix());
			
			System.out.print("40번 자신이 정 사각 행렬인지 판별(38번행렬) : " );
			System.out.println(am.CheckSquareMatrix());
			
			System.out.println("41번 자신이 상삼각행렬인지 판별");
			double[][] tri_41 ={ {1,0,1,1}, {0,1,0,1} ,{0,0,0,1} ,{0,0,0,0} };
			double[][] tri_42= { {0,0,0,0}, {0,1,0,0} ,{0,0,1,0} ,{1,1,1,0} };
			am = Factory.createMatrixfromArr2(tri_41);
			bm = Factory.createMatrixfromArr2(tri_42);
			System.out.println("테스트 할  1번 행렬");
			System.out.println(am);
			System.out.println("테스트 할 2번 행렬");
			System.out.println(bm);
			System.out.println("1번행렬 결과 : "+am.CheckUpperTriangleMatrix()+"2번행렬 결과"+bm.CheckUpperTriangleMatrix());
			
			System.out.println("42번 자신이 하삼각행렬인지 판별");
			System.out.println("테스트 할  1번 행렬");
			System.out.println(am);
			System.out.println("테스트 할 2번 행렬");
			System.out.println(bm);
			System.out.println("1번행렬 결과 : "+am.CheckLowerTriangleMatrix()+"2번행렬 결과"+bm.CheckLowerTriangleMatrix());
			
			System.out.println("43 자신이 단위 행렬인지 판별");
			am = Factory.createIdentityMatrix(3);
			bm = Factory.createMatrix(3, 3, 0);
			System.out.println("테스트 할  1번 행렬");
			System.out.println(am);
			System.out.println("테스트 할 2번 행렬");
			System.out.println(bm);
			System.out.println("1번행렬 결과 : "+am.CheckIdentityMatrix()+" 2번행렬 결과"+bm.CheckIdentityMatrix());
			
			System.out.println("44 자신이 영행렬인지 판별");
			System.out.println("테스트 할  1번 행렬");
			System.out.println(am);
			System.out.println("테스트 할 2번 행렬");
			System.out.println(bm);
			System.out.println("1번행렬 결과 : "+am.CheckZeroMatrix()+" 2번행렬 결과"+bm.CheckZeroMatrix());
			
			System.out.println("45행렬은 특정 두행 위치 맞교환");
			am = Factory.createMatrixfromArr2(sample38);
			System.out.println("행렬 원본");
			System.out.println(am);
			System.out.println("2행 3행 맞교환");
			am = am.TradeSelectRowInMatrix(2, 3);
			System.out.println(am);
			
			System.out.println("46 행렬의 특정 두 열 위치 맞교환");
			
			System.out.println("행렬 원본");
			System.out.println(am);
			System.out.println("2열 3열 맞교환");
			am = am.TradeSelectColInMatrix(2, 3);
			System.out.println(am);
			
			System.out.println("47  행렬은 특정 행에 상수배 가능 (2행에 3배)");
			System.out.println("행렬 원본");
			System.out.println(am);
			System.out.println("상수배 결과 행렬");
			Scalar s = Factory.createScalar(3);
			am = am.MulSelectRowInMatrix(2, s);
			System.out.println(am);
			
			System.out.println("48 행렬은 특정 열에 상수배 가능 (3열에 2배)");
			System.out.println("행렬 원본");
			double[][] sample_48 ={ {1,0,1,2} , {0,1,2,4} , {1,1,3,2},{3,2,4,1} };
			am = Factory.createMatrixfromArr2(sample_48);
			System.out.println(am);
			System.out.println("상수배 결과 행렬(3열에 2배)");
			s= Factory.createScalar(2);
			am = am.MulSelectColInMatrix(3, s);
			System.out.println(am);
			
			System.out.println("49 행렬은 특정행에 다른행의 상수배 덧셈 가능(2행에 1행 2배 합)");
			System.out.println("기존행렬");
			am = Factory.createMatrixfromArr2(sample_48);
			System.out.println(am);
			am = am.MulSelectRowFromOtherRowInMatrix(2, 1, s);
			System.out.println("결과 행렬");
			System.out.println(am);
			
			System.out.println("50 행렬은 특정열에 다른열의 상수배 곱셈가능(4열에 2열 2배 합)");
			System.out.println("기존행렬");
			am = Factory.createMatrixfromArr2(sample_48);
			System.out.println(am);
			am = am.MulSelectColFromOtherColInMatrix(4, 2, s);
			System.out.println("결과 행렬");
			System.out.println(am);
			
			
			System.out.println("51 자신으로부터 RREF행렬 구해서 반환");
			double[][] sample_51 = { {0,0,-2,0,7,12},{2,4,-10,6,12,28},{2,4,-5,6,-5,-1} };
			am = Factory.createMatrixfromArr2(sample_51);
			System.out.println("기존 행렬");
			System.out.println(am);
			am = am.ExtractRREFMatrix();
			System.out.println("RREF행렬은 ");
			System.out.println(am);
			
			System.out.println("52 자신으로부터 RREF행렬 참/거짓 판단");
			System.out.println("테스트 행렬");
			System.out.println(am);
			
			System.out.println("테스트 행렬은 "+am.CheckRREFMatrix());
			
			System.out.println("53 자신의 행렬식 구하기");
			am = Factory.createMatrixfromArr2(sample_48);
			System.out.println("행렬은 : ");
			System.out.println(am);
			System.out.print("행렬식은 :");
			System.out.println(am.Determinant());
			
//			double[][] sample_54 = { {1,0,3,7},{4,2,0,1},{7,7,3,0},{5,0,6,8} };
			
			System.out.println("54 역행렬 구하기");
			am = Factory.createMatrixfromArr2(sample_48);
			System.out.println("기존 행렬은 : ");
			System.out.println(am);
			bm = am.ReverseMatrix();
			System.out.println("역행렬은 ");
			System.out.println(bm);
			System.out.println("기존행렬 X 역행렬");
			System.out.println(Tensors.MatrixMultiply(am, bm));
			System.out.println("마지막 행은 타입 변환계산으로 0에 한없이 가까운 숫자들이 나옵니다, 역행를은 맞습니다 ㅠㅠ");
			
			
			
			
		}catch(MyException mye) {
			mye.printStackTrace();
		}catch(ArrayIndexOutOfBoundsException ae) {
			ae.printStackTrace();
		}catch(CloneNotSupportedException ce) {
			ce.printStackTrace();
		}
	
		
	}
	
}
