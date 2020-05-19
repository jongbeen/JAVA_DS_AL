package tensor;

import java.util.Arrays;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class MatrixImpl implements Matrix, Cloneable {
	
	private int row;
	private int col;
	
	private ArrayList<ArrayList<ScalarImpl>> scalar;
	private ArrayList<ScalarImpl> element;
	
	public MatrixImpl() {
		scalar = new ArrayList<ArrayList<ScalarImpl>>();
	}
	
	public MatrixImpl(int row, int col) {
		this.row = row;
		this.col = col;
		scalar = new ArrayList<ArrayList<ScalarImpl>>();
	}
	
	
	public MatrixImpl(int row, int col,double one_value) {
		this.row = row;
		this.col = col;
		ScalarImpl temp = new ScalarImpl();
		scalar = new ArrayList<ArrayList<ScalarImpl>>();
		for(int i=0;i<row;i++) {
			element = new ArrayList<ScalarImpl>();
			for(int j=0;j<col;j++) {
				temp.ScalarSet(one_value);
				element.add(temp);
			}
			scalar.add(element);
		}
	}
	public MatrixImpl(int row, int col, double start, double end) {
		this.row = row;
		this.col = col;
		scalar = new ArrayList<ArrayList<ScalarImpl>>();

		for(int i=0;i<this.row;i++) {
			element = new ArrayList<ScalarImpl>();
			for(int j=0;j<this.col;j++) {
				ScalarImpl tmp = new ScalarImpl();
				double random = (double)((Math.random()*(end-start))+start);
				tmp.ScalarSet(random);
				element.add(tmp);
			}
			scalar.add(element);
		}
	}
	public MatrixImpl(double[][] arr) throws MyException {
		this.row = arr.length;
		this.col = arr[0].length;
		for(int i=0;i<arr.length;i++) {
			if(arr[0].length != arr[i].length)
				throw new MyException("모든 행길이 동일해야함");
		}
		scalar = new ArrayList<ArrayList<ScalarImpl>>();
		for(int i=0;i<row;i++) {
			element = new ArrayList<ScalarImpl>();
			for(int j=0;j<col;j++) {
				ScalarImpl tmp = new ScalarImpl();
				tmp.ScalarSet(arr[i][j]);
				element.add(tmp);
			}
			scalar.add(element);
		}
	}
	
	public MatrixImpl(int identity) {
		if(identity < 2) 
			System.out.println("설정 불가, 최소 2이상");
		else {
			this.row = identity;
			this.col = identity;
			scalar = new ArrayList<ArrayList<ScalarImpl>>();
			for(int i=0;i<row;i++) {
				element = new ArrayList<ScalarImpl>();
				for(int j=0;j<col;j++) {
					ScalarImpl tmp = new ScalarImpl();
					if(i==j) {
						tmp.ScalarSet(1);
						element.add(tmp);
					}
					else {
						tmp.ScalarSet(0);
						element.add(tmp);
					}
				}
				scalar.add(element);
				
			}
		}
	}

//	Matrix의 생성자 - 6번,7번,9번,10번
	
	static MatrixImpl AddMatrix(Matrix matrix1, Matrix matrix2) {
		return matrix1.AddMatrix(matrix2);
	}
//	28번 두 행렬합해 새로운 행렬 리턴
	static MatrixImpl MultiplyMatrix(Matrix matrix1, Matrix matrix2) {
		return (MatrixImpl) matrix1.MultiplyMatrix(matrix2);
	}
//	29번 두 행렬 곱해 새로운 행렬 리턴
	
	
	static public MatrixImpl AddMatrixInRow(Matrix matrix1,Matrix matrix2) {
		
		double[][] arr1 = new double[matrix1.GetMatrixRow()][matrix1.GetMatrixCol()];
		double[][] arr2 = new double[matrix2.GetMatrixRow()][matrix2.GetMatrixCol()];
		
		double[][] total = new double[matrix1.GetMatrixRow()][matrix1.GetMatrixCol()+matrix2.GetMatrixCol()];
		MatrixImpl Temp = new MatrixImpl(matrix1.GetMatrixRow(), matrix1.GetMatrixCol()+matrix2.GetMatrixCol(), 0);
		if(matrix1.GetMatrixCol() == matrix2.GetMatrixCol()) {
			for(int i=0;i<matrix1.GetMatrixRow();i++) {
				for(int j=0;j<matrix1.GetMatrixCol();j++) {
					arr1[i][j] = matrix1.GetScalarfromMatrix(i, j).ScalarGet();
				}
			}
			for(int i=0;i<matrix2.GetMatrixRow();i++) {
				for(int j=0; j<matrix2.GetMatrixCol();j++) {
					arr2[i][j] = matrix2.GetScalarfromMatrix(i, j).ScalarGet();
				}
			}
			for(int i=0;i<matrix1.GetMatrixRow();i++) {
				for(int j=0;j<matrix1.GetMatrixCol()+matrix2.GetMatrixCol();j++) {
					if(j<matrix1.GetMatrixCol())
						total[i][j] = arr1[i][j];
					else
						total[i][j] = arr2[i][j-matrix1.GetMatrixCol()];
				}
			}
			Temp = Factory.createMatrixfromArr2(total);
			return Temp;
		}
		System.out.println("합 불가능");
		return null;
	}
	
	static public MatrixImpl AddMatrixInCol(Matrix matrix1,Matrix matrix2) {
		
		
		double[][] arr1 = new double[matrix1.GetMatrixRow()][matrix1.GetMatrixCol()];
		double[][] arr2 = new double[matrix2.GetMatrixRow()][matrix2.GetMatrixCol()];
		
		double[][] total = new double[matrix1.GetMatrixRow()+matrix2.GetMatrixCol()][matrix1.GetMatrixCol()];
		MatrixImpl Temp = new MatrixImpl(matrix1.GetMatrixRow()+matrix2.GetMatrixCol(), matrix1.GetMatrixCol(), 0);
		if(matrix1.GetMatrixCol() == matrix2.GetMatrixCol()) {
			for(int i=0;i<matrix1.GetMatrixRow();i++) {
				for(int j=0;j<matrix1.GetMatrixCol();j++) {
					arr1[i][j] = matrix1.GetScalarfromMatrix(i, j).ScalarGet();
				}
			}
			for(int i=0;i<matrix2.GetMatrixRow();i++) {
				for(int j=0; j<matrix2.GetMatrixCol();j++) {
					arr2[i][j] = matrix2.GetScalarfromMatrix(i, j).ScalarGet();
				}
			}
			for(int i=0;i<matrix1.GetMatrixRow()+matrix2.GetMatrixCol();i++) {
				for(int j=0;j<matrix1.GetMatrixCol();j++) {
					if(i<matrix1.GetMatrixCol())
						total[i][j] = arr1[i][j];
					else
						total[i][j] = arr2[i-matrix1.GetMatrixRow()][j];
				}
			}
			Temp = Factory.createMatrixfromArr2(total);
			return Temp;
		}
		System.out.println("합 불가능");
		return null;
	}
//	33번 세로로 합쳐지는 행렬리턴, null을 리턴하는 경우는 null 포인터 exception 생성하던지, 아니면 한개만 리턴하고 안된다 출력하던지 
	
//	디폴트 static 구현부
	
//	이하는  Matrix의 오버라이드 구현부
	
	
	@Override
	public ScalarImpl GetScalarfromMatrix(int row,int col) throws MyException {
		if(row>this.row || col>this.col)
			throw new MyException("주어진 범위에서 해결 할 것");
		return (ScalarImpl) this.scalar.get(row-1).get(col-1);
	}
//	11번m 특정 위치 스칼라 조회 가능
	@Override
	public int GetMatrixRow() {
		return this.row;
	}
	@Override
	public int GetMatrixCol() {
		return this.col;
	}
	@Override
	public String toString() {
		String Matrix="Matrix 는\n ";
		double[][] arr = new double[this.row][this.col];
		for(int i=0;i<this.row;i++) {
			for(int j=0;j<this.col;j++) {
				arr[i][j] = scalar.get(i).get(j).ScalarGet();
				Matrix += arr[i][j]+"\t";
			}
			Matrix +="\n ";
		}
		return Matrix;
	}
	@Override
	public boolean equals(Object mxl) {
		MatrixImpl mc = (MatrixImpl)mxl;
		if(this.CheckMatrixLength(mc)) {
			for(int i=0; i<this.row; i++) {
				for( int j=0; j<this.col; j++) {
					if(scalar.get(i).get(j).ScalarGet() != mc.scalar.get(i).get(j).ScalarGet())
						return false;
				}
			}
			return true;
		}
		else
			return false;
	}
	public MatrixImpl clone() throws CloneNotSupportedException{
		MatrixImpl m = (MatrixImpl)super.clone();
		m.scalar = (ArrayList<ArrayList<ScalarImpl>>) scalar.clone();
		return m;
	}
//	17.clone
	
	@Override
	public void show() {
		System.out.println("행 :"+row+"열 :"+col+"인 행렬");
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				System.out.print(scalar.get(i).get(j).ScalarGet()+"\t");
			}
			System.out.println();
		}
	}
