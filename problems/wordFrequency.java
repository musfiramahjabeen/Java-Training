class WordFrequency {
    public static void countWords(String text) {
        String[] words = text.toLowerCase().split("\\W+");
        java.util.HashMap<String, Integer> freqMap = new java.util.HashMap<>();

        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        for (java.util.Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}