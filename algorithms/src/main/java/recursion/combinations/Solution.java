package recursion.combinations;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        dfs(1, n, k);
        return ans;
    }

    private void dfs(int current, int n, int k){
        if (path.size() + (n-current+1) < k){
            // 不可能凑齐，剪枝
            return;
        }
        if (path.size() == k){
            ans.add(new ArrayList<>(path));
            return;
        }
        path.add(current);
        dfs(current+1, n, k);
        path.remove(path.size() - 1);
        dfs(current + 1, n, k);
    }

    @Test
    public void Test1(){
        List<List<Integer>> ans = combine(4, 2);
        for (List<Integer> path:ans) {
            System.out.println(Arrays.toString(path.toArray()));
        }
    }
}
