package Day19;

interface A3 {
    void abc();
    int kor();
}

interface C3{
    void xor();
    void rsd();
}



class B3 implements A3,C3{  // interface는 다중 상속 가능하다.
    public void abc(){
        System.out.println("abc");
    }
    public int kor() {
        return 0;
    }

    @Override
    public void xor() {   // 상속받은 C3에 있는 메소드를 동일하게 정의만 해줘도 오류 발생하지 않음.

    }

    @Override
    public void rsd() {

    }

}


class D3 implements A3,C3 {
    void aaa(){

    };

    public void abc(){
        System.out.println("abc");
    }
    public int kor() {
        return 0;
    }

    @Override
    public void xor() {   // 상속받은 C3에 있는 메소드를 동일하게 정의만 해줘도 오류 발생하지 않음.

    }

    @Override
    public void rsd() {

    }

}

public class InterfaceTest {
    static void main() {

    }
}
