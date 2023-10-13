import java.util.Scanner;
public class StarTriangle {
	public static void main(String args[]) {
		Scanner input=new Scanner(System.in);
		System.out.println("Input triangle height: ");
		int n= input.nextInt();
		
		for (int i=0; i<n;i++) {
			int space=n-i-1;
			int star=1+i*2;
			for (int x=0; x<space;x++) {
				System.out.print(" ");
			}
			for (int y=0; y<star; y++) {
				System.out.print("*");
			}
			System.out.print("\n");			
		}
		input.close();
	}
}
