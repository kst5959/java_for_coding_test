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

	//시험관 크기 가로 세로
	public static int N;
	//바이러스 종류 수
	public static int K;
	
	//S초 뒤에 (X,Y)에 존재하는 바이러스의 종류 출력
	public static int S;
	public static int X;
	public static int Y;
	
	//바이러스는 상하좌우로 퍼트릴 수 있다.
	public static int[] dx = {-1, 0, 1 , 0};
	public static int[] dy = {0, 1, 0 , -1};
	
	//시험관
	public static int[][] graph;
	//바이러스 정보 배열
	public static ArrayList<Virus> virusList = new ArrayList<Virus>();
	
	public static void bfs()
	{
		//큐에 바이러스 정보 입력
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
			
			//원하는 시간 S에 도달하였을 경우 원하는 좌표 값 출력
			if(virus.getTime() == S)
			{
				break;
			}
			
			//바이러스의 상하좌우 확인
			for (int i = 0; i < 4; i++) 
			{
				int nx = x + dx[i];
				int ny = y + dy[i];
					
				//해당 위치가 시험관을 벗어나지 않고 바이러스가 없는 경우
				if(nx < N && nx >= 0 && ny < N && ny >= 0 && graph[nx][ny] == 0)
				{
					//바이러스 전이
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
		
		//시험관 정보 입력
		for (int i = 0; i < N; i++) 
		{
			for (int j = 0; j < N; j++) 
			{
				graph[i][j] = sc.nextInt();
				//해당 시험관 좌표에 바이러스가 있을 경우 정보 입력
				if(graph[i][j] != 0)
				{
					virusList.add(new Virus(i, j, graph[i][j], 0));
				}
			}
		}
		
		//작은 번호 순대로 진행하니 정렬
		Collections.sort(virusList);
		
		//구해야할 값의 초 , 좌표 입력
		S = sc.nextInt();
		X = sc.nextInt();
		Y = sc.nextInt();
		
		bfs();
		
		System.out.println(graph[X-1][Y-1]);
	}

}
