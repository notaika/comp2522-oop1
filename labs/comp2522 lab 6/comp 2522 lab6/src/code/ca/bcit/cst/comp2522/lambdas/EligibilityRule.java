package ca.bcit.cst.comp2522.lambdas;

@FunctionalInterface
public interface EligibilityRule
{
    boolean test(HockeyPlayer player, int minAge, int minGoals, int currentYear);
}
