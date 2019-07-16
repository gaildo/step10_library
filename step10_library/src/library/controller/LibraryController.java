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

	// ��� ���� �˻�
	public void bookListView() {
		ArrayList<LibraryInfo> bookList = service.getAllBookInfo();
		if (bookList.size() != 0) {
			EndView.bookListView(bookList);
		} else {
			EndView.messageView("���� �������� ������ �����ϴ�");
		}
	}

	// Ư�� ���� �˻�
	public void bookView(String bookName) {
		LibraryInfo book = service.getBookInfo(bookName);
		if (book != null) {
			EndView.bookView(book);
		} else {
			EndView.messageView("�˻� ��û�Ͻ� ������ �������� �ʽ��ϴ�.");
		}
	}

	// ���� �˻�
	public void writerView(String writerName) {
		ArrayList<LibraryInfo> wBookList = service.getWriterInfo(writerName);

		if (wBookList != null) {
			EndView.bookListView(wBookList);
		} else {
			EndView.messageView("���� �������� ������ �����ϴ�");
		}
	}

	// ���� ����
	public void insertBook(LibraryInfo newBook) {
		try {
			service.insertBook(newBook);
			EndView.messageView("���� �Ϸ� �߽��ϴ�");
		} catch (NotExistException e) {
			FailView.failMessageView(e.getMessage());
		}
	}

	// ���� ����
	public void deleteBook(String bookName) {
		try {
			service.deleteBook(bookName);
			EndView.messageView("���� �Ϸ� �߽��ϴ�");
		} catch (NotExistException e) {
			FailView.failMessageView(e.getMessage());
		}
	}

	// å ���� ����
	public void updateBook(String bookName, People people) {
		try {
			service.bookUpdate(bookName, people);
			EndView.messageView("���� �Ϸ� �߽��ϴ�");
		} catch (NotExistException e) {
			FailView.failMessageView(e.getMessage());
			// e.printStackTrace();
		}

	}

	// ��ü���� ������Ʈ
	public void updateOverdueStatus() {
		try {
			service.updateBookStatus();
		} catch (NotExistException e) {
			FailView.failMessageView(e.getMessage());
		}
	}

	// ��ü���� �˻�
	public void overdueBookList() {
		ArrayList<LibraryInfo> overdueList = service.getOverdueBook();
		if (overdueList != null) {
			EndView.bookListView(overdueList);
		} else {
			EndView.messageView("���� ��ü���� ������ �����ϴ�");
		}
	}

	// ��� ���� ���̽� ��ȯ
	public void jsongetAllBooks() {
		JSONArray bookList = service.jsongetAllBooks();
		if (bookList.size() != 0) {
			EndView.JSONView(bookList);
		}
	}
}