//	toString전 객체 확인하던 메소드
	@Override
	public boolean CheckMatrixLength(Matrix mxl) {
		if(this.GetMatrixRow() == mxl.GetMatrixRow()) {
			if(this.GetMatrixCol() == mxl.GetMatrixCol()) {
				return true;
			}
			else
				return false;
		}
		else
			return false;
	}		
	@Override
	public MatrixImpl AddMatrix(Matrix mxl) throws MyException {
		if(this.CheckMatrixLength(mxl)==false)
			throw new MyException("같은 size의 행렬이여야 함");
		MatrixImpl tmp = new MatrixImpl(row, col);
		MatrixImpl mc = (MatrixImpl)mxl;
		if(this.CheckMatrixLength(mxl)) {
			for(int i=0;i<this.row;i++) {
				tmp.element = new ArrayList<ScalarImpl>();
				for(int j=0;j<this.col;j++) {
					ScalarImpl s= new ScalarImpl();
					double num1 = 0,num2 = 0;
					num1 = scalar.get(i).get(j).ScalarGet();
					num2 = mc.scalar.get(i).get(j).ScalarGet();
					s.ScalarSet(num1+num2);
					tmp.element.add(s);
					
				}
				tmp.scalar.add(tmp.element);
			}
			return tmp;
		}
		else {
			System.out.println("덧셈불가");
			return this;
			}
	}	
	
	@Override
	public MatrixImpl MultiplyMatrix(Matrix mxl) throws MyException {
		MatrixImpl mc = (MatrixImpl)mxl;
		MatrixImpl temp = new MatrixImpl(this.row, mc.col);
		
		if(this.CheckMatrixLength(mxl)==false)
			throw new MyException("같은 size의 행렬이여야 함");

		if(this.GetMatrixCol() == mc.GetMatrixRow()) {
			for(int i=0;i<temp.row;i++) {
				temp.element = new ArrayList<ScalarImpl>();
				for(int j=0;j<temp.col;j++) {
					ScalarImpl sum = new ScalarImpl(0);
					double hap = 0;
					for(int k=0;k<this.col;k++) {
						ScalarImpl s2 = new ScalarImpl();
						ScalarImpl s3 = new ScalarImpl();
						
						double num1, num2 = 0;
						s2 = this.scalar.get(i).get(k);
						s3 = mc.scalar.get(k).get(j);
						num1 = s2.ScalarGet();
						num2 = s3.ScalarGet();
						
						hap += num1*num2;
						
					}
					sum.ScalarSet(hap);
					temp.element.add(sum);
				}
				temp.scalar.add(temp.element);
			}
			return temp;
		}
		else {
			System.out.println("곱셈 불가");
			return this;
		}
	}
	
