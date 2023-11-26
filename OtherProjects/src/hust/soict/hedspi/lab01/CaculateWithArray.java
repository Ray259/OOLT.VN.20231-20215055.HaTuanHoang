import java.util.Scanner;
public class CaculateWithArray {
    public static void Sort(int a[], int n){
        for (int i=0;i<n;i++)
            for(int j=i;j<n;j++)
                if(a[i]>a[j]){
                    int tg = a[i];
                        a[i] = a[j];
                        a[j] = tg;
                }
        System.out.print("Sorted array: ");
        for (int i=0;i<n;i++) System.out.print(a[i]+", ");
        System.out.println("\n");
    }
    public static void SumAverage(int a[], int n){
        long sum=0;
        for (int i=0;i<n;i++) sum+=a[i];
        System.out.print("Sum of array: " + sum + "\nAverage: " + sum/n);
        System.out.println("\n");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please input the number of elements: ");
        int n = input.nextInt();
        int[] a=new int[100] ;
        for (int i=0;i<n;i++){
            System.out.print("a["+i+"]: ");
            a[i] = input.nextInt();
        }
        input.close();
        Sort(a, n);
        SumAverage(a,n);
    }
}