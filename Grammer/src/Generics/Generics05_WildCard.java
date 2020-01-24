package Generics;

import java.util.Arrays;

public class Generics05_WildCard {
	static void registerCourse( Course<?> course) {
		System.out.println(course.getName()+" 수강생 " 
				+Arrays.toString(course.getStudents()));
	}
	
	static void registerCourseStudent( Course<? extends Student> course) {	
		System.out.println(course.getName()+" 수강생 "
				+Arrays.toString(course.getStudents()));
	}
	static void registerCourseWorker( Course<? super Worker> course) {
		System.out.println(course.getName()+" 수강생 "
				+Arrays.toString(course.getStudents()));
	}
	
	public static void main(String[] args) {
		Course<Person> personCourse = new Course<Person>("모든 사람",5);
		personCourse.add(new Person("일반인"));
		personCourse.add(new Worker("노동자"));
		personCourse.add(new Student("학생"));
		personCourse.add(new HighStudent("고등학생"));
		
		Course<Worker> workerCourse = new Course<Worker>("직장 과정",5);
		workerCourse.add(new Worker("직장인"));
		
		Course<Student> studentCourse = new Course<Student>("학생과정",5);
		studentCourse.add(new Student("학생"));
		studentCourse.add(new HighStudent("고등학생"));
		
		Course<HighStudent> highstudentCourse = new Course<HighStudent>("고등학생과정",5);
		highstudentCourse.add(new HighStudent("고등학생"));
		
		System.out.println("-----일반인 과정 신청대상-----");
		registerCourse(personCourse);
		registerCourse(workerCourse);
		registerCourse(studentCourse);
		registerCourse(highstudentCourse);
		System.out.println("");
		
		System.out.println("-----학생 과정 신청대상-----");
		//registerCourseStudent(personCourse);      Student이하의 Type만 접근 가능
		//registerCourseStudent(workerCourse);		Worker는 Student 이하 Class가 아님
		registerCourseStudent(studentCourse);
		registerCourseStudent(highstudentCourse);
		System.out.println("");
		
		System.out.println("-----직장인 과정 신청대상-----");
		registerCourseWorker(workerCourse);
		registerCourseWorker(personCourse);
		
	}

}





class Course<T>{
	private String name;
	private T[] students;	// 선언은 문제 없다!		그냥 new T[] 만 안되지 다른건 (반환, 타입변환 )다 된다!
	
	public Course(String name,int capacity) {
		this.name = name;
		students = (T[]) new Object[capacity];	// new T[] 가 안됨. 따라서 Object형으로 생성후 타입변환 필요
	}
	
	public String getName() { return name;}
	public T[] getStudents() { return students;}
	public void add(T t) {
		for(int i=0; i<students.length;i++) {
			if(students[i] == null) {
				students[i] = t;
				break;
			}
		}
	}
}

// Person -> Student -> HighStudent
//        -> Worker


class Person{
	protected String name;
	public Person(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name;
	}
}
class Worker extends Person{
	
	public Worker(String name) {
		super(name);
	}
}

class Student extends Person{
	public Student(String name) {
		super(name);
	}
}

class HighStudent extends Student{
	public HighStudent(String name) {
		super(name);
	}
}





