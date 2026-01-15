package ca.bc.spca;

import java.io.IOException;

/**
 * Represents a dog.
 *
 * @author aika
 * @version 1.0
 */
class Dog extends Animal // explicitly this is -> public class Dog extends Object
{
    // java has created a no args constructor, which is a super with no args
    // no match in super class (Animal)
    // how to fix error:
        // 1. add a no args constructor
        // 2. get dog class to ask for an int, that passes it onto the parent?

    private final String name;

    Dog (final int birthYear,
         final String name)
            throws IOException
    {
        // super goes at the top and must come first!!!
        // to construct a dog... you must first construct a parent!

        super(birthYear);
        this.name = name;
    }





}

/*
From a Dog perspective...
    Animal = parent
    Object = grandparent
 */