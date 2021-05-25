package PART02;

import java.util.*;

public class Chapter16_33 {

	public static int N = 0;
	public static int[] pay = new int[1000];
	public static int[] time;
	public static int[] dp;
	public static int max_value = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		pay = new int[N+1];
		time = new int[N+1];
		dp = new int[N+1];
		
		for (int i = 0; i < N; i++) 
		{
			int t = sc.nextInt();
			int p = sc.nextInt();
			time[i] = t;                              
			pay[i] = p;
		}
		
		//점화식 dp[i] = max(dp[time[i] + i]] , max_value)
		
		Arrays.fill(dp, max_value);
		
		int currentTime = 0;
		for (int i = N-1; i > -1; i--) 
		{
			currentTime = time[i] + i;
			
			//N+1일 전에 상담이 끝나는 경우
			if(currentTime < N+1)
			{
				dp[i] = Math.max(pay[i] + dp[currentTime], max_value);
				max_value = dp[i];
			}
			//상담 기간을 벗어나는 경우
			else
			{
				dp[i] = max_value;
			}
		}
		
		System.out.println(max_value);
		
	}

}
