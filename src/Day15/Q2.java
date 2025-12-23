package Day15;

// 동물명 먹이
class Animal {
    String type;
    String food;

    Animal(String type, String food) {
        this.type = type;
        this.food = food;
    }

    void print() {
        System.out.println(type + " -> " + food);
    }
}


public class Q2 {
    static void main() {
        Animal[] animals = new Animal[4];
        String[] types = {"원숭이", "개", "닭", "돼지"};
        String[] foods = {"바나나", "뼈다귀", "모이", "여물"};
        for (int i = 0; i < animals.length; i++) {
            animals[i] = new Animal(types[i], foods[i]);
            animals[i].print();
        }
        // 원숭이 -> 여물 / 개 -> 바나나 / 닭 -> 뼈다귀 / 돼지 -> 모이
        String temp = animals[3].food;
        for (int i = animals.length - 1; i > 0; i--) {
            animals[i].food = animals[i - 1].food;
        }
        animals[0].food = temp;

        for (int i = 0; i < animals.length; i++) {
            animals[i].print();
        }
    }
}
