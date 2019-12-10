package ValidParentheses;

import java.util.ArrayList;

/**
 * 使用list自己实现一个栈结构，然后就是很简单的匹配了，需要注意的特殊情况有：
 *  1. 上来就是右括号，导致的index超出边界的问题
 */
public class ValidParentheses {
    public static void main(String[] args) {
        boolean valid = isValid("()[]{");
        System.out.println(valid);
    }

    public static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        ArrayList<Character> stack = new ArrayList<>();
        int index = -1;

        for (char aChar : chars) {
            char c = checkChar(aChar);
            if (c == aChar){
                stack.add(c);
                index ++;
            }else {
                boolean match = match(stack.get(index), aChar);
                if (!match){
                    return false;
                }else {
                    stack.remove(index);
                    index--;
                }
            }
        }
        if (index > -1) {
            return false;
        }
        return true;
    }

    static boolean match(char left, char right){
        switch (left){
            case '(':
                return ')' == right;
            case '{':
                return '}' == right;
            case '[':
                return ']' == right;
            default:
                return false;
        }
    }
    static char checkChar(char c){
        switch (c){
            case ')':
                return '(';
            case '}':
                return '{';
            case ']':
                return '[';
            default:
                return c;
        }
    }
}
