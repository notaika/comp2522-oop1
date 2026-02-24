package ca.bcit.cst.comp2522.lambdas;

import java.util.ArrayList;
import java.util.List;

public class HockeyTeam
{
    private final String             name;
    private final List<HockeyPlayer> roster;

    public HockeyTeam(String name)
    {
        this.name   = name;
        roster = new ArrayList<>();
    }

    public String getName()
    {
        return name;
    }

    public List<HockeyPlayer> getRoster()
    {
        return roster;
    }
}
