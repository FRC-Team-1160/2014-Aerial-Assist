package lessons.tables.fields;

import org.w3c.dom.Element;

public class NumericMenu {
	
	protected String name;
	protected int top,bottom,increment;
	
	public NumericMenu(Element numericMenu) throws Exception{
		top = 0;
		bottom = 0;
		increment = 0;
		if(numericMenu.getAttribute("type").equals("numerical") && numericMenu.getAttribute("input").equals("menu")){
			name = numericMenu.getElementsByTagName("name").item(0).getTextContent();
			top = Integer.parseInt(numericMenu.getElementsByTagName("top").item(0).getTextContent());
			bottom = Integer.parseInt(numericMenu.getElementsByTagName("bottom").item(0).getTextContent());
			increment = Integer.parseInt(numericMenu.getElementsByTagName("step").item(0).getTextContent());
			if(Math.abs(top-bottom)%increment != 0){     //If the range defined can not be expressed using the increment defined use 1 as step
				increment = 1;
			}
		}else{
			throw new Exception("Xml data did not represent numeric menu");
		}
	}
	
	public String toString(){
		String result = "";
		result += "Field name: " + this.name + "\n";
		result += "Type: Numeric menu\n";
		result += "Max of: " + this.top + "\n";
		result += "Min of: " + this.bottom + "\n";
		result += "Increment of: " + this.increment + "\n";
		return result;
	}
}
