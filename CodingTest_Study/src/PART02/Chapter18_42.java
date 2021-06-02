package PART02;

import java.util.*;

public class Chapter18_42 {

	public static int G;
	public static int P;
	
	public static int[] parent = new int[100001];
	
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
		G = sc.nextInt();
		P = sc.nextInt();
		
		for (int i = 1; i <= G; i++) 
		{
			parent[i] = i;
		}
		
		int result = 0;
		for (int i = 0; i < P; i++) 
		{
			int x = sc.nextInt();
			int root = findParent(x);
			if(root == 0)
			{
				break;
			}
			else
			{
				unionParent(root, root-1);
				result++;
			}
		}
		
		
		System.out.println(result);
	}

}
