package library.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LibraryInfo {
	private String bookName;
	private Book book;
	private Writer writer;
	private Borrower borrower;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("1. 도서명 : ");
		builder.append(bookName);
		builder.append("\n2. 도서 정보 : ");
		builder.append(book);
		builder.append("\n3. 저자 정보: ");
		builder.append(writer);
		builder.append("\n4. 대출자 정보: ");
		builder.append(borrower);
		return builder.toString();
	}

}
