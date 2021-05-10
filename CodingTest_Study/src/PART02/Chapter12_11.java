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

	//������ ũ��
	public static int N;
	//����� ����
	public static int K;
	//����
	public static int[][] board = new int[101][101];
	//						    ��    ��    ��    ��
	public static int[] dx = {0, 1, 0, -1};
	public static int[] dy = {1, 0, -1, 0};
	
	//���� ��ȯ Ƚ��
	public static int L;
	//���� ��ȯ ���� 
	public static String[] turn_info = new String[10001];
	
	//���� ��ȯ
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
		//���� ó�� ��ġ
		int x = 1;
		int y = 1;
		//���� ��ġ�ϴ°� = 2
		board[x][y] = 2;
		int time = start;
		//���� ���� : ����(0)���� �ʱ�ȭ
		int direction = 0;
		
		//���� ��ġ�� ��ǥ�� ��Ÿ���� ���� ť�� ���
		Queue<Position> position = new LinkedList<Position>();
		//���� ���� �����ϰ� �ִ� ��ǥ (�Ӹ� ��ġ) �Է�
		position.offer(new Position(x, y));
		
		while(true) 
		{
			int nx = x + dx[direction];
			int ny = y + dy[direction];
			
			System.out.println(time +" , " + direction + ": " + nx+ " , " + ny);
			
			//���� ����� �ʰ�, ���� ����� �� ��ġ�� ��ġ��� (�̵� ������ ��ġ���)
			if(nx >= 1 && nx <= N && ny >= 1 && ny <= N && board[nx][ny] != 2)
			{
				//�ش� ��ġ�� ����� ������ �̵� �Ŀ� ���� ����
				if(board[nx][ny] == 0)
				{
					board[nx][ny] = 2;
					position.offer(new Position(nx, ny));
					Position tail = position.poll();
					board[tail.getX()][tail.getY()] = 0;
				}
				
				//�ش� ��ġ�� ����� �ִ� ��� ���� x
				else if(board[nx][ny] == 1)
				{
					board[nx][ny] = 2;
					position.offer(new Position(nx, ny));
				}
				
			}
			//���� ����ų� ���� ���ΰ��
			else
			{
				time++;
				System.out.println(time + "�ʿ� ����");
				break;
			}
			
			x = nx;
			y = ny;
			time++;
			//���� �Ͽ� ȸ���ؾ��ϴ��� �˻�
			if(!turn_info[time].equals(""))
			{
				System.out.println(time + "�ʿ� ȸ��");
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
		
		//��� ��ġ �Է�
		for (int i = 0; i < K; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			board[a][b] = 1;
		}
		
		Arrays.fill(turn_info, "");
		
		L = sc.nextInt();
		//���� ��ȯ ���� �Է�
		for (int i = 0; i < L; i++) {
			int x = sc.nextInt();
			String C = sc.nextLine();
			
			turn_info[x] = C;
			
		}
		
		System.out.println(simulation(0));
		
	}

}
