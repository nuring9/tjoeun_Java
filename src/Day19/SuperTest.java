package Day19;

class C1{
    C1(int a) {

    }
    C1(String str){

    }
}

class D1 extends C1{

    // C1에 생성자를 맞춰서 생성자 하나 만들어줘야 함.
    // C1에 오버라이딩 되어있어도 둘 중에 하나만 만들어 놓으면 오류가 생기지 않음.
    D1() {
        super(5);
    }
}


public class SuperTest {
    static void main() {

    }
}
