package dsa.problems.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class SMSSplitting {
    private static int numberSize(int n) {
        int result = 0;
        while (n > 0) {
            result++;
            n /= 10;
        }
        return result;
    }

    public static List<String> segments(String message) {
        int length = message.length();
        System.out.println("Length is " + length);
        List<String> resultList = new ArrayList<>();
        if (length <= 160) {
            resultList.add(message);
            return resultList;
        }

        List<String> words = Arrays.asList(message.split(" "));
        int totalSegments = Math.floorDiv(length, 160) + 1;
        int totalSegmentStringSize = numberSize(totalSegments);
        int segmentIndex = 0;
        
        int wordIndex = 0;
        int lengthAllowed = 160;
        int segmentSize = 0;
        StringJoiner sj;

        while (segmentIndex < totalSegments) {
            segmentIndex++;
            lengthAllowed = 160 - (4 + totalSegmentStringSize + numberSize(segmentIndex));

            segmentSize = 0;
            sj = new StringJoiner(" ");
            int wordSize = 0;
            boolean isLeadingWord = true;
            while (wordIndex < words.size()) {
                String word = words.get(wordIndex);
                if (isLeadingWord) {
                    wordSize = word.length();
                    isLeadingWord = false;
                } else wordSize = word.length() + 1; // Include space in word size

                if (segmentSize + wordSize > lengthAllowed) {
                    break;
                }
                segmentSize += wordSize;
                sj.add(word);
                wordIndex++;
            }
            resultList.add(String.format("%s (%d/%d)", sj.toString(), segmentIndex, totalSegments));
            System.out.println(String.format("%s, Size: %d, Allowed: %d", resultList.get(segmentIndex - 1), resultList.get(segmentIndex - 1).length(), lengthAllowed));
        }
        return resultList; //Arrays.asList(message.split("(?<=\\G.{160})"));
    }
}