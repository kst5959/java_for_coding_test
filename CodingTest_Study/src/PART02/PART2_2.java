package PART02;

import java.util.*;

public class PART2_2 {

  public int solution(int[] n, int m, int k) {
    int answer = 0;
    Arrays.sort(n);
    int first = n[n.length-1];
    int second = n[n.length-2];
    
    while(m != 0)
    {
      for(int i=0; i<k; i++)
      {
        answer += first;    
        m--;
        System.out.println(answer);
        if(m == 0) break;
      }

      answer += second;
      m--;
    }

    return answer;
  }

  public static void main(String[] args) {
    int[] n = {2,4,5,4,6};
    int m = 8;
    int k = 3;

    PART2_2 main = new PART2_2();
    int answer = main.solution(n,m,k);

    System.out.println(answer);
  }
}