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
		builder.append("[분류 : ");
		builder.append(category);
		builder.append(", 내용 : ");
		builder.append(summary);
		builder.append(", 출판사 : ");
		builder.append(publisher);
		builder.append(", 출판일자 : ");
		builder.append(publishingDate);
		builder.append("]");
		return builder.toString();
	}
}
