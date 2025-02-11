package dev.cachaguercus.proyecto4.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;

import java.time.LocalDate;

import dev.cachaguercus.proyecto4.enums.enumDangerLevel;
import dev.cachaguercus.proyecto4.enums.enumGhostType;

public class GhostBusterModelTest {

    @Test
    @DisplayName("Should get GhostBuster name")
    void testGetGhostbusterModel() {

        GhostBusterModel ghostBuster = new GhostBusterModel();
        ghostBuster.setName("Cachaguercu");
        String name = ghostBuster.getName();

        assertEquals("Cachaguercu", name);
    }

    @Test
    @DisplayName("Should set GhostBuster name")
    void testSetGhostBusterModel() {
        GhostBusterModel ghostBuster = new GhostBusterModel();
        ghostBuster.setName("Cachaguercu");

        assertEquals(ghostBuster.getName(), "Cachaguercu");
    }

    @Test
    @DisplayName("Should add a new ghost to the trap")
    void testCaptureGhost() {
        GhostModel casper = new GhostModel(1, "casper", enumGhostType.CLASE_I, enumDangerLevel.BAJO, "aparecerse y sonreir", LocalDate.now());
        GhostBusterModel.captureGhost(casper);
        assertThat(GhostBusterModel.getGhostTrap(), contains(casper));
    }

    @Test
    @DisplayName("Should delete ghost from the trap")
    void testRemoveGhost() {
        GhostModel casper = new GhostModel(1, "casper", enumGhostType.CLASE_I, enumDangerLevel.BAJO, "aparecerse y sonreir", LocalDate.now());
        GhostBusterModel.captureGhost(casper);
        GhostBusterModel.removeGhost(casper);
        assertThat(GhostBusterModel.getGhostTrap(), not(contains(casper)));
    }



}
