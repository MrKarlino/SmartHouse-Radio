public class Radio {
    private int currentStation = 0;
    private int volume = 5;
    private final static int MAX_STATION = 9;
    private final static int MIN_STATION = 0;
    private final static int MAX_VOLUME = 10;
    private final static int MIN_VOLUME =0;

    public int getCurrentStation() {
        return currentStation;
    }

    public void setCurrentStation(int currentStation) {
        this.currentStation = Math.max(MIN_STATION, currentStation);
        this.currentStation = Math.min(MAX_STATION, this.currentStation);
    }

    public void nextStation() {
        if(currentStation >= MAX_STATION)
            setCurrentStation(MIN_STATION);
        else
            setCurrentStation(currentStation + 1);
    }

    public void prevStation() {
        if(currentStation <= MIN_STATION)
            setCurrentStation(MAX_STATION);
        else
            setCurrentStation(currentStation - 1);
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = Math.max(MIN_VOLUME, volume);
        this.volume = Math.min(MAX_VOLUME, this.volume);
    }

    public void increaseVolume() {
        setVolume(volume + 1);
    }

    public void decreaseVolume() {
        setVolume(volume - 1);
    }

}
