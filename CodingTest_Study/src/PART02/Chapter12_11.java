package PART02;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import java.util.*;

class Position {
	private int x;
	private int y;
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
}

public class Chapter12_11 {

	//보드의 크기
	public static int N;
	//사과의 개수
	public static int K;
	//보드
	public static int[][] board = new int[101][101];
	//						    동    남    서    북
	public static int[] dx = {0, 1, 0, -1};
	public static int[] dy = {1, 0, -1, 0};
	
	//방향 전환 횟수
	public static int L;
	//방향 전환 정보 
	public static String[] turn_info = new String[10001];
	
	//방향 전환
	private static int turn_direction(int direction, String C) {
		if(C.equals(" L"))
		{
			System.out.println("dd");
			direction = (direction == 0) ? 3 : direction -1;
		}
		else
		{
			direction = (direction + 1) % 4;
		}
		
		return direction;
	}
	
	private static int simulation(int start)
	{
		//뱀의 처음 위치
		int x = 1;
		int y = 1;
		//뱀이 위치하는곳 = 2
		board[x][y] = 2;
		int time = start;
		//현재 방향 : 동쪽(0)으로 초기화
		int direction = 0;
		
		//뱀이 위치한 좌표를 나타내기 위해 큐를 사용
		Queue<Position> position = new LinkedList<Position>();
		//현재 뱀이 차지하고 있는 좌표 (머리 위치) 입력
		position.offer(new Position(x, y));
		
		while(true) 
		{
			int nx = x + dx[direction];
			int ny = y + dy[direction];
			
			System.out.println(time +" , " + direction + ": " + nx+ " , " + ny);
			
			//맵을 벗어나지 않고, 뱀의 몸통과 안 겹치는 위치라면 (이동 가능한 위치라면)
			if(nx >= 1 && nx <= N && ny >= 1 && ny <= N && board[nx][ny] != 2)
			{
				//해당 위치에 사과가 없으면 이동 후에 꼬리 제거
				if(board[nx][ny] == 0)
				{
					board[nx][ny] = 2;
					position.offer(new Position(nx, ny));
					Position tail = position.poll();
					board[tail.getX()][tail.getY()] = 0;
				}
				
				//해당 위치에 사과가 있는 경우 제거 x
				else if(board[nx][ny] == 1)
				{
					board[nx][ny] = 2;
					position.offer(new Position(nx, ny));
				}
				
			}
			//맵을 벗어났거나 뱀의 몸인경우
			else
			{
				time++;
				System.out.println(time + "초에 종료");
				break;
			}
			
			x = nx;
			y = ny;
			time++;
			//다음 턴에 회전해야하는지 검사
			if(!turn_info[time].equals(""))
			{
				System.out.println(time + "초에 회전");
				direction = turn_direction(direction, turn_info[time]);
			}
		}
		
		
		return time;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		
		//사과 위치 입력
		for (int i = 0; i < K; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			board[a][b] = 1;
		}
		
		Arrays.fill(turn_info, "");
		
		L = sc.nextInt();
		//방향 전환 정보 입력
		for (int i = 0; i < L; i++) {
			int x = sc.nextInt();
			String C = sc.nextLine();
			
			turn_info[x] = C;
			
		}
		
		System.out.println(simulation(0));
		
	}

}
