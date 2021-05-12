package PART02;

import java.util.*;

public class Chapter13_16 {

	//연구소 크기 : 가로 세로
	public static int N;
	public static int M;
	
	public static int result;
	
	//4방향
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, 1, 0, -1};
	
	//벽 설치 전
	public static int[][] graph = new int[8][8];
	//벽 설치 후
	public static int[][] after_graph = new int[8][8];
	
	public static void virus(int x, int y)
	{
		//바이러스는 상하좌우 이동할 수 있다
		for (int i = 0; i < 4; i++) 
		{
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < N && nx >= 0 && ny < M && ny >= 0)
			{
				if (after_graph[nx][ny] == 0) 
				{
					//해당 위치에 바이러스 배치하고 재귀
					after_graph[nx][ny] = 2;
					virus(nx, ny);					
				}
			}
			
		}
	}
	
	public static int getScore()
	{
		int score = 0;
		
		for (int i = 0; i < N; i++) 
		{
			for (int j = 0; j < M; j++) 
			{
				if(after_graph[i][j] == 0)
				{
					score++;
				}
			}
		}
		
		return score;
	}
	
	//dfs로 벽 설치 하면서 매번 안전영역 크기 계산
	public static void dfs(int count)
	{
		//벽이 3개 설치된 경우
		if(count == 3)
		{
			for (int i = 0; i < N; i++) 
			{
				for (int j = 0; j < M; j++) 
				{
					//벽 설치 다 했으면 벽 설치 후 배열에 옮기기
					after_graph[i][j] = graph[i][j];
				}
			}
			//벽 다 설치했으면 바이러스 전파 시작
			for (int i = 0; i < N; i++) 
			{
				for (int j = 0; j < M; j++) 
				{
					if(after_graph[i][j] == 2)
					{
						virus(i,j);
					}
				}
			}
			
			//벽 설치 후 바이러스 전파 후 안전 영역이 큰 값을 저장
			result = Math.max(result, getScore());
			
		}
		//벽 설치가 안 끝났을 경우
		else
		{
			//벽 설치
			for (int i = 0; i < N; i++) 
			{
				for (int j = 0; j < M; j++) 
				{
					//빈칸인 경우 벽 설치 후 카운트 증가
					if(graph[i][j] == 0)
					{
						graph[i][j] = 1;
						count++;
						//벽 설치가 다 끝날 때 까지 재귀
						dfs(count);	
						graph[i][j] = 0;
						count--;
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
			}
		}
		
		
		dfs(0);
		System.out.println(result);
	}

}
