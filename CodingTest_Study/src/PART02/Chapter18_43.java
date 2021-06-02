package PART02;

import java.util.*;

class Edge implements Comparable<Edge>
{
	private int distance;
	private int A;
	private int B;
	
	public Edge(int distance, int A, int B)
	{
		this.distance = distance;
		this.A = A;
		this.B = B;
	}
	
	public int getDistance()
	{
		return this.distance;
	}
	
	public int getA()
	{
		return this.A;
	}
	
	public int getB()
	{
		return this.B;
	}
	
	@Override
	public int compareTo(Edge o2) {
		// TODO Auto-generated method stub
		if(this.distance < o2.getDistance())
		{
			return -1;
		}
		else if(this.distance > o2.getDistance())
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
	
}

public class Chapter18_43 {

	public static int V;
	public static int E;
	
	public static int[] parent = new int[200001];
	
	public static ArrayList<Edge> graph = new ArrayList<Edge>();
	public static int result = 0;
	
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
		
		for (int i = 0; i < E; i++) 
		{
			int A = sc.nextInt();
			int B = sc.nextInt();
			int distance = sc.nextInt();
			
			graph.add(new Edge(distance, A, B));
		}
		
		Collections.sort(graph);
		
		int total = 0;
		for (int i = 0; i < graph.size(); i++) 
		{
			int distance = graph.get(i).getDistance();
			int A = graph.get(i).getA();
			int B = graph.get(i).getB();

			
			if(findParent(A) != findParent(B))
			{
				unionParent(A, B);
				result = result + distance;
			}
			
			total = total + distance;
			
		}
		
		System.out.println(total - result);
	}

}
