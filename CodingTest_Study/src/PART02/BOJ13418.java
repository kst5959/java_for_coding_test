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
		return this.distance - o2.getDistance();
	}
}


public class BOJ13418 {

	public static int V;
	public static int E;
	
	public static int[] parent = new int[1001];
	public static ArrayList<Edge> graph = new ArrayList<Edge>();
	
	public static int findParent(int x)
	{
		if(x == parent[x])
		{
			return x;
		}
		else
		{
			return findParent(parent[x]);
		}
	}
	
	public static void unionParent(int a, int b)
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		V = sc.nextInt();
		E = sc.nextInt();
		
		for (int i = 1; i <= V; i++) 
		{
			parent[i] = i;
		}
		
		for (int i = 0; i < E+1; i++) 
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			graph.add(new Edge(c, a, b));
		}
		
		//distance가 0일 경우 오름차순
		Collections.sort(graph);
		
		int max = 0;
		int min = 0;
		
		//최고 비용 신장트리
		int cnt = 0;
		for (int i = 0; i < graph.size(); i++) 
		{
			int distance = graph.get(i).getDistance();
			int a = graph.get(i).getA();
			int b = graph.get(i).getB();
			
			if(findParent(a) != findParent(b))
			{
				unionParent(a,b);
				if(distance == 0)
				{
					cnt++;
				}
			}
		}
		
		max = cnt * cnt;
		
		//parent 초기화
		for (int i = 1; i <= V; i++) 
		{
			parent[i] = i;
		}
		
		//최소 비용 신장트리
		Collections.reverse(graph);
		cnt = 0;
		for (int i = 0; i < graph.size(); i++) 
		{
			int distance = graph.get(i).getDistance();
			int a = graph.get(i).getA();
			int b = graph.get(i).getB();
			
			if(findParent(a) != findParent(b))
			{
				unionParent(a,b);
				if(distance == 0)
				{
					cnt++;
				}
			}
		}
		
		min = cnt * cnt;
		
		System.out.println(max - min);
	}

}
