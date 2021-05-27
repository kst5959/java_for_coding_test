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
		
		//LIS : 최장 증가 부분 수열 (본 문제에서는 내림차순으로 정렬하기에 변형해서 풀어야한다)
		int cnt = arr.length-1;
		for (int i = 0; i < arr.length; i++) 
		{
			arr_reverse[i] = arr[cnt];
			cnt--;
		}
		
		for (int i = 0; i < N; i++) 
		{
			//i번 째 병사 보다 전투력이 낮은 병사가 있는지 i-1번째 병사 까지 체크
			for (int j = 0; j < i; j++) 
			{
				//i번 째 병사보다 j번 째 병사의 전투력이 낮을 경우 내림차순일 경우
				if(arr_reverse[i] > arr_reverse[j])
				{
					//현재 저장된 dp[i]의 값과 현재 비교되는 내림차순되는 dp[j]의 값에서 1더한 것 을 비교하여 큰 값을 넣음
					dp[i] = Math.max(dp[i], dp[j] + 1);
					
				}
			}
		}
		
		Arrays.parallelSort(dp);
		System.out.println(N - dp[dp.length-1]);
		
	}

}
