import java.util.List;
import java.util.ArrayList;

public class NameExplorer {

    /**
     * Task 1. Find the most popular name for a given year.
     *
     * @param year the year in question
     * @return the name with the most occurrences
     */
    public static String mostPopularNameForYear(String year) {
        // TODO implement this method
        return null;
    }

    /**
     * Task 2. Find the most popular name for a year for the indicated sex.
     *
     * @param year the year in question
     * @param sex, "M" or "F"
     * @return the name with the most occurrences
     */
    public static String mostPopularNameForYearBySex(String year, String sex) {
        // TODO implement this method
        return null;
    }

    /**
     * Task 3. Look up the number of babies of the specified sex with the given name.
     *
     * @param year the year of interest
     * @param name the name to search for
     * @param sex focus the lookup on babies of the specified sex
     * @return the number of babies given the specified name.
     */
    public static int lookup(int year, int name, String sex) {
        // TODO implement this method
        return 0;
    }

    /**
     * Task 4. Return a count of all babies born of a specific sex in a given year.
     *
     * @param year
     * @return the number of babies born with the indicated sex
     */
    public static int numBabiesBySex(String year, String sex) {
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
    public static int numBabiesTotal(String year) {
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
    public static ArrayList<String> topTenForYear(String year) {
        // TODO implement this method
        return null;
    }

    /**
     * Task 7.  Find the year in which the given name was most popular.
     *
     * @param name of interest
     * @return the NameEntry object of the year that name was most popular
     */
    public static NameEntry getMostPopularYear(String name) {
        // TODO implement this method
        return null;
    }

    /**
     * Task 8. Often, several names might be considered nicknames for a common name.
     * For example, "William", "Will", "Bill", "Billy", "Willie", and "Willy" are
     * all derived from the base name "William". Write a method that accepts an
     * array/list of names (strings) and returns the total count for all.
     *
     * @param nicknames a list of string names
     * @param year      the year of interest
     */
    public static int countAsSingleName(List<String> nicknames, String year) {
        // TODO implement this method
        return 0;
    }

    /**
     * Task 9. Determine the most popular name ever given that starts with the specified letter.
     *
     * @param startingLetter the letter of interest
     */
    public static String mostPopularStartingWith(String startingLetter) {
        // TODO implement this method
        return null;
    }

    /**
     * Task 10. Examine the list and replace names that were given to both boys and girls with a new, single
     * name entry with the summed number of babies from each.  The original entries are removed from the list and
     * the combined entry instance shows sex as "-" to indicate that the sex is no longer exclusively "M" or "F".
     * @param names a list in which to replace names given to both sexes with a single entry
     */
    public static void combineAcrossSex(ArrayList<NameEntry> names) {
        // TODO implement this method
    }

    /**
     * Binary Search Challenge -- search for the given name in the provided arraylist using a binary search.
     * Print the number of guesses and the index of the name.  Remember that in order for binary search to be
     * successful, the entries in the list must be in sorted order.
     * @param names a sorted arraylist
     *   @param target a name to search for in the list
     */
    public static void binarySearch(ArrayList<NameEntry> names, String target) {
        // print the index of the name and the number of guesses to locate
    }

    public static void main(String[] args) {
        String mostPopularName1986 = mostPopularNameForYear("1986"); // Michael
        System.out.println("The most popular name in 1986 was: " + mostPopularName1986);
        String mostPopularName1986Female = mostPopularNameForYearBySex("1986", "F"); // Jessica
        System.out.println("Most popular female name in 1986: " + mostPopularName1986Female);

        // In addition to implementing and testing the task methods above, research and answer the following:
        // Q1 - do boys or girls have more diverse naming?
        // Q2 - is there a difference in average name length between boys and girls?
        // Q3 - what have proven to be the most popular names over time?

    }
}
