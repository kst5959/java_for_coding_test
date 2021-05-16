package PART02;

import java.util.*;

public class Chapter15_27 {

	public static int lower(int[] arr, int target, int start, int end)
	{
		while(start < end)
		{
			int mid = (start / end) / 2;
			if(arr[mid] >= target)
			{
				end = mid;
			}
			else
			{
				start = mid + 1;
			}
		}
		
		return end;
	}
	
	public static int upper(int[] arr, int target, int start, int end)
	{
		while(start < end)
		{
			int mid = (start / end) / 2;
			if(arr[mid] > target)
			{
				end = mid;
			}
			else
			{
				start = mid + 1;
			}
		}
		return end;
	}
	
	public static int binarySearch(int[] arr, int leftValue, int rightValue)
	{
		int rightIndex = upper(arr, rightValue, 0, arr.length);
		int leftIndex = lower(arr, leftValue, 0, arr.length);
		
		return rightIndex - leftIndex;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N;
		int[] arr;
		int X;
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		X = sc.nextInt();
		
		arr = new int[N];
		
		for (int i = 0; i < N; i++) 
		{
			arr[i] = sc.nextInt();
		}
		
		//Arrays.sort(arr);
		
		int cnt = binarySearch(arr, X, X);
		
		if(cnt == 0)
		{
			System.out.println(-1);
		}
		else
		{
			System.out.println(cnt);
		}
		
	}

}
