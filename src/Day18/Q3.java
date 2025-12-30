package Day18;
/*
낚시게임 클래스화
- int[5][5] 의 배열 생성
- 배열 int[5][5] 중에 물고기 3마리가  랜덤으로 들어가 있음 (중복X)
- 행과 열을 입력받아 내 위치 생성, 그 기준으로 물고기를 잡음.
- 위, 아래, 왼쪽, 오른쪽 이동하여 물고기가 있는 곳으로 이동하여 캐치.
- 3마리가 전부 잡히면 프로그램 종료. (아니면 반복)
 */

import java.util.Random;
import java.util.Scanner;

class Fish {
}

class Hosu {
    Fish[][] hosu = new Fish[5][5];

    Hosu() {
        Random r = new Random();
        for (int i = 0; i < 3; i++) {
            int y = r.nextInt(5);
            int x = r.nextInt(5);
            if (hosu[y][x] == null) {
                hosu[y][x] = new Fish();
            } else {
                i--;
            }
        }
    }

    //1. 호수상태 출력
    void printHosu(int[] position) {
        for (int i = 0; i < hosu.length; i++) {
            for (int j = 0; j < hosu[i].length; j++) {
                if (position[0] == i && position[1] == j) {
                    System.out.print("❤");
                } else if (hosu[i][j] == null) {
                    System.out.print("🟦");
                } else {
                    System.out.print("🐟");
                }
            }
            System.out.println();
        }
    }

    //2. 물고기주기
    Fish sendFish(int[] position) {
        return hosu[position[0]][position[1]];
    }

    //3. 무조건 널 작업 낚시꾼이 지나가면 무조건
    void nullFish(int[] position) {
        hosu[position[0]][position[1]] = null;
    }
}

class Fisher {
    Fish[] bowl = new Fish[3];
    int[] position = new int[2];

    Fisher() {
        position[0] = -1;
        position[1] = -1;
    }

    //0. 캐스팅
    void fisherCasting(Scanner sc) {
        while (true) {
            System.out.print("행 입력 : ");
            position[0] = sc.nextInt();
            System.out.print("열 입력 : ");
            position[1] = sc.nextInt();
            if (position[0] > -1 && position[0] < 5 && position[1] > -1 && position[1] < 5) {
                break;
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }
        System.out.println(position[0] + "," + position[1]);
    }

    //1. 물고기 받기
    void resiveFish(Fish f) {
        for (int i = 0; i < bowl.length; i++) {
            if (bowl[i] == null) {
                if (f != null) {
                    System.out.println("물고기를 잡았습니다.");
                }
                bowl[i] = f;
                break;
            }
        }
    }

    //2. 종료체크
    boolean bowlCheck() {
        for (int i = 0; i < bowl.length; i++) {
            if (bowl[i] == null) {
                return true;
            }
        }
        return false;
    }

    //3.위,아래,왼쪽,오른쪽
    void moveFisher(Scanner sc) {
        System.out.print("1. 위 2. 아래 3. 왼쪽 4. 오른쪽 : ");
        int num = sc.nextInt();
        if (num == 1) {
            position[0]--;
            if (position[0] < 0) {
                System.out.println("더이상 위로 움직일 수 없습니다.");
                position[0] = 0;
            }
        } else if (num == 2) {
            position[0]++;
            if (position[0] > 4) {
                System.out.println("더이상 아래로 움직일 수 없습니다.");
                position[0] = 4;
            }
        } else if (num == 3) {
            position[1]--;
            if (position[1] < 0) {
                System.out.println("더이상 왼쪽으로 움직일 수 없습니다.");
                position[1] = 0;
            }
        } else if (num == 4) {
            position[1]++;
            if (position[1] > 4) {
                System.out.println("더이상 오른쪽으로 움직일 수 없습니다.");
                position[1] = 4;
            }
        } else {
            System.out.println("잘못된 입력입니다.");
        }
    }
}

public class Q3 {
    static void main() {
        Scanner sc = new Scanner(System.in);
        Hosu h = new Hosu();
        Fisher fisher = new Fisher();
        h.printHosu(fisher.position);
        fisher.fisherCasting(sc);
//        Fish f =h.sendFish(fisher.position);
//        fisher.resiveFish(f);
        fisher.resiveFish(h.sendFish(fisher.position));
        h.nullFish(fisher.position);
        h.printHosu(fisher.position);
        while (fisher.bowlCheck()) {
            fisher.moveFisher(sc);
//            f =h.sendFish(fisher.position);
//            fisher.resiveFish(f);
            fisher.resiveFish(h.sendFish(fisher.position));
            h.nullFish(fisher.position);
            h.printHosu(fisher.position);
        }
    }
}
