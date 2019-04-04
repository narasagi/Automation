/**
 * 
 */
package utility;

import java.io.FileNotFoundException;    
import java.io.FileReader;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

import com.testdata.GovernmentSchemeSearchData;

/**
 * @author narasimhulu.sagi
 *
 */
public class ReadDataFromJson {
	public  static void readLoginDataFromJSONFile() throws Exception {
		JSONParser parser = new JSONParser();
		FileReader reader = null;
		try {
			reader = new FileReader("C:\\dev\\SampleProject\\config\\InputData.json");
		}catch(FileNotFoundException ex) {
			ex.printStackTrace();
		}
		if(reader != null) {
			AppContext context = AppContext.getInstance();
			String obj = parser.parse(reader).toString();
			if(obj != null) {
				JSONObject jsonMainObj = new JSONObject(obj);
				JSONObject userJson = jsonMainObj.getJSONObject("search-field");
				GovernmentSchemeSearchData searchScheme = new GovernmentSchemeSearchData(userJson.getString("search"));
				
				if(searchScheme != null) {
					context.put("search-field", searchScheme);
				}
				
				
			}
		}
	}
}
