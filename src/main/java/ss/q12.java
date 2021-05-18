package ss;

import java.util.HashMap;
import java.util.Map;

public class q12 {
    static HashMap<String, String> flattenDictionary(HashMap<String, Object> dict) {
        HashMap<String, String> flatDict = new HashMap<>();
        flattenDictionary(dict, flatDict, null);
        return flatDict;
    }

    static void flattenDictionary(HashMap<String, Object> dict, HashMap<String, String> flatDict,
                                  String prefixKey) {
        for ( Map.Entry<String, Object> entry : dict.entrySet()) {
            String key = getKey(prefixKey, entry.getKey());
            if (entry.getValue() instanceof HashMap) {
                flatDict.put( key.toString(), (String) entry.getValue());
            } else {
                flattenDictionary( (HashMap) entry.getValue(), flatDict, key);
            }
        }
    }

    static String getKey(String prefixKey, String key) {
        if (prefixKey == null) {
            if (key.isEmpty()) {
                return null;
            }
            return key;
        }
        if (key.isEmpty()) {
            return prefixKey;
        }
        return prefixKey + "." + key;
    }

    public static void main(String[] args) {

    }
}
