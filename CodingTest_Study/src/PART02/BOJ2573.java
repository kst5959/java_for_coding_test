package PART02;

import java.util.*;

class Iceberg
{
	private int x;
	private int y;
	
	public Iceberg(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public int getX()
	{
		return this.x;
	}
	
	public int getY()
	{
		return this.y;
	}
	
}

public class BOJ2573 {

	public static int N;
	public static int M;
	
	public static int[][] graph = new int[301][301];
	public static int[][] graph_melt = new int[301][301];
	
	public static boolean[][] isVisited = new boolean[301][301];
	public static boolean[][] isVisited2 = new boolean[301][301];
	
	public static int[] dx = {-1, 0, 1 , 0};
	public static int[] dy = {0, 1, 0, -1};
	
	public static int count = 0;
	public static int result = 0;
	public static int iceberg_count = 0;
	
	
	public static void initialize()
	{
		for (int i = 0; i < N; i++) 
		{
			for (int j = 0; j < M; j++) 
			{
				isVisited[i][j] = false;
				isVisited2[i][j] = false;
				graph_melt[i][j] = 0;
			}
		}
	}
	
	public static void melt()
	{
		for (int i = 0; i < N; i++) 
		{
			for (int j = 0; j < M; j++) 
			{
				if(graph[i][j] > 0)
				{
					graph[i][j] = graph[i][j] - graph_melt[i][j];
					if(graph[i][j] <= 0)
					{
						graph[i][j] = 0;
						iceberg_count--;
					}
				}
			}
		}
	}
	
	public static void dfs(int startX, int startY)
	{
		isVisited[startX][startY] = true;
		
		for (int i = 0; i < 4; i++) 
		{
			int nextX = startX + dx[i];
			int nextY = startY + dy[i];
			
			if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < M)
			{
				if(isVisited[nextX][nextY] == false && graph[nextX][nextY] > 0)
				{
					dfs(nextX, nextY);
				}
			}
		}
	}
	
	public static void bfs(int startX, int startY)
	{
		Queue<Iceberg> q = new LinkedList<Iceberg>();
		q.offer(new Iceberg(startX, startY));
		isVisited2[startX][startY] = true;
		
		while(!q.isEmpty())
		{
			Iceberg iceberg = q.poll();
			int x = iceberg.getX();
			int y = iceberg.getY();
			
			for (int i = 0; i < 4; i++) 
			{
				int nextX = x + dx[i];
				int nextY = y + dy[i];
				
				if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < M)
				{
					if(graph[nextX][nextY] <= 0)
					{
						graph_melt[x][y]++;
					}
					
					else if(graph[nextX][nextY] > 0 && isVisited2[nextX][nextY] == false)
					{
						isVisited2[nextX][nextY] = true;
						q.offer(new Iceberg(nextX, nextY));
					}
				}
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		for (int i = 0; i < N; i++) 
		{
			for (int j = 0; j < M; j++) 
			{
				graph[i][j] = sc.nextInt();
				if(graph[i][j] > 0)
				{
					iceberg_count++;
				}
			}
		}
		
		while(true)
		{
			initialize();
			count = 0;
			
			for (int i = 0; i < N; i++) 
			{
				for (int j = 0; j < M; j++) 
				{
					if(isVisited[i][j] == false && graph[i][j] > 0)
					{
						dfs(i,j);
						count++;
					}
				}
			}
			
			if(count > 1)
			{
				System.out.println(result);
				break;
			}
			if(iceberg_count == 0)
			{
				System.out.println("0");
				break;
			}
			
			for (int i = 0; i < N; i++) 
			{
				for (int j = 0; j < M; j++) 
				{
					if(isVisited2[i][j] == false && graph[i][j] > 0)
					{
						bfs(i,j);
					}
				}
			}
			
			melt();
			result++;
		}
		
		
	}

}
