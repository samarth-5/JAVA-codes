public class removeDuplicates 
{
    public static void removeDup(int[] nums) 
    {
        int j = 1;
        for (int i = 1; i < nums.length; i++) 
        {
            if (nums[i] != nums[i - 1]) 
            {
                nums[j] = nums[i];
                j++;
            }
        }
        for(int i=0;i<j;i++)
        System.out.print(nums[i]+" ");
    }
    public static void main(String[] args) 
    {
        int ar[]={1,1,2,3,3};
        removeDup(ar);
    }
}
