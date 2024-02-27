import java.util.*;
class activitySelection
{
    public static void main(String[] args) //nlog(n)
    {
        int start[]={1,3,0,5,8,5};
        int end[]={2,4,6,7,9,9};//end time basis sorted
        //If array is not sorted, then first sort on basis of end
        int activities[][]=new int[start.length][3];
        for(int i=0;i<start.length;i++)
        {
            activities[i][0]=i;
            activities[i][1]=start[i];
            activities[i][2]=end[i];
        }
        //lambda function -> Comparator is an interface for sorting Java objects
        Arrays.sort(activities,Comparator.comparingDouble((o->o[2])));//log(n)
        int maxAct=0;
        ArrayList <Integer>ans=new ArrayList<>();
        //1st activity
        maxAct=1;
        ans.add(0);
        int lastEnd=end[0];
        for(int i=1;i<end.length;i++)
        {
            if(activities[i][1]>=lastEnd)
            {
                //activity selected
                ans.add(activities[i][0]);
                maxAct++;
                lastEnd=activities[i][2];
            }
        }
        System.out.println("Maximum Activities:"+maxAct);
        System.out.println(ans);
    }
}