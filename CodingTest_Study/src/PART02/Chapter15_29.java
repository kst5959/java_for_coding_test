package PART02;

import java.util.*;

public class Chapter15_29 {

	public static int N;
	public static int C;
	
	//�Ķ��Ʈ�� ��ġ : ��� ������ �����ϴ� ���� �˸��� ���� ã�� ������ ���̴� Ž����
	//target ���� �־����� �ʴ� ������ mid���� target���� ���鼭 Ž��
	public static void binarySearch(int[] arr, int start, int end)
	{
		int answer = 0;
		int distance = 0;
		
		//�Ķ��Ʈ�� ��ġ
		while(start <= end)
		{
			//mid�� ���� ������ �� ������ ������ �Ÿ� : distance�� ������ �Ǵ� �� 
			int mid = (start + end) /2;
			//ó�� �� ���� ��ġ�Ѵٰ� ����
			int value = arr[0];
			int count = 1;
				
			for (int i = 1; i < arr.length; i++) 
			{
				//�����⸦ ��ġ ���� �� �� �� ������ �Ÿ� Ȯ��
				distance = arr[i] - value;
				
				//�Ÿ��� �߰��� ���� ũ�ų� ���� ���
				if(distance >= mid)
				{
					//������ �� ���� �Ÿ��� �߰���(���ذ�) ���� ũ�� ������ ��ġ, ���� �� �� ������ �Ÿ��� üũ �ϱ� ���� value�� ����
					count++;
					value = arr[i];
				}
			}
			
			//��ġ�� �������� �ּ� ���� C �̻��� �����⸦ ��ġ�� �� �ִ� ��� -> ���ذ�(mid) ���� �ø��� ���� �Ÿ��� ������.
			if(count >= C)
			{
				//���� ������ �ø����ν�, �� �� �Ÿ��� �ִ� �����ٰ� �����⸦ ��ġ�� �� �ֵ��� �Ѵ�
				start = mid + 1;
				//������ ������ �� ����
				answer = mid;
			}
			//��ġ�� �������� �ּ� ���� C ���� ��ġ�� �������� ������ ���� ��� -> �ּ� ���� ���� �� ��ġ�� ��� -> ���ذ� (mid)�� �ٿ��� (�Ÿ��� ������) Ž�� 
			else
			{
				//�� ������ �ٿ��� ��ü �Ÿ��� ����
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
		
		//�Ÿ��� ���� ���� Ž�� �����ӿ� ���� start�� end ���� ����
		//start(�ּ� �Ÿ�) 1 , end(�ִ� �Ÿ�) : arr�� �ִ밪  - �ּҰ�
		binarySearch(arr, 1, (arr[arr.length-1] - arr[0]));
		
	}

}
