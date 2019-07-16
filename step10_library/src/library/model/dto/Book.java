package library.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
	private String category;
	private String summary;
	private int publishingDate;
	private String publisher;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[�з� : ");
		builder.append(category);
		builder.append(", ���� : ");
		builder.append(summary);
		builder.append(", ���ǻ� : ");
		builder.append(publisher);
		builder.append(", �������� : ");
		builder.append(publishingDate);
		builder.append("]");
		return builder.toString();
	}
}
