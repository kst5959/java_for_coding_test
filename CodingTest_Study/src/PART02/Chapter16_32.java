package PART02;

import java.util.*;

public class Chapter16_32 {
	
	public static int n;
	public static int[][] arr = new int[500][500];
	public static int[][] dp = new int[500][500];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		for (int i = 0; i < n; i++) 
		{
			for (int j = 0; j < i + 1; j++) 
			{
				dp[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < n; i++) 
		{
			for (int j = 0; j < i + 1; j++) 
			{
				//제일 왼쪽에 있는 경우 왼쪽 위의 값이 없으니까 체크
				int leftUp;
				if(j == 0)
				{
					leftUp = 0;
				}
				else
				{
					leftUp = dp[i-1][j-1];
				}
				
				int up;
				//각 삼각형 행 라인의 마지막 부분은 바로 위에 값이 없으니까 체크
				if(j == i)
				{
					up = 0;
				}
				else
				{
					up = dp[i-1][j];
				}
				
				dp[i][j] = dp[i][j] + Math.max(leftUp, up);
				
			}
			
		}
		int result = 0;
		for (int j = 0; j < n; j++) 
		{
			result = Math.max(dp[n-1][j], result);
		}
		
		System.out.println(result);
		
	}

}
