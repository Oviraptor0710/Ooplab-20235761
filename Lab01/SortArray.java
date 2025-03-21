import java.util.Scanner;

public class SortArray {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int []a = new int[n];
		int sum = 0;

		for(int i = 0; i<n; i++) {
			a[i] = sc.nextInt();
			sum += a[i];
		}
		int average = sum / n;
		
		for(int i = 0; i < n-1; i++) {
			for(int j = n-1; j>i; j--) {
				if(a[j] < a[j-1]) {
					int tmp = a[j-1];
					a[j-1] = a[j];
					a[j] = tmp;
				}
			}
		}
		
		for(int i = 0; i<n; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println("Sum = " + sum);
		System.out.println("Average Of Array = " + average);
		sc.close();
	}
}
