package PART02;

import java.util.*;

public class BOJ1744 {

	public static int N;
	public static ArrayList<Integer> plus_list = new ArrayList<Integer>();
	public static ArrayList<Integer> minus_list = new ArrayList<Integer>();
	public static int zero = 0;
	public static int one = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
	
		for (int i = 0; i < N; i++) 
		{
			int x = sc.nextInt();
			if(x == 1)
			{
				one++;
			}
			else if(x > 0)
			{
				plus_list.add(x);
			}
			else if(x < 0)
			{
				minus_list.add(x);
			}
			else
			{
				zero++;
			}
		}
		
		Collections.sort(plus_list);
		Collections.reverse(plus_list);
		Collections.sort(minus_list);
		
		int result = 0;
		
		if(plus_list.size() % 2 == 1)
		{
			plus_list.add(1);
		}
			
		if(minus_list.size() % 2 == 1)
		{
			if(zero > 0)
			{
				minus_list.add(0);
			}
			else
			{
				minus_list.add(1);
			}
		}
		
		
		result = one;
		
		for (int i = 0; i < plus_list.size(); i++) 
		{
			result = result + plus_list.get(i) * plus_list.get(i + 1);
			i = i + 1;
		}
		
		for (int i = 0; i < minus_list.size(); i++) 
		{
			result = result + minus_list.get(i) * minus_list.get(i + 1);
			i = i + 1;
		}
		
		System.out.println(result);
		
	}

}
