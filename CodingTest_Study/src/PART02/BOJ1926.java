package PART02;

import java.util.*;

class DrawNode
{
	private int x;
	private int y;
	private int draw;
	
	public DrawNode(int x, int y, int draw)
	{
		this.x = x;
		this.y = y;
		this.draw = draw;
	}
	
	public int getX()
	{
		return this.x;
	}
	
	public int getY()
	{
		return this.y;
	}
	
	public int getDraw()
	{
		return this.draw;
	}
	
}

public class BOJ1926 {

	public static int N;
	public static int M;
	public static int[][] graph = new int[501][501];
	public static boolean[][] isVisited = new boolean[501][501];
	public static int big = 0;
	public static int count = 0;
	
	public static int[] dx = {-1,0,1,0};
	public static int[] dy = {0,1,0,-1};
	
	public static void bfs(int startX, int startY)
	{
		Queue<DrawNode> q = new LinkedList<DrawNode>();
		q.offer(new DrawNode(startX, startY, graph[startX][startY]));
		isVisited[startX][startY] = true;
		int tempBig = 0;
		while(!q.isEmpty())
		{
			DrawNode drawNode = q.poll();
			int x = drawNode.getX();
			int y = drawNode.getY();
			int draw = drawNode.getDraw();
			tempBig++;
			
			for (int i = 0; i < 4; i++) 
			{
				int nextX = x + dx[i];
				int nextY = y + dy[i];
				
				if(nextX <= N && nextX > 0 && nextY <= M && nextY > 0) 
				{
					if(isVisited[nextX][nextY] == false && draw == graph[nextX][nextY])
					{
						isVisited[nextX][nextY] = true;
						q.offer(new DrawNode(nextX, nextY, draw));
					}
				}	
			}
		}
		
		if(graph[startX][startY] == 1)
		{
			big = Math.max(big, tempBig);			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		for (int i = 1; i <= N; i++) 
		{
			for (int j = 1; j <= M; j++) 
			{
				graph[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 1; i <= N; i++) 
		{
			for (int j = 1; j <= M; j++) 
			{
				isVisited[i][j] = false;
			}
		}
		
		for (int i = 1; i <= N; i++) 
		{
			for (int j = 1; j <= M; j++) 
			{
				if(isVisited[i][j] == false)
				{
					bfs(i,j);
					if(graph[i][j] == 1)
					{
						count++;						
					}
				}
			}
		}
		
		System.out.println(count);
		System.out.println(big);
		
	}

}
