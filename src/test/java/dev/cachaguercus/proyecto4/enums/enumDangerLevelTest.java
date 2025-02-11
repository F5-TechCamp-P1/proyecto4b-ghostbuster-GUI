package dev.cachaguercus.proyecto4.enums;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class enumDangerLevelTest {
    @Test
    void testNumericLevelLow() {
        assertEquals(1, enumDangerLevel.BAJO.getNumericLevel());
    }

    @Test
    void testNumericLevelMedium() {
        assertEquals(2, enumDangerLevel.MEDIO.getNumericLevel());
    }

    @Test
    void testNumericLevelHigh() {
        assertEquals(3, enumDangerLevel.ALTO.getNumericLevel());
    }

    @Test
    void testNumericLevelCritical() {
        assertEquals(4, enumDangerLevel.CRITICO.getNumericLevel());
    }
}
