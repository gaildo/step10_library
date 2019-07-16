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

		// ���� ����
		Book book5 = new Book("�����ι�", "�����ϴ� ��������ؼ� �˷��ش�", 20180503, "å����");
		// ���� �̸�
		Writer Writer5 = new Writer("�ֽ���", 54, "����/����", "����� �Բ��� ��ġ�� ���ϴ�");
		// ������
		Borrower Borrower5 = new Borrower("�����", 28, "�Ÿ�", LocalDate.of(2019,07,13), LocalDate.of(2019,07,13).plusDays(13), "");
		// ���� �̸�
		LibraryInfo Library5 = new LibraryInfo("���θӸ� ������", book5, Writer5, Borrower5);

		// ��� ���� �˻�
		System.out.println("***** 1. �������� ���� �� ��� ������� �˻� *****");
		controller.bookListView();
		System.out.println();

		// ���ο� ���� ����
		System.out.println("***** 2. ���ο� ���� ���� ��  ��� ���� �˻� *****");
		controller.insertBook(Library5);
		controller.bookListView();

		System.out.println();

		// �����ϴ� ���� �˻�
		System.out.println("***** 3. �����ϴ� ���� �˻� *****");
		controller.bookView("���θӸ� ������");
	
		System.out.println();

		System.out.println("***** 4. �������ϴ� ���� �˻� - ����ó�� Ȯ�ο� *****");
		controller.bookView("����---");

		System.out.println();

		// Ư���۰� ���� �˻�
		String searchWriter = "�迵��";
		System.out.println("***** 5. Ư���۰� ���� �˻� [" + searchWriter + "] *****");
		controller.writerView(searchWriter);

		// �����ϴ� ���� ������Ʈ test
		System.out.println("***** 6. �����ϴ� ���� ���� �� ������ ���� �˻� *****");
		controller.updateBook("���� ���ñ���1", new Borrower("��ö��", 33, "��������", LocalDate.of(2019,06,30), LocalDate.of(2019,06,30).plusDays(13), ""));
		controller.bookView("���� ���ñ���1");

		System.out.println();

		// �� �����ϴ� ���� ������Ʈ test : ���� �߻�
		System.out.println("***** 7. �������ϴ� ���� ���� - ����ó�� Ȯ�ο� *****");
		controller.updateBook("����", new Writer("������", 55, "����", "����"));

		System.out.println();

		// ������ ���� �˻�
		System.out.println("***** 8. ���� ���� �� �ش� ���� �˻� *****");
		controller.deleteBook("���θӸ� ������");
		controller.bookView("���θӸ� ������");
		
		System.out.println();
		
		// ��ü ���� ������Ʈ
		System.out.println("***** 9. ��ü ���� ������Ʈ �� ���(��ü)���� ��� �˻� *****");
		controller.updateOverdueStatus();
		controller.overdueBookList();
		
		System.out.println();
		
		// ��� ���� ���̽� ���
		System.out.println("***** 10. ��絵�� ���̽� ��ȯ �� ��� *****");
		controller.jsongetAllBooks();
	}
}
