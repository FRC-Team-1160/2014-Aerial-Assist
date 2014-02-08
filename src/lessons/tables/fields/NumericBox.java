package lessons.tables.fields;

import org.w3c.dom.Element;

public class NumericBox {
	public String name;
	
	public NumericBox(Element numericBox) throws Exception{
		if(numericBox.getAttribute("input").equals("box") && numericBox.getAttribute("type").equals("numerical")){
			this.name = numericBox.getElementsByTagName("name").item(0).getTextContent();
		}else{
			throw new Exception("xml data does not represent numeric box");
		}
	}
	
	public String toString(){
		String result = "";
		result += "Field name: " + this.name + "\n";
		result += "Type: Numeric box\n";
		return result;
	}
}
