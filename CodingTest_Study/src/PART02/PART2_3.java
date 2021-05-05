package PART02;

import java.util.*;

public class PART2_3 {

	public int solution(int[][] matrix, int row, int col){
		int answer = 0;
		int[] temp = new int[row];
		for(int i=0; i<row; i++)
		{
			Arrays.sort(matrix[i]);
			temp[i] = matrix[i][0];
		}
		
		Arrays.sort(temp);
		answer = temp[temp.length-1];
		return answer;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { {3,1,2},
						   {4,1,4},
						   {2,2,2}};
		int row = 3;
		int col = 3;
		
		int[][] matrix2 = { {7,3,1,8},
				   			{3,3,3,4}};
		int row2 = 2;
		int col2 = 4;
		
		PART2_3 p = new PART2_3();
		int answer = p.solution(matrix, row, col);
		int answer2 = p.solution(matrix2, row2, col2);
		
		System.out.println(answer);
		System.out.println(answer2);
	}

}