//	23번 행렬곱셈 연산 구현 
	
	@Override
	public VectorImpl ExtractRowVectorFromMatrix(int row) throws MyException {
		if(row>this.row)
			throw new MyException("주어진 범위에서 해결 할 것");
		VectorImpl temp = new VectorImpl(this.GetMatrixCol());
		ScalarImpl s = new ScalarImpl();
		for(int i=0;i<this.GetMatrixCol();i++) {
			s = this.GetScalarfromMatrix(row-1, i);
			temp.SetScalarInVector(i, s);
		}
		return temp;
	}
//	34번 특정 행(i번째) 추출하는 행렬 기능
	@Override
	public VectorImpl ExtractColVectorFromMatrix(int col) throws MyException {
		if(col>this.col)
			throw new MyException("주어진 범위에서 해결 할 것");
		VectorImpl temp = new VectorImpl(this.GetMatrixRow());
		ScalarImpl s = new ScalarImpl();
		for(int i=0;i<this.GetMatrixCol();i++) {
			s = this.GetScalarfromMatrix(i, col-1);
			temp.SetScalarInVector(i, s);
		}
		return temp;
	}
//	35번 특정 열(i번째) 추출하는 행렬 기능 
	
	@Override
	public MatrixImpl ExtractPartialFromMatrix(int start_row,int start_col,int end_row,int end_col)throws MyException {
		if(start_row <0 || start_col <0 || end_row>this.row || end_col >this.col)
			throw new MyException("주어진 범위에서 해결 할 것");
		
		MatrixImpl temp = new MatrixImpl(end_row-start_row+1, end_col-start_col+1);
		for(int i=0;i<end_row-start_row+1;i++) {
			temp.element = new ArrayList<ScalarImpl>();
			double num=0;
			for(int j=0;j<end_col-start_col+1;j++) {
				num = this.scalar.get(start_row+i-1).get(start_col+j-1).ScalarGet();
				temp.element.add(new ScalarImpl(num));
			}
			temp.scalar.add(temp.element);
		}
		return temp;
	}
	
	
