public class NameData {

	private String year;
	private String name;
	private String gender;
	private int numBabies;

	public NameData(String year, String name, String gender,
			int number) {
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
		StringBuilder sb = new StringBuilder("{");
		sb.append(getName()+" (");
		sb.append(getYear()+", "+getGender()+"): ");
		sb.append(getNumBabies()+"}");
		return sb.toString();
	}
}
