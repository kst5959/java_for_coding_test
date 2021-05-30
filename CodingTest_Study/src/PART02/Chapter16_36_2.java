package PART02;

import java.util.*;

public class Chapter16_36_2 {

	public static String A;
	public static String B;
	
	public static int[][] dp;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		A = sc.nextLine();
		B = sc.nextLine();
		
		dp = new int[A.length() + 1][B.length() + 1];
		dp[0][0] = 0;
		
		for (int i = 1; i < A.length()+1; i++) 
		{
			dp[i][0] = i;
		}
		
		for (int i = 1; i < B.length()+1; i++) 
		{
			dp[0][i] = i;
		}
	
		
		for (int i = 1; i < A.length()+1; i++) 
		{
			for (int j = 1; j < B.length()+1; j++) 
			{
				if(A.substring(i-1,i).equals(B.substring(j-1, j)))
				{
					dp[i][j] = dp[i-1][j-1];
				}
				else
				{
					int insert = dp[i][j-1];
					int delete = dp[i-1][j];
					int replace = dp[i-1][j-1];
					
					dp[i][j] = Math.min(insert, Math.min(delete, replace)) + 1;
				}
			}
		}
		
		System.out.println(dp[A.length()][B.length()]);
		
	}

}
