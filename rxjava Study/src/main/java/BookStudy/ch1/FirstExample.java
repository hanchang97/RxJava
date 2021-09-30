package BookStudy.ch1;

import io.reactivex.rxjava3.core.Observable;

public class FirstExample {

    public void emit(){
        Observable.just("Hello", "RxJava 3!!")
                .subscribe(System.out::println);
    }

    public static void main(String[] args) {
        FirstExample demo = new FirstExample();
        demo.emit();
    }
}
