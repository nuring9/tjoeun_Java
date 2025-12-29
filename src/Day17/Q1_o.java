package Day17;

import java.util.Scanner;

// 컴퓨터 클래스
class Computer1 {
    String menu;  // 제조사
    String cpu;   // CPU 종류
    int price; // 가격

    // 생성자
    Computer1(String menu, String cpu, int price) {
        this.menu = menu;
        this.cpu = cpu;
        this.price = price;
    }

    // 사용 메서드 출력
    void use() {
        System.out.println("제조사가 " + menu + "인" + cpu + "컴퓨터를 사용한다.");
    }
}

// 에어콘 클래스
class AirCorn {
    String menu;
    String type;
    int price;

    // 생성자
    AirCorn(String menu, String type, int price) {
        this.menu = menu;
        this.type = type;
        this.price = price;
    }

    // 사용 메서드 출력
    void use() {
        System.out.println("제조사가 " + menu + "인" + type + "에어콘을 사용한다.");
    }
}

class Ref {
    String menu;
    String type;
    String size;
    int price;

    Ref(String menu, String type, String size, int price) {
        this.menu = menu;
        this.type = type;
        this.size = size;
        this.price = price;
    }

    void use() {
        System.out.println("제조사가 " + menu + "인" + type + "형" + size + "냉장고가 식품을 관리한다.");
    }
}

class AirCleaner {
    String menu;
    int price;

    AirCleaner(String menu, int price) {
        this.menu = menu;
        this.price = price;
    }

    void use() {
        System.out.println("제조사가 " + menu + "인 공기청정기가 공기를 깨끗하게 한다.");
    }
}

// 마트 클래스 : 제품 재고 보유 및 제공 기능
class Mart {
    Computer1[] c = new Computer1[10];  // 컴퓨터 재고 10개
    AirCorn[] a = new AirCorn[10]; // 에어콘 재고 10개
    Ref[] r = new Ref[10]; // 냉장고 재고 10개
    AirCleaner[] ac = new AirCleaner[10]; // 공기청정기 재고 10개
    
    int index = -1; // 재고 인덱스 관리용
    // 배열 인덱스는 0부터 시작이므로, -1은 유효하지 않은 값이라서 오류 추적 하기 위해 범위에 없는 값을 일단 넣어둠.
    // -2로 초기화해도 상관없지만, 개발자 사이의 약속과 관례로 유효하지 않은 인덱스를 -1로 널리 통용되어 사용.

    // 생성자 : 초기 재고 10개 설정 ( 0~4: 삼성, 5~9: LG / 공기청정기만 0~4 LG, 5~9 다이슨 )
    Mart() {
        for (int i = 0; i < 10; i++) { // 0~9
            if (i < 5) {
                c[i] = new Computer1("삼성", "i7", 200);
                a[i] = new AirCorn("삼성", "벽걸이", 100);
                r[i] = new Ref("삼성", "양문", "600L", 200);
                ac[i] = new AirCleaner("LG", 80);
            } else {
                c[i] = new Computer1("LG", "i5", 150);
                a[i] = new AirCorn("LG", "스탠드", 250);
                r[i] = new Ref("LG", "4도어", "800L", 350);
                ac[i] = new AirCleaner("다이슨", 60);
            }
        }
    }

    // 마트에서 휴먼에게 제품을 주는 기능. 제품별로 제공하는 메서드와 null 처리 메서드

    //1. 컴퓨터 주기
    // main
    // sendComputer -> Human -> null 작업

    // start ~ end 범위 안에서 null이 아닌 첫 번째 제품을 반환.
    Computer1 sendComputer(int start, int end) {
        for (int i = start; i < end; i++) {
            if (c[i] != null) {    // 재고가 존재하면
                index = i;         // 현재 위치 기억 (null 처리용)
                return c[i];       // 해당 컴퓨터 반환.
            }
        }
        return null;
    }

    //human이 가지고 갔어 그러니까 null 작업 해
    // 해당 인덱스 위치의 컴퓨터를 null로 변경 (판매 완료 처리)
    void nullComputer() {
        c[index] = null;
    }

    // 2. 에어콘 주기
    // sendAirCorn -> Human -> null 작업
    AirCorn sendAirCorn(int start, int end) {
        for (int i = start; i < end; i++) {
            if (a[i] != null) {
                index = i;
                return a[i];
            }
        }
        return null;
    }

    // 해당 인덱스 위치의 에어콘를 null로 변경 (판매 완료 처리)
    void nullAirCorn() {
        a[index] = null;
    }

    // 3. 냉장고 주기
    // sendRef -> Human -> null 작업
    Ref sendRef(int start, int end) {
        for (int i = start; i < end; i++) {
            if (r[i] != null) {
                index = i;
                return r[i];
            }
        }
        return null;
    }

