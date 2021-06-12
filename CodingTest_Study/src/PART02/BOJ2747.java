package PART02;

import java.util.Scanner;

public class BOJ2747 {

	public static int N;
	public static int[] dp;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		dp = new int[N+1];
		dp[0] = 0;
		dp[1] = 1;
		
		for (int i = 2; i <= N; i++) 
		{
			dp[i] = dp[i-1] + dp[i-2];
		}

		System.out.println(dp[N]);
	}

}
