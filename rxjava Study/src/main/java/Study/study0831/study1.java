package Study.study0831;

import java.util.Arrays;
import java.util.List;

public class study1 {
    public static void main(String[] args){
        List<Integer> numbers = Arrays.asList(1, 3, 21, 10, 8, 11);    // 6이상 홀수 합

        int sum = 0;
        for(int i: numbers){
            if(i % 2 == 1 && i >= 6)
                sum+=i;
        }

        System.out.println(sum);
    }
}
