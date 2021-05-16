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
			//ù ��° ������ ������ �����⸦ ��ġ�Ѵٰ� ���� (������)
			int value = arr[0];
			int count = 1;	
			
			//�Ÿ��� �������� ������ ��ġ
			for (int i = 1; i < N; i++) 
			{
				distance = arr[i] - value;
				//�Ÿ��� �߰��� ���� ũ�ų� ������
				if(distance >= mid)
				{
					//������ ����
					value = arr[i];
					count++;
				}
			}
			
			//C�� �̻��� �����⸦ ��ġ �� �� �ִ� ���, �Ÿ� ����
			if(count >= C)
			{
				start = mid + 1;
				result = mid;
			}
			//���� ��� �Ÿ� ����
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
		
		//���� ������ �� ������ ������ �Ÿ� : arr[0] ~ arr[arr.length-1];
		//���� ������ �� ������ ������ �Ÿ� : �ּҰ�
		int start = 1;
		//���� ������ �� ������ ������ �Ÿ� : �ִ밪
		int end = arr[N-1] - arr[0];

		binarySearch(arr, start, end);
	}

}
