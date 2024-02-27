class subset
{
    public static void findSubsets(String str,String ans,int i)
    {
        //base case
        if(i==str.length())
        {
            System.out.println(ans);
            return;
        }
        //yes choice
        findSubsets(str, ans+str.charAt(i), i+1);
        //no choice
        findSubsets(str, ans, i+1);
    }
    public static void main(String[] args) 
    {
        String str="abc",ans="";
        findSubsets(str,ans, 0);
    }
}