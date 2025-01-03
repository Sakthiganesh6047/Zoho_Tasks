package hashmap.task;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import exception.CustomException;
import arraylist.customobj.CustomObj;

public class HashMapTask {
	
	public <K,V> Map<K,V> createHashMap() {
		return new HashMap<>();
	}
	
	public int getSize(Map<?,?> hashmap) throws CustomException {
		checkMapValidity(hashmap);
		return hashmap.size();
	}
	
	public <K,V> void addKeyValuePair(Map<K, V> map, K key, V value) throws CustomException {
		checkMapValidity(map);
        map.put(key, value);
    }
	
	@SuppressWarnings("unchecked")
	public <K,V> Map<K,V> addCustomObject(Map<K,V> map , K key , CustomObj object) throws CustomException {
		checkMapValidity(map);
		map.put(key , (V) object);
		return map;
	}
	
	public <K,V> boolean checkKeyExists(Map<K,V> map, K key) throws CustomException {
		checkMapValidity(map);
        return map.containsKey(key);
    }
	
	public <K,V> boolean checkValueExists(Map<K,V> map, V value) throws CustomException {
		checkMapValidity(map);
        return map.containsValue(value);
	}
	
	public <K,V> K[] extractKeysToArray(Map<K,V> map) throws CustomException {
		checkMapValidity(map);
        Set<K> keySet = map.keySet();
        @SuppressWarnings("unchecked")
		K[] keysArray = (K[]) new String[keySet.size()];  
        keySet.toArray(keysArray);
        return keysArray;
	}
	
	public <K,V> void updateHashMap(Map<K,V> map , K keyToAlter , V newValue) throws CustomException {
		checkMapValidity(map);
		map.put(keyToAlter, newValue);
	}
	
	public <K,V> V getKeyValue(Map<K,V> map , K keyToSearch) throws CustomException {
		checkMapValidity(map);
		return map.get(keyToSearch);
	}
	
	public <K,V> V getKeyValueOrDefault(Map<K,V> map , K keyToSearch , V defaultValue) throws CustomException {
		checkMapValidity(map);
		return map.getOrDefault(keyToSearch , defaultValue);
	}
	
	public <K,V> void removeKey(Map<K,V> map , K keyToRemove) throws CustomException {
		checkMapValidity(map);
		map.remove((K) keyToRemove);
	}
	
	public <K,V> void removeKeyIfValueMatches(Map<K,V> map , K keyToRemove , V checkValue) throws CustomException {
		checkMapValidity(map);
		map.remove(keyToRemove, checkValue);
	}
	
	public <K,V> void replaceKey(Map<K,V> map , K replaceKey , V replaceValue) throws CustomException {
		checkMapValidity(map);
		map.replace(replaceKey, replaceValue);
	}
	
	public <K,V> void replaceKeyIfValueMatches(Map<K,V> map , K replaceKey , V checkValue , V replaceValue) throws CustomException {
		checkMapValidity(map);
		map.replace(replaceKey , checkValue , replaceValue);
	}
	
	public <K,V> void transferValues(Map<K,V> map1 , Map<K,V> map2) throws CustomException {
		checkMapValidity(map1);
		checkMapValidity(map2);
		map2.putAll(map1);
	}
	
	public void removeEntries(Map<?,?> map) throws CustomException {
		checkMapValidity(map);
		map.clear();
	}
	
	private void checkMapValidity(Map<?,?> map) throws CustomException {
		if (map == null) {
	        throw new IllegalArgumentException("Map must not be null");
	    }
	}
	
	
}




