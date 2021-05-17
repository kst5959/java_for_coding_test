package PART02;

import java.util.*;

public class Chapter15_28 {

	public static int N;
	public static int[] arr;
	
	
	//target 값이 명확히 주어지지 않은 경우 배열의 mid 값(arr[mid])을 target으로 선정하여 이진 탐색을 수행한다
	public static int binarySearch(int[] arr, int FixedPoint ,int start, int end)
	{
		while(start < end)
		{
			int mid = (start + end) /2;
			
			//고정점인경우 : 증간값과 그 인덱스 값이 일치하는 경우
			if(arr[mid] == mid)
			{
				FixedPoint = arr[mid];
				return FixedPoint;
			}
			else if(arr[mid] > mid)
			{
				end = mid;
			}
			else
			{
				start = mid + 1;
			}
			
		}
		
		
		return FixedPoint;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		
		
		for (int i = 0; i < N; i++) 
		{
			arr[i] = sc.nextInt();
		}
		
		int FixedPoint = binarySearch(arr, -1 ,0, N);
		
		System.out.println(FixedPoint);
		
	}

	
	
}
