public class QuickSort {


    public static void quickSort(int[] input) {
        quickSort(input,0,input.length-1);
    }

    public static void quickSort(int[] input, int si, int ei)
    {
        if (si>=ei)
        {
            return;
        }
        int pivotIndex=partition(input,si,ei);
        quickSort(input, si, pivotIndex-1);
        quickSort(input,pivotIndex+1,ei);
    }

    public static int partition(int[] a, int si, int ei)
    {
        int pivotElement=a[si];
        int smallerEleCount=0;
        for(int i=si+1;i<=ei;i++)
        {
            if (a[i]<pivotElement)
            {
                smallerEleCount++;
            }
        }

        int temp=a[si+smallerEleCount];
        a[si+smallerEleCount]=pivotElement;
        a[si]=temp;

        int i=si;
        int j=ei;
        while(i<j)
        {
            if (a[i]<pivotElement)
            {
                i++;
            }
            else if (a[j]>=pivotElement)
            {
                j--;
            }
            else
            {
                temp=a[i];
                a[i]=a[j];
                a[j]=temp;
                i++;
                j--;
            }
        }

        return si+smallerEleCount;
    }
    public static void main(String[] args) {
        int[] input = {10,3,4,8,9,7,6,2,5,1};
        quickSort(input,0,input.length-1);
        for (int i = 0; i < input.length; i++){
            System.out.print(input[i]+ " ");
        }
    }
}
