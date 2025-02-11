package dev.cachaguercus.proyecto4.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import dev.cachaguercus.proyecto4.enums.enumDangerLevel;
import dev.cachaguercus.proyecto4.enums.enumGhostType;
import java.time.LocalDate;

public class GhostModelTest {

    @Test
    @DisplayName("when the GB selects a ghost, all the expected info is provided")
    void testGetGhostModel() {

        GhostModel ghost1 = new GhostModel(1, "ghost1", enumGhostType.CLASE_I, enumDangerLevel.ALTO, "vomitar verde", LocalDate.now());

        int id = ghost1.getId();
        String name = ghost1.getName();
        enumGhostType ghost_type = ghost1.getGhost_type();
        enumDangerLevel danger_level = ghost1.getDanger_level();
        String special_skill = ghost1.getSpecial_skill();
        LocalDate local_date = ghost1.getCapture_date();

        assertEquals(1, id);
        assertEquals("ghost1", name);
        assertEquals(enumGhostType.CLASE_I, ghost_type);
        assertEquals(enumDangerLevel.ALTO, danger_level);
        assertEquals("vomitar verde", special_skill);
        assertEquals(LocalDate.now(), local_date);
    }

    @Test
    @DisplayName("when the GB captures a ghost, they provide the expected info")
    void testSetGhostModel() {
        GhostModel ghost2 = new GhostModel(0, null, null, null, null, null);

        ghost2.setName("ghost2");
        ghost2.setGhost_type(enumGhostType.CLASE_II);
        ghost2.setDanger_level(enumDangerLevel.CRITICO);
        ghost2.setSpecial_skill("vomitar azul");    
        ghost2.setCapture_date(LocalDate.now());

        assertEquals("ghost2", ghost2.getName());
        assertEquals(enumGhostType.CLASE_II, ghost2.getGhost_type());
        assertEquals(enumDangerLevel.CRITICO, ghost2.getDanger_level());
        assertEquals("vomitar azul", ghost2.getSpecial_skill());
        assertEquals(LocalDate.now(), ghost2.getCapture_date());
    }
    
}
