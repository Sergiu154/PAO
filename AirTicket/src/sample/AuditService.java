package sample;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AuditService {

    private AuditService() {
    }

    private static AuditService oneInstance = null;


    public static AuditService getInstance() {

        if (oneInstance == null)
            oneInstance = new AuditService();

        return oneInstance;
    }

    public void logAction(String action) {

        String date = new SimpleDateFormat("dd-MM-yyyy-HH:mm:ss").format(new Date());
        try (FileWriter fout = new FileWriter("src/csvFiles/logs.csv", true)) {
            fout.append(action).append(",").append(date).append("\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
