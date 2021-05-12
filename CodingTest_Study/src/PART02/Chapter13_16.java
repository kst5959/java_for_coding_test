package PART02;

import java.util.*;

public class Chapter13_16 {

	//������ ũ�� : ���� ����
	public static int N;
	public static int M;
	
	public static int result;
	
	//4����
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, 1, 0, -1};
	
	//�� ��ġ ��
	public static int[][] graph = new int[8][8];
	//�� ��ġ ��
	public static int[][] after_graph = new int[8][8];
	
	public static void virus(int x, int y)
	{
		//���̷����� �����¿� �̵��� �� �ִ�
		for (int i = 0; i < 4; i++) 
		{
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < N && nx >= 0 && ny < M && ny >= 0)
			{
				if (after_graph[nx][ny] == 0) 
				{
					//�ش� ��ġ�� ���̷��� ��ġ�ϰ� ���
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
	
	//dfs�� �� ��ġ �ϸ鼭 �Ź� �������� ũ�� ���
	public static void dfs(int count)
	{
		//���� 3�� ��ġ�� ���
		if(count == 3)
		{
			for (int i = 0; i < N; i++) 
			{
				for (int j = 0; j < M; j++) 
				{
					//�� ��ġ �� ������ �� ��ġ �� �迭�� �ű��
					after_graph[i][j] = graph[i][j];
				}
			}
			//�� �� ��ġ������ ���̷��� ���� ����
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
			
			//�� ��ġ �� ���̷��� ���� �� ���� ������ ū ���� ����
			result = Math.max(result, getScore());
			
		}
		//�� ��ġ�� �� ������ ���
		else
		{
			//�� ��ġ
			for (int i = 0; i < N; i++) 
			{
				for (int j = 0; j < M; j++) 
				{
					//��ĭ�� ��� �� ��ġ �� ī��Ʈ ����
					if(graph[i][j] == 0)
					{
						graph[i][j] = 1;
						count++;
						//�� ��ġ�� �� ���� �� ���� ���
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
