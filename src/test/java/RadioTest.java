import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RadioTest {

    @Test
    void setStationWithinLimit() {
        Radio radio = new Radio();

        int expected = 3;
        radio.setCurrentStation(3);
        int actual = radio.getCurrentStation();
        assertEquals(actual,expected);
    }

    @Test
    void setCurrentStationUnderLimit() {
        Radio radio = new Radio();

        int expected = 0;
        radio.setCurrentStation(-1);
        int actual = radio.getCurrentStation();
        assertEquals(actual, expected);
    }

    @Test
    void setCurrentStationOverLimit() {
        Radio radio = new Radio();

        int expected = 9;
        radio.setCurrentStation(10);
        int actual = radio.getCurrentStation();
        assertEquals(actual, expected);
    }

    @Test
    void setCurrentStationAtLoverLimit() {
        Radio radio = new Radio();
        int minStation = 0;

        int expected = minStation;
        radio.setCurrentStation(minStation);
        int actual = radio.getCurrentStation();
        assertEquals(actual, expected);
    }

    @Test
    void setCurrentStationAtUpperLimit() {
        Radio radio = new Radio();
        int maxStation = 9;

        int expected = maxStation;
        radio.setCurrentStation(maxStation);
        int actual = radio.getCurrentStation();
        assertEquals(actual, expected);
    }

    @Test
    void testNextStation() {
        Radio radio = new Radio();
        int minStation = 0;
        radio.setCurrentStation(minStation);
        radio.nextStation();
        int expected = minStation + 1;
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    void testNextStationOverLimit() {
        Radio radio = new Radio();
        int maxStation = 9;
        int minStation = 0;
        radio.setCurrentStation(maxStation);
        radio.nextStation();
        int expected = minStation;
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    void testPrevStation() {
        Radio radio = new Radio();
        int maxStation = 9;
        radio.setCurrentStation(maxStation);
        radio.prevStation();
        int expected = maxStation - 1;
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    void testPrevStationUnderLimit() {
        Radio radio = new Radio();
        int minStation = 0;
        int maxStation = 9;
        radio.setCurrentStation(minStation);
        radio.prevStation();
        int expected = maxStation;
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    void testIncreaseVolume() {
        Radio radio = new Radio();
        int minVolume = 0;
        int expected = minVolume + 1;
        radio.setVolume(minVolume);
        radio.increaseVolume();
        int actual = radio.getVolume();
        assertEquals(expected, actual);
    }

    @Test
    void testIncreaseVolumeOverLimit() {
        Radio radio = new Radio();
        int maxVolume = 10;
        int expected = maxVolume;
        radio.setVolume(maxVolume);
        radio.increaseVolume();
        int actual = radio.getVolume();
        assertEquals(actual, expected);
    }

    @Test
    void testDecreaseVolume() {
        Radio radio = new Radio();
        int maxVolume = 10;
        int expected = maxVolume - 1;
        radio.setVolume(maxVolume);
        radio.decreaseVolume();
        int actual = radio.getVolume();
        assertEquals(expected, actual);
    }

    @Test
    void testDecreaseVolumeUnderLimit() {
        Radio radio = new Radio();
        int minVolume = 0;
        int expected = minVolume;
        radio.setVolume(minVolume);
        radio.decreaseVolume();
        int actual = radio.getVolume();
        assertEquals(expected, actual);
    }
}
