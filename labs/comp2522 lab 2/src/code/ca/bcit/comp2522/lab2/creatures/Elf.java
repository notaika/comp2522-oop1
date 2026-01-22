package ca.bcit.comp2522.lab2.creatures;

/**
 * Represents a fantasy elf.
 *
 * @author Aika Manalo - Set 2C
 * @author Thor Baker - Set 2C
 * @version 1.0
 */
public class Elf extends Creature
{
    private static final int MIN_MANA = 0;
    private static final int LOW_MANA_THRESHOLD = 5;
    private static final int MAX_MANA = 50;
    private static final int SPELL_DAMAGE = 10;


    private int mana;

    public Elf(final String name,
               final Date dob,
               final int health,
               final int mana)
    {
        super(name, dob, health);
        validateMana(mana);
        this.mana = mana;
    }

    /**
     * Returns the elf's mana stat.
     *
     * @return mana stat
     */
    public int getMana()
    {
        return mana;
    }

    /*
     *
     * @param mana
     * @throws IllegalArgumentException
     */
    private static void validateMana(final int mana)
    {
        if (mana < MIN_MANA || mana > MAX_MANA)
        {
            throw new IllegalArgumentException("ERROR: Mana must be in between " +
                                               MIN_MANA + " and " + MAX_MANA);
        }
    }

    /**
     *
     *
     * @return
     * @throws LowManaException
     */
    public int castSpell() throws LowManaException
    {
        // Send a warning if mana is less than 10
        if (mana < LOW_MANA_THRESHOLD)
        {
            throw new LowManaException("Mana is at " + getMana());
        }

        // Reduce mana by 10
        mana -= LOW_MANA_THRESHOLD;
        System.out.println(getName() + " breathed fire: " + SPELL_DAMAGE
                           + " damage points");
        System.out.println("Mana: " + getMana());
        // Deals 20 damage
        return SPELL_DAMAGE;
    }

    public void restoreMana(final int amountToRestore)
    {
        if (amountToRestore < MIN_MANA)
        {
            throw new IllegalArgumentException("ERROR: Mana must be in between " +
                                               MIN_MANA + " and " + MAX_MANA);
        }

        mana += amountToRestore;

        // Mana capped at 100
        if (mana > MAX_MANA)
        {
            mana = MAX_MANA;
            System.out.println("Mana restored: " + amountToRestore + " points");
        }
        System.out.println("Mana: " + getMana());
    }

    @Override
    public void getDetails()
    {
        super.getDetails();
        System.out.println("Mana: " + getMana());
    }











}
