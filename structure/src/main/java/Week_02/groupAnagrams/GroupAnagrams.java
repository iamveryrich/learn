package Week_02.groupAnagrams;//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
//
// 示例:
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//]
//
// 说明：
//
//
// 所有输入均为小写字母。
// 不考虑答案输出的顺序。
//
// Related Topics 哈希表 字符串


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Test;


//leetcode submit region begin(Prohibit modification and deletion)
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result = new ArrayList<>();

        Set<Integer> indexSet = new HashSet<>();
        int len = strs.length;
        for(int i=0,l=len;i<l;i++){
            if(indexSet.contains(i)){
                continue;
            }

            List<String> group = new ArrayList<>();
            group.add(strs[i]);
            indexSet.add(i);


            for(int j=i;j<len;j++){
                if(indexSet.contains(j)){
                    continue;
                }

                if(isAnagrams(strs[i],strs[j])){
                    group.add(strs[j]);
                    indexSet.add(j);
                }
            }
            result.add(group);
        }
        return result;
    }

    public boolean isAnagrams(String str1, String str2){
        if(str1 == null || str2 == null || str1.length() != str2.length()){
            return false;
        }
        char[] char1 = str1.toCharArray();
        char[] char2 = str2.toCharArray();
        int[] temp = new int[26];
        for(int i=0,j=char1.length;i<j;i++){
            temp[char1[i] - 'a']++;
            temp[char2[i] - 'a']--;
        }
        for(int i : temp){
            if(i>0){
                return false;
            }
        }
        return true;
    }

    @Test
    public void test(){
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

}
//leetcode submit region end(Prohibit modification and deletion)

