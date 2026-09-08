import java.util.Scanner;
public class javaExample {
    public static void main(String[] args) {
        int sum = 0,n;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the value for n: ");
        n = input.nextInt();
        for (int i = 0; i < n+1; i++) {
            if (i%2==0) {
                sum = sum + i;
            }
        }
        System.out.println("The Sum is "+sum);
    }
}