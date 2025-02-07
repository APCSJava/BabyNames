import java.util.ArrayList;

public class NameExplorer {

    /**
     * Task 1. Find the most popular name for a given year.
     *
     * @param year the year in question
     * @return the name assigned to the most babies
     */
    public static String annualMostPopularName(int year) {
        // TODO implement this method
        return null;
    }

    /**
     * Task 2. Find the most popular name assigned to a baby of the indicated sex
     *
     * @param year the year in question
     * @param sex, "M" or "F"
     * @return the name with the most occurrences
     */
    public static String annualMostPopularName(int year, String sex) {
        // TODO implement this method
        return null;
    }

    /**
     * Task 3. Finds a NameEntry matching the requested year, name and sex.
     *
     * @param year the year of interest
     * @param name the name to search for
     * @param sex  focus the lookup on babies of the specified sex
     * @return a reference to the name entry object or null if not match found
     */
    public static int lookup(int year, String name, String sex) {
        // TODO implement this method
        return 0;
    }

    /**
     * Task 4. Return the total number of babies of the given sex for the year.
     *
     * @param year
     * @return the number of babies born with the indicated sex
     */
    public static int annualBabyCount(int year, String sex) {
        // TODO implement this method
        return 0;
    }

    /**
     * Task 5. Return a count of the total number of named babies born during a
     * given year.
     *
     * @param year
     * @return the number of named babies born
     */
    public static int annualBabyCount(int year) {
        // TODO implement this method
        return 0;
    }

    /**
     * Task 6. Return a list holding the top ten names for the year, in decreasing
     * popularity, no matter the sex.
     *
     * @param year
     * @return the ten most popular names
     */
    public static ArrayList<String> topTenForYear(int year) {
        // TODO implement this method
        return null;
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
    public static int countAsSingleName(ArrayList<String> nicknames, int year) {
        // TODO implement this method
        return 0;
    }

    /**
     * Task 8. Returns an arraylist holding name entries for all years for which data
     * is available.
     *
     * @return combined name entry data from all available years
     */
    public static ArrayList<NameEntry> retrieveAllYears() {
        return null;
    }

    /**
     * Task 9.  Find the year in which a given name was most popular.
     *
     * @param name of interest
     * @return the NameEntry object of the year that name was most popular
     */
    public static NameEntry getMostPopularYear(String name) {
        // TODO implement this method
        return null;
    }

    /**
     * Task 10. Determine the name assigned to the most babies across all years
     * for which data is available.
     *
     */
    public static String mostPopularNameEver() {
        // TODO implement this method
        return null;
    }

    /**
     * Task 10. Examine the list and replace names that were given to both boys and girls with a new, single
     * name entry with the summed number of babies from each.  The original entries are removed from the list and
     * the combined entry instance shows sex as "-" to indicate that the sex is no longer exclusively "M" or "F".
     *
     * @param names a list in which to replace names given to both sexes with a single entry
     */
    public static void combineAcrossSex(ArrayList<NameEntry> names) {
        // TODO implement this method
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

        // In addition to implementing and testing the task methods above, research and answer the following:
        // Q1 - do boys or girls have more diverse naming?
        // Q2 - is there a difference in average name length between boys and girls?
        // Q3 - what have proven to be the most popular names over time?

    }
}
