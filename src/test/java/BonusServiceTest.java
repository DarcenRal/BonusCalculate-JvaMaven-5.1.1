import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void shouldcalculateRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1000_60;
        boolean registered = true;
        long expected = 30;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }
    @Test
    void shouldcalculateRegisteredAndOverLimit() {
         BonusService service = new BonusService();

         // подготавливаем данные:
         long amount = 26_000_60;
         boolean registered = true;
         long expected = 500;

          //вызываем целевой метод:
         long actual = service.calculate(amount, registered);

         assertEquals(expected, actual);
    }
    @Test
    void shouldcalculateNotRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 19_000_60;
        boolean registered = false;
        long expected = 190;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }
    @Test
    void shouldcalculateNotRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1300;
        boolean registered = false;
        long expected = 0;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }
    @Test
    void shouldcalculateRegisteredAndBoundaryLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1300;
        boolean registered = true;
        long expected = 0;

         //вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateNotRegisteredAndBoundaryLimit() {
        BonusService service = new BonusService();

        long amount = 13000000;
        boolean registered = false;
        long expected = 500;

        long actual = service.calculate(amount,registered);

        assertEquals(expected,actual);
    }
    @Test
    void shouldCalculateNotRegisteredAndMinBonus() {
        BonusService service = new BonusService();

        long amount = 13000;
        boolean registered = false;
        long expected = 1;

        long actual = service.calculate(amount,registered);

        assertEquals(expected,actual);
    }
}