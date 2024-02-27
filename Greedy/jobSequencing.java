import java.util.*;
public class jobSequencing
{
    static class Job
    {
        int deadLine;
        int profit;
        int id;
        public Job(int i,int d,int p)
        {
            id=i;
            deadLine=d;
            profit=p;
        }
    }
    public static void main(String[] args) 
    {
        int jobInfo[][]={{4,20},{1,10},{1,40},{1,30}};//{deadLine,profit}
        //sort on basis of profit
        ArrayList<Job>jobs=new ArrayList<>();
        for(int i=0;i<jobInfo.length;i++)
        {
            jobs.add(new Job(i,jobInfo[i][0],jobInfo[i][1]));
        }
        //descending order on basis of profit
        Collections.sort(jobs,(a,b)->b.profit-a.profit);//descending
        ArrayList<Integer>seq=new ArrayList<>();
        int time=0;
        for(int i=0;i<jobs.size();i++)
        {
            Job curr=jobs.get(i);
            if(curr.deadLine > time)
            {
                seq.add(curr.id);
                time++;
            }
        }
        //printing sequnece
        System.out.println("Max jobs:"+seq.size());
        for(int i=0;i<seq.size();i++)
        {
            System.out.println(seq.get(i));
        }
    }
}