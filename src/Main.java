import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("테스트 케이스를 입력하세요 : ");
        int T = input.nextInt();
        int[] Trray = new int[T];
        for(int i = 0; i < T; i++) {
            Trray[i] = input.nextInt();
        }
        for(int i = 0; i < T; i++) {
            baekjoon_1003.fibonacci_counter(Trray[i]);
        }
    }
}
