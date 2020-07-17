import java.util.*;

public class baekjoon_1541 {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String Expression = input.next();
        Vector<Integer> numStorage = new Vector<Integer>();
        Vector<Character> signStorage = new Vector<Character>();
        String numBuffer="";
        String signBuffer="";
        int maxForMininum=0;
        int prevPivot=0;
        int start=0,end=0;
        int result=0;

        // 문자열 전체를 숫자와 문자로 파싱하여 각각의 벡터에 저장
        for(int i=0;i<Expression.length();i++){
            if(i==0){
                if(Expression.charAt(i)=='-'){
                    signStorage.add(Expression.charAt(i));
                    prevPivot=i+1;
                }else {
                    signStorage.add('+');
                }
            }else if(Expression.charAt(i)=='+' || Expression.charAt(i)=='-'){
                signStorage.add(Expression.charAt(i));
                numStorage.add(Integer.parseInt(Expression.substring(prevPivot, i)));
                prevPivot = i + 1;
            }
        }
        numStorage.add(Integer.parseInt(Expression.substring(prevPivot,Expression.length())));

        // 바꿀 수 있는 경우의 최대를 구한다.
        for(int i=0; i<signStorage.size();i++){
            // -를 찾는다.
            int plusCount=0;
            if(signStorage.get(i)=='-'){
                //+ 있는지 본다.;
                int tempStart=i,tempEnd=i;
                int tempMax=0;
                for(int j=i+1;j<signStorage.size();j++){
                    if(signStorage.get(j)=='+'){
                        plusCount++;
                        tempEnd+=1;
                        tempMax+=numStorage.get(j);
                    }
                }
                if(maxForMininum<tempMax&&plusCount>0){
                    maxForMininum=tempMax;
                }
            }
        }
        //원래대로 식을 계산한 결과에, max값을 2번 뺀다.
        for(int i=0;i<signStorage.size();i++){
            result += Integer.parseInt(signStorage.get(i)+Integer.toString(numStorage.get(i)));
        }
        System.out.println(result-(maxForMininum*2));
    }
}
