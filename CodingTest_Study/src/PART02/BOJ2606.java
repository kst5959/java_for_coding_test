package PART02;

import java.util.*;

public class BOJ2606 {

	public static int N;
	public static int P;
	
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	public static boolean[] isInfected = new boolean[101];
	public static int count = 0;
	
	public static void bfs()
	{
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(1);
		isInfected[1] = true;
		
		while (!q.isEmpty()) 
		{
			int currentNode = q.poll();
			
			for (int i = 0; i < graph.get(currentNode).size(); i++) 
			{
				if(isInfected[graph.get(currentNode).get(i)] == false)
				{
					isInfected[graph.get(currentNode).get(i)] = true;
					q.offer(graph.get(currentNode).get(i));
					//System.out.println("°¨¿° : " + graph.get(currentNode).get(i));
					count++;
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		P = sc.nextInt();
		
		for (int i = 0; i <= N; i++) 
		{
			graph.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < P ; i++) 
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		Arrays.fill(isInfected, false);
		
		bfs();
		
		System.out.println(count);
	}

}
