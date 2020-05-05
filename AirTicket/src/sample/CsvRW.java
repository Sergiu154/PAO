package sample;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvRW {

    private static CsvRW instance = null;


    private CsvRW() {
    }

    // singleton instance
    public static CsvRW getInstance() {

        if (instance == null)
            instance = new CsvRW();

        return instance;
    }


    /**
     * generic function which takes as parameters the path to a csv file and
     * FuncitionlMapInteface<T> f - a generic functional interface which reads a line of the csv file, parses it and returns an object of type
     * return type: a list of objects of type T, containing the lines of the csv file "path"
     */
    public <T> List<T> readCSV(String path, FunctionalMapInterface<T> f) {

        List<T> linii = new ArrayList<>();

        boolean readHeader = false;
        String line = "";
        String sep = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            while ((line = br.readLine()) != null) {

                if (!readHeader) {
                    // skip header
                    readHeader = true;
                    String[] elements = line.split(",");
                } else {

                    T row = f.mapLine(line);
                    linii.add(row);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return linii;

    }

    public void writeCSV(String path, String line) {

        // am prespus ca toate csv-urile mele, chiar daca nu au date
        // au prima linie cu denumirile coloanelor completata

        try (BufferedWriter br = new BufferedWriter(new FileWriter(path, true))) {
            br.append(line).append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
