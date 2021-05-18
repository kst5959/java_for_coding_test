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
				//���� ���ʿ� �ִ� ��� ���� ���� ���� �����ϱ� üũ
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
				//�� �ﰢ�� �� ������ ������ �κ��� �ٷ� ���� ���� �����ϱ� üũ
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
