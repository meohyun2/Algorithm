/*
정수를 1,2,3 의 합으로 나타내는 방법은 총 7가지가 있다.
 */

import javax.naming.PartialResultException;

public class baekjoon_1003 {
    public int fibonacci(int n){
        if(n ==0){
            System.out.println("0");
            return 0;
        } else if (n==1){
            System.out.println("1");
            return 1;
        } else {
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }

    public void fibonacci_counter(int T){
        // T는 테스트 케이스의 수
        int[][] arrForCount = new int[T][2];
        arrForCount[0][0]=1;arrForCount[0][1]=0;
        arrForCount[1][0]=0;arrForCount[1][1]=1;
        for(int i=2;i<T;i++){
            arrForCount[i][0]=arrForCount[i-1][0]+arrForCount[i-2][0];
            arrForCount[i][1]=arrForCount[i-1][1]+arrForCount[i-2][1];
        }
        System.out.println(arrForCount[T-1][0]);
        System.out.println(arrForCount[T-1][1]);
    }
}
