package voteProject;

public class candidateDto {
	String name;
	int count;
	
	public candidateDto(String name, int count) {
		this.name = name;
		this.count = count;
	}

	public candidateDto() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
