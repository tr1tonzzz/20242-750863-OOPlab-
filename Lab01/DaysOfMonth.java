import java.util.Scanner;
public class DaysOfMonth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int month = 0, year = 0;
        while (true) {
            System.out.print("Enter month: ");
            String monthInput = scanner.next();
            month = convertMonthToNumber(monthInput);
            if (month != -1) break;
            System.out.println("Invalid month.Enter again!");
        }
        while (true) {
            System.out.print("Enter year: ");
            if (scanner.hasNextInt()) {
                year = scanner.nextInt();
                if (year >= 0) break;
            } else {
                scanner.next(); 
            }
            System.out.println("Invalid year. Enter again!");
        }
        int days = getDaysInMonth(month, year);
        System.out.println("Number of days in " + month + "/" + year + ": " + days);
        scanner.close();
    }

    public static int convertMonthToNumber(String month) {
        month = month.toLowerCase();
        switch (month) {
            case "1": case "jan": case "january": return 1;
            case "2": case "feb": case "february": return 2;
            case "3": case "mar": case "march": return 3;
            case "4": case "apr": case "april": return 4;
            case "5": case "may": return 5;
            case "6": case "jun": case "june": return 6;
            case "7": case "jul": case "july": return 7;
            case "8": case "aug": case "august": return 8;
            case "9": case "sep": case "september": return 9;
            case "10": case "oct": case "october": return 10;
            case "11": case "nov": case "november": return 11;
            case "12": case "dec": case "december": return 12;
            default: return -1;
        }
    }
    public static boolean checkLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    public static int getDaysInMonth(int month, int year) {
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return checkLeapYear(year) ? 29 : 28;
            default:
                return -1; 
        }
    }
}
