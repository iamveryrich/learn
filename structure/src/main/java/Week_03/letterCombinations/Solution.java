package Week_03.letterCombinations;//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
//
//
//
// 示例:
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
//
//
// 说明:
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
// Related Topics 字符串 回溯算法


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {

  public List<String> letterCombinations(String digits) {
    List<String> result = new ArrayList<>();
    if(digits == null || digits.length() == 0){
      return null;
    }
    Map<Character, String> phone = new HashMap<Character, String>() {{
      put('2', "abc");
      put('3', "def");
      put('4', "ghi");
      put('5', "jkl");
      put('6', "mno");
      put('7', "pqrs");
      put('8', "tuv");
      put('9', "wxyz");
    }};

    //结果存储对象(不变的参数3)
    //字符与字母的映射关系(不变的参数4)
    searchCombin("",0,digits,phone,result);
    return result;
  }

  private void searchCombin(String s, int index, String digits,Map<Character, String> phone, List<String> result) {
    if(index ==  (digits.length())){
      result.add(s);
      return;
    }
    //要和哪个字符串进行拼接(入参1)
    Character charKey = digits.charAt(index);
    //要对哪些字符进行判断(入参2)
    String letters = phone.get(charKey);
    //要拼接这个字符对应的哪些字母（处理过程）
    index++;
    for(Character letter : letters.toCharArray()){
      searchCombin(s.concat(letter.toString()),index,digits,phone,result);
    }
  }

  @Test
  public void test() {
    System.out.println(letterCombinations("236"));
  }

}
//leetcode submit region end(Prohibit modification and deletion)

