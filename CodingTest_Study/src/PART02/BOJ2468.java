package PART02;

import java.util.*;

class Safe
{
	private int x;
	private int y;
	
	public Safe(int x, int y)
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

public class BOJ2468 {

	public static int N;
	
	public static int[][] graph = new int[101][101];
	public static boolean[][] isVisited = new boolean[101][101];
	
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, 1, 0, -1};
	
	public static int result = 0;
	
	public static void initiallize()
	{
		for (int i = 0; i < N; i++) 
		{
			for (int j = 0; j < N; j++) 
			{
				isVisited[i][j] = false;
			}
		}
	}
	
	public static void bfs(int startX, int startY, int currentValue)
	{
		Queue<Safe> q = new LinkedList<Safe>();
		q.offer(new Safe(startX, startY));
		isVisited[startX][startY] = true;
		
		while(!q.isEmpty())
		{
			Safe safe = q.poll();
			int x = safe.getX();
			int y = safe.getY();
	
			for (int i = 0; i < 4; i++) 
			{
				int nextX = x + dx[i];
				int nextY = y + dy[i];
				
				if(nextX < N && nextX >= 0 && nextY < N && nextY >= 0)
				{
					if(isVisited[nextX][nextY] == false && graph[nextX][nextY] > currentValue)
					{
						q.offer(new Safe(nextX, nextY));
						isVisited[nextX][nextY] = true;
					}
				}
			}
		}

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		int max = 0;
		for (int i = 0; i < N; i++) 
		{
			for (int j = 0; j < N; j++) 
			{
				graph[i][j] = sc.nextInt();
				max = Math.max(max, graph[i][j]);
			}
		}
		
		initiallize();
		
		for (int v = 0; v <= max; v++) 
		{			
			int count = 0;
			for (int i = 0; i < N; i++) 
			{
				for (int j = 0; j < N; j++) 
				{
					if(isVisited[i][j] == false && graph[i][j] > v)
					{
						bfs(i,j,v);
						count++;
					}
				}
			}
			
			result = Math.max(result, count);
			initiallize();
		}
		
		System.out.println(result);			
		
	}

}
