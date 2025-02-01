public class NameEntry {

	private final int year;
	private final String name;
	private final String sex;
	private final int numBabies;

	public NameEntry(int year, String name, String sex, int number) {
		this.year = year;
		this.name = name;
		this.sex = sex;
		this.numBabies = number;
	}

	public int getYear() {
		return year;
	}

	public String getName() {
		return name;
	}

	public String getSex() {
		return sex;
	}

	public int getNumBabies() {
		return numBabies;
	}
	
  public String toString() {
		return "["+ year + " " + name + " " + sex + " " + numBabies + "]";
  }
}
