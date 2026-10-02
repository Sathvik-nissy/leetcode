import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder ans = new StringBuilder();
        gen(n, ans, res, 0, 0);
        return res;
    }

    private void gen(int n, StringBuilder ans, List<String> res, int op, int cl) {
        if (op == n && cl == n) {
            res.add(ans.toString());
            return;
        }
        if (op < n) {
            ans.append('(');
            gen(n, ans, res, op + 1, cl);
            ans.deleteCharAt(ans.length() - 1);
        }
        if (cl < op) {
            ans.append(')');
            gen(n, ans, res, op, cl + 1);
            ans.deleteCharAt(ans.length() - 1);
        }
    }
}