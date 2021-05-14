package PART02;

public class Chapter13_18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

import java.util.*;

class Solution {
    
    //�������� ��ȣ ���ڿ����� �˻�
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
        
        //Step2 U�� V�� �и�
        int index = balancedIndex(p);
        String U = p.substring(0, index + 1);
        String V = p.substring(index + 1, p.length());
        
        //Step3 U�� �ùٸ� ��ȣ ���ڿ����� �˻�
        if(isCollect(U))
        {
            //�ùٸ� ��ȣ ���ڿ��̸� V�� ���� 1�ܰ� ���� �ٽ� ����
            String recursive = solution(V);
            //������ ��� ���ڿ��� U�� �̾� ���� �� ��ȯ
            answer = U + recursive;
            return answer;
        }
        else
        {
            //Step4-1 �� ���ڿ��� ù ��° ���ڷ� ( ����
            answer = "(";
            //Step4-2 ���ڿ� V�� ���� 1�ܰ���� ��������� ������ ����� �̾� ����
            String recursive = solution(V);
            answer += recursive;
            //Step4-3 �ٽ� )�� ����
            answer += ")";
            //Step4-4 U�� ù ��°�� ������ ���ڸ� �����ϰ� ������ ���ڿ��� ��ȣ ������ ����� �ڿ� ����
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