package io;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Purpose of MyFile is to read text files and store them into an list
 * and access the data through methods.  
 * @author Camposm97
 */
public class MyFile {
	private LinkedList<String> contentList;
	
	public MyFile(String src) {
		contentList = new LinkedList<>();
		try {
			Scanner input = new Scanner(new File(src));
			while (input.hasNextLine()) {
				contentList.add(input.nextLine());
			}
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public LinkedList<String> getContentList() {
		return contentList;
	}
}
