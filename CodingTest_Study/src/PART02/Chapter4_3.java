package PART02;

public class Chapter4_3 {

	public int solution(int n, int m, int x, int y, int direction, int[][] map){
		//���� ��� �ִ� ������ ������ ���� �ȴ�
		int answer = 1;
		//�� �� �� �� ���� ����
		//ex) ���� ��� ���� �ٶ󺸰� �̵��� �� ���� �̵��ؾ� �ϴϱ� ���� ũ��(�ε���)�� 1 �ٿ��ִ� ������ �̵� �׷��� (-1,0) �̵ȴ�
		int[] dx = {-1, 0, 1 ,0};
		int[] dy = {0, 1, 0 ,-1};
		//�ߺ� �湮 üũ�� ���� ���� �ʱ�ȭ
		int[][] isVisited = new int[50][50];
		//���� ��� �ִ� ������ ������ ���� �Ǿ �ʱ�ȭ
		isVisited[x][y] = 1;
		//�ϵ����� ���� �� �� ���� ī��Ʈ
		int turn_time = 0;
		
		while(true)
		{
			//�޴��� ���� �������� ���� ��ȯ
			direction = turn_left(direction);
			//�ӽú����� ����� ���⸸ŭ �̵�
			int nextX = x + dx[direction];
			int nextY = y + dy[direction];
			
			//�̵��� ��ġ�� ���� ũ�⸦ ��� ���
			if(nextX >= n || nextY >= m)
			{
				turn_time++;
			}
			//�̵��� ��ġ�� ���� ũ�⸦ ��� ���
			else if(nextX < 0 || nextY < 0)
			{
				turn_time++;
			}
			//�̵��� ��ġ�� �����̸� �湮�� ���� ���� ���
			else if(map[nextX][nextY] == 0 && isVisited[nextX][nextY] == 0)
			{
				isVisited[nextX][nextY] = 1;
				x = nextX;
				y = nextY;
				answer++;
				turn_time = 0;
			}
			
			else turn_time++;
			//�ϵ����� �� ���ƺ� ���
			if(turn_time == 4)
			{
				//�� ĭ �ڷ� �̵�
				nextX = x - dx[direction];
				nextY = y - dy[direction];
				//�ٴٰ� �ƴ� ��� �̵� Ȯ��
				if(map[x][y] == 0)
				{
					x = nextX;
					y = nextY;
				}
				//�ٴ��� ��� ���
				else	break;
				
				turn_time = 0;
			}
		}
		
		return answer;
	}
	
	//���� ��ȯ�� ������ �������� �Ѵ�
	public int turn_left(int direction)
	{
		direction--;
		//-1�� ��� �������� ���� �ʱ�ȭ
		if(direction == -1) direction = 3;
		
		return direction;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3; // �� ���� ����
		int m = 3; // �� ���� ����
		int x = 1; // ���� ��ġ x
		int y = 1; // ���� ��ġ y
		int direction = 0; // �����ִ� ����
		//�� �ʱ�ȭ
		int[][] map = {{1,1,0},
					   {1,1,1},
					   {1,0,0},
					   {1,1,0}};
		
		Chapter4_3 c = new Chapter4_3();
		int answer = c.solution(n, m, x, y, direction ,map); 
		System.out.println(answer);
	}

}
