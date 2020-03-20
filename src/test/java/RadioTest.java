import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    @Test
    void setCurrentStation() {
        Radio radio = new Radio();

        int expected = 3;
        radio.setCurrentStation(3);
        int actual = radio.getCurrentStation();
        assertEquals(actual,expected);

        expected = 0;
        radio.setCurrentStation(-1);
        actual = radio.getCurrentStation();
        assertEquals(actual, expected);

        expected = 0;
        radio.setCurrentStation(0);
        actual = radio.getCurrentStation();
        assertEquals(actual, expected);

        expected = 9;
        radio.setCurrentStation(10);
        actual = radio.getCurrentStation();
        assertEquals(actual, expected);

        expected = 9;
        radio.setCurrentStation(9);
        actual = radio.getCurrentStation();
        assertEquals(actual, expected);
    }

    @Test
    void nextStation() {
        Radio radio = new Radio();
        int minStation = 0;
        int maxStation = 9;
        int stationLength = (maxStation - minStation) + 1;
        for (int i = minStation; i <= maxStation; i++) {
            int expected = i + 1;
            // Сдвигаем expected до тех пор пока он не будет попадать в пределы станций
            while (expected > maxStation){
                expected -= stationLength;
            }
            radio.nextStation();
            int actual = radio.getCurrentStation();
            assertEquals(actual, expected);
        }
    }

    @Test
    void prevStation() {
        Radio radio = new Radio();
        int minStation = 0;
        int maxStation = 9;
        int stationLength = (maxStation - minStation) + 1;
        for (int i = minStation; i >= -maxStation; i--) {
            int expected = i - 1;
            while (expected < minStation){
                expected += stationLength;
            }// Сдвигаем expected до тех пор пока он не будет попадать в пределы станций

            radio.prevStation();
            int actual = radio.getCurrentStation();
            assertEquals(actual, expected);
        }
    }

    @Test
    void increaseVolume() {
        Radio radio = new Radio();
        int currentVolume = 5;
        int maxVolume = 10;
        for (int i = currentVolume; i <= maxVolume; i++) {
            radio.increaseVolume();
            int expected = Math.min(maxVolume, i + 1);
            int actual = radio.getVolume();
            assertEquals(expected, actual);
        }
    }

    @Test
    void decreaseVolume() {
        Radio radio = new Radio();
        int currentVolume = 5;
        int minVolume = 0;
        for (int i = currentVolume; i >= minVolume; i--) {
            radio.decreaseVolume();
            int expected = Math.max(minVolume, i - 1);
            int actual = radio.getVolume();
            assertEquals(expected, actual);
        }
    }
}