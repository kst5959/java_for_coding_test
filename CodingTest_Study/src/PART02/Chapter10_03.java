package PART02;

import java.util.*;

class Edge implements Comparable<Edge>
{
	private int distance;
	private int a;
	private int b;
	
	public Edge(int distance, int a, int b)
	{
		this.distance = distance;
		this.a = a;
		this.b = b;
	}
	
	public int getDistance()
	{
		return this.distance;
	}
	
	public int getA()
	{
		return this.a;
	}
	
	public int getB()
	{
		return this.b;
	}
	
	@Override
	public int compareTo(Edge o2) {
		// TODO Auto-generated method stub
		if(this.distance < o2.getDistance())
		{
			return -1;
		}
		
		return 1;
	}
	
}

public class Chapter10_03 {

	public static int N;
	public static int M;
	
	public static int[] parent = new int[100001];
	public static ArrayList<Edge> graph = new ArrayList<Edge>();
	public static int max_cost = 0;
	public static int result = 0;
	
	//��Ʈ ��� ã��
	public static int findParent(int x)
	{
		//��Ʈ ����� ���
		if(x == parent[x])
		{
			return x;
		}
		else
		{
			//�� �θ� ��ȯ�Ͽ� ��������� ��� ã��
			return findParent(parent[x]);
		}
	}
	
	public static void unionParent(int cost, int a, int b)
	{
		//�� ����� ��Ʈ ã��
		a = findParent(a);
		b = findParent(b);
		
		//�� ����� �θ� ���� ��� : ����Ŭ�� �߻��ϴ� ���
		if(a == b)
		{
			return;
		}
		else
		{
			if(a < b)
			{
				parent[b] = a;
			}
			else
			{
				parent[a] = b;
			}
			
			result = result + cost;
			max_cost = cost;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		//�ڱ� �ڽ��� �θ�� �ʱ�ȭ
		for (int i = 1; i <= N; i++) 
		{
			parent[i] = i;
		}
		
		//�׷��� �Է�
		for (int i = 0; i < M; i++) 
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			int distance = sc.nextInt();

			graph.add(new Edge(distance, a, b));
		}
		
		//�ּҺ�� ����Ʈ���� ���� �׷��� ����
		Collections.sort(graph);
		
		for (int i = 0; i < graph.size(); i++) 
		{
			int cost = graph.get(i).getDistance();
			int a = graph.get(i).getA();
			int b = graph.get(i).getB();
			
			unionParent(cost, a, b);
		}
		
		result = result - max_cost;
		System.out.println(result);
	}

}
