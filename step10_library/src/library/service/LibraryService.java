package library.service;

import java.time.LocalDate;
import java.util.ArrayList;

import library.exception.Log4j;
import library.exception.NotExistException;
import library.model.LibraryModelVirtualDB;
import library.model.dto.Borrower;
import library.model.dto.LibraryInfo;
import library.model.dto.People;
import library.model.dto.Writer;
import net.sf.json.JSONArray;

public class LibraryService {

	private static LibraryService instance = new LibraryService();
	private LibraryModelVirtualDB LibraryVitrualData = LibraryModelVirtualDB.getInstance();

	private LibraryService() {}

	public static LibraryService getInstance() {
		return instance;
	}

	// ��� �������� �˻�
	public ArrayList<LibraryInfo> getAllBookInfo() {
		return LibraryVitrualData.getLibraryList();

	}

	// ���� �˻�
	public LibraryInfo getBookInfo(String bookName) {
		ArrayList<LibraryInfo> libraryList = getAllBookInfo();
		int listCount = libraryList.size();
		LibraryInfo info = null;
		for (int i = 0; i < listCount; i++) {
			info = libraryList.get(i);
			if (info != null && info.getBookName().equals(bookName)) {
				return info;
			}
		}
		return null;
	}

	// ���� �˻�
	public ArrayList<LibraryInfo> getWriterInfo(String writerName) {
		ArrayList<LibraryInfo> libraryList = getAllBookInfo();
		ArrayList<LibraryInfo> wArray = new ArrayList<LibraryInfo>();
		int listCount = libraryList.size();
		LibraryInfo info = null;

		for (int i = 0; i < listCount; i++) {
			info = libraryList.get(i);
			if (info != null && info.getWriter().getName().equals(writerName)) {
				wArray.add(info);
			}
		}
		return wArray;
	}

	// ���� �߰�
	public void insertBook(LibraryInfo book) throws NotExistException {
		if (book == null) {
			throw new NotExistException("xxxxxxx ������ �߰��� �� �����ϴ� xxxxxxx\n");
		}
		LibraryVitrualData.insertLibrary(book);

	}

	// ���� ����
	public void deleteBook(String bookName) throws NotExistException {
		LibraryInfo book = getBookInfo(bookName);
		if (book == null) {
			Log4j.getInstance().error("book == null ���� ������ �ֽ��ϴ�");
			throw new NotExistException("xxxxxxx �����ϰ��� �ϴ� ������ �� �����մϴ�. xxxxxxx\n");
		}
		getAllBookInfo().remove(book);

	}

	// ���� ���� ����
	public void bookUpdate(String bookName, People people) throws NotExistException {
		LibraryInfo book = getBookInfo(bookName);
		if (book == null) {
			Log4j.getInstance().error("book == null ���� ������ �ֽ��ϴ�");
			throw new NotExistException("xxxxxxx �����ϰ��� �ϴ� ������ �� �����մϴ�. xxxxxxx\n");
		}
		if (people instanceof Borrower) {
			book.setBorrower((Borrower) people);
		} else if (people instanceof Writer) {
			book.setWriter((Writer) people);
		} else {
			throw new NotExistException("xxxxxxx �ش�Ǵ� ���� �Ǵ� ������ ������ �����ϴ� xxxxxxx\n");
		}
	}

	// ��ü ���� ������Ʈ
	public void updateBookStatus() throws NotExistException {
		ArrayList<LibraryInfo> libraryList = getAllBookInfo();
		if (libraryList == null) {
			throw new NotExistException("���� ���� ������ �����ϴ�.");
		}
		int listCount = libraryList.size();
		for (int i = 0; i < listCount; i++) {
			LibraryInfo info = null;
			info = libraryList.get(i);
			if (info.getBorrower().getReturnDate() != null) {
				if (info.getBorrower().getReturnDate().compareTo(LocalDate.now()) < 0) {
					info.getBorrower().setStatus("��ü");
				}
			}
		}
	}

	// ��ü ���� ���
	public ArrayList<LibraryInfo> getOverdueBook() {
		ArrayList<LibraryInfo> libraryList = getAllBookInfo();
		ArrayList<LibraryInfo> dueArray = new ArrayList<LibraryInfo>();
		int listCount = libraryList.size();
		for (int i = 0; i < listCount; i++) {
			LibraryInfo info = null;
			info = libraryList.get(i);
			if (info != null && info.getBorrower().getStatus().equals("��ü")) {
				dueArray.add(info);
			}
		}
		return dueArray;
	}

	// ��� ���̽� ��ȯ
	public JSONArray jsongetAllBooks() {
		return JSONArray.fromObject(getAllBookInfo());
	}
}
