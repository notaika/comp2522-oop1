package ca.bc.spca;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        final Animal a1;
        final Animal a2;
        final Animal a3;
        final Animal a4;




        try {
            a1 = new Dog(2021, "Lano");
            a4 = new Animal(2026);
            a2 = new Cat(2026, "Tom");

            a2.speak();
        } catch (final IOException e) {
            System.out.println("NO ANIMAL FOR YOU");
            System.out.println(e.getMessage());
        }



//        if (a2 instanceof Cat)
//        {
//            final Cat c;
//            c = (Cat) a2;
//            c.meow();
//        }
//
//        a2.speak();
    }
}
