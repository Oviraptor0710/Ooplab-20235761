import java.util.Scanner;

public class SolveEquation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.println("1. Phuong trinh bac nhat 1 an");
            System.out.println("2. He phuong trinh bac nhat 2 an");
            System.out.println("3. Phuong trinh bac nhat 2 an");
            System.out.println("Dua ra lua chon loai phuong trinh: " );             
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    BacNhatMotAn(sc);
                    break;
                case 2:
                    HeBacNhatMotAn(sc);
                    break;
                case 3:
                    BacHaiMotAn(sc);
                    break;
                default:
                    System.out.println("Khong hop le");
            }
        }
    }
    
    public static void BacNhatMotAn(Scanner sc) {
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        
        if (a == 0) {
            if (b == 0) {
                System.out.println("Phuong trinh luon dung");
            } else {
                System.out.println("Vo nghiem");
            }
        } else {
            double x = -b / a;
            System.out.println("x = " + x);
        }
    }
    
    public static void HeBacNhatMotAn(Scanner sc) {
        double a11 = sc.nextDouble(), a12 = sc.nextDouble(), b1 = sc.nextDouble();
        double a21 = sc.nextDouble(), a22 = sc.nextDouble(), b2 = sc.nextDouble();
        
        double D = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;
        
        if (D == 0) {
            if (D1 == 0 && D2 == 0) {
                System.out.println("Phuong trinh luon dung");
            } else {
                System.out.println("Vo nghiem");
            }
        } else {
            double x1 = D1 / D;
            double x2 = D2 / D;
            System.out.println("x1 = " + x1 + ", x2 = " + x2);
        }
    }
    
    public static void BacHaiMotAn(Scanner sc) {
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        
        if (a == 0) {
            BacNhatMotAn(sc);
            return;
        }
        
        double delta = b * b - 4 * a * c;
        if (delta > 0) {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            System.out.println("x1 = " + x1 + ", x2 = " + x2);
        } else if (delta == 0) {
            double x = -b / (2 * a);
            System.out.println("x = " + x);
        } else {
            System.out.println("Vo nghiem");
        }
    }
}
