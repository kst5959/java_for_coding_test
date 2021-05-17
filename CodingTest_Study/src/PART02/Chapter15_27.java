package PART02;

import java.util.*;

public class Chapter15_27 {
	
	//���� Ž���� �߰����� ���������Ͽ� �߰���(mid)�� �������� �̵��ϴ� ���
	public static int left(int[] arr, int target, int start, int end)
	{
		while(start < end)
		{
			int mid = (start + end) /2;
			//arr[mid](�߰� ����) target �� ���� ũ�ų� ���� ��� (�迭���� ���ų� �ڿ� �ִ� ���)
			if(arr[mid] >= target)
			{
				//mid �� ���� �迭���� target ���� �����Ƿ� end(�迭�� ũ��)���� mid �� ��ŭ �����Ѵ�
				end = mid;
			}
			else
			{
				//mid ���� target ���� �����Ƿ� start ���� ����
				start = mid + 1;
			}
		}
		
		System.out.println(end);
		return end;
	}
	
	//���� Ž���� �߰����� ���������Ͽ� �߰���(mid)�� ���������� �̵��ϴ� ���
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
	
	//countBy �Լ��� target�� �ش��ϴ� ������ ���� �� �ַ� ����
	//�� left, right�� end ���� �迭�� ũ��� �Ѵ� (end ���� ũ�⿡ ���� -> end ���� ������ ��)
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
