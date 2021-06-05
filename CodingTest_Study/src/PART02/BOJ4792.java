package PART02;

import java.util.*;

class Edges implements Comparable<Edges>
{
	private int color;
	private int a;
	private int b;
	
	public Edges(int color, int a, int b)
	{
		this.color = color;
		this.a = a;
		this.b = b;
	}
	
	public int getColor()
	{
		return this.color;
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
	public int compareTo(Edges o2) {
		// TODO Auto-generated method stub
		return this.color - o2.getColor();
	}
}



public class BOJ4792 {
	
	public static int V;
	public static int E;
	public static int K;
	
	public static int[] parent = new int[1001];
	
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
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		while(true)
		{
			V = sc.nextInt();
			E = sc.nextInt();
			K = sc.nextInt();
			
			if(V == 0 && E == 0 && K == 0)
			{
				break;
			}
			
			ArrayList<Edges> graph = new ArrayList<Edges>();
			
			for (int i = 1; i <= V; i++) 
			{
				parent[i] = i;
			}
			
			for (int i = 0; i < E; i++) 
			{
				String color = sc.next();
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				if(color.equals("B"))
				{
					graph.add(new Edges(0,a,b));
				}
				else
				{
					graph.add(new Edges(1,a,b));
				}
			}
			
			Collections.sort(graph);
			
			//MAX BLUE COUNT
			int Max = 0;
			for (int i = 0; i < graph.size(); i++) 
			{
				int color = graph.get(i).getColor();
				int a = graph.get(i).getA();
				int b = graph.get(i).getB();
				
				if(findParent(a) != findParent(b))
				{
					if(color == 0)
					{
						Max++;						
					}
					unionParent(a, b);
				}
			}
			
			//최소 사용 횟수를 구하기 위해 배열 뒤집기
			Collections.reverse(graph);
			
			//부모 배열 초기화
			for (int i = 1; i <= V; i++) 
			{
				parent[i] = i;
			}
			
			//MIN BLUE COUNT
			int Min = 0;
			for (int i = 0; i < graph.size(); i++) 
			{
				int color = graph.get(i).getColor();
				int a = graph.get(i).getA();
				int b = graph.get(i).getB();
				
				if(findParent(a) != findParent(b))
				{
					if(color == 0)
					{
						Min++;						
					}
					unionParent(a, b);
				}
			}
			
			if(Max >= K && K >= Min)
			{
				result.add(1);
			}
			else
			{
				result.add(0);
			}
			
		}
		
		for (int i = 0; i < result.size(); i++) 
		{
			System.out.println(result.get(i));
		}

	}

}
