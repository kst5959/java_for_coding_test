package PART02;

import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int step = 1;
        int[] slice_Arr = new int[s.length()/2];
        
        if(s.length() == 1) return 1;
        
        for(int i=0; i<s.length()/2; i++)
        {
            int slice_length = bruteForce(s, step);
            slice_Arr[i] = slice_length;
            step++;
        }
        
        Arrays.sort(slice_Arr);
        
        return slice_Arr[0];
    }
    
    private int bruteForce(String s, int step) {
        String slice = s.substring(0,step);
        String compress ="";
        int compressCount = 1;
        //System.out.println("Slice : " + slice);
        
        for(int i=slice.length(); i<=s.length()-step; i++)
        {
            if(s.substring(i,i+step).equals(slice))
            {
                compressCount++;
            }
            else
            {
                if(compressCount <= 1)
                {
                    compress += slice;    
                }
                else
                {
                    compress += (Integer.toString(compressCount) + slice);    
                }
                
                slice = s.substring(i,i+step);
                //System.out.println(slice);
                compressCount = 1;
                
            }
            i += (step-1);
        }
        
        if(compressCount <= 1)
        {
            compress += slice;    
        }
        else
        {
            compress += (Integer.toString(compressCount) + slice);    
        }
        int remain = s.length() % step;
        if(remain > 0)
        {
            compress += s.substring(s.length()-remain, s.length());
        }
        
       // System.out.println("Step : "+ step +" 압축 결과 : "+compress);
        return compress.length();
        
    }
}