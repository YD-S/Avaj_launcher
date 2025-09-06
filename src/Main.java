package src;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            if(args.length != 1) {
                throw new LauncherException("Invalid number of arguments");
            }
            Simulation simulation = new Simulation();
            simulation.FileValidate(args[0]);
            simulation.run();
        } catch (LauncherException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Error: the file could not be read or does not exist.");
        }
    }
}