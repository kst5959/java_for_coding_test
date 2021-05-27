package PART02;

import java.util.*;

public class Chapter16_35 {

	public static int N;
	public static int[] dp = new int[1000];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		dp[0] = 1;

		int index2 = 0;
		int index3 = 0;
		int index5 = 0;
		
		int ugly2 = 2;
		int ugly3 = 3;
		int ugly5 = 5;
		
		
		for (int i = 1; i < N; i++) 
		{
			dp[i] = Math.min(ugly2, Math.min(ugly3, ugly5));
			
			if(dp[i] == ugly2)
			{
				index2++;
				ugly2 = dp[index2] * 2;
			}
			
			if(dp[i] == ugly3)
			{
				index3++;
				ugly3 = dp[index3] * 3;
			}
			
			if(dp[i] == ugly5)
			{

				index5++;
				ugly5 = dp[index5] * 5;
			}
			
		}
		
		System.out.println(dp[N-1]);
	}

}
