import java.util.*;
public class itrHashSet
{
    public static void main(String[] args) {
        HashSet<String> cities=new HashSet<>();
        cities.add("Delhi");
        cities.add("Noida");
        cities.add("Mumbai");
        cities.add("Bengaluru");
        //Using iterators
        //Iterator itr=cities.iterator();
        //while(itr.hasNext())
        //{
        //    System.out.println(itr.next());
        //}
        //Using advamced loops
        for(String city:cities)
        {
            System.out.println(city);
        }
    }
}