package arrary;

import java.util.HashMap;
import java.util.Map;

public class LengthOflongestSubstring {

    public int solution(String s) {
//        int end = 0;
//        int maxSize = 0;
//        int start = 0;
//        HashMap<Character, Integer> map = new HashMap<>(s.length());
//        for (; start < s.length(); start++) {
//            if (!map.containsKey(s.charAt(start))) {
//                map.put(s.charAt(start), start);
//            } else {
//                maxSize = Math.max(maxSize,start-end);
//                for (int i = end; i < map.get(s.charAt(start)); i++) {
//                    map.remove(s.charAt(i));
//                }
//                end = map.get(s.charAt(start))+1;
//                map.put(s.charAt(start), start);
//            }
//        }
//        return Math.max(maxSize,start-end);
        int[] last = new int[128];
        for (int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;
        int start = 0; // 窗口开始位置
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            res = Math.max(res, i - start + 1);
            last[index] = i;
        }

        return res;

    }

    public static void main(String[] args) {
        LengthOflongestSubstring substring = new LengthOflongestSubstring();

        String target1 = "dvdf";
        String target2 = "bbbbb";
        String target3 = "cdd";

        System.out.println(substring.solution(target1));
        System.out.println(substring.solution(target2));
        System.out.println(substring.solution(target3));
    }

}
