package PART02;

import java.util.*;

public class Chapter16_34 {

	public static int N;
	public static int[] arr;
	public static int[] dp;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		int[] arr_reverse = new int[N]; 
		dp = new int[N];
		
		for (int i = 0; i < N; i++) 
		{			
			arr[i] = sc.nextInt();
		}
		
		Arrays.fill(dp, 1);
		
		//LIS : ���� ���� �κ� ���� (�� ���������� ������������ �����ϱ⿡ �����ؼ� Ǯ����Ѵ�)
		int cnt = arr.length-1;
		for (int i = 0; i < arr.length; i++) 
		{
			arr_reverse[i] = arr[cnt];
			cnt--;
		}
		
		for (int i = 0; i < N; i++) 
		{
			//i�� ° ���� ���� �������� ���� ���簡 �ִ��� i-1��° ���� ���� üũ
			for (int j = 0; j < i; j++) 
			{
				//i�� ° ���纸�� j�� ° ������ �������� ���� ��� ���������� ���
				if(arr_reverse[i] > arr_reverse[j])
				{
					//���� ����� dp[i]�� ���� ���� �񱳵Ǵ� ���������Ǵ� dp[j]�� ������ 1���� �� �� ���Ͽ� ū ���� ����
					dp[i] = Math.max(dp[i], dp[j] + 1);
					
				}
			}
		}
		
		Arrays.parallelSort(dp);
		System.out.println(N - dp[dp.length-1]);
		
	}

}
