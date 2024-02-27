import java.util.Arrays;
import java.util.Scanner;
public class StringAnagram 
{
    public static void Anagram(String str1,String str2)
    {
        str1=str1.toLowerCase();
        str2=str2.toLowerCase();
        if(str1.length()==str2.length())
        {
            char ar1[]=str1.toCharArray();
            char ar2[]=str2.toCharArray();
            Arrays.sort(ar1);
            Arrays.sort(ar2);
            boolean res=Arrays.equals(ar1,ar2);
            if(res)
            System.out.println("Strings are Anagrams.");
            else        
            System.out.println("Strings are not Anagrams.");
        }
        else        
        System.out.println("Strings are not Anagrams.");
    }    
    public static void main(String Args[])
    {
        Scanner sc=new Scanner(System.in);
        String str1=sc.nextLine();
        String str2=sc.nextLine();
        Anagram(str1,str2);
    }
}
