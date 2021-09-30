package BookStudy.ch3.reduce;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import javafx.util.Pair;  // 기본라이브러리 아님

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;


public class study2 {

    public static void main(String[] args) {

        List<AbstractMap.SimpleEntry<String, Integer>> sales = new ArrayList<>();

        sales.add(new AbstractMap.SimpleEntry<>("TV", 2500));
        sales.add(new AbstractMap.SimpleEntry<>("Camera", 300));
        sales.add(new AbstractMap.SimpleEntry<>("TV", 1600));
        sales.add(new AbstractMap.SimpleEntry<>("Phone", 800));
        sales.add(new AbstractMap.SimpleEntry<>("TV", 900));
        sales.add(new AbstractMap.SimpleEntry<>("TV", 1000));

        Maybe<Integer> tvSales = Observable.fromIterable(sales)
                // reduce 함수 호출 시 인자로 너긴 람다 표현식에 의해 결고 없이 완료될 수 있다 -> 따라서 Observable이 아닌 Maybe객체로 리턴
                .filter(sale -> "TV".equals(sale.getKey()))
                .map(sale -> sale.getValue())
                .reduce((sale1, sale2) -> sale1 + sale2);  // reduce = BiFunction 객체를 인자로 받기에 괄호로 묶어서 람다표현식 사용

        tvSales.subscribe(System.out::println);

    }




}
