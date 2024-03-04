package dailyAlgorithm.day_04;


import java.util.*;

/**
 * TODO 题目：判断一个字符串是否是有效的括号序列。
 * <p>
 * 给定一个只包含字符 '(', ')', '{', '}', '[' 和 ']' 的字符串，判断字符串是否有效。有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 例如：
 * 输入: "()"
 * 输出: true
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * <p>
 * 输入: "(]"
 * 输出: false
 * <p>
 * 输入: "([)]"
 * 输出: false
 * <p>
 * 输入: "{[]}"
 * 输出: true
 * 编写一个函数，接受一个字符串作为参数，返回一个布尔值，表示字符串是否是有效的括号序列。
 */
public class Test {


    public static void main(String[] args) {
        System.out.println("请输入");
        String brackets = new Scanner(System.in).next();
        System.out.println((new Test().bracketCheck(brackets)) ? "合规" : "不合规");
    }


    public boolean bracketCheck(String brackets) {
        Stack<Character> stack = new Stack<>();
        for (char bracket : brackets.toCharArray()) {
            if (bracket == '(' || bracket == '{' || bracket == '[') {
                stack.push(bracket);
            } else {
                if (stack.empty()) {
                    return false;
                }
                char pop = stack.pop();
                if ((bracket == ')' && pop != '(') || (bracket == '}' && pop != '{') || (bracket == ']' && pop != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


}
