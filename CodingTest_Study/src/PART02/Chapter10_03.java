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
	
	//루트 노드 찾기
	public static int findParent(int x)
	{
		//루트 노드일 경우
		if(x == parent[x])
		{
			return x;
		}
		else
		{
			//그 부모를 반환하여 재귀적으로 계속 찾기
			return findParent(parent[x]);
		}
	}
	
	public static void unionParent(int cost, int a, int b)
	{
		//각 노드의 루트 찾기
		a = findParent(a);
		b = findParent(b);
		
		//두 노드의 부모가 같은 경우 : 싸이클이 발생하는 경우
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
		
		//자기 자신을 부모로 초기화
		for (int i = 1; i <= N; i++) 
		{
			parent[i] = i;
		}
		
		//그래프 입력
		for (int i = 0; i < M; i++) 
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			int distance = sc.nextInt();

			graph.add(new Edge(distance, a, b));
		}
		
		//최소비용 신장트리를 위해 그래프 정렬
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
