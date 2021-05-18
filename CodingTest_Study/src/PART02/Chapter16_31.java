package PART02;

import java.util.*;

public class Chapter16_31 {

	public static int t;
	public static int n;
	public static int m;
	
	public static int[][] arr = new int[20][20];
	public static int[][] dp = new int[20][20];
	
	public static int[] dx = {-1, 0, 1};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		
		for (int k = 0; k < t; k++) 
		{
			n = sc.nextInt();
			m = sc.nextInt();
			
			for (int i = 0; i < n; i++) 
			{
				for (int j = 0; j < m; j++) 
				{
					arr[i][j] = sc.nextInt();
					dp[i][j] = arr[i][j];
				}
			}
			
			for (int j = 1; j < m; j++) 
			{
				for (int i = 0; i < n; i++) 
				{
					int leftUp = 0; 
					if(i + dx[0] >= 0)
					{
						leftUp = dp[i + dx[0]][j - 1];						
					}
					
					int left = dp[i + dx[1]][j - 1];
					
					int leftDown = 0;
					if(i + dx[2] < n)
					{
						leftDown = dp[i + dx[2]][j - 1];
					}
						
					dp[i][j] = dp[i][j] + Math.max(leftUp, Math.max(left, leftDown));
					
				}
			}
		
			int result = 0;
			for (int i = 0; i < n; i++) 
			{
				//System.out.println(dp[i][m-1]);
				result = Math.max(result, dp[i][m-1]);
			}
			System.out.println(result);
		}
		
	}

}
