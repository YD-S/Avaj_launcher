package src;
import src.aircrafts.Coordinates;
public class WeatherTower extends Tower{
    private int TotalSimulations;
    private int SimulationCount;

    public WeatherTower(int p_TotalSimulations) throws LauncherException {
        if (p_TotalSimulations < 0)
            throw new LauncherException("Invalid number of simulations it must be greater than 0");
        TotalSimulations = p_TotalSimulations;
        SimulationCount = 0;
    }

    public int getTotalSimulations() { return TotalSimulations; }
    public void setTotalSimulations(int p_NumSimulations) { TotalSimulations = p_NumSimulations; }
    public int getSimulationCount() { return SimulationCount; }
    public void setSimulationCount(int p_SimulationCount) { SimulationCount = p_SimulationCount; }
    public void IncreamentSimulationCount() { SimulationCount++; }
    public String getWeather(Coordinates p_coordinates) { return WeatherProvider.getCurrentWeather(p_coordinates); }
    public void ChangeWeather() { this.conditionsChanged(); }
}
