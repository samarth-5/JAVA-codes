import java.util.*;
class pairSum//for Sorted Array
{
    public static boolean pair(ArrayList<Integer> ar,int target)
    {
        int i=0,j=ar.size()-1;
        while(i<j)
        {
            if(ar.get(i)+ar.get(j)==target)
            return true;
            else if(ar.get(i)+ar.get(j)<target)
            i++;
            else if(ar.get(i)+ar.get(j)>target)
            j--;
        }
        return false;
    }
    public static void main(String[] args)
    {
        ArrayList <Integer> ar=new ArrayList<>();        
        ar.add(1);
        ar.add(2);
        ar.add(3);
        ar.add(4);
        ar.add(5);
        ar.add(6);
        System.out.println(pair(ar,66));
    }
}