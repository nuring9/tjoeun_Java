package Day24;


 class OuterClass {
    private static int staticOuterField = 20;
    private int memberOuterField = 30;

    // 정적 내부 클래스
    public static class StaticInnerClass {
        public void displayStaticOuterField() {
            System.out.println("Static outer field value: " + staticOuterField);
        }
    }

    // 멤버 내부 클래스
    public class MemberInnerClass {
        public void displayMemberOuterField() {
            System.out.println("Member outer field value: " + memberOuterField);
        }
    }

    public void methodWithLocalInnerClass() {
        // 지역 내부 클래스
        class LocalInnerClass {  // 메소드가 사용이 끝나면 없어지는 클래스.
            public void display() {
                System.out.println("Local inner class method");
            }
        }

        // 지역 내부 클래스 객체 생성 및 메서드 호출
        LocalInnerClass localInnerObj = new LocalInnerClass();
        localInnerObj.display();
    }





public class InnerClassTest {
    public static void main(String[] args) {
        // 정적 내부 클래스 객체 생성 및 메서드 호출
        StaticInnerClass staticInnerObj = new StaticInnerClass();
        staticInnerObj.displayStaticOuterField();

        // OuterClass의 인스턴스 생성
        OuterClass outerObj = new OuterClass();

        // 멤버 내부 클래스 객체 생성 및 메서드 호출
        MemberInnerClass memberInnerObj = outerObj.new MemberInnerClass();
        memberInnerObj.displayMemberOuterField();

        // 지역 내부 클래스 객체 생성 및 메서드 호출
        outerObj.methodWithLocalInnerClass();

        // 익명 내부 클래스
        Runnable anonymousInnerObj = new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous inner class method");
            }
        };

        // 익명 내부 클래스 객체 실행
        anonymousInnerObj.run();
    }
}
}
