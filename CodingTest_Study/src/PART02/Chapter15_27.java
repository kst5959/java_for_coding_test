package PART02;

import java.util.*;

public class Chapter15_27 {
	
	//이진 탐색시 중간점을 기준으로하여 중간점(mid)이 왼쪽으로 이동하는 경우
	public static int left(int[] arr, int target, int start, int end)
	{
		while(start < end)
		{
			int mid = (start + end) /2;
			//arr[mid](중간 값이) target 값 보다 크거나 같은 경우 (배열에서 같거나 뒤에 있는 경우)
			if(arr[mid] >= target)
			{
				//mid 값 뒤의 배열에는 target 값이 없으므로 end(배열의 크기)값을 mid 값 만큼 조정한다
				end = mid;
			}
			else
			{
				//mid 값이 target 보다 작으므로 start 값을 조정
				start = mid + 1;
			}
		}
		
		System.out.println(end);
		return end;
	}
	
	//이진 탐색시 중간점을 기준으로하여 중간점(mid)이 오른쪽으로 이동하는 경우
	public static int right(int[] arr, int target, int start, int end)
	{
		while(start < end)
		{
			int mid = (start + end) /2 ;
			if(arr[mid] > target)
			{
				end = mid;
			}
			else
			{
				start = mid + 1;
			}
		}
		
		System.out.println(end);
		return end;
	}
	
	//countBy 함수는 target에 해당하는 갯수를 구할 때 주로 쓴다
	//각 left, right는 end 값을 배열의 크기로 한다 (end 값의 크기에 따라 -> end 값이 갯수가 됨)
	public static int countByValue(int[] arr, int target, int start, int end)
	{
		int leftCount = left(arr, target, start, end);
		int rightCount = right(arr, target, start, end);
		
		return (rightCount - leftCount);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) 
		{
			arr[i] = sc.nextInt();
		}
		Arrays.parallelSort(arr);
		
		int answer = countByValue(arr, x, 0, arr.length);
		
		if(answer == 0)
		{
			System.out.println(-1);
		}
		else
		{
			System.out.println(answer);
		}
		
	}

}
