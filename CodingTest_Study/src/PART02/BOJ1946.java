package PART02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Grade implements Comparable<Grade>
{
	private int scoreA;
	private int scoreB;
	
	public Grade(int scoreA, int scoreB)
	{
		this.scoreA = scoreA;
		this.scoreB = scoreB;
	}
	
	public int getA()
	{
		return this.scoreA;
	}
	
	public int getB()
	{
		return this.scoreB;
	}
	
	@Override
	public int compareTo(Grade o2) {
		// TODO Auto-generated method stub
		if(this.scoreA == o2.scoreA)
		{
			return this.scoreB - o2.scoreB;
		}
		else
		{
			return this.scoreA - o2.scoreA;
		}
		
	}
}

public class BOJ1946 {

	public static int T;
	public static int N;
	public static ArrayList<Integer> resultArr = new ArrayList<Integer>();
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) 
		{
			ArrayList<Grade> list = new ArrayList<Grade>();
			N = Integer.parseInt(br.readLine());
			
			for (int j = 0; j < N; j++) 
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				int scoreA = Integer.parseInt(st.nextToken());
				int scoreB = Integer.parseInt(st.nextToken());
				
				list.add(new Grade(scoreA, scoreB));
			}
			
			Collections.sort(list);
			
			int result = 1;
			int temp = list.get(0).getB();
			for (int j = 1; j < list.size(); j++) 
			{
				if(list.get(j).getB() < temp)
				{
					temp = list.get(j).getB();
					result++;
				}
			}
		
			System.out.println(result);
		}
		
	}

}
