package dev.cachaguercus.proyecto4.models;

import java.time.LocalDate;

import dev.cachaguercus.proyecto4.enums.enumDangerLevel;
import dev.cachaguercus.proyecto4.enums.enumGhostType;

public class GhostModel {
    private int id;
    private String name;
    private enumGhostType ghost_type;
    private enumDangerLevel danger_level;
    private String special_skill;
    private LocalDate capture_date;

    public GhostModel(int id, String name, enumGhostType ghost_type, enumDangerLevel danger_level, String special_skill,
            LocalDate capture_date) {
        this.id = id;
        this.name = name;
        this.ghost_type = ghost_type;
        this.danger_level = danger_level;
        this.special_skill = special_skill;
        this.capture_date = capture_date;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public enumGhostType getGhost_type() {
        return ghost_type;
    }

    public enumDangerLevel getDanger_level() {
        return danger_level;
    }

    public String getSpecial_skill() {
        return special_skill;
    }

    public LocalDate getCapture_date() {
        return capture_date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGhost_type(enumGhostType ghost_type) {
        this.ghost_type = ghost_type;
    }

    public void setDanger_level(enumDangerLevel danger_level) {
        this.danger_level = danger_level;
    }

    public void setSpecial_skill(String special_skill) {
        this.special_skill = special_skill;
    }

    public void setCapture_date(LocalDate capture_date) {
        this.capture_date = capture_date;
    }
}
