package dailyAlgorithm.day_02;


import java.util.*;

/**
 * TODO 给定一个非空字符串 s 和一个包含非空单词的字典，判断 s 是否可以被拆分成字典中的单词。你可以假设字典中没有重复的单词。
 *
 *
 * 思路：在这个实现中，我们使用一个布尔型数组 dp 来记录字符串 s 的子串是否可以被拆分成字典中的单词。
 *      具体地，dp[i] 表示字符串 s 的前 i 个字符（下标从 1 开始）是否可以被拆分成字典中的单词。
 *      初始化时，空字符串可以被拆分，所以 dp[0] = true。
 *      然后，我们使用两层循环来遍历字符串 s 的所有子串，并判断它们是否可以被拆分。
 *      如果存在一个前缀子串可以被拆分，并且剩余部分是字典中的单词，那么当前子串也可以被拆分，因此 dp[i] = true。
 *      最后，返回 dp[n]，其中 n 是字符串 s 的长度，表示整个字符串是否可以被拆分成字典中的单词。
 */
public class Test {

    private static final List<String> wordDic = Arrays.asList("pre", "ish", "ing", "do", "child", "tend");


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入单词:");
        String word = scanner.next();
        System.out.println(splitWord(word) ? "可以拆分" : "不可拆分");
    }

    public static boolean splitWord(String word) {
        // 将List装换为Set集合，便于快速查找
        Set<String> set = new HashSet<>(wordDic);
        int n = word.length();
        // dp数组，dp[i]表示word的前i个字符能否被wordDic拆分
        boolean[] dp = new boolean[n + 1];
        // 初始化空字符串可以被拆分
        dp[0] = true;

        // 遍历word
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                // 如果前缀字串可以被拆分，并且剩余部分是字典中的单词
                if (dp[j] && set.contains(word.substring(j, i))) {
                    // 则当前字串也可以被拆分
                    dp[i] = true;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        // 返回整个字符串word是否可以被拆分
        return dp[n];
    }
}
