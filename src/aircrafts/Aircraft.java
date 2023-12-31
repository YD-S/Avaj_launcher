package src.aircrafts;

public abstract class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    protected static String type;
    protected Aircraft(int p_id, String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
    }
}
