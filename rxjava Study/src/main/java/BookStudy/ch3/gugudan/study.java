package BookStudy.ch3.gugudan;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;

import java.util.Scanner;

public class study {
    public static void main(String[] args) {   // 드래그 후 'ctrl + /'  = 전체 주석
        // 일반적인 구구단
//        Scanner in =  new Scanner(System.in);
//        System.out.println("Gugudan Input");
//        int dan = Integer.parseInt(in.nextLine());
//        for(int i = 1; i<=9; i++)
//            System.out.println(dan + " * " + i + " = " + dan*i);

        // step1
//        Scanner in =  new Scanner(System.in);
//        System.out.println("Gugudan Input : ");
//        int dan = Integer.parseInt(in.nextLine());
//
//        Observable<Integer> source = Observable.range(1,9);  // start 숫자 부터 count 만큼 숫자 값 발행
//        source.subscribe(data -> System.out.println(dan + " * " + data + " = " + dan*data));

        // 하지만 step1 에서는 dan 변수에 대한 예외 처리를 Observable 안에서 할 수 없다
        // dan 에 문제가 없는지 (ex> 음수 입력) Observable 안에서 확인하는 것이 좋다


        // step2
//        Scanner in =  new Scanner(System.in);
//        System.out.println("Gugudan Input : ");
//        int dan = Integer.parseInt(in.nextLine());
//
//        Function<Integer, Observable<String>> gugudan = num ->
//                Observable.range(1,9).map(row -> num + " * " + row + " = " + num * row);
//        // 책에는 num * row 가 아니라 dan * row -> why??
//
//        Observable<String> source = Observable.just(dan).flatMap(gugudan);
//        source.subscribe(System.out::println);



        // step3  step2에서 만든 gugudan 함수를 인라인으로 flatMap() 함수 내부에 넣어보기
        Scanner in =  new Scanner(System.in);
        System.out.println("Gugudan Input : ");
        int dan = Integer.parseInt(in.nextLine());

        Observable<String> source = Observable.just(dan)
                .flatMap(num -> Observable.range(1,9)
                .map(data -> num + " * " + data + " = " + num*data));

        source.subscribe(System.out::println);


        // Observable 내 디버깅 및 예외 처리는 ch7에서 공부




    }
}
