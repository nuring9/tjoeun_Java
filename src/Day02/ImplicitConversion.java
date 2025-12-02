package Day02;

public class ImplicitConversion {
    static void main() {
        byte bNum = 10;
        int iNum = bNum;
        System.out.println(bNum);
        System.out.println(iNum);

        int iNum2 = 20;
        float fNum = iNum2;  // int형 값이 float형 변수로 대입됨.  20.0
        System.out.println(iNum);
        System.out.println(fNum);

        double dNum;
        dNum = fNum + iNum;  // 자동형변환 float + int
        System.out.println(dNum);
    }
}
