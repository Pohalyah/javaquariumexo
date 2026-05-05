package fr.afpa;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class Loggers {

    public static void createLog(String texte) {
        try (BufferedWriter newLog = new BufferedWriter(new FileWriter("logs.txt", true))) {
            newLog.write(texte);
            newLog.newLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
