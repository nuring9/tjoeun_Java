package Day02;

public class OPTest2 {
    static void main() {
        System.out.println(5>3 && 4 == 7 || 3!=7); //  앞이 참이면 뒤에도 참, ||가 중심이 됨. 3!=7이 true
        System.out.println(5<3 && 4 == 7 || 3!=7); //  ||가 중심이 됨. 3!=7이 true
        System.out.println(5<3 && 4 == 7 && 3!=7); //  false
        System.out.println(!("강아지" == "고양이" && "호랑이" != "호랑이")); //  앞이 거짓이면 뒤에도 거짓인데 !로 true
        System.out.println(!("강아지" == "고양이" && "호랑이" == "호랑이")); //  앞이 거짓이면 뒤에도 거짓인데 !로 true
        System.out.println(!("강아지" == "고양이") && "호랑이" != "호랑이"); //  앞이 거짓이면 뒤에도 거짓
        System.out.println(!("강아지" == "고양이") && "호랑이" == "호랑이"); //  앞이 참이면 뒤에도 참.
    }
}
