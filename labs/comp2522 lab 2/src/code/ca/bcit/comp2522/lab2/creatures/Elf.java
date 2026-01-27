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
    private static final int MIN_MANA = 1;
    private static final int LOW_MANA_THRESHOLD = 5;
    private static final int MAX_MANA = 50;
    private static final int SPELL_DAMAGE = 10;

    private int mana;

    /**
     * Sets Elf's name, dote of birth, health and fire power on creation.
     *
     * @param name The name of the Elf
     * @param dob The date of birth of the Elf
     * @param health The health of the Elf
     * @param mana The current mana of the Elf
     */
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
     * Checks if the mana is between MIN_MANA and MAX_MANA.
     *
     * @param mana The mana to check
     */
    private static void validateMana(final int mana)
    {
        if (mana < MIN_MANA || mana > MAX_MANA)
        {
            throw new IllegalArgumentException("ERROR: Mana must be in between " +
                                               MIN_MANA +
                                               " and " +
                                               MAX_MANA);
        }
    }

    /**
     * Deals SPELL_DAMAGE to another Creature and reduces mana by LOW_MANA_THRESHOLD.
     *
     * @param creatureToAttack
     * @throws LowManaException if mana is below LOW_MANA_THRESHOLD
     */
    public void castSpell(final Creature creatureToAttack) throws LowManaException
    {
        if (isPassedOut())
        {
            System.out.println(getName() + " is passed out. Attack failed!");
            return;
        }

        if (mana < MIN_MANA)
        {
            throw new LowManaException("ERROR: " + getName() + " doesn't have enough mana " +
                                       " - Attack failed.");
        }

        // Inflict damage onto creature
        creatureToAttack.takeDamage(SPELL_DAMAGE);

        // Reduce mana by 10
        mana -= LOW_MANA_THRESHOLD;
        System.out.println(getName() +
                           " casted a spell: inflicted +" +
                           SPELL_DAMAGE +
                           " spell damage | Mana left: " + getMana());

        // Send a warning if mana is less than 10
        if (mana < LOW_MANA_THRESHOLD)
        {
            throw new LowManaException("WARNING: " + getName() + " mana is critically low!");
        }
    }

    /**
     * Adds a specified amount to mana.
     *
     * @param amountToRestore The amount to add to mana
     */
    public void restoreMana(final int amountToRestore)
    {
        if (amountToRestore < MIN_MANA)
        {
            throw new IllegalArgumentException("ERROR: Mana must be in between " +
                                               MIN_MANA +
                                               " and " +
                                               MAX_MANA);
        }

        mana += amountToRestore;

        // Mana capped at 100
        if (mana > MAX_MANA)
        {
            mana = MAX_MANA;
            System.out.print("mana restored: " +
                               amountToRestore +
                               " points");
        }
        System.out.println(" | Mana left:" + getMana());
    }

    /**
     * Calls Creature's getDetails() and adds mana to the list.
     */
    @Override
    public void getDetails()
    {
        super.getDetails();
        System.out.println("Mana: " + getMana());
    }
}
