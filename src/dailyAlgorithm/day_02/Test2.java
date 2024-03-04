package dailyAlgorithm.day_02;


import java.util.*;

/**
 * 思路：在这个实现中，我们使用一个布尔型数组 dp 来记录字符串 s 的子串是否可以被拆分成字典中的单词。
 * 具体地，dp[i] 表示字符串 s 的前 i 个字符（下标从 1 开始）是否可以被拆分成字典中的单词。
 * 初始化时，空字符串可以被拆分，所以 dp[0] = true。
 * 然后，我们使用两层循环来遍历字符串 s 的所有子串，并判断它们是否可以被拆分。
 * 如果存在一个前缀子串可以被拆分，并且剩余部分是字典中的单词，那么当前子串也可以被拆分，因此 dp[i] = true。
 * 最后，返回 dp[n]，其中 n 是字符串 s 的长度，表示整个字符串是否可以被拆分成字典中的单词。
 */


@SuppressWarnings("DuplicatedCode")
public class Test2 {

    private static final List<String> wordDic = Arrays.asList("pre", "ish", "ing", "do", "child", "tend");


    public static void main(String[] args) {
        System.out.println("请输入");
        String word = new Scanner(System.in).next();
        System.out.println(wordSplit(word) ? "可以" : "不行");

    }

    private static boolean wordSplit(String word) {
        int n = word.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        Set<String> subWords = new HashSet<>(wordDic);
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && subWords.contains(word.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}
