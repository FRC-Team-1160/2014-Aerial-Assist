package lessons.tables;
/**
 * This class holds data about
 * what is held in each match table
 * 
 * @author Ethan
 *
 */
public class MatchTable {
	String[] fields;
	
	
	/**
	 * Adds a new field to the table, allowing the user
	 * to define what data is important to track
	 * 
	 * @param string currently this is a string, later will be a more formal object
	 */
	public void addField(String string){
		if(fields == null){
			fields = new String[1]; 
			fields[0] = string;
		}else{
			// Probably a cleaner way to do this but this is just a prototype so meh
			String[] temp = fields;
			fields = new String[fields.length + 1];
			for(int i = 0; i < temp.length; i++){
				fields[i] = temp[i];
			}
			fields[temp.length] = string;
		}
	}	
	/**
	 * This function acts like the addField function
	 * how ever it allows you to add multiple fields
	 * at once.
	 * 
	 * @param strings array of fields to add
	 */
	public void addFields(String[] strings){
		if(fields == null){
			fields = strings; 
		}else{
			String[] temp = fields;
			int length = temp.length + strings.length;
			fields = new String[length];
			for(int i=0; i < temp.length; i++){
				fields[i] = temp[i];
			}
			for(int i=temp.length; i < fields.length; i++){
				fields[i] = strings[i];
			}
		}
		
	}
	/**
	 * 
	 * @return all of the fields in string form
	 */
	public String toString(){
		String result = "";
		if(fields == null){
			result = "this table has no fields";
		}else{
			for(int i = 0; i < fields.length; i++){
				result += "Field #" + i + ":\n";
				result += fields[i] + "\n";
			}
		}
		return result;
	}
}