    // 해당 인덱스 위치의 냉장고를 null로 변경 (판매 완료 처리)
    void nullRef() {
        r[index] = null;
    }

    // 4. 공기청정기 주기
    // sendAirCleaner -> Human -> null 작업
    AirCleaner sendAirCleaner(int start, int end) {
        for (int i = start; i < end; i++) {
            if (ac[i] != null) {
                index = i;
                return ac[i];
            }
        }
        return null;
    }

    //  해당 인덱스 위치의 공기청정기를 null로 변경 (판매 완료 처리)
    void nullAirCleaner() {
        ac[index] = null;
    }
}

// 소비자 클래스
class Human {
    int money;  //  보유금액
    Computer1[] c = new Computer1[10];
    AirCorn[] a = new AirCorn[10];
    Ref[] r = new Ref[10];
    AirCleaner[] ac = new AirCleaner[10];
    // 각 상품들의 객체를 받아옴. 각 10개씩 보유

    //mart 상품을 받는 기능
    // Human 클래스 내에서 제품 배열 초기화는 생략된 상태지만 아래 메서드들에서 활용 중
    // 제품을 받는 메서드, 빈 공간 찾아 삽입
    
    // 컴퓨터를 받을 때 사용되는 메서드
    void reciveComputer(Computer1 c) {
        for (int i = 0; i < this.c.length; i++) {
            // 배열 크기만큼 순회하면서 비어있는 null을 찾으면
            if (this.c[i] == null) {
                this.c[i] = c;
                // 해당 위치에 컴퓨터 저장
                break;
                // 한 칸에만 넣고 종료
            }
        }
    }

    // 에어콘을 받을 때 사용되는 메서드
    void reciveAirCorn(AirCorn a) {
        for (int i = 0; i < this.a.length; i++) {
            if (this.a[i] == null) {
                this.a[i] = a;
                break;
            }
        }
    }

    // 냉장고를 받을 때 사용되는 메서드
    void reciveRef(Ref r) {
        for (int i = 0; i < this.r.length; i++) {
            if (this.r[i] == null) {
                this.r[i] = r;
                break;
            }
        }
    }

    // 공기청정기를 받을 때 사용되는 메서드
    void reciveAirCleaner(AirCleaner ac) {
        for (int i = 0; i < this.ac.length; i++) {
            if (this.ac[i] == null) {
                this.ac[i] = ac;
                break;
            }
        }
    }

    // 보유 상품 출력
    void allPrint() {
        for (int i = 0; i < 10; i++) {
            if (c[i] != null) {
                c[i].use();
            }
            if (a[i] != null) {
                a[i].use();
            }
            if (r[i] != null) {
                r[i].use();
            }
            if (ac[i] != null) {
                ac[i].use();
            }
        }
    }
}