//	36번 행렬의 특정범위를 추출하는 기능
	
	@Override
	public MatrixImpl ExtractUnPartialFromMatrix(int row,int col)throws MyException {
		if(row >this.row || col >this.col)
			throw new MyException("주어진 범위에서 해결 할 것");
		MatrixImpl temp = new MatrixImpl(this.row-1, this.col-1);
		for(int i=0;i<this.row;i++) {
			temp.element = new ArrayList<ScalarImpl>();
			for(int j=0;j<this.col;j++) {
				if(i != row-1 && j != col-1) {
					double num = this.scalar.get(i).get(j).ScalarGet();
					temp.element.add(new ScalarImpl(num));
				}			
			}
			if(i!=row-1)
				temp.scalar.add(temp.element);
		}
		return temp;
	}
	
	@Override
	public MatrixImpl TransposeMatrix() throws MyException{
		if(this.CheckSquareMatrix() == false)
			throw new MyException("정사각행렬이여야 가능한 기능");
		MatrixImpl temp = new MatrixImpl(this.col, this.row);
		for(int i=0;i<this.col;i++) {
			temp.element = new ArrayList<ScalarImpl>();
			for(int j=0; j<this.row;j++) {
				double num = this.scalar.get(j).get(i).ScalarGet();
				temp.element.add(new ScalarImpl(num));
			}
			temp.scalar.add(temp.element);
		}
		return temp;
	}
//	38번 전치행렬 리턴
	
	
	@Override
	public double TraceMatrix() {
		double sum=0;
		if(this.col != this.row) {
			System.out.println("덧셈 불가");
			return 0;
		}
		else {
			for(int i=0; i< this.row; i++) {
				sum += this.scalar.get(i).get(i).ScalarGet();
			}
		}
	return sum;
	}
