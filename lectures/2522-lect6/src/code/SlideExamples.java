class SlideExamples
{
    public static void main(final String[] args)
    {
        // repeat strings n time
        final Nameable repeatNames;
        repeatNames = (first, last, repeat)->{
            String str = "";

            for (int i = 0; i < repeat; i++)
            {
                str += first;
                str += last;
            }

            return str;
        };

        System.out.println(repeatNames.getOneString("tiger", "woods", 3));

        // string gets first n chars
        final Nameable getSubstrings;
        getSubstrings = (s1, s2, n)->{
            String str = "";

            str += s1.substring(0, n);
            str += s2.substring(0, n);

            return str;
        };

        System.out.println(getSubstrings.getOneString("tiger", "woods", 3));

        // get letters at position n
        final Nameable nthChars;
        nthChars = (s1, s2, n)->{return "" + s1.charAt(n) + s2.charAt(n);};

        System.out.println(nthChars.getOneString("tiger", "woods", 3));
    }
}

@FunctionalInterface
interface Nameable
{
    String getOneString(String s1, String s2, int n);
}