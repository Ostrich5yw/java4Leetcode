package hardDifficulty;

import java.util.ArrayList;
import java.util.List;

public class p282 {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return res;
        }

        help(num, target, 0, 0, 0, "", res);
        return res;
    }

    private void help(String num, int target, long curRes, long diff, int start, String curExp, List<String> expressions) {
        if (start == num.length() && (long)target == curRes) {
            expressions.add(new String(curExp));
        }

        for (int i = start; i < num.length(); i++) {
            String cur = num.substring(start, i + 1);
            if (cur.length() > 1 && cur.charAt(0) == '0') {     //按照题目要求，得到的操作数不应该包含前导0，即'0'只能以数字0加入表达式
                break;
            }

            if (curExp.length() > 0) {
                help(num, target, curRes + Long.valueOf(cur), Long.valueOf(cur), i + 1, curExp + "+" + cur, expressions);
                help(num, target, curRes - Long.valueOf(cur), -Long.valueOf(cur), i + 1, curExp + "-" + cur, expressions);
                help(num, target, (curRes - diff) + diff * Long.valueOf(cur), diff * Long.valueOf(cur),
                        i + 1, curExp + "*" + cur, expressions);
            } else {
                help(num, target, Long.valueOf(cur), Long.valueOf(cur), i + 1, cur, expressions);
            }
        }
    }
}
