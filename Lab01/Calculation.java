import java.util.Scanner;

public class Calculation{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String strNum1 = sc.next();
        String strNum2 = sc.next();
        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);
        System.out.println("Sum = " + (num1 + num2));
        System.out.println("Difference = " + (num1 - num2));
        System.out.println("Product = " + (num1 * num2));
        System.out.println("Quotient = " + (num1 / num2));
        sc.close();
    }
}