//	39번 대각 요소의 합을 구한다.
	
	@Override
	public boolean CheckSquareMatrix() {
		if(this.col == this.row)
			return true;
		return false;
	}
//	40번 자신이 정사각 행렬인지 여부를 파악 할 수 있다
	
	@Override
	public boolean CheckUpperTriangleMatrix() {
		for(int i=0;i<this.row;i++) {
			for(int j=0;j<this.col;j++) {
				if(i>j) {
					if(this.scalar.get(i).get(j).ScalarGet()!=0)
						return false;
				}
			}
		}
		return true;
	}
//	41번 상삼각 행렬 여부 판단
	
	@Override
	public boolean CheckLowerTriangleMatrix() {
		for(int i=0;i<this.row;i++) {
			for(int j=0;j<this.col;j++) {
				if(i<j) {
					if(this.scalar.get(i).get(j).ScalarGet()!=0)
						return false;
				}
			}
		}
		return true;
	}
//	42번 하삼각 행렬 여부 판단
	
	@Override
	public boolean CheckIdentityMatrix() {
		if(this.col != this.row)
			return false;
		else {
			for(int i=0;i<this.row;i++) {
				for(int j=0;j<this.col;j++) {
					if(i!=j) {
						if(this.scalar.get(i).get(j).ScalarGet() != 0)
							return false;
					}
					else {
						if(this.scalar.get(i).get(j).ScalarGet() != 1)
							return false;
					}
				}
			}
			return true;
		}
	}
//		43번 단위행렬 여부 판단	
	@Override	
	public boolean CheckZeroMatrix() {
		for(int i=0;i<this.row;i++) {
			for(int j=0;j<this.col;j++) {
				if(this.scalar.get(i).get(j).ScalarGet() !=0)
					return false;
			}
		}
		return true;
	}
//	44번 0행렬 여부 판단
	
	@Override
	public MatrixImpl TradeSelectRowInMatrix(int row1, int row2) throws MyException {
		if(row1 > this.row || row2 > this.row)
			throw new MyException("주어진 범위에서 해결 할 것");
		double[][] array = new double[this.row][this.col];
		double[] arr = new double[this.col];
		double[] brr = new double[this.col];
		
		for(int i=0;i< this.row;i++) {
			for(int j=0;j<this.col;j++) {
				array[i][j] = this.scalar.get(i).get(j).ScalarGet();
			}
		}
		for(int i=0;i<this.col;i++) {	
			arr[i] = this.scalar.get(row1-1).get(i).ScalarGet();
			brr[i] = this.scalar.get(row2-1).get(i).ScalarGet();
		}
		for(int i=0;i<this.col;i++) {
			array[row1-1][i] = brr[i];
			array[row2-1][i] = arr[i];
		}
		Matrix temp = new MatrixImpl(array);
		
		return (MatrixImpl) temp;
	}
//	45번 특정한 두 행의 위치를 맞교환 가능
	
	@Override
	public MatrixImpl TradeSelectColInMatrix(int col1, int col2) throws MyException {
		if(col1 > this.col || col2 > this.col )
			throw new MyException("주어진 범위에서 해결 할 것");
		double[][] array = new double[this.row][this.col];
		double[] arr = new double[this.row];
		double[] brr = new double[this.row];
		
		for(int i=0;i<this.row;i++) {
			for(int j=0;j<this.col;j++) {
				array[i][j] = this.scalar.get(i).get(j).ScalarGet();
			}
		}
		for(int i=0;i<this.row;i++) {
			arr[i] = this.scalar.get(i).get(col1-1).ScalarGet();
			brr[i] = this.scalar.get(i).get(col2-1).ScalarGet();
		}
		for(int i=0;i<this.row;i++) {
			array[i][col1-1] = brr[i];
			array[i][col2-1] = arr[i]; 
		}
		Matrix temp = new MatrixImpl(array);
		return (MatrixImpl) temp;
	}
