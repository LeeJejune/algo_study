package kookmin_algo_study.second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[10];

        var val = Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine());

        String str = String.valueOf(val);

        for (var i = 0; i < str.length(); i++) {
            arr[(str.charAt(i) - 48)]++;
        }

        for (var v : arr) {
            System.out.println(v);
        }
    }
}
