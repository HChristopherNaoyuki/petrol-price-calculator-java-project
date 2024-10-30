package Solution;

import java.util.HashMap;
import java.util.Map;

// DataStore class stores petrol prices and provides methods for retrieval and calculation.
public class DataStore
{
    private final Map<String, double[]> petrolPrices;

    public DataStore()
    {
        petrolPrices = new HashMap<>();
        petrolPrices.put("Johannesburg", new double[] {10.72, 10.35, 10.20});
        petrolPrices.put("Durban", new double[] {12.75, 12.32, 12.22});
        petrolPrices.put("Cape Town", new double[] {13.70, 13.31, 13.23});
    }

    public double getPrice(String city, int year)
    {
        double[] prices = petrolPrices.get(city);
        int index = year - 2017;
        if (index >= 0 && index < prices.length)
        {
            return prices[index];
        }
        else
        {
            throw new IllegalArgumentException("Invalid year provided.");
        }
    }

    public double calculateAverage(String city)
    {
        double[] prices = petrolPrices.get(city);
        double sum = 0.0;
        for (double price : prices)
        {
            sum += price;
        }
        return sum / prices.length;
    }
}
