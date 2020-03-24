import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RadioTest {

    @Test
    void setStationWithinLimit() {
        Radio radio = new Radio(10);

        int expected = 3;
        radio.setCurrentStation(3);
        int actual = radio.getCurrentStation();
        assertEquals(actual,expected);
    }

    @Test
    void setCurrentStationUnderLimit() {
        Radio radio = new Radio(10);

        int expected = 0;
        radio.setCurrentStation(-1);
        int actual = radio.getCurrentStation();
        assertEquals(actual, expected);
    }

    @Test
    void setCurrentStationOverLimit() {
        int maxStation = 10;
        Radio radio = new Radio(maxStation);
        int expected = maxStation;
        radio.setCurrentStation(maxStation + 1);
        int actual = radio.getCurrentStation();
        assertEquals(actual, expected);
    }

    @Test
    void setCurrentStationAtLowerLimit() {
        Radio radio = new Radio(10);
        int minStation = 0;

        int expected = minStation;
        radio.setCurrentStation(minStation);
        int actual = radio.getCurrentStation();
        assertEquals(actual, expected);
    }

    @Test
    void setCurrentStationAtUpperLimit() {
        int maxStation = 10;
        Radio radio = new Radio(maxStation);
        int expected = maxStation;
        radio.setCurrentStation(maxStation);
        int actual = radio.getCurrentStation();
        assertEquals(actual, expected);
    }

    @Test
    void testNextStation() {
        Radio radio = new Radio(10);
        int minStation = 0;
        radio.setCurrentStation(minStation);
        radio.nextStation();
        int expected = minStation + 1;
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    void testNextStationOverLimit() {
        int maxStation = 10;
        Radio radio = new Radio(maxStation);
        int minStation = 0;
        radio.setCurrentStation(maxStation);
        radio.nextStation();
        int expected = minStation;
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    void testPrevStation() {
        int maxStation = 10;
        Radio radio = new Radio(maxStation);
        radio.setCurrentStation(maxStation);
        radio.prevStation();
        int expected = maxStation - 1;
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    void testPrevStationUnderLimit() {
        int maxStation = 10;
        Radio radio = new Radio(maxStation);
        int minStation = 0;
        radio.setCurrentStation(minStation);
        radio.prevStation();
        int expected = maxStation;
        int actual = radio.getCurrentStation();
        assertEquals(expected, actual);
    }

    @Test
    void testIncreaseVolume() {
        Radio radio = new Radio(10);
        int expected = Radio.MIN_VOLUME + 1;
        radio.setVolume(Radio.MIN_VOLUME);
        radio.increaseVolume();
        int actual = radio.getVolume();
        assertEquals(expected, actual);
    }

    @Test
    void testIncreaseVolumeOverLimit() {
        Radio radio = new Radio(10);
        int expected = Radio.MAX_VOLUME;
        radio.setVolume(Radio.MAX_VOLUME);
        radio.increaseVolume();
        int actual = radio.getVolume();
        assertEquals(actual, expected);
    }

    @Test
    void testDecreaseVolume() {
        Radio radio = new Radio(10);
        int expected = Radio.MAX_VOLUME - 1;
        radio.setVolume(Radio.MAX_VOLUME);
        radio.decreaseVolume();
        int actual = radio.getVolume();
        assertEquals(expected, actual);
    }

    @Test
    void testDecreaseVolumeUnderLimit() {
        Radio radio = new Radio(10);
        int expected = Radio.MIN_VOLUME;
        radio.setVolume(Radio.MIN_VOLUME);
        radio.decreaseVolume();
        int actual = radio.getVolume();
        assertEquals(expected, actual);
    }
}
