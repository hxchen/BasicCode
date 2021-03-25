package rangeModule;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Range 模块是跟踪数字范围的模块。你的任务是以一种有效的方式设计和实现以下接口。
 *
 * addRange(int left, int right) 添加半开区间 [left, right)，跟踪该区间中的每个实数。添加与当前跟踪的数字部分重叠的区间时，应当添加在区间 [left, right) 中尚未跟踪的任何数字到该区间中。
 * queryRange(int left, int right) 只有在当前正在跟踪区间 [left, right) 中的每一个实数时，才返回 true。
 * removeRange(int left, int right) 停止跟踪区间 [left, right) 中当前正在跟踪的每个实数。
 *  
 *
 * 示例：
 *
 * addRange(10, 20): null
 * removeRange(14, 16): null
 * queryRange(10, 14): true （区间 [10, 14) 中的每个数都正在被跟踪）
 * queryRange(13, 15): false （未跟踪区间 [13, 15) 中像 14, 14.03, 14.17 这样的数字）
 * queryRange(16, 17): true （尽管执行了删除操作，区间 [16, 17) 中的数字 16 仍然会被跟踪）
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-module
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author haixiangchen
 */
public class RangeModule {
    TreeSet<Interval> ranges;
    public RangeModule() {
        ranges = new TreeSet();
    }

    public void addRange(int left, int right) {
        Iterator<Interval> itr = ranges.tailSet(new Interval(0, left - 1)).iterator();
        while (itr.hasNext()) {
            Interval iv = itr.next();
            if (right < iv.left) {
                break;
            }
            left = Math.min(left, iv.left);
            right = Math.max(right, iv.right);
            itr.remove();
        }
        ranges.add(new Interval(left, right));
    }

    public boolean queryRange(int left, int right) {
        Interval iv = ranges.higher(new Interval(0, left));
        return (iv != null && iv.left <= left && right <= iv.right);
    }

    public void removeRange(int left, int right) {
        Iterator<Interval> itr = ranges.tailSet(new Interval(0, left)).iterator();
        ArrayList<Interval> todo = new ArrayList();
        while (itr.hasNext()) {
            Interval iv = itr.next();
            if (right < iv.left) {
                break;
            }
            if (iv.left < left) {
                todo.add(new Interval(iv.left, left));
            }
            if (right < iv.right) {
                todo.add(new Interval(right, iv.right));
            }
            itr.remove();
        }
        for (Interval iv: todo) {
            ranges.add(iv);
        }
    }

    /**
     * 内部类
     */
    class Interval implements Comparable<Interval>{
        int left;
        int right;

        public Interval(int left, int right){
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Interval that){
            if (this.right == that.right) {
                return this.left - that.left;
            }
            return this.right - that.right;
        }
    }

    public static void main(String[] args) {
        RangeModule rangeModule = new RangeModule();
        rangeModule.addRange(10,20);
        rangeModule.removeRange(14,16);
        boolean ret1 = rangeModule.queryRange(10,14);
        System.out.println(ret1);
        boolean ret2 = rangeModule.queryRange(13,15);
        System.out.println(ret2);
        boolean ret3 = rangeModule.queryRange(16,17);
        System.out.println(ret3);
    }

}
