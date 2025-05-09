import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        
        int level = 1;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                
                for (int j = 0; j < currentWord.length(); j++) {
                    char[] wordArray = currentWord.toCharArray();
                    
                    for (char c = 'a'; c <= 'z'; c++) {
                        wordArray[j] = c;
                        String newWord = new String(wordArray);
                        
                        if (wordList.contains(newWord) && !visited.contains(newWord)) {
                            if (newWord.equals(endWord)) {
                                return level + 1;
                            }
                            
                            queue.offer(newWord);
                            visited.add(newWord);
                        }
                    }
                }
            }
            
            level++;
        }
        
        return 0;
    }

    public static void main(String[] args) {
        WordLadder solution = new WordLadder();
        
        Set<String> wordList = new HashSet<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        
        String beginWord = "hit";
        String endWord = "cog";
        
        int result = solution.ladderLength(beginWord, endWord, wordList);
        System.out.println("The length of the shortest transformation sequence is: " + result);
    }
}