package neetcode150.binary_search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeBasedKeyValueStore {
    Map<String,List<Pair<Integer,String>>> keyStore;
    public TimeBasedKeyValueStore() {
        keyStore = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {

        if(keyStore.get(key) == null) {
            keyStore.put(key,new ArrayList());
        }
        keyStore.get(key).add(new Pair(timestamp,value));
    }

    public String get(String key, int timestamp) {

        if(keyStore.get(key) == null) {
            return "";
        }
        int i = 0;
        List<Pair<Integer,String>> pairList = keyStore.get(key);
        int left =0;
        int right = pairList.size()-1;
        Pair<Integer,String> result = null;
        while (left <= right) {

            int mid = left + ((right -left) /2);

            if(pairList.get(mid).getTimestamp() <= timestamp) {
                result = pairList.get(mid);
                left = mid +1;
            } else {
                right = mid -1;
            }
        }
        return (result == null) ? "" : result.getValue();
    }

    class Pair<K,V> {
        K timestamp;
        V value;
        public Pair(K timestamp,V value) {
            this.timestamp = timestamp;
            this.value = value;
        }
        public K getTimestamp() {
            return this.timestamp;
        }
        public V getValue() {
            return this.value;
        }
    }
}
