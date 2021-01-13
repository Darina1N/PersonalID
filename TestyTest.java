mport org.junit.jupiter.api.Test;
import sk.kosickaakademia.rodne.cislo.Testy;

import static org.junit.jupiter.api.Assertions.*;

class TestyTest {

    @org.junit.jupiter.api.Test
    void sucet() {
        Testy test=new Testy();
        assertEquals(0,test.sucet(0,0));

    }

    @Test
    void isPrimeNumber() {
    }

    @Test
    void isRectangularTriangle() {
        Testy test=new Testy();
        assertTrue(test.isRectangularTriangle(3,4,5));
        assertTrue(test.isRectangularTriangle(4,3,5));

    }

    @Test
    void reverse() {
        Testy test=new Testy();
        assertEquals("johA",test.reverse("Ahoj"));
    }
}