public class Radio {
    private int currentStation = 0;
    private int volume = 5;
    private int maxStation = 9;
    private int minStation = 0;
    private int maxVolume = 10;
    private int minVolume =0;

    public int getCurrentStation() {
        return currentStation;
    }

    public void setCurrentStation(int currentStation) {
        this.currentStation = Math.max(minStation, currentStation);
        this.currentStation = Math.min(maxStation, this.currentStation);
    }

    public void nextStation() {
        if(currentStation >= maxStation)
            setCurrentStation(minStation);
        else
            setCurrentStation(currentStation + 1);
    }

    public void prevStation() {
        if(currentStation <= minStation)
            setCurrentStation(maxStation);
        else
            setCurrentStation(currentStation - 1);
    }

    public int getVolume() {
        return volume;
    }

    private void setVolume(int volume) {
        this.volume = Math.max(minVolume, volume);
        this.volume = Math.min(maxVolume, this.volume);
    }

    public void increaseVolume() {
        setVolume(volume + 1);
    }

    public void decreaseVolume() {
        setVolume(volume - 1);
    }

}
