package dev.cachaguercus.proyecto4.models;

import java.util.ArrayList;
import java.util.List;

public class GhostBusterModel {
    private static List<GhostModel> ghostTrap = new ArrayList<GhostModel>();
    private String name;

    public GhostBusterModel() {
    }

    public static List<GhostModel> getGhostTrap() {
        return ghostTrap;
    }

    public static void captureGhost(GhostModel ghost) {
        ghostTrap.add(ghost);
    }

    public static void removeGhost(GhostModel ghost) {
        ghostTrap.remove(ghost);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