public class Q1_o {
    public static void main(String[] args) {
        Mart m = new Mart();
        Human[] h = new Human[3];
        Scanner sc = new Scanner(System.in);
        //1. 소비자 돈입력
        for (int i = 0; i < h.length; i++) {
            h[i] = new Human();
            System.out.println((i + 1) + "번째 소비자 : ");
            h[i].money = sc.nextInt();
        }
        //2. 게임시작
        while (h[0].money >= 60 || h[1].money >= 60 || h[2].money >= 60) {
            for (int i = 0; i < h.length; i++) {
                System.out.println((i + 1) + "번째 소비자 남은 금액 : " + h[i].money);
                if (h[i].money >= 60) {
                    System.out.print((i + 1) + "번째 소비자 상품을 선택해주세요 1. 컴퓨터 2. 에어콘 3. 냉장고 4.공기청정기 :");
                    int num = sc.nextInt();
                    if (num == 1) {
                        System.out.print("1.삼성 2.LG : ");
                        int num1 = sc.nextInt();
                        if (num1 == 1) {
                            if (h[i].money >= 200) {
                                //1. 마트에서 컴퓨터 가지고 오기
                                Computer1 c = m.sendComputer(0, 5);
                                if (c == null) {
                                    System.out.println("물건이 모두 팔렸습니다.");
                                } else {
                                    //2. 가지고 온 컴퓨터 휴먼주기
                                    h[i].money -= c.price;
                                    h[i].reciveComputer(c);
                                    //3. 마트에 있는 컴퓨터 null
                                    m.nullComputer();
                                }
                            } else {
                                System.out.println("돈이 부족합니다.");
                            }
                        } else if (num1 == 2) {
                            if (h[i].money >= 150) {
                                //1. 마트에서 컴퓨터 가지고 오기
                                Computer1 c = m.sendComputer(5, 10);
                                if (c == null) {
                                    System.out.println("물건이 모두 팔렸습니다.");
                                } else {
                                    //2. 가지고 온 컴퓨터 휴먼주기
                                    h[i].money -= c.price;
                                    h[i].reciveComputer(c);
                                    //3. 마트에 있는 컴퓨터 null
                                    m.nullComputer();
                                }
                            } else {
                                System.out.println("돈이 부족합니다.");
                            }
                        } else {
                            System.out.println("잘못된 입력입니다.");
                        }
                    } else if (num == 2) {
                        System.out.print("1.삼성 2.LG : ");
                        int num1 = sc.nextInt();
                        if (num1 == 1) {
                            if (h[i].money >= 100) {
                                //1. 마트에서 에어컨 가지고 오기
                                AirCorn a = m.sendAirCorn(0, 5);
                                if (a == null) {
                                    System.out.println("물건이 모두 팔렸습니다.");
                                } else {
                                    //2. 가지고 온 컴퓨터 휴먼주기
                                    h[i].money -= a.price;
                                    h[i].reciveAirCorn(a);
                                    //3. 마트에 있는 컴퓨터 null
                                    m.nullAirCorn();
                                }
                            } else {
                                System.out.println("돈이 부족합니다.");
                            }
                        } else if (num1 == 2) {
                            if (h[i].money >= 250) {
                                //1. 마트에서 컴퓨터 가지고 오기
                                AirCorn a = m.sendAirCorn(5, 10);
                                if (a == null) {
                                    System.out.println("물건이 모두 팔렸습니다.");
                                } else {
                                    //2. 가지고 온 컴퓨터 휴먼주기
                                    h[i].money -= a.price;
                                    h[i].reciveAirCorn(a);
                                    //3. 마트에 있는 컴퓨터 null
                                    m.nullAirCorn();
                                }
                            } else {
                                System.out.println("돈이 부족합니다.");
                            }
                        } else {
                            System.out.println("잘못된 입력입니다.");
                        }
                    } else if (num == 3) {
                        System.out.print("1.삼성 2.LG : ");
                        int num1 = sc.nextInt();
                        if (num1 == 1) {
                            if (h[i].money >= 200) {
                                //1. 마트에서 냉장고 가지고 오기
                                Ref r = m.sendRef(0, 5);
                                if (r == null) {
                                    System.out.println("물건이 모두 팔렸습니다.");
                                } else {
                                    //2. 가지고 온 컴퓨터 휴먼주기
                                    h[i].money -= r.price;
                                    h[i].reciveRef(r);
                                    //3. 마트에 있는 컴퓨터 null
                                    m.nullRef();
                                }
                            } else {
                                System.out.println("돈이 부족합니다.");
                            }
                        } else if (num1 == 2) {
                            if (h[i].money >= 350) {
                                //1. 마트에서 냉장고 가지고 오기
                                Ref r = m.sendRef(5, 10);
                                if (r == null) {
                                    System.out.println("물건이 모두 팔렸습니다.");
                                } else {
                                    //2. 가지고 온 컴퓨터 휴먼주기
                                    h[i].money -= r.price;
                                    h[i].reciveRef(r);
                                    //3. 마트에 있는 컴퓨터 null
                                    m.nullRef();
                                }
                            } else {
                                System.out.println("돈이 부족합니다.");
                            }
                        } else {
                            System.out.println("잘못된 입력입니다.");
                        }
                    } else if (num == 4) {
                        System.out.print("1.LG 2.다이슨 : ");
                        int num1 = sc.nextInt();
                        if (num1 == 1) {
                            if (h[i].money >= 80) {
                                //1. 마트에서 공기청정기 가지고 오기
                                AirCleaner ac = m.sendAirCleaner(0, 5);
                                if (ac == null) {
                                    System.out.println("물건이 모두 팔렸습니다.");
                                } else {
                                    //2. 가지고 온 컴퓨터 휴먼주기
                                    h[i].money -= ac.price;
                                    h[i].reciveAirCleaner(ac);
                                    //3. 마트에 있는 컴퓨터 null
                                    m.nullAirCleaner();
                                }
                            } else {
                                System.out.println("돈이 부족합니다.");
                            }
                        } else if (num1 == 2) {
                            if (h[i].money >= 60) {
                                //1. 마트에서 공기청정기 가지고 오기
                                AirCleaner ac = m.sendAirCleaner(5, 10);
                                if (ac == null) {
                                    System.out.println("물건이 모두 팔렸습니다.");
                                } else {
                                    //2. 가지고 온 컴퓨터 휴먼주기
                                    h[i].money -= ac.price;
                                    h[i].reciveAirCleaner(ac);
                                    //3. 마트에 있는 컴퓨터 null
                                    m.nullAirCleaner();
                                }
                            } else {
                                System.out.println("돈이 부족합니다.");
                            }
                        } else {
                            System.out.println("잘못된 입력입니다.");
                        }
                    } else {
                        System.out.println("잘못된 입력입니다.");
                    }
                }
            }
        }
        for (int i = 0; i < h.length; i++) {
            System.out.println((i + 1) + "번째 소비자 구매 상품");
            h[i].allPrint();
        }
    }
}