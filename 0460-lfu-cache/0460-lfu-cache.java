class LFUCache {
    /**
     * Instead of using DLL we have used LinkedHashSet for the easier implementation.
     * Removal of an element from LinkedHashSet takes O(1)
     * Insertion of an element from LinkedHashSet takes O(1)
     * And also it preserves the insertion order, unlike hashset
     */
    private int capacity = 0;

    private int minFreq = 0;
    /**
     * Stores key and its respective value
     */
    private HashMap<Integer, Integer> keyToValueMap;
    /**
     * Stores key and its respective freq
     */
    private HashMap<Integer, Integer> keyToFreqMap;
    /**
     * Stores freq and its associated values
     */
    private HashMap<Integer, LinkedHashSet<Integer>> freqToListMap;

    public LFUCache(int capacity) {
        /**
         * Initialize all the instance variables here
         */
        this.capacity = capacity;
        minFreq = 0;
        keyToValueMap = new HashMap<>();
        keyToFreqMap = new HashMap<>();
        freqToListMap = new HashMap<>();
    }

    public int get(int key) {
        /**
         * If the value is not in the keyToValueMap return -1
         */
        if (!keyToValueMap.containsKey(key)) return -1;
        /**
         * Get the current freq of the key
         */
        int currentFreq = keyToFreqMap.get(key);
        /**
         * Since we have to increase the freq remove the element from current freq list
         */
        freqToListMap.get(currentFreq).remove(key);
        /**
         * If all the elements from the min freq are removed, update the minFreq
         */
        if (currentFreq == minFreq && freqToListMap.get(currentFreq).isEmpty()) {
            minFreq++;
            freqToListMap.remove(currentFreq);
        }
        freqToListMap.putIfAbsent(currentFreq + 1, new LinkedHashSet<>());
        freqToListMap.get(currentFreq + 1).add(key);
        keyToFreqMap.put(key, currentFreq + 1);
        return keyToValueMap.get(key);

    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        if (keyToValueMap.containsKey(key)) {
            keyToValueMap.put(key, value);
            get(key);
            return;
        }

        /**
         * If the capacity is equal to keyToValueMap size
         */
        if (capacity == this.keyToValueMap.size()) {
            /**
             * Remove the LRU element from the list
             */
            if (freqToListMap.get(minFreq).iterator().hasNext()) {
                int valueToRemove = freqToListMap.get(minFreq).iterator().next();
                System.out.println();
                freqToListMap.get(minFreq).remove(valueToRemove);
                keyToValueMap.remove(valueToRemove);
                keyToFreqMap.remove(valueToRemove);
            }


        }
        minFreq = 1;
        freqToListMap.putIfAbsent(minFreq, new LinkedHashSet<>());
        freqToListMap.get(minFreq).add(key);
        keyToFreqMap.put(key, minFreq);
        keyToValueMap.put(key, value);

    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */