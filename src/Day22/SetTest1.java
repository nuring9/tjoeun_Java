package Day22;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public class SetTest1 {
    static void main() {
        HashSet<Integer> odd = new HashSet<Integer>(); // 홀수
        HashSet<Integer> even = new HashSet<Integer>(); // 짝수
        for (int i = 1; i <= 5; i = i + 2) {
            odd.add(i); // 1, 3, 5
            even.add(i + 1); // 2, 4, 6
        }
        boolean setChanged = odd.add(5);  // 중복 안됨.
        System.out.println("odd에 5 추가 성공 ? : " + setChanged);  // false
        setChanged = even.add(12);  // 중북 안되는데 없어서 추가 됨.
        System.out.println("even에 12 추가 성공 ? : " + setChanged);  // true
        System.out.println("odd 집합 : " + odd);       // [1, 3, 5]
        System.out.println("even 집합 : " + even);     // [2, 4, 6, 12]
        System.out.println("add에서 가장 작은 값은 : " + Collections.min(odd));  // 1
        System.out.println("even에서 가장 큰 값은 : " + Collections.max(even));  // 12
        Iterator<Integer> it = even.iterator();
        int sum = 0;
        while (it.hasNext()) {
            sum = sum + it.next();
        }
        System.out.println("even 집합의 합은 : " + sum);  // 24
    }
}
