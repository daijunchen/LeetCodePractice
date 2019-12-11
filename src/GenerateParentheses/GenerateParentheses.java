package GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

/**
 *  代码比较丢人，这里直接使用递归+枚举。在对括号的匹配使用了栈。
 *
 *  假设当前位置是“（” 或者 “）”的情况，并遍历下面的节点是否能闭合括号。
 *
 **/

//@SuppressWarnings("ALL")
public class GenerateParentheses {
    public static void main(String[] args) {
        List<String> strings = generateParenthesis(3);
        System.out.println(strings);
    }

    public static List<String> generateParenthesis(int n) {
        List<String> list = getLIst(new ArrayList<>(), new ArrayList<>(), new StringBuilder(), n, 2 * n);
        ArrayList<String> result = new ArrayList<>(list);
        return result;
    }

    public static List<String> getLIst(List<String> result, List<String> stack, StringBuilder s, int n, int current){

        // 大于0说明还没拼完
        if (current > 0) {
            ArrayList<String> strings = new ArrayList<>(stack);

                strings.add("(");
                s.append("(");
                getLIst(result,strings,s,n,current - 1);
                int length = s.length();
                s.deleteCharAt(length - 1);
                int size = strings.size();
                strings.remove(size - 1);

                int size2 = strings.size();
                if (size2 > 0){
                    String left = strings.get(size2 - 1);
                    if (left.equals("(")){
                        strings.remove(size2 - 1);
                        s.append(")");
                        getLIst(result,strings,s,n,current - 1);
                        int length2 = s.length();
                        s.deleteCharAt(length2 - 1);
                    }
            }
            System.out.println();
        }else {
            // 否则就是拼完了，判断是否符合规则
            boolean b = stack.size() > 0;
            if (b) {
                return result;
            }else {
                result.add(s.toString());
                return result;
            }
        }



        return result;
    }

}
