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
		//���� ������ ���� ���
		if(this.kor == o2.kor)
		{
			//���� ������ ���� ���
			if(this.eng == o2.eng)
			{
				//���� ������ ���� ���
				if(this.math == o2.math)
				{
					return this.name.compareTo(o2.name);
				}
				//���� ���� �����ϴ� ������
				else
				{
					return Integer.compare(o2.math, this.math);
				}
			}
			//�ƴϸ� ���� ���� �����ϴ� ������
			else
			{
				return Integer.compare(this.eng, o2.eng);
			}
		}
		
		//���� ������ �ٸ� ��� �����ϴ� ������
		return Integer.compare(o2.kor, this.kor);
	}
	
}


public class Chapter14_23 {

	//��� ��
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
