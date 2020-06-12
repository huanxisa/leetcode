package arrary;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author DELL
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */



public class TwoSum {
    private static int[] NUM = {2, 7, 11, 15};

    private static int TARGET = 9;

    private static int[] solution1() {
        //解决方案:全部存入hashMap，值为键，坐标为值。
        Map map = new HashMap<Integer, Integer>();
        for(int i = 0; i < NUM.length; i ++){
            //先查找，后放入，能够避免使用同一个元素两次

            Integer index = (Integer) map.get(TARGET - NUM[i]);

            if (index == null) {
                map.put(NUM[i] , i);
            }else {
                return new int[]{i,index};
            }
        }

        throw new RuntimeException("数组中不存在符合条件的数值");

    }

    public static void main(String[] args) {

        int[] solution  = solution1();
        System.out.println(Arrays.toString(solution));
    }
}
/**
 * 思路分析：
 * 初见：暴力破解，一遍一遍遍历。时间复杂度为N^2.空间复杂度为0
 *
 * 官方给出解法：将这a和b加起来等于c，转化为寻找c-a问题,及转化为查找问题。
 *
 *
 */