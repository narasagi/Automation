/**
 * 
 */
package utility;

import java.util.HashMap; 
import java.util.Map;

import utility.AppContext;

/**
 * @author narasimhulu.sagi
 *
 */
public class AppContext {
private static AppContext instance;
	

	private Map<String, Object> dataMap;
	
	private AppContext() {
		dataMap = new HashMap<String, Object>();
	}
	
	public void put(String key, Object obj) {
		dataMap.put(key, obj);
	}
public static AppContext getInstance() {
		
		if(instance == null) {
			instance = new AppContext();
		}
		
		return instance;
	}

@SuppressWarnings("unchecked")
	public <T> T get(String key, Class<T> claszz) {
		if(dataMap.get(key) != null) {
			return (T) dataMap.get(key);
		}else {
			return null;
		}
	}

}
