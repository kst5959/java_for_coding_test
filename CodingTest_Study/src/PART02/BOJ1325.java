package PART02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1325 {

	public static int N;
	public static int M;
	
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	public static int[] result;
	public static int max_value = 0;
	

	public static void dfs(int startNode, boolean[] isVisited)
	{
		isVisited[startNode] = true;		
		
		for (int i = 0; i < graph.get(startNode).size(); i++) 
		{
			if(isVisited[graph.get(startNode).get(i)] == false)
			{
				result[graph.get(startNode).get(i)]++;
				dfs(graph.get(startNode).get(i), isVisited);
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		result = new int[N+1];
		
		for (int i = 0; i <= N; i++) 
		{
			graph.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < M; i++) 
		{
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(b);
		}
		
		for (int i = 1; i <= N; i++) 
		{
			boolean[] isVisited = new boolean[N+1];
			dfs(i, isVisited);
		}
		
		for (int i = 1; i <= N; i++) 
		{
			max_value = Math.max(max_value, result[i]);
		}
		
		for (int i = 1; i <= N; i++) 
		{
			if(max_value == result[i])
			{
				System.out.print(i + " ");
			}
		}
		
	}

}
