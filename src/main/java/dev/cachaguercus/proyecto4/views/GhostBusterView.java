package dev.cachaguercus.proyecto4.views;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.util.List;

import dev.cachaguercus.proyecto4.enums.enumDangerLevel;
import dev.cachaguercus.proyecto4.enums.enumGhostType;
import dev.cachaguercus.proyecto4.models.GhostBusterModel;
import dev.cachaguercus.proyecto4.models.GhostModel;

public class GhostBusterView {

    public String displayWelcomeMessage() {
        String message = "\n" +
                "============================================================\n" +
                "    ¡Bienvenido a la Base Ghostbusters Asturias!\n" +
                "    Gestiona tus fantasmas atrapados y protege la región\n" +
                "============================================================\n" +
                "\n" +
                "Introduce tu nombre: ";
        System.out.println(message);
        return message;
    }

    public String displayInitialMenu() {
        String message = "\n" +
                "============================================\r\n" +
                "OPCIONES:\n" +
                "============================================\r\n" +
                "1. Capturar un nuevo fantasma\n" +
                "2. Ver lista de fantasmas capturados\n" +
                "3. Liberar un fantasma\n" +
                "4. Salir\n" +
                "============================================\r\n" +
                "\n" +
                "Por favor, selecciona una opción (1-4):";
        System.out.println(message);
        return message;
    }

    public String displayCaptureGhost() {
        String message = "\r\n" +
                "============================================\r\n" +
                "CAPTURAR UN NUEVO FANTASMA\r\n" +
                "============================================\r\n" +
                "\n" +
                "Ingresa el nombre del fantasma: ";
        System.out.println(message);
        return message;
    }

    public String displayGhostTypes(){
        String message ="\r\n" +
                "============================================\r\n" +
                "SELECCIONA LA CLASE DEL FANTASMA:\r\n" +
                "============================================\r\n" +
                "1. Clase I - Manifestación menor\r\n" +
                "2. Clase II - Aparición móvil\r\n" +
                "3. Clase III - Entidad inteligente\r\n" +
                "4. Clase IV - Fantasma histórico\r\n" +
                "5. Clase V - Espíritu antropomorfo\r\n" +
                "6. Clase VI - Espíritu demoníaco\r\n" +
                "7. Clase VII - Entidad ultraterrena\r\n" +
                "============================================\r\n" +
                "\n";
        System.out.println(message);
        return message;
    }

    public String displayDangerLevels(){
        String message = "\r\n" +
            "============================================\r\n" +
            "SELECCIONA EL NIVEL DE PELIGRO:\r\n" +
            "============================================\r\n" +
            "1. Bajo\r\n" +
            "2. Medio\r\n" +
            "3. Alto\r\n" +
            "4. Crítico\r\n" +
            "============================================\r\n" +
            "\n";
        System.out.println(message);
        return message;
    }

    public String displaySpecialSkill(){
        String message = "\r\n" +
            "============================================\r\n" +
            "HABILIDAD ESPECIAL DEL FANTASMA:\r\n" +
            "============================================\r\n" +
            "\n" +
            "Añade una habilidad especial: ";
        System.out.println(message);
        return message;
    }

    public String displaySuccessfulCapture(String name, LocalDate capture_date) {
        String message = MessageFormat.format("\r\nFantasma {0} capturado exitosamente con buen nivel de afinidad ectoplásmica {1}.", name, capture_date);
        System.out.println(message);
        return message;
    }

    public String displayGhostTrap(){
        List<GhostModel> list = GhostBusterModel.getGhostTrap();
        String tableline;
        StringBuilder table = new StringBuilder();
        table.append("\r\n")
                .append("==================================================================\r\n")
                .append("ID Nombre      Clase     Nivel de Peligro  Fecha de Captura\r\n")
                .append("==================================================================\r\n");
        for (GhostModel ghost : list) {
            int id = ghost.getId();
            String name = ghost.getName();
            enumGhostType type = ghost.getGhost_type();
            enumDangerLevel danger = ghost.getDanger_level();
            LocalDate capture_date = ghost.getCapture_date();

            tableline = MessageFormat.format("{0} {1} {2} {3} {4}", id, name, type, danger, capture_date);
            table.append("\r\n")
            .append(tableline);
        }
        String message = table.toString();
        System.out.println(message);
        return message;
    }

    public String displayReleaseGhost(){
        String message = "\r\n" +
            "============================================\r\n" +
            "LIBERA UN FANTASMA\r\n" +
            "============================================\r\n" +
            "\n" +
            "Ingresa el nombre del fantasma que quieres liberar: ";
        System.out.println(message);
        return message;
    }

    public String displaySuccessfulRelease(){
        String message = "\r\n" +
            "============================================\r\n" +
            "Fantasma liberado con éxito\r\n" +
            "============================================\r\n";
        System.out.println(message);
        return message;
    }

    public String displayExitMessage(){
        String message = "\r\n" +
                        "====================================================\n" +
                        "    \n" + "¡Gracias por proteger Asturias!\n" +
                        "\n" +
                        "    ¡Nos vemos en la próxima cacería paranormal!\n" +
                        "====================================================\n";
        System.out.println(message);
        return message;
    }

}
