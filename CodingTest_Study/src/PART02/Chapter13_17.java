package PART02;

import java.util.*;

class Virus implements Comparable<Virus> {
	
	private int x;
	private int y;
	private int virus;
	private int time;
	
	public Virus(int x, int y, int virus, int time)
	{
		this.x = x;
		this.y = y;
		this.virus = virus;
		this.time = time;
	}
	
	public int getX()
	{
		return this.x;
	}
	
	public int getY()
	{
		return this.y;
	}
	
	public int getVirus()
	{
		return this.virus;
	}
	
	public int getTime()
	{
		return this.time;
	}
	
	@Override
	public int compareTo(Virus o2) {
		// TODO Auto-generated method stub
		if(virus < o2.getVirus())
		{
			return -1;
		}
		return 1;
	}
	
}

public class Chapter13_17 {

	//����� ũ�� ���� ����
	public static int N;
	//���̷��� ���� ��
	public static int K;
	
	//S�� �ڿ� (X,Y)�� �����ϴ� ���̷����� ���� ���
	public static int S;
	public static int X;
	public static int Y;
	
	//���̷����� �����¿�� ��Ʈ�� �� �ִ�.
	public static int[] dx = {-1, 0, 1 , 0};
	public static int[] dy = {0, 1, 0 , -1};
	
	//�����
	public static int[][] graph;
	//���̷��� ���� �迭
	public static ArrayList<Virus> virusList = new ArrayList<Virus>();
	
	public static void bfs()
	{
		//ť�� ���̷��� ���� �Է�
		Queue<Virus> q = new LinkedList<Virus>();
		for (int i = 0; i < virusList.size(); i++) 
		{
			q.offer(virusList.get(i));
		}
		
		while(!q.isEmpty())
		{
			
			Virus virus = q.poll();
			int x = virus.getX();
			int y = virus.getY();
			int num = virus.getVirus(); 		
			
			//���ϴ� �ð� S�� �����Ͽ��� ��� ���ϴ� ��ǥ �� ���
			if(virus.getTime() == S)
			{
				break;
			}
			
			//���̷����� �����¿� Ȯ��
			for (int i = 0; i < 4; i++) 
			{
				int nx = x + dx[i];
				int ny = y + dy[i];
					
				//�ش� ��ġ�� ������� ����� �ʰ� ���̷����� ���� ���
				if(nx < N && nx >= 0 && ny < N && ny >= 0 && graph[nx][ny] == 0)
				{
					//���̷��� ����
					graph[nx][ny] = num;
					q.offer(new Virus(nx, ny, num, virus.getTime() + 1));
				}
			}	
				
			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		graph = new int[N+1][N+1];
		
		//����� ���� �Է�
		for (int i = 0; i < N; i++) 
		{
			for (int j = 0; j < N; j++) 
			{
				graph[i][j] = sc.nextInt();
				//�ش� ����� ��ǥ�� ���̷����� ���� ��� ���� �Է�
				if(graph[i][j] != 0)
				{
					virusList.add(new Virus(i, j, graph[i][j], 0));
				}
			}
		}
		
		//���� ��ȣ ����� �����ϴ� ����
		Collections.sort(virusList);
		
		//���ؾ��� ���� �� , ��ǥ �Է�
		S = sc.nextInt();
		X = sc.nextInt();
		Y = sc.nextInt();
		
		bfs();
		
		System.out.println(graph[X-1][Y-1]);
	}

}
