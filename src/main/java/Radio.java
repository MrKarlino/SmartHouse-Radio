public class Radio {
    private int currentStation = 0;
    private int volume = 5;
    private int maxStation = 10;
    private final static int MIN_STATION = 0;
    protected final static int MAX_VOLUME = 100;
    protected final static int MIN_VOLUME = 0;

    public Radio(int maxStation) {
        this.maxStation = maxStation;
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public void setCurrentStation(int currentStation) {
        this.currentStation = Math.max(MIN_STATION, currentStation);
        this.currentStation = Math.min(maxStation, this.currentStation);
    }

    public void nextStation() {
        if(currentStation >= maxStation)
            setCurrentStation(MIN_STATION);
        else
            setCurrentStation(currentStation + 1);
    }

    public void prevStation() {
        if(currentStation <= MIN_STATION)
            setCurrentStation(maxStation);
        else
            setCurrentStation(currentStation - 1);
    }

    public int getVolume() {
        return volume;
    }

    protected void setVolume(int volume) {
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
