package PART02;

import java.util.*;

class Baechoo
{
	private int x;
	private int y;
	private int bc;
	
	public Baechoo(int x, int y, int bc)
	{
		this.x = x;
		this.y = y;
		this.bc = bc;
	}
	
	public int getX()
	{
		return this.x;
	}
	
	public int getY()
	{
		return this.y;
	}
	
	public int getBaechoo()
	{
		return this.bc;
	}
	
}

public class BOJ1012 {
	
	//테스트케이스, 가로, 세로, 배추수
	public static int T;
	public static int M;
	public static int N;
	public static int K;
	
	public static int[][] graph = new int[51][51];
	public static boolean[][] isVisited = new boolean[51][51];
	
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, 1, 0, -1};
	
	public static ArrayList<Integer> count_list = new ArrayList<Integer>();

	public static void bfs(int startX, int startY)
	{
		Queue<Baechoo> q = new LinkedList<Baechoo>();
		q.offer(new Baechoo(startX, startY, graph[startX][startY]));
		isVisited[startX][startY] = true;
		
		while(!q.isEmpty())
		{
			Baechoo baechoo = q.poll();
			int x = baechoo.getX();
			int y = baechoo.getY();
			int bc = baechoo.getBaechoo();
			
			for (int i = 0; i < 4; i++) 
			{
				int nextX = x + dx[i];
				int nextY = y + dy[i];
				
				if(nextX < M && nextX >= 0 && nextY < N && nextY >= 0)
				{
					if(isVisited[nextX][nextY] == false && graph[nextX][nextY] == 1)
					{
						q.offer(new Baechoo(nextX, nextY, bc));
						isVisited[nextX][nextY] = true;
					}
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for (int tc = 0; tc < T; tc++) 
		{
			M = sc.nextInt();
			N = sc.nextInt();
			K = sc.nextInt();
			
			int count = 0;
			
			for (int i = 0; i < M; i++) 
			{
				for (int j = 0; j < N; j++) 
				{
					graph[i][j] = 0;
					isVisited[i][j] = false;
				}
			}
			
			for (int i = 0; i < K; i++) 
			{
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				graph[a][b] = 1;
			}
			
			for (int i = 0; i < M; i++) 
			{
				for (int j = 0; j < N; j++) 
				{
					if(isVisited[i][j] == false && graph[i][j] == 1)
					{
						bfs(i,j);
						//System.out.println("bfs tc : " + tc + ", position : (" + i + " , " + j +")");
						count++;
					}
				}
			}
			
			count_list.add(count);
		}

		for (int i = 0; i < count_list.size(); i++) 
		{
			System.out.println(count_list.get(i));
		}
	}

}