//	46번 특정한 두 열의 위치 맞교환 가능
	
	
	@Override
	public MatrixImpl MulSelectRowInMatrix(int srow,Scalar s) throws MyException {
		if(srow>this.row)
			throw new MyException("주어진 범위에서 해결 할 것");
		for(int i=0;i<this.row;i++) {
			this.element = new ArrayList<ScalarImpl>();
			for(int j=0;j<this.col;j++) {
				ScalarImpl temp = new ScalarImpl();
				if(i==srow-1) {
					temp = this.scalar.get(i).get(j).MultiplyScalar(s);
					this.element.add(temp);
				}
			}
			if(i==srow-1)
				this.scalar.set(i, element);
		}
		return this;
	}
//	47번 특정 행에 스칼라 배
	@Override
	public MatrixImpl MulSelectColInMatrix(int scol,Scalar s) throws MyException {
		if(scol>this.col)
			throw new MyException("주어진 범위에서 해결 할 것");
		for(int i=0;i<this.row;i++) {
			this.element = new ArrayList<ScalarImpl>();
			for(int j=0;j<this.col;j++) {
				ScalarImpl temp = new ScalarImpl();
				if(j==scol-1) {
					temp = this.scalar.get(i).get(j).MultiplyScalar(s);
					this.element.add(temp);
				}
				else {
					temp = this.scalar.get(i).get(j);
					this.element.add(temp);
				}
			}
			this.scalar.set(i, element);
		}
		return this;
	}
//	48번 특정열에 스칼라배
	
	@Override
	public MatrixImpl MulSelectRowFromOtherRowInMatrix(int row1,int row2,Scalar s) throws MyException {
		if(row1>this.row || row2 > this.row)
			throw new MyException("주어진 범위내에서 해결할 것.");
		double num1=0,num2=0;
		this.element = new ArrayList<ScalarImpl>();
		for(int i=0;i<this.col;i++) {
			num1 = this.scalar.get(row1-1).get(i).ScalarGet();
			num2 = this.scalar.get(row2-1).get(i).ScalarGet();
			this.element.add(new ScalarImpl(num1+num2*s.ScalarGet()));
		}
		this.scalar.set(row1-1, this.element);
		return this;
	}
//	49번 특정해에 다른 행 상수배

	@Override
	public MatrixImpl MulSelectColFromOtherColInMatrix(int col1,int col2,Scalar s) throws MyException{
		double num1=0,num2=0;
		if(col1>this.col || col2>this.col)
			throw new MyException("주어진 범위에서 해결 할 것.");
		for(int i=0;i<this.row;i++) {
			this.element = new ArrayList<ScalarImpl>();
			for(int j=0;j<this.col;j++) {
				if(j==col1-1) {
					num1 = this.scalar.get(i).get(col1-1).ScalarGet();
					num2 = this.scalar.get(i).get(col2-1).ScalarGet();
					this.element.add( new ScalarImpl(num1+num2*s.ScalarGet()) );
				}
				else
					this.element.add(new ScalarImpl(this.scalar.get(i).get(j).ScalarGet()));
			}
			this.scalar.set(i, element);
		}
		return this;
	}
//	50번 특정 열에 다른 열 상수 배

	public MatrixImpl ExtractRREFMatrix() {
		double rref[][] = new double[this.row][this.col];
		double temp[][] = new double[this.row][this.col];
		for(int i=0;i<this.row;i++) {
			for(int j=0;j<this.col;j++) {
				temp[i][j] = this.scalar.get(i).get(j).ScalarGet();
			}
		}
		for(int i=0;i<this.row;i++) {
			rref[i] = Arrays.copyOf(temp[i], temp[i].length);
		}
		int r=0;
		for (int c = 0; c < rref[0].length && r < rref.length; c++) {
			int j = r;
			for (int i = r + 1; i < rref.length; i++)
				if (Math.abs(rref[i][c]) > Math.abs(rref[j][c]))
					j = i;
			if (Math.abs(rref[j][c]) < 0.00001)
				continue;

			double[] tmp = rref[j];
			rref[j] = rref[r];
			rref[r] = tmp;
			
			double s = 1.0 / rref[r][c];
			for (j = 0; j < rref[0].length; j++)
				rref[r][j] *= s;
			for (int i = 0; i < rref.length; i++) {
				if (i != r) {
					double t = rref[i][c];
					for (j = 0; j < rref[0].length; j++)
						rref[i][j] -= t * rref[r][j];
				}
			}
			r++;
		}
		return Factory.createMatrixfromArr2(rref);
	}
