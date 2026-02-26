package ca.bcit.cst.comp2522.lambdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

/**
 * Main entry to the program.
 *
 * @author Aika Manalo - Set 2C
 * @version 1.0
 */
public class Main
{
    /**
     * Drives the program.
     *
     * @param args unsed
     */
    
    public static void main(String[] args)
    {
        final HockeyTeam team;
        team = new HockeyTeam("stfu");
        final List<HockeyPlayer> teamRoster;
        teamRoster = team.getRoster();

        final HockeyPlayer p1;
        final HockeyPlayer p2;
        final HockeyPlayer p3;
        final HockeyPlayer p4;
        final HockeyPlayer p5;
        final HockeyPlayer p6;

        p1 = new HockeyPlayer("Quinn Callander","F", 2007, 67);
        p2 = new HockeyPlayer("Mischa Potter","G", 2007, 0);
        p3 = new HockeyPlayer("Mayvee Tan","D", 2000, 32);
        p4 = new HockeyPlayer("Grace Yang","F", 2007, 3);
        p5 = new HockeyPlayer("Matthew Tong","D", 2000, 11);
        p6 = new HockeyPlayer("Aika Manalo","D", 2000, 27);

        teamRoster.add(p1);
        teamRoster.add(p2);
        teamRoster.add(p3);
        teamRoster.add(p4);
        teamRoster.add(p5);
        teamRoster.add(p6);

        // Supplier
        final Supplier<HockeyPlayer> callUp;
        callUp = ()->new HockeyPlayer("Lano Doggo", "F", 2021, 101);

        final HockeyPlayer p7;
        p7 = callUp.get();

        teamRoster.add(p7);

        for (final HockeyPlayer member : teamRoster)
        {
            System.out.println(member.getName());
        }

        // Predicate
        // Checks if player is forward
        final Predicate<HockeyPlayer> isForward;
        isForward = p->p.getPosition().equals("F");
        System.out.println(isForward.test(p7));

        // Checks if player has more than 20 goals
        final Predicate<HockeyPlayer> moreThan20Goals;
        moreThan20Goals = p->p.getGoals()>=20;

        for (final HockeyPlayer player : teamRoster)
        {
            if (isForward.test(player) && moreThan20Goals.test(player))
            {
                System.out.println(player);
            }
        }

        // Maps a player to a label String
        final Function<HockeyPlayer, String> playerLabel;
        playerLabel = p->p.getName() + " — " + p.getGoals() + p.getPosition();


        System.out.println(playerLabel.apply(p1));
        System.out.println();

        // Print player name
        final Consumer<HockeyPlayer> printPlayerName;
        printPlayerName = p-> System.out.println(p.getName());

        for (final HockeyPlayer player : teamRoster)
        {
            printPlayerName.accept(player);
        }

        System.out.println();

        // Uppercase Names
        final UnaryOperator<String> toUpper;
        toUpper = s->s.toUpperCase();

        for (final HockeyPlayer player : teamRoster)
        {
            System.out.println(toUpper.apply(player.getName()));;
        }

        // Sorts players by goal descending
        final Comparator<HockeyPlayer> goalsDesc;
        goalsDesc = (pl1, pl2)->Integer.compare(pl2.getGoals(), pl1.getGoals());

        Collections.sort(teamRoster, goalsDesc);
        System.out.println(teamRoster);

        // Aggregation
        int count = 0;

        for (final HockeyPlayer player : teamRoster)
        {
            count += player.getGoals();
        }

        System.out.println(count);

        // Custom Functional Interface
        final EligibilityRule isEligible;
        isEligible = (player, minAge, minGoals, year)->{
            final int age;
            age = year - player.getYearOfBirth();

            return (age > minAge && player.getGoals() > minGoals);
        };

        for (final HockeyPlayer player : teamRoster)
        {
            System.out.println(isEligible.test(player, 20, 10, 2026));
        }
    }
}
