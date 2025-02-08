import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NameExplorer {

    /**
     * Task 1. Find the most popular name for a given year.
     *
     * @param year the year in question
     * @return the name assigned to the most babies
     */
    public static String annualMostPopularName(int year) {
        return FileHandler.getDataForYear(year).stream()
                .sorted((e1, e2) -> e2.getNumBabies() - e1.getNumBabies())
                .limit(1)
                .toList()
                .getFirst()
                .getName();
    }

    /**
     * Task 2. Find the most popular name assigned to a baby of the indicated sex
     *
     * @param year the year in question
     * @param sex, "M" or "F"
     * @return the name with the most occurrences
     */
    public static String annualMostPopularName(int year, String sex) {
        return FileHandler.getDataForYear(year).stream()
                .filter(e -> e.getSex().equals(sex))
                .sorted((e1, e2) -> e2.getNumBabies() - e1.getNumBabies())
                .limit(1)
                .toList()
                .getFirst()
                .getName();
    }

    /**
     * Task 3. Finds a NameEntry matching the requested year, name and sex.
     *
     * @param year the year of interest
     * @param name the name to search for
     * @param sex  focus the lookup on babies of the specified sex
     * @return a reference to the name entry object or null if not match found
     */
    public static NameEntry lookup(int year, String name, String sex) {

        return FileHandler.getDataForYear(year).stream()
                .filter(e -> e.getName().equals(name))
                .filter(e -> e.getSex().equals(sex))
                .toList()
                .getFirst();
    }

    /**
     * Task 4. Return the total number of babies of the given sex for the year.
     *
     * @param year
     * @return the number of babies born with the indicated sex
     */
    public static int annualBabyCount(int year, String sex) {
        return FileHandler.getDataForYear(year).stream()
                .filter(e -> e.getSex().equals(sex))
                .mapToInt(NameEntry::getNumBabies)
                .sum();
    }

    /**
     * Task 5. Return a count of the total number of named babies born during a
     * given year.
     *
     * @param year
     * @return the number of named babies born
     */
    public static int annualBabyCount(int year) {
        return FileHandler.getDataForYear(year).stream()
                .mapToInt(NameEntry::getNumBabies)
                .sum();
    }

    /**
     * Task 6. Return a list holding the top ten names for the year, in decreasing
     * popularity, no matter the sex.
     *
     * @param year
     * @return the ten most popular names
     */
    public static ArrayList<String> topTenForYear(int year) {
        return new ArrayList<>(FileHandler.getDataForYear(year).stream()
                .sorted((e1, e2) -> e2.getNumBabies() - e1.getNumBabies())
                .limit(10)
                .map(NameEntry::getName)
                .toList());
    }

    /**
     * Task 7. Often, several names might be considered nicknames for a common name.
     * For example, "Michael", "Mike", "Mikey" are all derived from the root name
     * "Michael". Write a method that accepts a list of names and returns the total
     * number of babies for a given year.
     *
     * @param nicknames a list of string names
     * @param year      the year of interest
     */
    public static int tallyAsSingleName(ArrayList<String> nicknames, int year) {
        return FileHandler.getDataForYear(year).stream()
                .filter(e -> nicknames.contains(e.getName()))
                .mapToInt(NameEntry::getNumBabies)
                .sum();
    }

    /**
     * Task 8. Returns an arraylist holding name entries for all years for which data
     * is available.
     *
     * @return combined name entry data from all available years
     */
    public static ArrayList<NameEntry> retrieveAllYears() {
        return FileHandler.getListOfYears().stream()
                .flatMap(y -> FileHandler.getDataForYear(y).stream())
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Task 9.  Find the entry for the year in which a given name was assigned
     * to the most babies.
     *
     * @param name of interest
     * @return the annual entry with the most number of babies
     */
    public static NameEntry mostPopularEntryForName(String name) {
        return retrieveAllYears().stream()
                .filter(e -> e.getName().equals(name))
                .sorted((e1, e2) -> e2.getNumBabies() - e1.getNumBabies())
                .toList()
                .getFirst();
    }

    /**
     * Task 10. Determine the most popular entry across all years
     * for which data is available.
     */
    public static NameEntry mostPopularEntryEver() {
        return retrieveAllYears().stream()
                .sorted(Comparator.comparing(NameEntry::getNumBabies).reversed())
                .limit(1)
                .toList()
                .getFirst();
    }

    /**
     * Task 11. If the name is assigned to both girls and boys in this year, create
     * a new name entry having the sum of male and female babies but with the sex
     * attribute designated as "X" instead of "M" or "F".
     *
     * @return a reference to the newly created merged name object
     */
    public static NameEntry mergeNameBetweenSexes(String name, int year) {
        Map<String, List<NameEntry>> collect = FileHandler.getDataForYear(year).stream()
                .filter(e -> e.getName().equals(name))
                .collect(Collectors.groupingBy(NameEntry::getSex));
        if (collect.containsKey("M") && collect.containsKey("F")) {
            int sum = collect.values().stream()
                    .flatMap(List::stream)
                    .mapToInt(NameEntry::getNumBabies)
                    .sum();
            return new NameEntry(year, name, "X", sum);
        }
        return null; // if no merging occurs (i.e. name not found or not assigned to both sexes)
    }

    /**
     * Binary Search Challenge -- search for the given name in the provided arraylist using a binary search.
     * Print the number of guesses and the index of the name.  Remember that in order for binary search to be
     * successful, the entries in the list must be in sorted order.
     *
     * @param names  a sorted arraylist
     * @param target a name to search for in the list
     */
    public static void binarySearch(ArrayList<NameEntry> names, String target) {
        // print the index of the name and the number of guesses to locate
    }

    public static void main(String[] args) {
        System.out.println("Task 1: " + annualMostPopularName(1986));
        // Task 1: Michael
        System.out.println("Task 2: " + annualMostPopularName(1986, "F"));
        // Task 2: Jessica
        System.out.println("Task 3: " + lookup(1986, "Michael", "M"));
        // Task 3: [1986 Michael M 64227]
        System.out.println("Task 4: " + annualBabyCount(1986, "M"));
        // Task 4: 1841466
        System.out.println("Task 5: " + annualBabyCount(1986));
        // Task 5: 3556946
        System.out.println("Task 6: " + topTenForYear(1986));
        // Task 6: [Michael, Christopher, Jessica, Ashley, Matthew, Amanda, Joshua, David, Daniel, Jennifer]
        ArrayList<String> collectedNames = new ArrayList<>();
        collectedNames.add("Michael");
        collectedNames.add("Mike");
        collectedNames.add("Mikey");
        System.out.println("Task 7: " + tallyAsSingleName(collectedNames, 1986));
        // Task 7: 65146
        ArrayList<NameEntry> allData = retrieveAllYears();
        System.out.println("Task 8: " + (allData == null ? 0 : allData.size()));
        // Task 8: 2117219
        System.out.println("Task 9: " + mostPopularEntryForName("Michael"));
        // Task 9: [1957 Michael M 92777]
        System.out.println("Task 10: " + mostPopularEntryEver());
        // Task 10: [1947 Linda F 99693]
        System.out.println("Task 11: " + mergeNameBetweenSexes("Michael", 1986));
        // Task 11: [1986 Michael X 64817]

        // In addition to implementing and testing the task methods above, research and answer the following:
        // Q1 - do boys or girls have more diverse naming?
        // Q2 - is there a difference in average name length between boys and girls?
        // Q3 - what have proven to be the most popular names over time?

    }
}
