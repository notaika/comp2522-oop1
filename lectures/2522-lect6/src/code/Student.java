class Student
{
    private final String firstName;
    private final int yearBorn;

    Student(final String firstName,
            final int yearBorn)
    {
        this.firstName = firstName;
        this.yearBorn  = yearBorn;
    }

    String getFirstName()
    {
        return firstName;
    }

    int getYearBorn()
    {
        return yearBorn;
    }
}

@FunctionalInterface
interface StudentPredicate
{
    boolean test(Student s);
}

class Main4
{
    public static void main(final String[] args)
    {
        final Student stu1;
        final Student stu2;
        stu1 = new Student ("Mischa Potter", 2007);
        stu2 = new Student ("Tawm", 1996);

        // are they born in the 2000?
        final StudentPredicate isBornAfter1999;
        isBornAfter1999 = s->s.getYearBorn()>1999;
        System.out.println("Is student born in the 2000s?");
        System.out.println(isBornAfter1999.test(stu1));
        System.out.println(isBornAfter1999.test(stu2));

        // is their name longer than 7 chars?
        final StudentPredicate nameIsSevenOrLonger;
        nameIsSevenOrLonger = Main4::isNameLongerThanSeven;
        System.out.println(nameIsSevenOrLonger.test(stu1));
        System.out.println(nameIsSevenOrLonger.test(stu2));
    }

    static boolean isNameLongerThanSeven(final Student student)
    {
        // - 1 because of white space if
        return student.getFirstName().replaceAll("\\s+", "").length() > 7;
    }
}