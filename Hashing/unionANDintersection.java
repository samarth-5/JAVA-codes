import java.util.*;
public class unionANDintersection {
    public static void main(String[] args) {
        int ar1[]={7,3,9};
        int ar2[]={6,3,9,2,9,4};
        HashSet<Integer>set=new HashSet<>();
        for(int i=0;i<ar1.length;i++)
        set.add(ar1[i]);
        for(int i=0;i<ar2.length;i++)
        set.add(ar2[i]);
        System.out.println("Union:"+set.size());
        set.clear();
        for(int i=0;i<ar1.length;i++)
        set.add(ar1[i]);
        int c=0;
        for(int i=0;i<ar2.length;i++)
        {
            if(set.contains(ar2[i]))
            c++;
            set.remove(ar2[i]);
        }
        System.out.println("Intersection:"+c);
    }
}
