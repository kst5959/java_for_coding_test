package PART02;

import java.util.*;

public class Chapter16_36 {

	public static String A;
	public static String B;
	
	public static int[][] dp;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		A = sc.nextLine();
		B = sc.nextLine();
		
		//���� �Ÿ� : ���ڿ� A�� ���ڿ� B�� �ٲٱ� ���ؼ� �ּ� �� ���� ������ ���ľ� �ϴ°�?
		//���� ������ 3������ �ִ�
		//1. ���� 
		//2. ����
		//3. ��ü A�� ���� �ϳ��� B�� ���� �ϳ��� ��ü
		
		//�ε����� 1���� �����ϱ� ���� ũ�⸦ �� ĭ �÷��־� �տ� null������ �����
		dp = new int[A.length() + 1][B.length() + 1];
		//DP���̺� ä��� : DP���̺��� �����ڸ��� �⺻������ ���ڿ��� ���̴�� ���� ������ ���ʷ� �켱 ä���ش�
		dp[0][0] = 0;
		for (int i = 1; i < A.length()+1; i++) 
		{
			dp[i][0] = i;
		}
		for (int i = 0; i < B.length()+1; i++) 
		{
			dp[0][i] = i;
		}
		
		
		//DP���̺��� ����� �������� ��ȭ���� ����� dp[i][j] = Math.min(����, ����, ��ü) + 1 �� �ǰڴ�
		//���� : dp[i][j-1]
		//���� : dp[i-1][j]
		//��ü : dp[i-1][i-1]
		//DP���̺�� ���� �� ����, ����, ������ �� �ǰڴ�.
		
		//�ε��� 1���� ����
		for (int i = 1; i < A.length()+1; i++) 
		{
			for (int j = 1; j < B.length()+1; j++) 
			{
				//�� ���ڿ��� ���ڰ� ���� ���
				if(A.substring(i-1, i).equals(B.substring(j-1, j)))
				{
					//������ ���� ������ ���� �����Ÿ� ���� �״�� �����´�
					dp[i][j] = dp[i-1][j-1];
				}
				//�ٸ� ���
				else
				{					
					int insert = dp[i][j-1];
					int delete = dp[i-1][j];
					int replace = dp[i-1][j-1];
					
					dp[i][j] = Math.min(insert, Math.min(delete, replace)) + 1;
				}
			}
		}
	
		//dp���̺��� ���� ������ �ε����� ���� �����Ÿ�
		System.out.println(dp[A.length()][B.length()]);
	}

}
