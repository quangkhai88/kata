package interview.algo;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FreqSmallestChar {

    public static void main(String[] args) {


      String[] ws = new String[]{"a","aa","aaa","aaaa"};
      String[] q = new String[]{"bbb","cc", "cccce"};

      for (int i: numSmallerByFrequency(q, ws))
          System.out.println( i);
    }

    private static void testBs() {
        int[] arr = new int[] { 1 ,3 ,5, 7, 9 };
        int l = 0;
        int r = arr.length -1;
        int val = -2;
        while (l < r) {
            int m = l + (r - l)/2;
            if (arr[m] > val)
                r = m;
            else
                l = m + 1;
        }
        System.out.println("ret = " + l);
    }

    public static int[] numSmallerByFrequency(String[] queries, String[] words) {
        Map<Integer, Integer> m = new HashMap<>();
        for (String s: words) {
            int v = f(s);
            m.put(v, m.getOrDefault(v,0) + 1);
        }
        List<Integer> keys = m.keySet().stream().sorted().toList();
        Map<Integer, Integer> sum = new HashMap<>();
        int cur = 0;
        for (int i = keys.size() -1; i >=0 ; i--) {
            int k = keys.get(i);
            cur += m.get(k);
            sum.put(k, cur);
        }
        int[] ret = new int[queries.length];
        int j = 0;
        for (String s: queries) {
            int val = f(s); // val < arr ( min index)
            if (val >= keys.get(keys.size() -1)) {
                ret[j++] = 0;
                continue;
            }
            int l = bs(keys, val);
            ret[j++] = sum.get(keys.get(l));
        }
        return ret;
    }

    static int bs(List<Integer> keys, int val) {
        int l = 0, r = keys.size() -1;
        while (l < r) {
            int mi = l + (r - l)/2;
            if (keys.get(mi) > val) {
                r = mi;
            } else {
                l = mi + 1;
            }
        }
        return l;
    }

    static int f (String s) {
        int[] arr = new int[26];
        for ( char c: s.toCharArray()) {
            arr[c-'a'] ++;
        }
        for (int i: arr) {
            if (i > 0) return i;
        }
        return 0;
    }
}
