package library.model;

import java.time.LocalDate;
import java.util.ArrayList;

import library.model.dto.Book;
import library.model.dto.Borrower;
import library.model.dto.LibraryInfo;
import library.model.dto.Writer;

public class LibraryModelVirtualDB {
	private static LibraryModelVirtualDB instance = new LibraryModelVirtualDB();
	private ArrayList<LibraryInfo> libraryList = new ArrayList<LibraryInfo>();

	private LibraryModelVirtualDB() {
		libraryList.add(new LibraryInfo("유럽 도시기행1", 
										new Book("교양인문", "아테네,로마,이스탄불, 파리편", 20190709, "생각의길"), 
										new Writer("유시민", 60, "역사/문화일반", "역사의 역사"), 
										new Borrower("조영욱", 26, "신대방", LocalDate.of(2019,07,16), LocalDate.of(2019,07,16).plusDays(13), "")));
		libraryList.add(new LibraryInfo("여행의 이유", 
										new Book("여행에세이", "여행의 감각을 일깨우는 소설가 김영하의 매혹적인 이야기", 20190417, "문학동네"), 
										new Writer("김영하", 51, "한국소설", "나는 나를 파괴할 권리가 있다"), 
										new Borrower("김수경", 32, "용산", LocalDate.of(2019,06,30), LocalDate.of(2019,06,30).plusDays(13), "")));
		libraryList.add(new LibraryInfo("살인자의 기억법", 
										new Book("한국소설", " 알츠하이머에 걸린 은퇴한 연쇄살인범 마지막 살인 계획 이야기", 20130724, "문학동네"), 
										new Writer("김영하", 51, "한국소설", "나는 나를 파괴할 권리가 있다"), 
										new Borrower("대출가능", 0, "", LocalDate.now(), LocalDate.now().plusDays(13), "")));
		libraryList.add(new LibraryInfo("천년의 질문", 
										new Book("한국소설", "조정래 작가가 던지는 천년의 질문을 통해 국민에게 국가란 무엇인가라는 질문을 던진다", 20190611, "해냄출판사"), 
										new Writer("조정래", 76, "한국소설", "태백산맥"), 
										new Borrower("민지은", 27, "강남", LocalDate.of(2019,07,01), LocalDate.of(2019,07,01).plusDays(13), "")));
		libraryList.add(new LibraryInfo("축구를 하며 생각한 것들", 
										new Book("시/에세이", "축구선수 손흥민의 성공 스토리", 20190712, "브레인스토어"), 
										new Writer("손흥민", 27, "시/에세이", "축구를 하며 생각한 것들"), 
										new Borrower("송시찬", 25, "서초", LocalDate.of(2019,07,15), LocalDate.of(2019,07,15).plusDays(13), "")));
	}

	public static LibraryModelVirtualDB getInstance() {
		return instance;
	}

	public ArrayList<LibraryInfo> getLibraryList() {
		return libraryList;
	}

	public void insertLibrary(LibraryInfo newLibrary) {
		libraryList.add(newLibrary);
	}

	public void deletLibrary(LibraryInfo Library) {
		libraryList.remove(Library);
	}
}
