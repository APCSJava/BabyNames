import javax.naming.Name;
import java.io.File;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
                .filter(e->e.getSex().equals(sex))
                .sorted((e1, e2)-> e2.getNumBabies()-e1.getNumBabies())
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
                .filter(e->e.getName().equals(name))
                .filter(e-> e.getSex().equals(sex))
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
                .filter(e->e.getSex().equals(sex))
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
        return  new ArrayList<>(FileHandler.getDataForYear(year).stream()
                .sorted((e1, e2)-> e2.getNumBabies()-e1.getNumBabies())
                .limit(10)
                .map(NameEntry::getName)
                .toList());
    }

    /**
     * Task 7. Often, several names might be considered nicknames for a common name.
     * For example, "William", "Will", "Bill", "Billy", "Willie", and "Willy" are
     * all derived from the base name "William". Write a method that accepts an
     * array/list of names (strings) and returns the total count for all.
     *
     * @param nicknames a list of string names
     * @param year      the year of interest
     */
    public static int tallyAsSingleName(ArrayList<String> nicknames, int year) {
        return FileHandler.getDataForYear(year).stream()
                .filter(e->nicknames.contains(e.getName()))
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
                .forEach(y->FileHandler.getDataForYear(y).stream()
                        );

    }

    /**
     * Task 9.  Find the year in which a given name was most popular.
     *
     * @param name of interest
     * @return the NameEntry object of the year that name was most popular
     */
    public static NameEntry mostPopularYearForName(String name) {
        // TODO implement this method
        return null;
    }

    /**
     * Task 10. Determine the most popular entry across all years
     * for which data is available.
     *
     */
    public static NameEntry mostPopularEntry() {
        // TODO implement this method
        return null;
    }

    /**
     * Task 11. If the name is assigned to both girls and boys, replace the original entries
     * with a new, single entry having the same total number of babies.  The original entries
     * are removed from the list and replaced with the combined entry.  The sex attribute
     * for the combined entry is presented as "X" in place of "M" or "F".
     *
     * @param name the name assigned
     * @return a reference to the newly created merged name object
     */
    public static NameEntry mergeNameBetweenSexes(String name, int year) {
        // TODO implement this method
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
        // Test cases and expected values
        System.out.println(annualMostPopularName(1986)); // Michael
        System.out.println(annualMostPopularName(1986, "F")); // Jessica
        System.out.println(lookup(1986, "Michael", "M")); // [1986 Michael M 64227]
        System.out.println(annualBabyCount(1986, "M")); // 1841466
        System.out.println(annualBabyCount(1986)); // 3556946
        System.out.println(topTenForYear(1986)); // [Michael, Christopher, Jessica, Ashley, Matthew, Amanda, Joshua, David, Daniel, Jennifer]
        System.out.println(retrieveAllYears()); //
        System.out.println(mostPopularYearForName("Michael")); // [1957 Michael M 92777]
        ArrayList<String> collectedNames = new ArrayList<>();
        collectedNames.add("Michael");
        collectedNames.add("Mike");
        collectedNames.add("Mikey");
        System.out.println(tallyAsSingleName(collectedNames, 1986)); // 65146
        System.out.println(mergeNameBetweenSexes("Michael", 1986)); // [1986 Michael X ???]

        // In addition to implementing and testing the task methods above, research and answer the following:
        // Q1 - do boys or girls have more diverse naming?
        // Q2 - is there a difference in average name length between boys and girls?
        // Q3 - what have proven to be the most popular names over time?

    }
}
