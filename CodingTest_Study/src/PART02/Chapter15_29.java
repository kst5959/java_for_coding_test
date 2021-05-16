package PART02;

import java.util.*;

public class Chapter15_29 {

	public static int N;
	public static int C;
	public static int[] arr;
	public static int result = 0;
	
	public static void binarySearch(int[] arr, int start, int end)
	{
		int distance = 0;
		
		while(start <= end)
		{
			int mid = (start + end) /2;
			//첫 번째 집에는 무조건 공유기를 설치한다고 가정 (시작점)
			int value = arr[0];
			int count = 1;	
			
			//거리를 기준으로 공유기 설치
			for (int i = 1; i < N; i++) 
			{
				distance = arr[i] - value;
				//거리가 중간값 보다 크거나 같으면
				if(distance >= mid)
				{
					//시작점 갱신
					value = arr[i];
					count++;
				}
			}
			
			//C개 이상의 공유기를 설치 할 수 있는 경우, 거리 증가
			if(count >= C)
			{
				start = mid + 1;
				result = mid;
			}
			//없는 경우 거리 감소
			else
			{
				end = mid - 1;
			}
			
		}
		
		System.out.println(result);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		C = sc.nextInt();
		
		arr = new int[N];
		for (int i = 0; i < N; i++) 
		{
			arr[i] = sc.nextInt();
		}
		
		Arrays.parallelSort(arr);
		
		//가장 인접한 두 공유기 사이의 거리 : arr[0] ~ arr[arr.length-1];
		//가장 인접한 두 공유기 사이의 거리 : 최소값
		int start = 1;
		//가장 인접한 두 공유기 사이의 거리 : 최대값
		int end = arr[N-1] - arr[0];

		binarySearch(arr, start, end);
	}

}
