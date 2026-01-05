package Day21;

class Case<T> {
    //class Case<T, K> 처럼 2개도 가능, 갯수 제한은 없지만 보통 1~2개만 사용.
    T val;

    void setVolume(T v) {
        val = v;
    }

    T getVolume() {
        return val;
    }
}

public class GenericTest {
    static void main() {
        Case<Integer> icase = new Case<Integer>();
        icase.setVolume(200);
        // icase.setVolume(37.7);  실수라서 안됨, 형변환은 상속관계만 가능.
        System.out.println(icase.getVolume());
        Case<Double> dcase = new Case<Double>();
        dcase.setVolume(49.8);
        System.out.println(dcase.getVolume());
        Case<String> scase = new Case<String>();
        scase.setVolume("안녕");
        System.out.println(scase.getVolume());
    }
}
