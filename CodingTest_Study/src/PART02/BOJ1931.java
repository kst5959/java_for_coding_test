package PART02;

import java.util.*;

class Conference implements Comparable<Conference>
{
	private int end;
	private int start;
	
	public Conference(int end, int start) {
		// TODO Auto-generated constructor stub
		this.end = end;
		this.start = start;
	}
	
	public int getEnd()
	{
		return this.end;
	}
	
	public int getStart()
	{
		return this.start;
	}
	
	
	@Override
	public int compareTo(Conference o2) {
		// TODO Auto-generated method stub
		if(this.end == o2.getEnd())
		{
			return this.start - o2.getStart();
		}
		else
		{
			return this.end - o2.getEnd();
		}
	}
	
}


public class BOJ1931 {

	public static int N;
	public static ArrayList<Conference> list = new ArrayList<Conference>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		for (int i = 0; i < N; i++) 
		{
			int start = sc.nextInt();
			int end = sc.nextInt();
			
			list.add(new Conference(end, start));
		}
		
		Collections.sort(list);
		
		int count = 0;
		int currentTime = 0;
		for (int i = 0; i < list.size(); i++) 
		{
			if(currentTime <= list.get(i).getStart())
			{
				currentTime = list.get(i).getEnd();
				System.out.println("Use (" + list.get(i).getStart() + " , " + list.get(i).getEnd()+")");
				count++;
			}
		}
		
		System.out.println(count);
		
	}

}
