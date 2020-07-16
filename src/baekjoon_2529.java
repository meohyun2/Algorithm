import java.util.*;

public class baekjoon_2529 {

    static int Num[]={0,1,2,3,4,5,6,7,8,9};

    public static void MaxMatchFinder(int numOfInequility,char[] inEquility){
        int top=9;
        for(int i=0;i<numOfInequility;i++){
            if(inEquility[i]=='>'){
                top--;
            }else{
            }
        }



    }

    public static void MinMatchFinder(){

    }

    public static void main(String[] args){
        // 초기화 및 입력
        Scanner input = new Scanner(System.in);
        int numOfInequality = input.nextInt();
        char[] inEquility = new char[numOfInequality];
        for(int i=0;i<numOfInequality;i++){
            inEquility[i]=input.next().charAt(0);
        }

        // 입력 검사
        System.out.println(inEquility);
        // 최댓값 구하기
        MaxMatchFinder(numOfInequality,inEquility);
    }

}
