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
			//mid�� target�̶�� �����ϰ� ����Ž��
			int mid = (start + end) /2;
			
			//ã�� ��� �߰��� �ε��� ��ȯ
			if(arr[mid] == mid)
			{
				return mid;
			}
			//�߰����� ������ ã���� �ϴ� ���� ���� ��� ���� Ȯ��
			else if(arr[mid] > mid)
			{
				end = mid - 1;
			}
			//�߰����� ������ ã���� �ϴ� ���� ū ��� ������ Ȯ��
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
