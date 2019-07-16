package library.view;

import java.util.ArrayList;

import library.model.dto.LibraryInfo;
import library.model.dto.Writer;
import net.sf.json.JSON;

public class EndView {

	// 특정 도서 출력
	public static void bookView(LibraryInfo book) {
		System.out.println(book);
	}

	// 모든 프로젝트 출력
	public static void bookListView(ArrayList<LibraryInfo> allBookInfo) {
		for (int index = 0; index < allBookInfo.size(); index++) {
			System.out.println("[책 " + (index + 1) + "]\n" + allBookInfo.get(index) + "\n");
		}
	}

	// 예외가 아닌 단순 메세지 출력
	public static void messageView(String message) {
		System.out.println(message);
	}

	// JSON 출력
	public static void JSONView(JSON jsonArray) {
		System.out.println(jsonArray);
	}

	public static void projectView(Writer writer) {
		System.out.println(writer);

	}
}
