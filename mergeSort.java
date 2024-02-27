class mergeSort//O(nlogn) 
{
    //Merge Sort is Outplace Sorting technique. Takes O(n) extra space.
    //Not better approach for small size array. For small array use insertion sort only.
    //Merge sort is a stable sorting algorithm.
    //After sorting if repeated element order not changes is called stable sorting technique.
    public static void display(int ar[])
    {
        for(int i=0;i<ar.length;i++)
        System.out.print(ar[i]+",");
        System.out.println();
    }
    public static void divide(int ar[],int si,int ei)
    {
        if(si>=ei)
        return;
        int mid=si+(ei-si)/2;
        divide(ar,si,mid);//left part
        divide(ar, mid+1, ei);//right part
        merge(ar,si,mid,ei);
    }
    public static void merge(int ar[],int si,int mid,int ei) 
    {
        int temp[]=new int[ei-si+1];
        int i=si;//iterator for left part
        int j=mid+1;//iterator for right part
        int k=0;//iterator for temporary array
        while(i<=mid && j<=ei)
        {
            if(ar[i]<ar[j])
            {
                temp[k]=ar[i];
                i++;
                k++;
            }
            else
            {
                temp[k]=ar[j];
                j++;
                k++;
            }
        }
        //leftover elements of left part
        while(i<=mid)
        {
            temp[k++]=ar[i++];
        }
        //leftover elements of right part
        while(j<=ei)
        {
            temp[k++]=ar[j++];
        }
        //copy temporary to original array
        for(k=0,i=si;k<temp.length;k++,i++)
        ar[i]=temp[k];
    }

    //Quick Sort is Inplace Sorting technique. Takes no extra space.
    //T.C. depends on value of pivot
    //T.C.  Worst Case = O(n^2)     Avg. case = O(nlog(n))    Best case = O(nlog(n))
    // 
    public static void quickSort(int ar[],int si,int ei)
    {
        if(si>=ei)
        return;
        int pivotIdx=partition(ar,si,ei);
        quickSort(ar, si, pivotIdx-1);//left
        quickSort(ar, pivotIdx+1, ei);//right
    }
    public static int partition(int ar[],int si,int ei)
    {
        int pivot=ar[ei];//taking last index as pivot
        int i=si-1;
        for(int j=si;j<ei;j++)
        {
            if(ar[j]<=pivot)
            {
                i++;
                int temp=ar[j];
                ar[j]=ar[i];
                ar[i]=temp;
            }
        }
        i++;
        int temp=pivot;
        ar[ei]=ar[i];
        ar[i]=temp;
        return i;
    }
    public static void main(String[] args) 
    {
        int ar[]={6,3,9,5,2,8,-6};
        quickSort(ar,0,ar.length-1);
        display(ar);
    }
}