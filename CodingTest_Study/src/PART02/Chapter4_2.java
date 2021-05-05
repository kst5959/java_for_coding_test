package PART02;

public class Chapter4_2 {

	public int solution(String currentLocation) {
		int answer = 0;
		int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
		int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
		
		int row = currentLocation.charAt(1) - '0';
		int col = currentLocation.charAt(0) - 'a' + 1;
		
		for(int i=0; i<8; i++)
		{
			int nextRow = row + dx[i];
			int nextCol = col + dy[i];
			if(nextRow >= 1 && nextRow <= 8 && nextCol >= 1 && nextCol <= 8)
				answer++;
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String currentlocation = "c3";
		
		Chapter4_2 c = new Chapter4_2();
		int answer = c.solution(currentlocation);
		
		System.out.println(answer);
	}

}
