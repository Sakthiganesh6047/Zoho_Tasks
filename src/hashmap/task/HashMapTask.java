package hashmap.task;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import exception.CustomException;

public class HashMapTask {
	
	public <K,V> Map<K,V> createHashMap() {
		return new HashMap<>();
	}
	
	public int getSize(Map<?,?> hashmap) throws CustomException {
		try {
			checkMapValidity(hashmap);
			return hashmap.size();
		} catch (CustomException e) {
			e.addSuppressed(new CustomException("Failed to get the size"));
			throw e;
		}
	}
	
	public <K,V> void addKeyValuePair(Map<K,V> map, K key, V value) throws CustomException {
		try {
			checkMapValidity(map);
	        map.put(key, value);
		} catch (CustomException e) {
			e.addSuppressed(new CustomException("Failed to add the values"));
			throw e;
		}
    }
	
	public <K,V> boolean checkKeyExists(Map<K,V> map, K key) throws CustomException {
		try {
			checkMapValidity(map);
	        return map.containsKey(key);
		} catch (CustomException e) {
			e.addSuppressed(new CustomException("Failed to check the existence of the key"));
			throw e;
		}
    }
	
	public <K,V> boolean checkValueExists(Map<K,V> map, V value) throws CustomException {
		try {
			checkMapValidity(map);
	        return map.containsValue(value);
		} catch (CustomException e) {
			e.addSuppressed(new CustomException("Failed to check the existence of the values"));
			throw e;
		}
	}
	
    @SuppressWarnings("unchecked")
	public <K,V> K[] extractKeysToArray(Map<K,V> map) throws CustomException {
    	try {
			checkMapValidity(map);
	        Set<K> keySet = map.keySet();
			K[] keysArray = (K[]) new String[keySet.size()];  
	        keySet.toArray(keysArray);
	        return keysArray;
    	} catch (CustomException e) {
    		e.addSuppressed(new CustomException("Failed to extract the keys to an Array"));
			throw e;
		}
	}
	
	public <K,V> void updateHashMap(Map<K,V> map , K keyToAlter , V newValue) throws CustomException {
		try {
			checkMapValidity(map);
			map.put(keyToAlter, newValue);
		} catch (CustomException e) {
			e.addSuppressed(new CustomException("Failed to update the HashMap"));
			throw e;
		}
	}
	
	public <K,V> V getKeyValue(Map<K,V> map , K keyToSearch) throws CustomException {
		try {
			checkMapValidity(map);
			return map.get(keyToSearch);
		} catch (CustomException e) {
			e.addSuppressed(new CustomException("Failed to get the value of entered key"));
			throw e;
		}
	}
	
	public <K,V> V getKeyValueOrDefault(Map<K,V> map , K keyToSearch , V defaultValue) throws CustomException {
		try {
			checkMapValidity(map);
			return map.getOrDefault(keyToSearch , defaultValue);
		} catch (CustomException e) {
			e.addSuppressed(new CustomException("Failed to get the value of entered key"));
			throw e;
		}
	}
	
	public <K,V> void removeKey(Map<K,V> map , K keyToRemove) throws CustomException {
		try {
			checkMapValidity(map);
			map.remove(keyToRemove);
		} catch (CustomException e) {
			e.addSuppressed(new CustomException("Failed to remove the key"));
			throw e;
		}
	}
	
	public <K,V> void removeKeyIfValueMatches(Map<K,V> map , K keyToRemove , V checkValue) throws CustomException {
		try {
			checkMapValidity(map);
			map.remove(keyToRemove, checkValue);
		} catch (CustomException e) {
			e.addSuppressed(new CustomException("Failed to remove key"));
			throw e;
		}
	}
	
	public <K,V> void replaceKey(Map<K,V> map , K replaceKey , V replaceValue) throws CustomException {
		try {
			checkMapValidity(map);
			map.replace(replaceKey, replaceValue);
		} catch (CustomException e) {
			e.addSuppressed(new CustomException("Failed to replace List"));
			throw e;
		}
	}
	
	public <K,V> void replaceKeyIfValueMatches(Map<K,V> map , K replaceKey , V checkValue , V replaceValue) throws CustomException {
		try {
			checkMapValidity(map);
			map.replace(replaceKey , checkValue , replaceValue);
		} catch (CustomException e) {
			e.addSuppressed(new CustomException("Failed to replace key"));
			throw e;
		}
	}
	
	public <K,V> void transferValues(Map<K,V> map1 , Map<K,V> map2) throws CustomException {
		try {
			checkMapValidity(map1);
			checkMapValidity(map2);
			map2.putAll(map1);
		} catch (CustomException e) {
			e.addSuppressed(new CustomException("Failed to transfer values"));
			throw e;
		}
	}
	
	public void removeEntries(Map<?,?> map) throws CustomException {
		try {
			checkMapValidity(map);
			map.clear();
		} catch (CustomException e) {
			e.addSuppressed(new CustomException("Failed to remove entries."));
			throw e;
		}
	}
	
	private void checkMapValidity(Map<?,?> map) throws CustomException {
		if (map == null) {
	        throw new CustomException("Map must not be null");
	    }
	}
	
	
}




