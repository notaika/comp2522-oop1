package ca.bcit.cst.comp2522.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

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
    }
}
