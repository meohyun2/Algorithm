/*
정수를 1,2,3 의 합으로 나타내는 방법은 총 7가지가 있다.
 */

import javax.naming.PartialResultException;
import java.util.Scanner;

public class baekjoon_1003 {

    public static void fibonacci_counter(int T){
        // T는 테스트 케이스의 수
        if(T==0){
            System.out.println("1 0");
        }else if(T==1){
            System.out.println("0 1");
        }else{
            int[][] arrForCount = new int[T+1][2];
            arrForCount[0][0]=1;arrForCount[0][1]=0;
            arrForCount[1][0]=0;arrForCount[1][1]=1;
            for(int i=2;i<=T;i++){
                arrForCount[i][0]=arrForCount[i-1][0]+arrForCount[i-2][0];
                arrForCount[i][1]=arrForCount[i-1][1]+arrForCount[i-2][1];
            }
            System.out.println(arrForCount[T][0]+" "+arrForCount[T][1]);
        }
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        int[] Trray = new int[T];
        for(int i = 0; i < T; i++) {
            Trray[i] = input.nextInt();
        }
        for(int i = 0; i < T; i++) {
            fibonacci_counter(Trray[i]);
        }
    }
}
