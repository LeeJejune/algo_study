package datastruct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int[] arr = new int[26];

        for (int i = 0; i <str.length(); i++) {
            arr[str.charAt(i) - 97]++;
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
