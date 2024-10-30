package Solution;

// PetrolPriceCalculator handles the retrieval and calculation of petrol prices.
public class PetrolPriceCalculator
{
    private final DataStore dataStore;

    public PetrolPriceCalculator()
    {
        dataStore = new DataStore();
    }

    public double getPetrolPrice(String city, int year)
    {
        return dataStore.getPrice(city, year);
    }

    public String generateAveragePriceReport()
    {
        StringBuilder report = new StringBuilder("Average Petrol Price Report:\n");
        String[] cities = {"Johannesburg", "Durban", "Cape Town"};
        
        for (String city : cities)
        {
            double avgPrice = dataStore.calculateAverage(city);
            report.append(city).append(": ").append(avgPrice).append("\n");
        }
        
        return report.toString();
    }
}
