package BookStudy.ch3.map;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;

public class study {
    public static void main(String[] args) {
        String[] balls = {"1", "2", "3"};

        Observable<String> source = Observable.fromArray(balls)
                .map(ball -> ball + "@");

        source.subscribe(System.out::println);

/////////////////////////////////////////////////////////////

        Function<String, Integer> ballToIndex = ball -> {
            switch (ball){
                case "RED": return 1;
                case "BLUE": return 2;
                default: return -1;
            }
        };


        String[] balls2 = {"RED", "BLUE"};
        Observable<Integer> source2 = Observable.fromArray(balls2)
                .map(ballToIndex);

        source2.subscribe(System.out::println);



    }


}
