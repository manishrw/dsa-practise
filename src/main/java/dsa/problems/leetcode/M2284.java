/*
* Medium 2284. Sender with Largest word count.
* https://leetcode.com/problems/sender-with-largest-word-count/
*/
package dsa.problems.leetcode;

import java.util.HashMap;
import java.util.Map;

public class M2284 {
    public String largestWordCount(String[] messages, String[] senders) {
        Map<String, Integer> wordCount = new HashMap<>();
        for (int i = 0; i < messages.length; i++) {
            String[] words = messages[i].split(" ");
            int count = wordCount.getOrDefault(senders[i], 0);
            wordCount.put(senders[i], count + words.length);
        }

        String sender = "";
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                sender = entry.getKey();
                maxCount = entry.getValue();
            } else if (entry.getValue() == maxCount) {
                if (entry.getKey().compareTo(sender) > 0) {
                    sender = entry.getKey();
                }
            }
        }
        return sender;
    }
}
