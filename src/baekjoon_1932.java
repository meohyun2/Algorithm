import java.util.*;

public class baekjoon_1932 {

    public static void findMax(int[] arr,int size){
        int max=0;
        for(int i=0;i<size;i++){
            if(max<arr[i])max=arr[i];
        }
        System.out.println(max);
    }


    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int numOfTriangle = input.nextInt();
        int valueOfTriangle[][]= new int[numOfTriangle][];
        //입력
        for(int i=1;i<=numOfTriangle;i++){
            valueOfTriangle[i-1] = new int[i];
            for(int j=0;j<i;j++){
                valueOfTriangle[i-1][j]= input.nextInt();
            }
        }

        // dp 를 위한 2차원 배열을 생성한다.
        int[][] result = new int[numOfTriangle][];
        int candidate1, candidate2;
        result[0]=new int[1];
        result[0][0]=valueOfTriangle[0][0];
        for(int i=1;i<numOfTriangle;i++){
            result[i] = new int[i+1];
            for(int j=0; j<=i; j++){
                if(j==0){
                    result[i][j]+=result[i-1][j]+valueOfTriangle[i][j];
                }else{
                    if(j==i){
                        result[i][j]+=result[i-1][j-1]+valueOfTriangle[i][j];
                    }else{
                        candidate1=result[i-1][j-1];
                        candidate2=result[i-1][j];
                        if(candidate1>candidate2){
                            result[i][j]=candidate1+valueOfTriangle[i][j];
                        }
                        else{
                            result[i][j] = candidate2 + valueOfTriangle[i][j];
                        }
                    }
                }
            }
        }
        findMax(result[numOfTriangle-1],numOfTriangle);
    }
}
