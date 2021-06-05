package Library;

import java.util.*;

import PART02.Edge;

//크루스칼 알고리즘 노드 클래스
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

public class KruskalAlgorithm {

	//노드와 간선
	public static int V;
	public static int E;
	
	//부모를 담을 배열
	public static int[] parent = new int[1001];
	
	//노드 클래스를 담을 배열
	public static ArrayList<Edge> graph = new ArrayList<Edge>();
	
	//부모 찾기
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
	
	//합치기
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
}
