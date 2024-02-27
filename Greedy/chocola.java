import java.util.*;
public class chocola
{
    public static void main(String[] args) 
    {
        int n=4,m=6;
        Integer costVer[]={2,1,3,1,4};//m-1
        Integer costHor[]={4,1,2};//n-1
        Arrays.sort(costVer,Collections.reverseOrder());
        Arrays.sort(costHor,Collections.reverseOrder());
        int h=0,v=0,hp=1,vp=1;//horizontal and vertical pieces
        int cost=0;
        while(h < costHor.length && v < costVer.length)
        {
            //case1-> ver cost < hor cost
            if(costVer[v] <= costHor[h])
            {
                //hor cut
                cost+=(costHor[h]*vp);
                hp++;
                h++;
            }
            //case2-> hor cost > ver cost
            else
            {
                //ver cut
                cost+=(costVer[v]*hp);
                vp++;
                v++;
            }
        }
        while(h < costHor.length)
        {
            //hor cut
            cost+=(costHor[h]*vp);
            hp++;
            h++;
        }
        while(v < costVer.length)
        {
            //ver cut
            cost+=(costVer[v]*hp);
            vp++;
            v++;
        }
        System.out.println("Minimum cost of cuts:"+cost);
    }
}