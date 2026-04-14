package ca.bcit.comp2522.termproject.singletonfiles;

/**
 * Defines the Observer contract for grid deduction updates.
 *
 * @author Aika Manalo - Set 2C
 * @version 1.0
 */
public interface GridObserver
{
    /**
     * Called when the logic grid confirms new deductions.
     *
     * @param who the deduced suspect
     * @param what the deduced weapon
     * @param when the deduced location
     */
    void onDeductionUpdated(String who,
                            String what,
                            String when);
}