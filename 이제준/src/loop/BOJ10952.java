package loop;

import java.io.IOException;
import java.util.Scanner;

public class BOJ10952 {
    public static void main(String[] args) throws IOException {
        //백준 10952
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//
//        while (true){
//            st = new StringTokenizer(br.readLine()," ");
//            int n = Integer.parseInt(st.nextToken());
//            int m = Integer.parseInt(st.nextToken());
//
//            if (n == 0 && m ==0){
//                break;
//            }
//
//            System.out.println((n+m));
//        }
//      백준 10951
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextInt()){

            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(a+b);

        }
        sc.close();

    }
}
