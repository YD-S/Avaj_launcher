package src;
import src.aircrafts.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Map;

public class Simulation {
    private BufferedReader reader;
    private WeatherTower weatherTower;
    private ArrayList<Flyable> flyables = new ArrayList<>();
    private Map <String, Integer> aircrafts = Map.of(
        "Baloon", 0,
        "Helicopter", 0,
        "JetPlane", 0
    );

    public Simulation() {}

    public void Increment(String type) {
        int currentValue = aircrafts.get(type);
        int newValue = currentValue + 1;
        aircrafts.put(type, newValue);
    }

    public int GetId(String type) {
        return aircrafts.get(type);
    }
    public void FileValidate(String Path) throws IOException, LauncherException {
        int lines_cont = 0;
        reader = new BufferedReader(new FileReader(Path));
        String line;
        line = reader.readLine();
        if (line == null) {
            throw new LauncherException("File is empty");
        } else if (!line.matches("[0-9]+") || Integer.parseInt(line) < 1) {
            throw new LauncherException("Invalid number of simulations");
        }
        try{
            weatherTower = new WeatherTower(Integer.parseInt(line));
        }catch (LauncherException e) {
            System.out.println(e.getMessage());
        }
        lines_cont++;
        while ((line = reader.readLine()) != null) {
            if (lines_cont == 0)
                continue;
            lines_cont++;
            String[] tokens = line.split(" ");
            if (tokens.length != 5)
                throw new LauncherException("Invalid number of arguments");
            if (Integer.parseInt(tokens[2]) < 0 || Integer.parseInt(tokens[3]) < 0 || Integer.parseInt(tokens[4]) < 0)
                throw new LauncherException("Invalid number of arguments");

            try {
                switch (tokens[0]) {
                    case "Baloon" -> Increment("Baloon");
                    case "Helicopter" -> Increment("Helicopter");
                    case "JetPlane" -> Increment("JetPlane");
                }
                Flyable flyable = AircraftFactory.newAircraft(tokens[0], tokens[1], Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4]));
                flyables.add(flyable);
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        reader.close();
    }

    public void run() {
        for (Flyable flyable : flyables) {
            flyable.registerTower(weatherTower);
        }
        while (weatherTower.getSimulationCount() < weatherTower.getTotalSimulations()) {
            weatherTower.ChangeWeather();
            weatherTower.IncreamentSimulationCount();
        }
    }
}
