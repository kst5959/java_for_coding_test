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
		//�����¿� Ž�� �� ��ǥ�� ���� ��� ���
		if(x >= n || y >= m || x < 0 || y < 0 )
		{
			return false;
		}
		
		if(graph[x][y] == 0)
		{
			graph[x][y] = 1;
			//�ش� ��ǥ�� 0�� ��� �� ��ġ�� �����¿� ��� Ž���ؾ� ��
			dfs(x-1, y, n, m); //��
			dfs(x+1, y, n, m); //��
			dfs(x, y-1, n, m); //��
			dfs(x, y+1, n, m); //��
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
		System.out.println("��������� ���̽�ũ���� ���� : " + answer);
	}

}
