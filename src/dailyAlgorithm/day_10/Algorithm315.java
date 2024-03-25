package dailyAlgorithm.day_10;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author wangyilin
 * @date 2024/3/15 17:42
 */
public class Algorithm315 {

    public static void main(String[] args) {
        Algorithm315 main = new Algorithm315();
//        System.out.println(main.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(main.groupAnagramsFlow(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));

    }

    /**
     * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
     * <p>
     * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
     */
    private List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hashMap = new HashMap<>();
        int i = 0;
        for (var str : strs) {
            char[] chars = str.toCharArray();
            System.out.println(i + "-----" + Arrays.toString(chars));

            Arrays.sort(chars);
            System.out.println(i + "-----" + Arrays.toString(chars));

            String s = new String(chars);

            List<String> list = hashMap.getOrDefault(s, new ArrayList<>());

            list.add(s);

            hashMap.put(s, list);
            i++;
            System.out.println();
        }
        return new ArrayList<List<String>>(hashMap.values());
    }

    private List<List<String>> groupAnagramsFlow(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            StringBuilder sb = new StringBuilder();
            str.chars().sorted().forEach(sb::appendCodePoint);
            String key = sb.toString();

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        List<List<String>> result = new ArrayList<>(map.values());
        return result;
//        return new ArrayList<>(Arrays.stream(strs).collect(Collectors.groupingBy(str -> str.chars().sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString())).values());
    }


}
