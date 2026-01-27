package ca.bcit.comp2522.lab2.creatures;

/**
 * Test files for Creature class.
 *
 * @author Aika Manalo - Set 2C
 * @author Thor Baker - Set 2C
 * @version 1.0
 */
public class CreatureTest
{
    /**
     * Makes the attacker Creature attack the target Creature.
     *
     * @param attacker The attacking Creature
     * @param target The Creature getting attacked
     */
    public static void testAttack(final Creature attacker, final Creature target)
    {
        if (attacker.isPassedOut())
        {
            System.out.println("ERROR: " + attacker.getName() + " is passed out. Attack failed.");
            return;
        }

        System.out.println(attacker.getName() + " attacks " + target.getName());

        try
        {
            if (attacker instanceof Dragon)
            {
                final Dragon dragon;
                dragon = (Dragon) attacker;
                dragon.breatheFire(target);
            }

            if (attacker instanceof Elf)
            {
                final Elf elf;
                elf = (Elf) attacker;
                elf.castSpell(target);
            }

            //Uses getClass() to meet lab requirements
            if (attacker.getClass() == Orc.class)
            {
                final Orc orc;
                orc = (Orc) attacker;
                orc.berserk(target);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Drives the program.
     *
     * @param args unused
     */
    public static void main(final String[] args)
    {
        final Date toothlessDOB;
        final Date legolasDOB;
        final Date shrekDOB;

        final Creature toothless;
        final Creature legolas;
        final Creature shrek;

        toothlessDOB = new Date(2007, 4, 26);
        legolasDOB = new Date(2003, 11, 17);
        shrekDOB = new Date(2000, 5, 27);

        toothless = new Dragon("Toothless", toothlessDOB, 100, 30);
        legolas = new Elf("Legolas", legolasDOB, 20, 10);
        shrek = new Orc("Shrek", shrekDOB, 100, 15);

        toothless.getDetails();
        System.out.println();
        legolas.getDetails();
        System.out.println();
        shrek.getDetails();
        System.out.println();

        testAttack(toothless, legolas);
        System.out.println();
        testAttack(legolas, shrek);
        System.out.println();
        testAttack(shrek, toothless);
        System.out.println();
        testAttack(toothless, legolas);
        testAttack(shrek, toothless);
        System.out.println();

        System.out.println("\n====\n");
    }
}
