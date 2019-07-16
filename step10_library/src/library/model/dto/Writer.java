package library.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Writer extends People {
	private String mainGenre;
	private String major;
	
	public Writer(String name, int age, String mainGenre,String major) {
		super(name, age);
		this.mainGenre = mainGenre;
		this.major = major;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append(", ��ǥ �о� : ");
		builder.append(mainGenre);
		builder.append(", ��ǥ�� : ");
		builder.append(major);
		builder.append("]");
		return builder.toString();
	}
}
