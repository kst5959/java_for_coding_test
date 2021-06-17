package PART02;

import java.util.*;

class House
{
	private int x;
	private int y;
	
	public House(int x, int y)
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

public class BOJ2667 {

	public static int N;
	
	public static int[][] graph = new int[26][26];
	public static boolean[][] isVisited = new boolean[26][26];
	
	public static ArrayList<Integer> result = new ArrayList<Integer>();
	
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, 1, 0, -1};
	
	public static void bfs(int startX, int startY)
	{
		Queue<House> q = new LinkedList<House>();
		q.offer(new House(startX, startY));
		isVisited[startX][startY] = true;
		int house_count = 1;
		
		while(!q.isEmpty())
		{
			House house = q.poll();
			int x = house.getX();
			int y = house.getY();			
			
			for (int i = 0; i < 4; i++) 
			{
				int nextX = x + dx[i];
				int nextY = y + dy[i];
				
				if(nextX < N && nextX >= 0 && nextY >= 0 && nextY < N)
				{
					if(graph[nextX][nextY] == 1 && isVisited[nextX][nextY] == false)
					{
						q.offer(new House(nextX, nextY));
						isVisited[nextX][nextY] = true;
						house_count++;
					}
				}
			}
		}
		
		result.add(house_count);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		for (int i = 0; i < N; i++) 
		{
			String S = sc.next();
			for (int j = 0; j < N; j++) 
			{
				graph[i][j] = S.charAt(j) - '0';
			}
		}

		for (int i = 0; i < N; i++) 
		{
			for (int j = 0; j < N; j++) 
			{
				isVisited[i][j] = false;
			}
		}
		
		for (int i = 0; i < N ; i++) 
		{
			for (int j = 0; j < N; j++) 
			{
				if(isVisited[i][j] == false && graph[i][j] == 1)
				{
					bfs(i,j);
				}
			}
		}
		
		System.out.println(result.size());
		Collections.sort(result);
		for (int i = 0; i < result.size(); i++) 
		{
			System.out.println(result.get(i));
		}
	}

}
