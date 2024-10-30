# Petrol Price Checker

A minimalist Java Swing application to view and report petrol prices across multiple cities and years. This app features a centered, clean interface with combo boxes for city and year selection, a submit button to fetch petrol prices, and a report menu to display average petrol prices.

## Features

- **City & Year Selection**: Choose a city and a year from dropdown menus.
- **Petrol Price Display**: Shows the petrol price based on the selected city and year.
- **Average Price Report**: Generates an average petrol price report across cities and years.

## Installation

1. **Clone the Repository**:
    ```bash
    git clone https://github.com/HChristopherNaoyuki/petrol-price-calculator-java-project.git
    cd petrol-price-checker
    ```
2. **Compile the Code**:
    Ensure you have JDK 8 or above installed.
    ```bash
    javac -d bin -sourcepath src src/Solution/MainFrame.java
    ```
3. **Run the Application**:
    ```bash
    java -cp bin Solution.MainFrame
    ```

## Usage

1. **Select a City**: Choose from Johannesburg, Durban, or Cape Town.
2. **Select a Year**: Choose from 2017, 2018, or 2019.
3. **Submit**: Click the submit button to display the petrol price for the chosen city and year.
4. **Generate Report**: Access the "Tools > Report" menu option to view an average petrol price report.

## Project Structure

```
petrol-price-checker/
├── src/
│   └── Solution/
│       ├── MainFrame.java             # Main GUI class
│       ├── PetrolPriceCalculator.java # Backend for price retrieval and report generation
│       └── DataStore.java             # Data layer storing petrol prices by city and year
└── README.md
```

## Development Details

- **Tech Stack**: Java Swing
- **GUI Layout**: Centered components using `GridBagLayout` for a Material Design-inspired style.
- **Styling**: Blue for primary buttons, light grey background for cards, minimal borders for a flat, modern look.

## Contributing

Contributions are welcome! Feel free to fork the repository, make enhancements, and submit a pull request.

## License

This project is licensed under the MIT License. See `LICENSE` for details.
