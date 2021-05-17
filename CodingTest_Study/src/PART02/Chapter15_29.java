package PART02;

import java.util.*;

public class Chapter15_29 {

	public static int N;
	public static int C;
	
	//파라메트릭 서치 : 어떠한 조건을 만족하는 가장 알맞은 값을 찾는 문제에 쓰이는 탐색법
	//target 값이 주어지지 않는 문제는 mid값을 target으로 보면서 탐색
	public static void binarySearch(int[] arr, int start, int end)
	{
		int answer = 0;
		int distance = 0;
		
		//파라메트릭 서치
		while(start <= end)
		{
			//mid는 가장 인접한 두 공유기 사이의 거리 : distance의 기준이 되는 값 
			int mid = (start + end) /2;
			//처음 집 부터 설치한다고 가정
			int value = arr[0];
			int count = 1;
				
			for (int i = 1; i < arr.length; i++) 
			{
				//공유기를 설치 했을 때 두 집 사이의 거리 확인
				distance = arr[i] - value;
				
				//거리가 중간값 보다 크거나 같을 경우
				if(distance >= mid)
				{
					//인접한 두 집의 거리가 중간값(기준값) 보다 크면 공유기 설치, 다음 두 집 사이의 거리를 체크 하기 위해 value값 조정
					count++;
					value = arr[i];
				}
			}
			
			//설치할 공유기의 최소 개수 C 이상의 공유기를 설치할 수 있는 경우 -> 기준값(mid) 값을 늘리기 위해 거리를 넓힌다.
			if(count >= C)
			{
				//시작 지점을 늘림으로써, 더 먼 거리에 있는 집에다가 공유기를 설치할 수 있도록 한다
				start = mid + 1;
				//현재의 최적의 값 저장
				answer = mid;
			}
			//설치할 공유기의 최소 개수 C 보다 설치한 공유기의 개수가 작은 경우 -> 최소 개수 보다 덜 설치한 경우 -> 기준값 (mid)을 줄여서 (거리를 좁혀서) 탐색 
			else
			{
				//끝 지점을 줄여서 전체 거리를 좁힘
				end = mid - 1;
			}
			
		}
		
		System.out.println(answer);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		C = sc.nextInt();
		
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) 
		{
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		//거리에 따른 이진 탐색 문제임에 따라 start와 end 값을 구함
		//start(최소 거리) 1 , end(최대 거리) : arr의 최대값  - 최소값
		binarySearch(arr, 1, (arr[arr.length-1] - arr[0]));
		
	}

}
