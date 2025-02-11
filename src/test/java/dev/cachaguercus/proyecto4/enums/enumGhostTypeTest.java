package dev.cachaguercus.proyecto4.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class enumGhostTypeTest {

    @Test
    @DisplayName("When the GB selects an option, the description displayed is the correct one")
    void testGetGhostType() {
        assertEquals("Manifestación menor", enumGhostType.CLASE_I.getGhostTypeDescription());
        assertEquals("Aparición móvil", enumGhostType.CLASE_II.getGhostTypeDescription());
        assertEquals("Entidad inteligente", enumGhostType.CLASE_III.getGhostTypeDescription());
        assertEquals("Fantasma histórico", enumGhostType.CLASE_IV.getGhostTypeDescription());
        assertEquals("Espíritu antropomorfo", enumGhostType.CLASE_V.getGhostTypeDescription());
        assertEquals("Espíritu demoníaco", enumGhostType.CLASE_VI.getGhostTypeDescription());
        assertEquals("Entidad ultraterrena", enumGhostType.CLASE_VII.getGhostTypeDescription());
    }
}
