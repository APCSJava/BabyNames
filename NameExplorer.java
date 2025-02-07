import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class NameExplorer {

    /**
     * Task 1. Find the most popular name for a given year.
     *
     * @param year the year in question
     * @return the name with the most occurrences
     */
    public static String mostPopularNameForYear(int year) {
        ArrayList<NameEntry> dataForYear = FileHandler.getDataForYear(year);
        NameEntry bestEntry = dataForYear.get(0);
        for (int i = 1; i < dataForYear.size(); i++) {
            NameEntry currentEntry = dataForYear.get(i);
            if (currentEntry.getNumBabies() > bestEntry.getNumBabies()) {
                bestEntry = currentEntry;
            }
        }
        return bestEntry.getName();
    }

    /**
     * Task 2. Find the most popular name for a year for the indicated sex.
     *
     * @param year the year in question
     * @param sex, "M" or "F"
     * @return the name with the most occurrences
     */
    public static String mostPopularNameForYearBySex(int year, String sex) {
        ArrayList<NameEntry> dataForYear = FileHandler.getDataForYear(year);
        NameEntry bestEntry = dataForYear.get(0);
        for (NameEntry currentEntry : dataForYear) {
            if (currentEntry.getSex().equals(sex)) {
                if (currentEntry.getNumBabies() > bestEntry.getNumBabies()) {
                    bestEntry = currentEntry;
                }
            }
        }
        return bestEntry.getName();
    }

    /**
     * Task 3. Look up the number of babies of the specified sex with the given name.
     *
     * @param year the year of interest
     * @param name the name to search for
     * @param sex  focus the lookup on babies of the specified sex
     * @return the number of babies given the specified name.
     */
    public static int lookup(int year, String name, String sex) {
        ArrayList<NameEntry> dataForYear = FileHandler.getDataForYear(year);
        for (NameEntry currentEntry : dataForYear) {
            if (name.equals(currentEntry.getName()) && sex.equals(currentEntry.getSex())) {
                return currentEntry.getNumBabies();
            }
        }
        return 0;
    }

    /**
     * Task 4. Return a count of all babies born of a specific sex in a given year.
     *
     * @param year
     * @return the number of babies born with the indicated sex
     */
    public static int numBabiesBySex(int year, String sex) {
        int count = 0;
        ArrayList<NameEntry> dataForYear = FileHandler.getDataForYear(year);
        for (NameEntry currentEntry : dataForYear) {
            if (sex.equals(currentEntry.getSex())) {
                count += currentEntry.getNumBabies();
            }
        }
        return count;
    }

    /**
     * Task 5. Return a count of the total number of named babies born during a
     * given year.
     *
     * @param year
     * @return the number of named babies born
     */
    public static int numBabiesTotal(int year) {
        ArrayList<NameEntry> dataForYear = FileHandler.getDataForYear(year);
        int total = 0;
        for (NameEntry currentEntry : dataForYear) {
            total += currentEntry.getNumBabies();
        }
        return total;
    }

    /**
     * Task 6. Return a list holding the top ten names for the year, in decreasing
     * popularity, no matter the sex.
     *
     * @param year
     * @return the ten most popular names
     */
    public static ArrayList<String> topTenForYear(int year) {
        ArrayList<NameEntry> dataForYear = FileHandler.getDataForYear(year);
        ArrayList<String> top10 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            NameEntry mostPopularEntry = dataForYear.get(0);
            for (int j = 0; j < dataForYear.size(); j++) {
                NameEntry currentEntry = dataForYear.get(j);
                if (currentEntry.getNumBabies() > mostPopularEntry.getNumBabies()) {
                    mostPopularEntry = currentEntry;
                }
            }
            top10.add(mostPopularEntry.getName());
            dataForYear.remove(mostPopularEntry); // don't want to find it again
        }
        return top10;
    }

    /**
     * Task 7.  Find the year in which the given name was most popular.
     *
     * @param name of interest
     * @return the NameEntry object of the year that name was most popular
     */
    public static NameEntry getMostPopularYear(String name) {
        ArrayList<NameEntry> completeList = new ArrayList<>();
        for (int year : FileHandler.getListOfYears()) {
            completeList.addAll(FileHandler.getDataForYear(year));
        }
        NameEntry mostPopularEntry = null;
        for (NameEntry currentEntry : completeList) {
            if (currentEntry.getName().equals(name)) {
                if (mostPopularEntry == null || currentEntry.getNumBabies() > mostPopularEntry.getNumBabies()) {
                    mostPopularEntry = currentEntry;
                }
            }
        }
        return mostPopularEntry;
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
    public static int countAsSingleName(List<String> nicknames, int year) {
        int total = 0;
        ArrayList<NameEntry> dataForYear = FileHandler.getDataForYear(year);
        for (String nickname : nicknames) {
            total += lookup(year, nickname, "M");
            total += lookup(year, nickname, "F");
        }
        return total;
    }

    /**
     * Task 9. Determine the most popular name ever given that starts with the specified letter.
     *
     * @param startingLetter the letter of interest
     */
    public static String mostPopularStartingWith(String startingLetter) {
        ArrayList<NameEntry> completeList = new ArrayList<>();
        for (int year : FileHandler.getListOfYears()) {
            completeList.addAll(FileHandler.getDataForYear(year));
        }
        NameEntry mostPopularEntry = null;
        for (NameEntry currentEntry : completeList) {
            if (startingLetter.equals(currentEntry.getName().substring(0, 1))) {
                if (mostPopularEntry == null) {
                    mostPopularEntry = currentEntry;
                }
                if (currentEntry.getNumBabies() > mostPopularEntry.getNumBabies()) {
                    mostPopularEntry = currentEntry;
                }
            }
        }
        return mostPopularEntry.getName();
    }

    /**
     * Task 10. Examine the list and replace names that were given to both boys and girls with a new, single
     * name entry with the summed number of babies from each.  The original entries are removed from the list and
     * the combined entry instance shows sex as "-" to indicate that the sex is no longer exclusively "M" or "F".
     *
     * @param year the year to affect
     * @param name a list in which to replace names given to both sexes with a single entry
     */
    public static void combineAcrossSex(String name, int year) {
        NameEntry male = null;
        NameEntry female = null;
        ArrayList<NameEntry> dataForYear = FileHandler.getDataForYear(year);
        for (int i = 0; i < dataForYear.size(); i++) {
            NameEntry currentEntry = dataForYear.get(i);
            if (currentEntry.getName().equals(name)) {
                if (currentEntry.getSex().equals("M")) {
                    male = currentEntry;
                    dataForYear.remove(i);
                    i--;
                } else if (currentEntry.getSex().equals("F")) {
                    female = currentEntry;
                    dataForYear.remove(i);
                    i--;
                }
            }
        }
        if (male != null && female != null) {
            NameEntry combined = new NameEntry(year, name, "-", male.getNumBabies()+female.getNumBabies());
            dataForYear.add(combined);
        }
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
        String mostPopularName1986 = mostPopularNameForYear(1986); // Michael
        System.out.println("The most popular name in 1986 was: " + mostPopularName1986);
        String mostPopularName1986Female = mostPopularNameForYearBySex(1986, "M"); // Jessica
        System.out.println("Most popular female name in 1986: " + mostPopularName1986Female);
        int lookup = lookup(1986, "Michael", "M");
        System.out.println("Lookup Michael in 1986: " + lookup); // 64227
        int maleBabyCount1986 = numBabiesBySex(1986, "M");
        System.out.println(maleBabyCount1986); // 1841466
        int totalBabyCount1986 = numBabiesTotal(1986);
        System.out.println(totalBabyCount1986); // 3556946
        ArrayList<String> topTenForYear = topTenForYear(1986);
        System.out.println(topTenForYear); // [Michael, Christopher, Jessica, Ashley, Matthew, Amanda, Joshua, David, Daniel, Jennifer]
        NameEntry mpy = getMostPopularYear("Michael");
        System.out.println(mpy); // [1957 Michael M 92777]
        ArrayList<String> collectedNames = new ArrayList<>();
        collectedNames.add("Michael");
        collectedNames.add("Mike");
        collectedNames.add("Mikey");
        int numMikes = countAsSingleName(collectedNames, 1986);
        System.out.println(numMikes); // 65146
        String nameX = mostPopularStartingWith("X");
        System.out.println(nameX); // Xavier
        combineAcrossSex("Michael", 1986);



        // In addition to implementing and testing the task methods above, research and answer the following:
        // Q1 - do boys or girls have more diverse naming?
        // Q2 - is there a difference in average name length between boys and girls?
        // Q3 - what have proven to be the most popular names over time?

    }
}
