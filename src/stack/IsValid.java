package stack;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author DELL
 * //给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * //
 * // 有效字符串需满足：
 * //
 * //
 * // 左括号必须用相同类型的右括号闭合。
 * // 左括号必须以正确的顺序闭合。
 * //
 * 思路：遍历数组，如果是左括号，将其压入堆，如果是右括号，判断是否为与栈顶对应的左括号匹配
 * 如果匹配直接弹出，不匹配直接返回false,遍历完之后如果栈为空就为true，否则为false
 */
public class IsValid {
    public boolean solution(String s) {
        Stack<Character> stack = new Stack<Character>();
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                char temp = stack.empty() ? '#' : stack.pop();
                if (temp != map.get(c)) {return false;}
            } else {stack.push(c);}
        }
        return stack.isEmpty();

    }

    public static void main(String[] args) {
        String s1 = "()）";
        String s2 = "()[]{}";
        String s3 = "(]";
        String s4 = "([)]";
        String s5 = "{[]}";

        IsValid isValid = new IsValid();
        System.out.println(isValid.solution(s1));
        System.out.println(isValid.solution(s2));
        System.out.println(isValid.solution(s3));
        System.out.println(isValid.solution(s4));
        System.out.println(isValid.solution(s5));
    }
}
