import java.util.Scanner;

public class DaysOfMonth {

	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		System.out.println("Input the month: ");
		String month= input.nextLine();
		System.out.println("Input the year: ");
		int year= input.nextInt();
		int days = 0;
		 if (month.equals("January") || month.equals("Jan.") || month.equals("Jan") || month.equals("1") ||
		            month.equals("March") || month.equals("Mar.") || month.equals("Mar") || month.equals("3") ||
		            month.equals("May") || month.equals("5") ||
		            month.equals("July") || month.equals("Jul") || month.equals("7") ||
		            month.equals("August") || month.equals("Aug.") || month.equals("Aug") || month.equals("8") ||
		            month.equals("October") || month.equals("Oct.") || month.equals("Oct") || month.equals("10") ||
		            month.equals("December") || month.equals("Dec.") || month.equals("Dec") || month.equals("12")) {
		            days = 31;
		            System.out.print("The number of days is: " + days + ".");
		        } else if (month.equals("April") || month.equals("Apr") || month.equals("Apr.") || month.equals("4") ||
		            month.equals("June") || month.equals("Jun") || month.equals("6") ||
		            month.equals("September") || month.equals("Sept.") || month.equals("Sep") || month.equals("9") ||
		            month.equals("November") || month.equals("Nov.") || month.equals("Nov") || month.equals("11")) {
		            days = 30;
		            System.out.print("The number of days is: " + days + ".");
		        }
		else if (month.equals("February")  || month.equals("Feb.") || month.equals("Feb") || month.equals("2")) {
				days = year%100==0 ? 28 : year%400==0? 29 : year%4==0 ? 29 : 28 ;
				System.out.print("The number of days is: "+days+".");
		}
		
		
		
		input.close();
	}
}
