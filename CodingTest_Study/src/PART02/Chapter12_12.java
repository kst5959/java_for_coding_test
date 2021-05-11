package PART02;

import java.util.*;

public class Chapter12_12 {

}

class Solution 
{
    public boolean isPossible(ArrayList<ArrayList<Integer>> answer) 
    {
        for (int i = 0; i < answer.size(); i++) 
        {
            int x = answer.get(i).get(0);
            int y = answer.get(i).get(1);
            int stuff = answer.get(i).get(2);
            //구조물이 기둥이면
            if(stuff == 0)
            {
                boolean check = false;
                //기둥 좌표가 바닥 위 인지 체크
                if(y == 0)
                {
                    check = true;
                }
                //보의 한 쪽 끝 부분이거나 다른 기둥 위인 경우 체크
                for (int j = 0; j < answer.size(); j++) 
                {
                    //한칸 왼쪽 에 보가 있는 경우 (보의 오른쪽 끝에 위치해 있는 경우)
                    if(x - 1 == answer.get(j).get(0) && y == answer.get(j).get(1) && 1 == answer.get(j).get(2))
                    {
                        check = true;
                    }
                    //보의 왼쪽 끝에 위치해 있는 경우
                    if(x == answer.get(j).get(0) && y == answer.get(j).get(1) && 1 == answer.get(j).get(2))
                    {
                        check = true;
                    }
                    //바로 아래에 기둥이 있는 경우
                    if(x == answer.get(j).get(0) && y - 1 == answer.get(j).get(1) && 0 == answer.get(j).get(2))
                    {
                        check = true;
                    }
                }
                if(!check)
                {
                    return false;
                }
            }
            //재료가 보 인 경우
            else if(stuff == 1)
            {
                boolean check = false;
                boolean left = false;
                boolean right = false;
                //한쪽 끝부분이 기둥 위 혹은 양쪽 끝 부분이 다른 보와 동시에 연결 상태인지 체크
                for (int j = 0; j < answer.size(); j++) 
                {
                    //양 쪽 중 한쪽의 끝 부분 아래(y - 1)에 기둥이 위치(get(2) == 0)해 있는 경우 
                    if(x == answer.get(j).get(0) && y - 1 == answer.get(j).get(1) && 0 == answer.get(j).get(2))
                    {
                        check = true;
                    }
                    if(x + 1 == answer.get(j).get(0) && y - 1 == answer.get(j).get(1) && 0 == answer.get(j).get(2))
                    {
                        check = true;
                    }
                    //양쪽 끝 부분(x - 1 or x + 1)에 다른 보가 위치해 있는 경우
                    if(x - 1 == answer.get(j).get(0) && y == answer.get(j).get(1) && 1 == answer.get(j).get(2))
                    {
                        left = true;
                    }
                    if(x + 1 == answer.get(j).get(0) && y == answer.get(j).get(1) && 1 == answer.get(j).get(2))
                    {
                        right = true;
                    }
                }

                if(left && right)
                {
                    check = true;
                }
                if(!check)
                {
                    return false;
                }
            }

        }

        return true;
    }

    public int[][] solution(int n, int[][] build_frame)
    {
        ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();

        //frame 최대 개수 1000
        for (int i = 0; i < build_frame.length; i++) 
        {
            //xy : 가로 세로, stuff : 구조물 종류, operate : 명령 종류
            int x = build_frame[i][0];
            int y = build_frame[i][1];
            int stuff =  build_frame[i][2];
            int operate =  build_frame[i][3];

            //명령이 삭제하는 경우
            if(operate == 0)
            {
                //만약 삭제를 했을 때 정상적인 구조를 유지할 수 있는 지
                for (int j = 0; j < answer.size(); j++) 
                {
                    if(x == answer.get(j).get(0) && y == answer.get(j).get(1) && stuff == answer.get(j).get(2))
                    {
                        //명령을 수행할 구조물(기둥 혹은 보)를 찾은 경우 삭제를 해보고 정상인지 판단
                        //temp : 삭제할 구조물의 정보 임시로 저장
                        ArrayList<Integer> temp = answer.get(j);
                        //삭제하고 체크 했더니 구조를 유지 못 할 경우
                        answer.remove(j);
                        if(!isPossible(answer))
                        {
                            //다시 구조물을 더해서 원상복구
                            answer.add(temp);
                        }
                        else
                        {
                            //System.out.println(x + "," + y + " 좌표에" + stuff + " 제거 완료");
                        }
                        break;
                    }
                }
            }

            //명령이 설치인 경우
            else if(operate == 1)
            {
                //설치를 해본 뒤에 정상적인 구조물인지 판단
                //임시로 구조물(ArrayList)을 만들고
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.add(x);
                temp.add(y);
                temp.add(stuff);

                //설치를 해봤는데 정상적인 구조물이 아닐 경우
                answer.add(temp);
                if(!isPossible(answer))
                {
                    //다시 제거해서 원상복구
                    answer.remove(answer.size() - 1);
                }
                else
                {
                    //System.out.println(x + "," + y + " 좌표에" + stuff + " 설치 완료");
                }
            }

        }

        int[][] res = new int[answer.size()][3]; 

        for (int i = 0; i < res.length; i++) 
        {
            res[i][0] = answer.get(i).get(0);
            res[i][1] = answer.get(i).get(1);
            res[i][2] = answer.get(i).get(2);
        }

        Arrays.sort(res, new Comparator<int[]>()
                    {
                       @Override
                        public int compare(int[] o1, int[] o2)
                        {
                            if(o1[0] == o2[0])
                            {
                                if(o1[1] == o2[1])
                                {
                                    return o1[2] - o2[2];    
                                }
                                else
                                {
                                    return o1[1] - o2[1];    
                                }
                            }

                            else
                            {
                                return o1[0] - o2[0];
                            }
                        }
                    });

        return res;
    }
}