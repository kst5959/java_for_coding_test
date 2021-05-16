package PART02;

import java.util.*;

public class Chapter15_28 {

	public static int N;
	public static int[] arr;
	public static int FixedPoint = 0;
	
	public static int binarySearch(int[] arr, int start,int end)
	{
		while(start <= end)
		{
			//mid가 target이라고 가정하고 이진탐색
			int mid = (start + end) /2;
			
			//찾은 경우 중간값 인덱스 반환
			if(arr[mid] == mid)
			{
				return mid;
			}
			//중간점의 값보다 찾고자 하는 값이 작은 경우 왼쪽 확인
			else if(arr[mid] > mid)
			{
				end = mid - 1;
			}
			//중간점의 값보다 찾고자 하는 값이 큰 경우 오른쪽 확인
			else
			{
				start = mid + 1;
			}
		}
		
		return -1;
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
		
		FixedPoint = binarySearch(arr, 0, arr.length);
		System.out.println(FixedPoint);
	}

	
	
}
