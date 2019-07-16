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
		libraryList.add(new LibraryInfo("���� ���ñ���1", 
										new Book("�����ι�", "���׳�,�θ�,�̽�ź��, �ĸ���", 20190709, "�����Ǳ�"), 
										new Writer("���ù�", 60, "����/��ȭ�Ϲ�", "������ ����"), 
										new Borrower("������", 26, "�Ŵ��", LocalDate.of(2019,07,16), LocalDate.of(2019,07,16).plusDays(13), "")));
		libraryList.add(new LibraryInfo("������ ����", 
										new Book("���࿡����", "������ ������ �ϱ���� �Ҽ��� �迵���� ��Ȥ���� �̾߱�", 20190417, "���е���"), 
										new Writer("�迵��", 51, "�ѱ��Ҽ�", "���� ���� �ı��� �Ǹ��� �ִ�"), 
										new Borrower("�����", 32, "���", LocalDate.of(2019,06,30), LocalDate.of(2019,06,30).plusDays(13), "")));
		libraryList.add(new LibraryInfo("�������� ����", 
										new Book("�ѱ��Ҽ�", " �������̸ӿ� �ɸ� ������ ������ι� ������ ���� ��ȹ �̾߱�", 20130724, "���е���"), 
										new Writer("�迵��", 51, "�ѱ��Ҽ�", "���� ���� �ı��� �Ǹ��� �ִ�"), 
										new Borrower("���Ⱑ��", 0, "", LocalDate.now(), LocalDate.now().plusDays(13), "")));
		libraryList.add(new LibraryInfo("õ���� ����", 
										new Book("�ѱ��Ҽ�", "������ �۰��� ������ õ���� ������ ���� ���ο��� ������ �����ΰ���� ������ ������", 20190611, "�س����ǻ�"), 
										new Writer("������", 76, "�ѱ��Ҽ�", "�¹���"), 
										new Borrower("������", 27, "����", LocalDate.of(2019,07,01), LocalDate.of(2019,07,01).plusDays(13), "")));
		libraryList.add(new LibraryInfo("�౸�� �ϸ� ������ �͵�", 
										new Book("��/������", "�౸���� ������� ���� ���丮", 20190712, "�극�ν����"), 
										new Writer("�����", 27, "��/������", "�౸�� �ϸ� ������ �͵�"), 
										new Borrower("�۽���", 25, "����", LocalDate.of(2019,07,15), LocalDate.of(2019,07,15).plusDays(13), "")));
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
