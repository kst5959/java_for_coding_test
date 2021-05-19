package PART02;

import java.util.*;

public class Chapter16_31 {

	public static int t;
	public static int n;
	public static int m;
	
	public static int[][] arr = new int[20][20];
	public static int[][] dp = new int[20][20];
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		
		//�׽�Ʈ���̽� Ƚ�� ��ŭ ����
		for (int tc = 0; tc < t; tc++) 
		{
			n = sc.nextInt();
			m = sc.nextInt();
			
			//arr �� �Է�
			for (int i = 0; i < n; i++) 
			{
				for (int j = 0; j < m; j++) 
				{					
					arr[i][j] = sc.nextInt();
				}
			}
			
			//dp�迭�� �ű��
			for (int i = 0; i < n; i++) 
			{
				for (int j = 0; j < m; j++) 
				{
					dp[i][j] = arr[i][j];
				}
			}
			
			//���� ó�� �� ���� ���� �� ���� �����ؼ� ���ʿ��� ���� ���� ���ϴ� ������ ����
			for (int j = 1; j < m; j++) 
			{
				for (int i = 0; i < n; i++) 
				{
					//���� ������ ���� ���
					int leftUp = 0;
					//���� ���� ���� �� (0)�� �ƴ� ��쿡�� ���� ���� ���� �����ϱ� ������ üũ�ϸ鼭 ����
					if(i != 0)
					{
						leftUp = dp[i-1][j-1];
					}
					
					//�ٷ� ������ üũ�� �ʿ䰡 ����
					int left = dp[i][j-1];
					
					//���� �Ʒ����� ���� ���
					int leftDown = 0;
					//���� �Ʒ� �� (n-1) ���� ���� �־�� ���� �Ʒ� ���� �����ϱ� ������ üũ
					if(i < n-1)
					{
						leftDown = dp[i+1][j-1];
					}
					
					dp[i][j] = dp[i][j] + Math.max(leftUp, Math.max(left, leftDown)); 
				}
				
			}
			
			int res = 0;
			for (int i = 0; i < n; i++) 
			{
				//ū ���� ã�� ���� ������ �� (m-1)�� ���� ��
				res = Math.max(res, dp[i][m-1]);
			}
			System.out.println(res);
		}
		
		
	}

}
