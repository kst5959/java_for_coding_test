package PART02;

import java.util.*;

public class Chapter10_02 {

	public static int N;
	public static int M;
	
	public static int[] parent = new int[100001];
	
	public static void unionParent(int a , int b)
	{
		a = findParent(a);
		b = findParent(b);
		
		if(a < b)
		{
			parent[b] = a;
		}
		else
		{
			parent[a] = b;
		}
	}
	
	//��Ʈ ��� ã��
	public static int findParent(int x)
	{
		//x�� ��Ʈ ��尡 �ƴ϶�� ��Ʈ ��带 ã�� �� ���� ���
		if(x == parent[x])
		{
			return x;
		}
		else
		{
			return findParent(parent[x]);
		}
	}
	
	public static boolean isTeam(int a, int b)
	{
		a = findParent(a);
		b = findParent(b);
		
		if(a == b)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		//�θ��带 �ڱ� �ڽ����� �ʱ�ȭ
		for (int i = 1; i <= N; i++) 
		{
			parent[i] = i;
		}
		
		//Union ���� ����
		for (int i = 0; i < M; i++) 
		{
			int operate = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			if(operate == 0)
			{
				unionParent(a, b);
			}
			else
			{
				if(isTeam(a, b))
				{
					System.out.println("YES");
				}
				else
				{
					System.out.println("NO");
				}
			}
		}
		
		
	}

}
