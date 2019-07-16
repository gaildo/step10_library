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

	// 모든 도서정보 검색
	public ArrayList<LibraryInfo> getAllBookInfo() {
		return LibraryVitrualData.getLibraryList();

	}

	// 도서 검색
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

	// 저자 검색
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

	// 도서 추가
	public void insertBook(LibraryInfo book) throws NotExistException {
		if (book == null) {
			throw new NotExistException("xxxxxxx 도서를 추가할 수 없습니다 xxxxxxx\n");
		}
		LibraryVitrualData.insertLibrary(book);

	}

	// 도서 삭제
	public void deleteBook(String bookName) throws NotExistException {
		LibraryInfo book = getBookInfo(bookName);
		if (book == null) {
			Log4j.getInstance().error("book == null 값을 가지고 있습니다");
			throw new NotExistException("xxxxxxx 삭제하고자 하는 도서가 미 존재합니다. xxxxxxx\n");
		}
		getAllBookInfo().remove(book);

	}

	// 도서 정보 수정
	public void bookUpdate(String bookName, People people) throws NotExistException {
		LibraryInfo book = getBookInfo(bookName);
		if (book == null) {
			Log4j.getInstance().error("book == null 값을 가지고 있습니다");
			throw new NotExistException("xxxxxxx 수정하고자 하는 도서가 미 존재합니다. xxxxxxx\n");
		}
		if (people instanceof Borrower) {
			book.setBorrower((Borrower) people);
		} else if (people instanceof Writer) {
			book.setWriter((Writer) people);
		} else {
			throw new NotExistException("xxxxxxx 해당되는 저자 또는 대출자 정보가 없습니다 xxxxxxx\n");
		}
	}

	// 연체 상태 업데이트
	public void updateBookStatus() throws NotExistException {
		ArrayList<LibraryInfo> libraryList = getAllBookInfo();
		if (libraryList == null) {
			throw new NotExistException("보유 중인 도서가 없습니다.");
		}
		int listCount = libraryList.size();
		for (int i = 0; i < listCount; i++) {
			LibraryInfo info = null;
			info = libraryList.get(i);
			if (info.getBorrower().getReturnDate() != null) {
				if (info.getBorrower().getReturnDate().compareTo(LocalDate.now()) < 0) {
					info.getBorrower().setStatus("연체");
				}
			}
		}
	}

	// 연체 도서 목록
	public ArrayList<LibraryInfo> getOverdueBook() {
		ArrayList<LibraryInfo> libraryList = getAllBookInfo();
		ArrayList<LibraryInfo> dueArray = new ArrayList<LibraryInfo>();
		int listCount = libraryList.size();
		for (int i = 0; i < listCount; i++) {
			LibraryInfo info = null;
			info = libraryList.get(i);
			if (info != null && info.getBorrower().getStatus().equals("연체")) {
				dueArray.add(info);
			}
		}
		return dueArray;
	}

	// 모든 제이슨 변환
	public JSONArray jsongetAllBooks() {
		return JSONArray.fromObject(getAllBookInfo());
	}
}