//	51 RREF행렬 추출
	public boolean CheckRREFMatrix() {
		int[] x_point = new int[this.row];
		int[] y_point = new int[this.col];
		
		int point_x = 0 , point_y = 0;
		int count = 0;
		for(int i=0;i<this.row;i++) {
			for(int j=0;j<this.col-1;j++) {
				if(this.scalar.get(i).get(j).ScalarGet() == 1) {
					if(count == 0) {
						x_point[count]=i;
						y_point[count]=j;
						count++;
						break;
					}
					else {
						if(point_x>i || point_y>j)
							return false;
						else {
							x_point[count] = i;
							y_point[count] = j;
							count++;
							break;
						}
					}	
				}	
			}
		}
		return true;
	}
//	52. RREF행렬 확인
	
	public double Determinant() {
		double[][] temp = new double[this.row][this.col];
		for(int i=0;i<this.row;i++) {
			for(int j=0; j<this.col ;j++) {
				temp[i][j] = this.scalar.get(i).get(j).ScalarGet();
			}
		}
		for(int n = 0; n< this.row; n++) {
			if(temp[n][n] == 0) {
				for(int a=n; a<this.row; a++) {
					if(temp[a][n] != 0) {
						for(int b=n; b<this.row; b++) {
							temp[n][b] += temp[a][b];
						}
						break;
					}
				}
				if(temp[n][n] == 0) {
					System.out.println(n+"ss");
					return 0;
				}
			}
			for(int i= n+1; i<this.row; i++) {
				for(int j= this.col-1; j>=n; j--) {
					temp[i][j] = temp[i][j] - temp[i][n] *temp[n][j] / temp[n][n];
				}
			}
		}
		double sum =1;
		for(int i=0;i<this.row; i++) {
			sum *= temp[i][i];
		}
		System.out.print("Determinant is ");
		return sum;
	}
//	53번 행렬식 리턴
	
	public MatrixImpl ReverseMatrix() throws MyException {
		if(this.CheckSquareMatrix()==false)
			throw new MyException("정사각행렬로 해야함");
		double[][] temp = new double[this.row][this.col];
		for(int i=0;i<row;i++) {
			for(int j=0;j<row;j++) {
				temp[i][j] = this.scalar.get(i).get(j).ScalarGet();
			}
		}
		double[][] comp = new double[this.row][this.row];
		for(int i=0;i<comp.length;i++) {
			comp[i][i]=1;
		}
		for(int n=0;n<this.row;n++) {
			if(temp[n][n] == 0) {
				for(int k=n;k<this.col;k++) {
					if(temp[k][n] != 0) {
						for(int a=0;a<col;a++) {
							comp[n][a] = comp[n][a] +comp[k][a];
							temp[n][a] = temp[n][a]+temp[k][a];
						}
						break;
					}
				}
			}
			double tmp = temp[n][n];
			for(int a=0;a<this.col;a++) {
				comp[n][a] /= tmp;
				temp[n][a] /= tmp;
			}
			for(int i=0; i<col; i++) {
				if(i!=n) {
					double tmp2 = temp[i][n];
					for(int j = col-1; j>=0;j--) {
						comp[i][j] -= tmp2*comp[n][j];
						temp[i][j] -= tmp2*temp[n][j];
					}
				}
			}
		}
		MatrixImpl ReversedMatrix = Factory.createMatrixfromArr2(comp);
		return ReversedMatrix;
	}
//	54번 역행렬
}
