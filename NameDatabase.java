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

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class NameDatabase {

    /**
     * Collect a list of all years for which data is available.
     *
     * @return a list of years as strings
     */
    public static ArrayList<Integer> getAvailableYears() {
        ArrayList<Integer> years = new ArrayList<>();
        File directory = new File("names/");
        File[] files = directory.listFiles((dir, name) -> name.startsWith("yob") && name.endsWith(".txt"));

        if (files != null) {
            for (File file : files) {
                String year = file.getName().substring(3, 7);
                years.add(Integer.parseInt(year));
            }
        }
        Collections.sort(years);
        return years;
    }


    /**
     * Retrieves a list of NameEntry instances for the given year.
     *
     * @param year of interest
     * @return a list of NameEntry references
     */
    public static ArrayList<NameEntry> getDataForYear(int year) {
        ArrayList<NameEntry> entries = new ArrayList<>();
        String filename = "names/yob" + year + ".txt";

        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");
                String name = data[0];
                String gender = data[1];
                int number = Integer.parseInt(data[2]);
                NameEntry nd = new NameEntry(year, name, gender, number);
                entries.add(nd);
            }
        } catch (FileNotFoundException e) {
            // File not found or other issues, return empty ArrayList
            System.err.println("Error reading file for year " + year + ": " + e.getMessage());
        }
        return entries;
    }


    public static void writeDataToFile(String filename, ArrayList<NameEntry> entries) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (NameEntry entry : entries) {
                writer.println(entry.getYear() + "," + entry.getName() + "," +
                        entry.getGender() + "," + entry.getNumBabies());
            }
        } catch (IOException e) {
            System.err.println("Error writing to file " + filename + ": " + e.getMessage());
        }
    }
}
