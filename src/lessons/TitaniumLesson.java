package lessons;

import java.io.File;

import lessons.tables.MatchTable;

public class TitaniumLesson {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File config = new File("C:/users/ehan/workspace/titaniumLessons/res/configs/tes.xml");
		try {
			MatchTable x = new MatchTable();
			x.addFields(new XmlParser(config).getMatchTable());
			System.out.println(x);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
