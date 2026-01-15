package ca.bc.spca;

import java.io.IOException;

public class Cat extends Animal {
    private final String name;

    Cat(final int birthYear,
        final String name)
    throws IOException
    {
        super(birthYear);
        this.name = name;
    }

    void meow()
    {
        System.out.println("meow");
    }

    @Override
    void speak()
    {
        System.out.println("MEOOOOW");
    }
}
