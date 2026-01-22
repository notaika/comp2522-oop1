package ca.bcit.comp2522.review;

import java.util.Objects;

class HockeyPlayer
{
    private final int birthYear;
    private final String position;
    private final double salaryCad;
    private final boolean rightHander;

    HockeyPlayer(int birthYear,
                        String position,
                        double salaryCad,
                        boolean rightHander)
    {
        this.birthYear = birthYear;
        this.position = position;
        this.salaryCad = salaryCad;
        this.rightHander = rightHander;
    }

//    @Override public boolean equals(Object object)
//    {
//        if (!(object instanceof HockeyPlayer that))
//        {
//            return false;
//        }
//        return Objects.equals(position,
//                              that.position);
//    }

    @Override
    public boolean equals(final Object o)
    {
        // way 1
        if (!(o instanceof HockeyPlayer))
        {
            return false;
        }

        // way 2
        // this doesn't check for inheritance!!!!
        // is your class EXACTLY HockeyPlayer?
//        if (!(obj.getClass()
//                 .equals(HockeyPlayer)))
//        {
//            return false;
//        }
        final HockeyPlayer h;
        h = (HockeyPlayer) o;

        return this.position.equalsIgnoreCase(h.position);
    }

    @Override
    public int hashCode() // where stuff goes in memory is based on the definition of this method!!
    {
        // equal objects return equal hashcodes
        // return 0; <- enough for the quiz :o
        return Objects.hashCode(position);
    }

    // GENERATED
//    @Override
//    public int hashCode()
//    {
//        return Objects.hashCode(position);
//    }
}
