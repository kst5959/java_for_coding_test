package PART02;

import java.util.*;

class ColorNode 
{
	private int x;
	private int y;
	private int color;
	
	public ColorNode(int x, int y, int color)
	{
		this.x = x;
		this.y = y;
		this.color = color;
	}
	
	public int getX()
	{
		return this.x;
	}
	
	public int getY()
	{
		return this.y;
	}
	
	public int getColor()
	{
		return this.color;
	}
	
}

public class BOJ10026 {

	public static int N;
	public static int[][] graph = new int[101][101];
	public static int[][] graph2 = new int[101][101];
	
	public static boolean[][] isVisited = new boolean[101][101];
	public static int[] result = new int[2];
	
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, 1, 0, -1};
	
	public static void bfs_for_normal(int a, int b)
	{
		Queue<ColorNode> q = new LinkedList<ColorNode>();
		q.offer(new ColorNode(a, b, graph[a][b]));
		isVisited[a][b] = true;
		
		while(!q.isEmpty())
		{
		 	ColorNode colorNode = q.poll();
		 	int x = colorNode.getX();
		 	int y = colorNode.getY();
		 	int color = colorNode.getColor();
		 	
		 	for (int i = 0; i < 4; i++) 
		 	{
				int nextX = x + dx[i];
				int nextY = y + dy[i];
				
				if(nextX <= N && nextX > 0 && nextY <= N && nextY > 0)
				{
					if(graph[nextX][nextY] == color && isVisited[nextX][nextY] == false)
					{
						isVisited[nextX][nextY] = true;
						q.offer(new ColorNode(nextX, nextY, graph[nextX][nextY]));
					}					
				}
			}
		}
	}
	
	public static void bfs_for_special(int a, int b)
	{
		Queue<ColorNode> q = new LinkedList<ColorNode>();
		q.offer(new ColorNode(a, b, graph2[a][b]));
		isVisited[a][b] = true;
		
		while(!q.isEmpty())
		{
		 	ColorNode colorNode = q.poll();
		 	int x = colorNode.getX();
		 	int y = colorNode.getY();
		 	int color = colorNode.getColor();
		 	
		 	for (int i = 0; i < 4; i++) 
		 	{
				int nextX = x + dx[i];
				int nextY = y + dy[i];
				
				if(nextX <= N && nextX > 0 && nextY <= N && nextY > 0)
				{
					if(graph2[nextX][nextY] == color && isVisited[nextX][nextY] == false)
					{
						isVisited[nextX][nextY] = true;
						q.offer(new ColorNode(nextX, nextY, graph2[nextX][nextY]));
					}					
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		 for (int i = 1; i <= N; i++) 
		 {
			 String color = sc.next();
	         for (int j = 1; j <= N; j++) 
	         {
	        	 graph[i][j] = color.charAt(j - 1);
	        	 if(color.charAt(j - 1) == 'G')
	        	 {
	        		 graph2[i][j] = 'R';
	        	 }
	        	 else
	        	 {
	        		 graph2[i][j] = color.charAt(j - 1);
	        	 }
	        	
	         }
	     }
		
		//ÀÏ¹ÝÀÎ¿ë
		for (int i = 1; i <= N; i++) 
		{
			for (int j = 1; j <= N; j++) 
			{
				isVisited[i][j] = false;
			}
		}
		
		for (int i = 1; i <= N; i++) 
		{
			for (int j = 1; j <= N; j++) 
			{
				if(isVisited[i][j] == false)
				{
					bfs_for_normal(i,j);		
					result[0]++;
				}
			}
		}
		
		
		//Àû³ì»ö¸Í¿ë
		for (int i = 1; i <= N; i++) 
		{
			for (int j = 1; j <= N; j++) 
			{
				isVisited[i][j] = false;
			}
		}
		
		for (int i = 1; i <= N; i++) 
		{
			for (int j = 1; j <= N; j++) 
			{
				if(isVisited[i][j] == false)
				{
					bfs_for_special(i,j);		
					result[1]++;
				}
			}
		}
		
		
		System.out.println(result[0]);
		System.out.println(result[1]);
	}

}
