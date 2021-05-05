package PART02;

import java.util.*;

//class Node {
	int x;
	int y;
	public Node(int x, int y)
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

class Chapter5_4 {

	private static int n = 5;
	private static int m = 6;
	private static int[][] graph1 = {{1,1,0},
									{0,1,0},
									{0,1,1}};
	
	private static int[][] graph = {{1,0,1,0,1,0},
									{1,1,1,1,1,1},
									{0,0,0,0,0,1},
									{1,1,1,1,1,1},
									{1,1,1,1,1,1}};
	 // 이동할 네 가지 방향 정의 (상, 하, 좌, 우) 
    public static int dx[] = {-1, 1, 0, 0};
    public static int dy[] = {0, 0, -1, 1};
    public static boolean[][] isVisited = new boolean[n][m];
    
	public int solution() {
		int answer = 1;
	
		for (int i = 0; i < n; i++) 
		{
			for (int j = 0; j < m; j++) 
			{
				isVisited[i][j] = false;
			}
		}
		
		isVisited[0][0] = true;
		answer = bfs(0, 0);
		
		return answer;
	}
	
	private int bfs(int x, int y) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(new Node(x, y));
		
		while(!queue.isEmpty())
		{
			//answer++;
			Node node = queue.poll();
			x = node.getX();
			y = node.getY();
			System.out.println("x : " + (x+1) + "  y : " + (y+1));
			
			//현재 위치에서 상하좌우 방향으로 위치 확인
			for (int i = 0; i < 4; i++) 
			{
				int nextX = x + dx[i];
				int nextY = y + dy[i];
				//맵 크기를 벗어난 경우 체크
				if(nextX >= n || nextY >= m || nextX < 0 || nextY < 0)
				{
					continue;
				}
				//해당 방향의 좌표가 벽인 경우
				if(graph[nextX][nextY] == 0)
				{
					continue;
				}
				//해당 방향의 좌표가 길이면서 첫 방문인 경우
				if(graph[nextX][nextY] == 1 && isVisited[nextX][nextY] == false)
				{
					isVisited[nextX][nextY] = true;
					System.out.print((nextX+1) + " " + (nextY+1) + " and ");
					graph[nextX][nextY] = graph[x][y] + 1;
					System.out.println(graph[nextX][nextY]);
					queue.offer(new Node(nextX, nextY));
				}
			}
			
		}
		
		return graph[n-1][m-1];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Chapter5_4 c = new Chapter5_4();
		int answer = c.solution();
		System.out.println(answer);
	}

}
