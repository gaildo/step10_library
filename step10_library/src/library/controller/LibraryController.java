package library.controller;

import java.util.ArrayList;

import library.exception.NotExistException;
import library.model.dto.LibraryInfo;
import library.model.dto.People;
import library.service.LibraryService;
import library.view.EndView;
import library.view.FailView;
import net.sf.json.JSONArray;

public class LibraryController {

	private static LibraryController instance = new LibraryController();
	private LibraryService service = LibraryService.getInstance();

	private LibraryController() {}

	public static LibraryController getInstance() {
		return instance;
	}

	// 모든 도서 검색
	public void bookListView() {
		ArrayList<LibraryInfo> bookList = service.getAllBookInfo();
		if (bookList.size() != 0) {
			EndView.bookListView(bookList);
		} else {
			EndView.messageView("현재 보유중인 도서가 없습니다");
		}
	}

	// 특정 도서 검색
	public void bookView(String bookName) {
		LibraryInfo book = service.getBookInfo(bookName);
		if (book != null) {
			EndView.bookView(book);
		} else {
			EndView.messageView("검색 요청하신 도서는 존재하지 않습니다.");
		}
	}

	// 저자 검색
	public void writerView(String writerName) {
		ArrayList<LibraryInfo> wBookList = service.getWriterInfo(writerName);

		if (wBookList != null) {
			EndView.bookListView(wBookList);
		} else {
			EndView.messageView("현재 보유중인 도서가 없습니다");
		}
	}

	// 도서 저장
	public void insertBook(LibraryInfo newBook) {
		try {
			service.insertBook(newBook);
			EndView.messageView("저장 완료 했습니다");
		} catch (NotExistException e) {
			FailView.failMessageView(e.getMessage());
		}
	}

	// 도서 삭제
	public void deleteBook(String bookName) {
		try {
			service.deleteBook(bookName);
			EndView.messageView("삭제 완료 했습니다");
		} catch (NotExistException e) {
			FailView.failMessageView(e.getMessage());
		}
	}

	// 책 정보 수정
	public void updateBook(String bookName, People people) {
		try {
			service.bookUpdate(bookName, people);
			EndView.messageView("수정 완료 했습니다");
		} catch (NotExistException e) {
			FailView.failMessageView(e.getMessage());
			// e.printStackTrace();
		}

	}

	// 연체정보 업데이트
	public void updateOverdueStatus() {
		try {
			service.updateBookStatus();
		} catch (NotExistException e) {
			FailView.failMessageView(e.getMessage());
		}
	}

	// 연체도서 검색
	public void overdueBookList() {
		ArrayList<LibraryInfo> overdueList = service.getOverdueBook();
		if (overdueList != null) {
			EndView.bookListView(overdueList);
		} else {
			EndView.messageView("현재 연체중인 도서가 없습니다");
		}
	}

	// 모든 도서 제이슨 변환
	public void jsongetAllBooks() {
		JSONArray bookList = service.jsongetAllBooks();
		if (bookList.size() != 0) {
			EndView.JSONView(bookList);
		}
	}
}
