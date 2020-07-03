import java.util.*;

public class baekjoon_11399 {

    public static void sort(int[] timeForEachPerson,int maxPerson){
        //버블 소팅
        int temp;
        for(int i=0;i<maxPerson;i++){
            for(int j=0;j<maxPerson;j++){
                if(timeForEachPerson[i]<timeForEachPerson[j]){
                    temp=timeForEachPerson[i];
                    timeForEachPerson[i]=timeForEachPerson[j];
                    timeForEachPerson[j]=temp;
                }
            }
        }
        sum(timeForEachPerson,maxPerson);
    }

    public static void sum(int[] timeForEachPerson,int maxPerson){
        // ATM 대기시간 더하
        int sum=0;
        for(int i=0;i<maxPerson;i++){
            for(int j=0;j<=i;j++){
                sum += timeForEachPerson[j];
            }
        }
        System.out.println(sum);
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("몇명의 사람이 있는가?");
        int personNum = input.nextInt();
        int[] timeForEachPerson = new int[personNum];
        for(int i=0; i < personNum ; i++){
            // 사람 별 사용 시간
            timeForEachPerson[i] = input.nextInt();
        }

        sort(timeForEachPerson,personNum);
    }
}
