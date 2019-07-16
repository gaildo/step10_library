package library.model.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Borrower extends People {
	private String region;
	private LocalDate borrowDate;
	private LocalDate returnDate;
	private String status;

	public Borrower(String name, int age, String region, LocalDate borrowDate, LocalDate returnDate, String status) {
		super(name, age);

		this.region = region;
		this.borrowDate = borrowDate;
		this.returnDate = returnDate;
		this.status = status;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		if (super.getName().equals("대출가능")) {
			builder.append("대출 가능한 도서입니다");
		} else {
			builder.append(super.toString());
			builder.append(", 지역 : ");
			builder.append(region);
			builder.append(", 대출일자 : ");
			builder.append(borrowDate);
			builder.append(", 반납일자 : ");
			builder.append(returnDate);
			builder.append(" ");
			builder.append(status);
			builder.append("]");
		}
		return builder.toString();
	}
}
