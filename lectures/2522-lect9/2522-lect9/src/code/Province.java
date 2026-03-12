public class Province
{
    final String name;
    final int population;

    public Province(String name,
                    int population)
    {
        this.name       = name;
        this.population = population;
    }

    public String getName()
    {
        return name;
    }

    public int getPopulation()
    {
        return population;
    }
}
