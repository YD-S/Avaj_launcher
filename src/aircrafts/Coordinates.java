package src.aircrafts;

public class Coordinates {
    private int latitude, longitude, height;
    Coordinates(int longitude, int latitude, int height) {
        if(longitude < 1)
            this.longitude = 1;
        else if(longitude > 100)
            this.longitude = 100;
        else
            this.longitude = longitude;

        if(latitude < 1)
            this.latitude = 1;
        else if(latitude > 100)
            this.latitude = 100;
        else
            this.latitude = latitude;

        if(height < 0)
            this.height = 0;
        else if(height > 100)
            this.height = 100;
        else
            this.height = height;
    }
    public int getLongitude() {
        return this.longitude;
    }
    public int getLatitude() {
        return this.latitude;
    }
    public int getHeight() {
        return this.height;
    }
}
