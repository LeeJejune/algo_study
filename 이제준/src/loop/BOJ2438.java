package loop;

import java.util.Scanner;

//public class 반복문.BOJ2438 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//
//        for (int i= 1; i <= n; i++){
//            for (int j = 1; j <= i; j++){
//                System.out.print('*');
//            }
//            System.out.println(" ");
//        }
//
//    }
//}

public class BOJ2438 {
    //별찍기 2
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i= 1; i <= n; i++){
            for (int j = 1; j <= n - i; j++){
                System.out.print(" ");
            }
            for (int k = 0; k < i; k++){
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
