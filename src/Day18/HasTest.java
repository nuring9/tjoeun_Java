package Day18;

class Car{
Engine e;
Tier[] t = new Tier[4];
}

class Engine{

}

class Tier{

}

class Factory{
   Car c;
   void make(Engine e, Tier[] t){
       c = new Car();
       c.e = e;
       c.t = t;
   }
}

public class HasTest {
    static void main() {
        Factory f = new Factory();
        Engine e = new Engine();
        Tier[] t = new Tier[4];

        for(int i = 0; i<t.length; i++){
            t[i] = new Tier();
        }
        f.make(e,t);
    }
}
