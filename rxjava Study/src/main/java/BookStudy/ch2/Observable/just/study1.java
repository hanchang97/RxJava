package BookStudy.ch2.Observable.just;

import io.reactivex.rxjava3.core.Observable;

public class study1 {
    public static void main(String[] args) {
        JustExample je = new JustExample();
        je.emit();
    }
}

class JustExample{
    public void emit(){
        Observable.just(1,2,3,4,5)   // just 사용시 데이터 타입 모두 같아야 한다
                .subscribe(System.out::println);
    }
}

