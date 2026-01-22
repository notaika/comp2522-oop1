package ca.bcit.comp2522.lecture3;

import java.util.Objects;

// making it abstract basically says: "a mammal exists as a category, but it doesn't exist as an object by itself"
public abstract class Mammal
{
    private final int weightKg;

    Mammal(final double weightKg)
    {
        this.weightKg = (int) Math.round(weightKg);
    }

    // QUIZ QUESTION
    // if you dont override equals method, it will only compare the
    // addresses of the objects being compared
    @Override
    public boolean equals(Object o)
    {
        if (o == null)
        {
            return false;
        }

        if (o == this)
        {
            return true;
        }

        if (!(o instanceof Mammal)) // called a guard
        {
            return false;
        }

        final Mammal that;
        that = (Mammal) o;

        return this.weightKg == that.weightKg;
    }

    @Override
    public int hashCode()
    {
        // equal objects must return equal hashcodes
        return weightKg;
    }


    // generated ones
//    @Override public boolean equals(Object object)
//    {
//        if (!(object instanceof Mammal mammal))
//        {
//            return false;
//        }
//        return weightKg == mammal.weightKg;
//    }
//
//    @Override public int hashCode()
//    {
//        return Objects.hashCode(weightKg);
//    }

    // we don't know how all mammals move...
    // e.g. some crawl, slither, fly, etc.
    // make it abstrct -> the child must implement it's own way
    abstract void move();

    abstract void speak();
}
