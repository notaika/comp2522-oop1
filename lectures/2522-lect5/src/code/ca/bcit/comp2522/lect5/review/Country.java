package ca.bcit.comp2522.lect5.review;

class Country
{
    private final String countryCode;
    private final String countryName;

    Country(String countryCode,
            String countryName)
    {
        this.countryCode = countryCode;
        this.countryName = countryName;
    }

    String getCountryCode()
    {
        return countryCode;
    }

    String getCountryName()
    {
        return countryName;
    }

    @Override
    public String toString()
    {
        return countryCode + " = " + countryName;
    }
}
