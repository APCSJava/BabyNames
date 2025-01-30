/***
 * Provides a source of data based on US Social Security registered
 * birth names between 1880 and 2023, inclusive.
 *
 * Source: https://www.ssa.gov/oact/babynames/limits.html
 *
 * Records are provided as NameData objects that associate a given name
 * with the gender of the baby and the total number of babies assigned
 * that name during a particular year.
 *
 * K Collins, Spring 2018, revised 2025

 */

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class NameDatabase {

    private static ArrayList<NameEntry> entries;

    static {
        initializeNameData();
    }

    /**
     * Collect a list of all years for which data is available.
     *
     * @return a list of years as strings
     */
    public static ArrayList<String> getAvailableYears() {
        List<String> collect = entries.stream().map(e -> e.getYear()).distinct().collect(Collectors.toList());
        Collections.sort(collect);
        return new ArrayList<>(collect);
    }

    /**
     * Retrieves a list of NameData entries for the given year.
     *
     * @param year of interest
     * @return a list of NameData entries
     */
    public static ArrayList<NameEntry> getDataForYear(String year) {
        List<NameEntry> collect = entries.stream().filter(e -> year.equals(e.getYear())).collect(Collectors.toList());
        Collections.sort(collect, Comparator.comparingInt(NameEntry::getNumBabies));
        Collections.reverse(collect);
        return new ArrayList<>(collect);
    }

    public static ArrayList<NameEntry> getAllData(){
        return new ArrayList<>(entries); // return a copy of the references to avoid data corruption
    }

    private static void initializeNameData() {
        entries = new ArrayList<>();
        File directory = new File(
                NameDatabase.class.getResource("/names/").getFile());
        File[] files = directory.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith("txt");
            }
        });
        try {
            assert files != null;
            for (File f : files) {
                String year = f.getName().substring(3,
                        f.getName().indexOf('.'));
                List<String> lines = Files
                        .readAllLines(Paths.get(f.getPath()));
                for (String line : lines) {
                    String[] data = line.split(",");
                    String name = data[0];
                    String gender = data[1];
                    int number = Integer.parseInt(data[2]);
                    NameEntry nd = new NameEntry(year, name, gender, number);
                    entries.add(nd);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
