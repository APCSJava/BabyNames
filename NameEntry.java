public class NameEntry {

	private final String year;
	private final String name;
	private final String gender;
	private final int numBabies;

	public NameEntry(String year, String name, String gender, int number) {
		this.year = year;
		this.name = name;
		this.gender = gender;
		this.numBabies = number;
	}

	public String getYear() {
		return year;
	}

	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

	public int getNumBabies() {
		return numBabies;
	}
	
  public String toString() {
		return "["+ year + " " + name + " " + gender + " " + numBabies + "]";
  }
}
