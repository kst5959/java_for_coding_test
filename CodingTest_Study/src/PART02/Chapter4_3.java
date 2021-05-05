package PART02;

public class Chapter4_3 {

	public int solution(int n, int m, int x, int y, int direction, int[][] map){
		//현재 밟고 있는 육지도 갯수에 포함 된다
		int answer = 1;
		//북 동 남 서 방향 정의
		//ex) 북의 경우 위로 바라보고 이동할 때 위로 이동해야 하니까 행의 크기(인덱스)를 1 줄여주는 식으로 이동 그래서 (-1,0) 이된다
		int[] dx = {-1, 0, 1 ,0};
		int[] dy = {0, 1, 0 ,-1};
		//중복 방문 체크를 위해 새로 초기화
		int[][] isVisited = new int[50][50];
		//현재 밟고 있는 육지도 갯수에 포함 되어서 초기화
		isVisited[x][y] = 1;
		//북동남서 돌아 볼 때 마다 카운트
		int turn_time = 0;
		
		while(true)
		{
			//메뉴얼에 따라 왼쪽으로 방향 전환
			direction = turn_left(direction);
			//임시변수를 만들어 방향만큼 이동
			int nextX = x + dx[direction];
			int nextY = y + dy[direction];
			
			//이동한 위치가 맵의 크기를 벗어난 경우
			if(nextX >= n || nextY >= m)
			{
				turn_time++;
			}
			//이동한 위치가 맵의 크기를 벗어난 경우
			else if(nextX < 0 || nextY < 0)
			{
				turn_time++;
			}
			//이동한 위치가 육지이며 방문한 적이 없는 경우
			else if(map[nextX][nextY] == 0 && isVisited[nextX][nextY] == 0)
			{
				isVisited[nextX][nextY] = 1;
				x = nextX;
				y = nextY;
				answer++;
				turn_time = 0;
			}
			
			else turn_time++;
			//북동남서 다 돌아본 경우
			if(turn_time == 4)
			{
				//한 칸 뒤로 이동
				nextX = x - dx[direction];
				nextY = y - dy[direction];
				//바다가 아닌 경우 이동 확정
				if(map[x][y] == 0)
				{
					x = nextX;
					y = nextY;
				}
				//바다인 경우 벗어남
				else	break;
				
				turn_time = 0;
			}
		}
		
		return answer;
	}
	
	//방향 전환은 무조건 왼쪽으로 한다
	public int turn_left(int direction)
	{
		direction--;
		//-1일 경우 서쪽으로 방향 초기화
		if(direction == -1) direction = 3;
		
		return direction;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3; // 맵 가로 길이
		int m = 3; // 맵 세로 길이
		int x = 1; // 현재 위치 x
		int y = 1; // 현재 위치 y
		int direction = 0; // 보고있는 방향
		//맵 초기화
		int[][] map = {{1,1,0},
					   {1,1,1},
					   {1,0,0},
					   {1,1,0}};
		
		Chapter4_3 c = new Chapter4_3();
		int answer = c.solution(n, m, x, y, direction ,map); 
		System.out.println(answer);
	}

}
