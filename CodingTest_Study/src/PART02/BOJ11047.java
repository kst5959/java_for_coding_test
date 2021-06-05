package PART02;

import java.util.*;

public class BOJ11047 {

	public static int N;
	public static int K;
	
	public static int[] coins;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		
		coins = new int[N];
		
		for (int i = coins.length-1; i >= 0; i--) 
		{
			coins[i] = sc.nextInt();
		}
		
		int coinIndex = 0;
		int count = 0;
		while(K > 1)
		{
			if(K >= coins[coinIndex])
			{
				int temp = (K / coins[coinIndex]);
				count = count + temp;
				K = K % coins[coinIndex];
			}
			else
			{
				coinIndex++;
			}
		}
		
		if(K == 1)
		{
			System.out.println(count + 1);
		}
		else
		{			
			System.out.println(count);
		}
		
	}

}
