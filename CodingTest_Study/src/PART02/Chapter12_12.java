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
            //�������� ����̸�
            if(stuff == 0)
            {
                boolean check = false;
                //��� ��ǥ�� �ٴ� �� ���� üũ
                if(y == 0)
                {
                    check = true;
                }
                //���� �� �� �� �κ��̰ų� �ٸ� ��� ���� ��� üũ
                for (int j = 0; j < answer.size(); j++) 
                {
                    //��ĭ ���� �� ���� �ִ� ��� (���� ������ ���� ��ġ�� �ִ� ���)
                    if(x - 1 == answer.get(j).get(0) && y == answer.get(j).get(1) && 1 == answer.get(j).get(2))
                    {
                        check = true;
                    }
                    //���� ���� ���� ��ġ�� �ִ� ���
                    if(x == answer.get(j).get(0) && y == answer.get(j).get(1) && 1 == answer.get(j).get(2))
                    {
                        check = true;
                    }
                    //�ٷ� �Ʒ��� ����� �ִ� ���
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
            //��ᰡ �� �� ���
            else if(stuff == 1)
            {
                boolean check = false;
                boolean left = false;
                boolean right = false;
                //���� ���κ��� ��� �� Ȥ�� ���� �� �κ��� �ٸ� ���� ���ÿ� ���� �������� üũ
                for (int j = 0; j < answer.size(); j++) 
                {
                    //�� �� �� ������ �� �κ� �Ʒ�(y - 1)�� ����� ��ġ(get(2) == 0)�� �ִ� ��� 
                    if(x == answer.get(j).get(0) && y - 1 == answer.get(j).get(1) && 0 == answer.get(j).get(2))
                    {
                        check = true;
                    }
                    if(x + 1 == answer.get(j).get(0) && y - 1 == answer.get(j).get(1) && 0 == answer.get(j).get(2))
                    {
                        check = true;
                    }
                    //���� �� �κ�(x - 1 or x + 1)�� �ٸ� ���� ��ġ�� �ִ� ���
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

        //frame �ִ� ���� 1000
        for (int i = 0; i < build_frame.length; i++) 
        {
            //xy : ���� ����, stuff : ������ ����, operate : ��� ����
            int x = build_frame[i][0];
            int y = build_frame[i][1];
            int stuff =  build_frame[i][2];
            int operate =  build_frame[i][3];

            //����� �����ϴ� ���
            if(operate == 0)
            {
                //���� ������ ���� �� �������� ������ ������ �� �ִ� ��
                for (int j = 0; j < answer.size(); j++) 
                {
                    if(x == answer.get(j).get(0) && y == answer.get(j).get(1) && stuff == answer.get(j).get(2))
                    {
                        //����� ������ ������(��� Ȥ�� ��)�� ã�� ��� ������ �غ��� �������� �Ǵ�
                        //temp : ������ �������� ���� �ӽ÷� ����
                        ArrayList<Integer> temp = answer.get(j);
                        //�����ϰ� üũ �ߴ��� ������ ���� �� �� ���
                        answer.remove(j);
                        if(!isPossible(answer))
                        {
                            //�ٽ� �������� ���ؼ� ���󺹱�
                            answer.add(temp);
                        }
                        else
                        {
                            //System.out.println(x + "," + y + " ��ǥ��" + stuff + " ���� �Ϸ�");
                        }
                        break;
                    }
                }
            }

            //����� ��ġ�� ���
            else if(operate == 1)
            {
                //��ġ�� �غ� �ڿ� �������� ���������� �Ǵ�
                //�ӽ÷� ������(ArrayList)�� �����
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.add(x);
                temp.add(y);
                temp.add(stuff);

                //��ġ�� �غôµ� �������� �������� �ƴ� ���
                answer.add(temp);
                if(!isPossible(answer))
                {
                    //�ٽ� �����ؼ� ���󺹱�
                    answer.remove(answer.size() - 1);
                }
                else
                {
                    //System.out.println(x + "," + y + " ��ǥ��" + stuff + " ��ġ �Ϸ�");
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