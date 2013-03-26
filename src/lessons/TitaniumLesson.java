package lessons;

import java.io.File;

public class TitaniumLesson {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File config = new File("C:/users/ehan/workspace/titaniumLessons/res/configs/tes.xml");
		try {
			System.out.println(new XmlParser(config).getMatchTable());
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
