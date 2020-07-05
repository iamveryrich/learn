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
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.Test;


//leetcode submit region begin(Prohibit modification and deletion)
public class GroupAnagramsUseMap {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> strMap = new HashMap<String,List<String>>();
        String key = null;
        for(int i=0,j=strs.length;i<j;i++){
            key = getSortStr(strs[i]);
            if(strMap.containsKey(key)){
                strMap.get(key).add(strs[i]);
                continue;
            }
            List<String> list = new ArrayList<>();
            list.add(strs[i]);
            strMap.put(key,list);
        }
        return new ArrayList<>(strMap.values());
    }

    public String getSortStr(String str){
        char[] charArr = str.toCharArray();
        Arrays.sort(charArr);
        return new String(charArr);
    }

    @Test
    public void test(){
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

}
//leetcode submit region end(Prohibit modification and deletion)

