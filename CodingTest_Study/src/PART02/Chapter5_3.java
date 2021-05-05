package PART02;

public class Chapter5_3 {
	
	private static int[][] graph = {{0,0,1,1,0},
			 						{0,0,0,1,1},
			 						{1,1,1,1,1},
			 						{0,0,0,0,0}};
	
	public int solution(int n, int m) {
		int answer = 0;
		System.out.println(graph.length);
		System.out.println(graph[0].length);
		
		for(int i = 0; i < n; i++)
		{
			for (int j = 0; j < m; j++) 
			{
				if(dfs(i , j, n ,m))
				{
					answer++;
				}
			}
		}
		
		return answer;
	}
	
	public boolean dfs(int x, int y, int n, int m) {
		//상하좌우 탐색 시 좌표가 맵을 벗어난 경우
		if(x >= n || y >= m || x < 0 || y < 0 )
		{
			return false;
		}
		
		if(graph[x][y] == 0)
		{
			graph[x][y] = 1;
			//해당 죄표가 0인 경우 그 위치의 상하좌우 모두 탐색해야 함
			dfs(x-1, y, n, m); //상
			dfs(x+1, y, n, m); //하
			dfs(x, y-1, n, m); //좌
			dfs(x, y+1, n, m); //우
			return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		int m = 5;
		
		Chapter5_3 c = new Chapter5_3();
		int answer = c.solution(n , m);
		System.out.println("만들어지는 아이스크림의 종류 : " + answer);
	}

}
