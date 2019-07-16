package library.view;

import java.util.ArrayList;

import library.model.dto.LibraryInfo;
import library.model.dto.Writer;
import net.sf.json.JSON;

public class EndView {

	// Ư�� ���� ���
	public static void bookView(LibraryInfo book) {
		System.out.println(book);
	}

	// ��� ������Ʈ ���
	public static void bookListView(ArrayList<LibraryInfo> allBookInfo) {
		for (int index = 0; index < allBookInfo.size(); index++) {
			System.out.println("[å " + (index + 1) + "]\n" + allBookInfo.get(index) + "\n");
		}
	}

	// ���ܰ� �ƴ� �ܼ� �޼��� ���
	public static void messageView(String message) {
		System.out.println(message);
	}

	// JSON ���
	public static void JSONView(JSON jsonArray) {
		System.out.println(jsonArray);
	}

	public static void projectView(Writer writer) {
		System.out.println(writer);

	}
}
