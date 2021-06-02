package PART02;

import java.util.*;

public class Chapter18_41 {

	public static int V;
	public static int E;
	
	public static int[] parent = new int[501];
	public static int[][] map;
	
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
		
		for (int i = 1; i <= V; i++) 
		{
			for (int j = 1; j <= V; j++) 
			{
				int operate = sc.nextInt();
				if(operate == 1)
				{
					unionParent(i, j);
				}
			}
		}
		
		ArrayList<Integer> plan = new ArrayList<Integer>();
		for (int i = 0; i < E; i++) 
		{
			int x = sc.nextInt();
			plan.add(x);
		}
		
		boolean result = false;
		for (int i = 1; i < plan.size(); i++) 
		{
			if(findParent(plan.get(i-1)) == findParent(plan.get(i)))
			{
				result = true;
			}
			else
			{
				result = false;
				break;
			}
		}
		
		
		if(result)
		{
			System.out.println("YES");
		}
		else
		{
			System.out.println("NO");
		}
		
	}

}
