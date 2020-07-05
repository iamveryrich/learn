package Week_02.anagram;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

//leetcode submit region begin(Prohibit modification and deletion)
public class Anagram {
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null || s.length() == 0 || s.length() != t.length()){
            return false;
        }

        return useArray(s,t);
    }

    public boolean useMap(String s, String t){
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        int len = chars1.length;
        Map<Character,Integer> charMap = new HashMap<Character, Integer>();
        for(int i=0;i<len;i++){
            if(charMap.containsKey(chars1[i])){
                charMap.put(chars1[i],charMap.get(chars1[i])+1);
            }else{
                charMap.put(chars1[i],1);
            }
            if(charMap.containsKey(chars2[i])){
                charMap.put(chars2[i],charMap.get(chars2[i])-1);
            }else{
                charMap.put(chars2[i],-1);
            }
        }
        for(int value : charMap.values()){
            if(value > 0){
                return false;
            }
        }
        return true;
    }
    public boolean useArray(String s, String t) {
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        int len = chars1.length;
        int[] result = new int[26];
        for(int i=0;i<len;i++){
            result[chars1[i] - 'a']++;
            result[chars2[i] - 'a']--;
        }
        for(int value : result){
            if(value > 0){
                return false;
            }
        }
        return true;
    }
    public boolean useSortAndEquals(String s, String t){
        char[] chars1 = s.toCharArray();
        Arrays.sort(chars1);
        char[] chars2 = t.toCharArray();
        Arrays.sort(chars2);
        return Arrays.equals(chars1,chars2);

    }
    @Test
    public void isAnagram(){
        System.out.println(isAnagram("anagram","nagaram"));
        System.out.println(isAnagram("rat","car"));
    }


}
//leetcode submit region end(Prohibit modification and deletion)

