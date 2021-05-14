package PART02;

public class Chapter13_18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

import java.util.*;

class Solution {
    
    //균형잡힌 괄호 문자열인지 검사
    public int balancedIndex(String p)
    {
        int count = 0;
        for(int i=0; i<p.length(); i++)
        {
            if(p.charAt(i) == '(')
            {
                count++;
            }
            else
            {
                count--;
            }
            if(count == 0)
            {
                return i;
            }
        }
        
        return -1;
    }
    
    public boolean isCollect(String U)
    {
        Stack stack = new Stack();
        for(int i=0; i<U.length(); i++)
        {
            if(U.charAt(i) == '(')
            {
                stack.push(U.charAt(i));
            }
            else
            {
                if(stack.isEmpty())
                {
                    return false;
                }
                else
                {
                    stack.pop();
                }
            }
        }
        
        return true;
    }
    
    public String solution(String p) {
        String answer = "";
        
        //Step1
        if(p.equals(""))
        {
            return answer;
        }
        
        //Step2 U랑 V로 분리
        int index = balancedIndex(p);
        String U = p.substring(0, index + 1);
        String V = p.substring(index + 1, p.length());
        
        //Step3 U가 올바른 괄호 문자열인지 검사
        if(isCollect(U))
        {
            //올바른 괄호 문자열이면 V에 대해 1단계 부터 다시 수행
            String recursive = solution(V);
            //수행한 결과 문자열을 U에 이어 붙인 후 반환
            answer = U + recursive;
            return answer;
        }
        else
        {
            //Step4-1 빈 문자열에 첫 번째 문자로 ( 붙임
            answer = "(";
            //Step4-2 문자열 V에 대해 1단계부터 재귀적으로 수행한 결과를 이어 붙임
            String recursive = solution(V);
            answer += recursive;
            //Step4-3 다시 )를 붙임
            answer += ")";
            //Step4-4 U의 첫 번째와 마지막 문자를 제거하고 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙임
            String U2 = U.substring(1, U.length()-1);
            String temp ="";
            for(int i=0; i<U2.length(); i++)
            {
                if(U2.charAt(i) == '(')
                {
                    temp += ")";
                }
                else
                {
                    temp += "(";
                }
            }
            answer += temp;
        }
        
        return answer;
    }
}