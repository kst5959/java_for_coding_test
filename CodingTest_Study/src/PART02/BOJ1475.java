package PART02;

import java.util.*;

public class BOJ1475 {

	public static int N;
	
	public static int[] card = new int[9];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		if(N == 0)
		{
			System.out.println(1);
			return;
		}
		
		while(N != 0)
		{
			int x = N % 10;
			
			if(x == 6 || x == 9)
			{
				card[6]++;
			}
			else
			{
				card[x]++;
			}
			
			N = N / 10;
		}
			
		int result1 = 0;
		for (int i = 0; i < card.length; i++) 
		{
			if(i != 6)
			{
				result1 = Math.max(result1, card[i]);
			}
			
		}
		
		int result2 = 0;
		if(card[6] % 2 == 0)
		{
			result2 = (card[6] / 2);
		}
		else
		{
			result2 = (card[6] / 2) + 1;
		}
		
		System.out.println(Math.max(result1, result2));
	}

}
