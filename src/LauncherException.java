package src;

public class LauncherException extends Exception{
    public LauncherException(String message) {
        super(message);
    }

    public void PrrintHelp(){
        System.out.println("Example of scenario.txt file:");
        System.out.println("25                      --> Number of simulations to run");
        System.out.println("Baloon B1 2 3 20        --> AircraftType CallSign Longitude Latitude Height");
        System.out.println("JetPlane J1 23 44 32    --> AircraftType CallSign Longitude Latitude Height");
        System.out.println("Helicopter H1 28 24 36  --> AircraftType CallSign Longitude Latitude Height");
        System.out.println("");
        System.out.println("All empty lines are ignored.");
        System.out.println("All integers must be positive..");
    }
}
