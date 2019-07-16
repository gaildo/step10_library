package library.view;

import java.time.LocalDate;

import library.controller.LibraryController;
import library.model.dto.Book;
import library.model.dto.Borrower;
import library.model.dto.LibraryInfo;
import library.model.dto.Writer;

public class StartView {

	public static void main(String[] args) {

		LibraryController controller = LibraryController.getInstance();

		// 도서 내용
		Book book5 = new Book("교양인문", "공부하는 방법에대해서 알려준다", 20180503, "책구루");
		// 저자 이름
		Writer Writer5 = new Writer("최승필", 54, "교육/과학", "여기는 함께섬 정치를 배웁니다");
		// 대출자
		Borrower Borrower5 = new Borrower("김수지", 28, "신림", LocalDate.of(2019,07,13), LocalDate.of(2019,07,13).plusDays(13), "");
		// 도서 이름
		LibraryInfo Library5 = new LibraryInfo("공부머리 독서법", book5, Writer5, Borrower5);

		// 모든 도서 검색
		System.out.println("***** 1. 도서정보 생성 후 모든 도서목록 검색 *****");
		controller.bookListView();
		System.out.println();

		// 새로운 도서 저장
		System.out.println("***** 2. 새로운 도서 저장 후  모든 도서 검색 *****");
		controller.insertBook(Library5);
		controller.bookListView();

		System.out.println();

		// 존재하는 도서 검색
		System.out.println("***** 3. 존재하는 도서 검색 *****");
		controller.bookView("공부머리 독서법");
	
		System.out.println();

		System.out.println("***** 4. 미존재하는 도서 검색 - 예외처리 확인용 *****");
		controller.bookView("개미---");

		System.out.println();

		// 특정작가 도서 검색
		String searchWriter = "김영하";
		System.out.println("***** 5. 특정작가 도서 검색 [" + searchWriter + "] *****");
		controller.writerView(searchWriter);

		// 존재하는 도서 업데이트 test
		System.out.println("***** 6. 존재하는 도서 수정 후 수정한 도서 검색 *****");
		controller.updateBook("유럽 도시기행1", new Borrower("김철수", 33, "나래마루", LocalDate.of(2019,06,30), LocalDate.of(2019,06,30).plusDays(13), ""));
		controller.bookView("유럽 도시기행1");

		System.out.println();

		// 미 존재하는 도서 업데이트 test : 예외 발생
		System.out.println("***** 7. 미존재하는 도서 수정 - 예외처리 확인용 *****");
		controller.updateBook("백제", new Writer("김정군", 55, "역사", "고구려"));

		System.out.println();

		// 삭제한 도서 검색
		System.out.println("***** 8. 도서 삭제 후 해당 도서 검색 *****");
		controller.deleteBook("공부머리 독서법");
		controller.bookView("공부머리 독서법");
		
		System.out.println();
		
		// 연체 도서 업데이트
		System.out.println("***** 9. 연체 정보 업데이트 후 모든(연체)도서 목록 검색 *****");
		controller.updateOverdueStatus();
		controller.overdueBookList();
		
		System.out.println();
		
		// 모든 도서 제이슨 출력
		System.out.println("***** 10. 모든도서 제이슨 변환 및 출력 *****");
		controller.jsongetAllBooks();
	}
}
