package PART02;

import java.util.*;

public class Chapter15_28 {

	public static int N;
	public static int[] arr;
	
	
	//target ���� ��Ȯ�� �־����� ���� ��� �迭�� mid ��(arr[mid])�� target���� �����Ͽ� ���� Ž���� �����Ѵ�
	public static int binarySearch(int[] arr, int FixedPoint ,int start, int end)
	{
		while(start < end)
		{
			int mid = (start + end) /2;
			
			//�������ΰ�� : �������� �� �ε��� ���� ��ġ�ϴ� ���
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
