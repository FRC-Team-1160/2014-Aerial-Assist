package lessons;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

import lessons.tables.MatchTable;
 

/**
 * The xml parser is where the code reads the config file
 * it has two main functions to create a pit table and a
 * match table it does so by reading the config.xml
 * 
 * @author Ethan
 *
 */

public class XmlParser {

	/**
	 * This is the config file that is read
	 */
	protected Document config;
	
	/**
	 * Creates a new parser based on the config file you feed it
	 * 
	 * @param config       Config file for the code
	 * @throws SAXException
	 * @throws IOException
	 * @throws ParserConfigurationException
	 */
	public XmlParser(File config) throws SAXException, IOException, ParserConfigurationException{
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		this.config = dBuilder.parse(config);
		this.config.getDocumentElement().normalize();
	}
	/**
	 * 
	 * @return    the match element for internal use
	 */
	protected Element getMatch(){
		NodeList nlist = config.getElementsByTagName("match");
		if(nlist.getLength() == 0){
			throw new NullPointerException("Config file set up wrong, no match config");
		}else if(nlist.getLength() > 1){
			throw new NullPointerException("Configs file set up wrong, to many match configs");
		}else{
			if(nlist.item(0).getNodeType() == Node.ELEMENT_NODE){
				return (Element) nlist.item(0);
			}else{
				throw new NullPointerException("Config mis-setup match is not an element");
			}
		}
	}
	
	/**
	 * 
	 * @return   the pit element for internal use
	 */
	protected Element getPit(){
		NodeList nlist = config.getElementsByTagName("pit");
		if(nlist.getLength() == 0){
			throw new NullPointerException("Config file set up wrong, no pit config");
		}else if(nlist.getLength() > 1){
			throw new NullPointerException("Configs file set up wrong, to many pit configs");
		}else{
			if(nlist.item(0).getNodeType() == Node.ELEMENT_NODE){
				return (Element) nlist.item(0);
			}else{
				throw new NullPointerException("Config mis-setup pit is not an element");
			}
		}
	}
	/**
	 * 
	 * @return   gives you a match table based on the specifications of the config file
	 */
	public MatchTable getMatchTable(){
		Element matchConfig = getMatch();
		MatchTable matchTable = new MatchTable();
		NodeList nlist = matchConfig.getElementsByTagName("field");
		for(int i = 0; i < nlist.getLength(); i++){
			if(nlist.item(0).getNodeType() == Node.ELEMENT_NODE){
				Element element = (Element) nlist.item(0);
				if(element.getAttribute("type").equals("numerical")){      
					if(element.getAttribute("input").equals("menu")){
						String field = "";
						field += "Field name: " + element.getElementsByTagName("name").item(0).getTextContent() + "\n";
						field += "Type: menu\n";
						field += "Max of: " + element.getElementsByTagName("top").item(0).getTextContent() + "\n";
						field += "Min of: " + element.getElementsByTagName("bottom").item(0).getTextContent() + "\n";
						field += "Increment of: " + element.getElementsByTagName("step").item(0).getTextContent() + "\n";
						matchTable.addField(field);
					}else if(element.getAttribute("input").equals("box")){
						String field = "";
						field += "Field name: " + element.getElementsByTagName("name").item(0).getTextContent() + "\n";
						field += "Type: box\n";
						matchTable.addField(field);
					}else{
						matchTable.addField("Field of unknown type found\n");
					}
				}
				
			}
		}
		return matchTable;
	}
	
}	
