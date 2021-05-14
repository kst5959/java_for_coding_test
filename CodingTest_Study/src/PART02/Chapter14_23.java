package PART02;

import java.util.*;

class Student implements Comparable<Student> {

	private String name;
	private int kor;
	private int math;
	private int eng;
	
	public Student (String name, int kor, int eng, int math)
	{
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		
	}
	
	public String getName()
	{
		return this.name;
	}
	
	@Override
	public int compareTo(Student o2) {
		// TODO Auto-generated method stub
		//국어 점수가 같은 경우
		if(this.kor == o2.kor)
		{
			//영어 점수도 같은 경우
			if(this.eng == o2.eng)
			{
				//수학 점수도 같은 경우
				if(this.math == o2.math)
				{
					return this.name.compareTo(o2.name);
				}
				//수학 점수 감소하는 순서로
				else
				{
					return Integer.compare(o2.math, this.math);
				}
			}
			//아니면 영어 점수 증가하는 순서로
			else
			{
				return Integer.compare(this.eng, o2.eng);
			}
		}
		
		//국어 점수가 다른 경우 감소하는 순으로
		return Integer.compare(o2.kor, this.kor);
	}
	
}


public class Chapter14_23 {

	//사람 수
	public static int N;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		ArrayList<Student> list = new ArrayList<>();
		
		for (int i = 0; i < N; i++) 
		{
			String name = sc.next();
			int kor = sc.nextInt();
			int eng = sc.nextInt();
			int math = sc.nextInt();
			
			list.add(new Student(name, kor, eng, math));
		}
	
		Collections.sort(list);
	
		
		for (int i = 0; i < N; i++) 
		{
			System.out.println(list.get(i).getName());
		}
		
	}

}
