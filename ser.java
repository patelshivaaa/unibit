import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArraySumCombinations {
    public static int[][] findCombinations(int[] nums, int target) {
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                List<Integer> pair = Arrays.asList(nums[i], nums[j]);
                map.putIfAbsent(sum, new ArrayList<>());
                map.get(sum).add(pair);
            }
        }

        List<List<Integer>> combinations = map.getOrDefault(target, new ArrayList<>());
        int[][] result = new int[combinations.size()][2];
        for (int i = 0; i < combinations.size(); i++) {
            List<Integer> pair = combinations.get(i);
            result[i][0] = pair.get(0);
            result[i][1] = pair.get(1);
        }

        return result;
    }

    public static int[][] doubleTargetCombinations(int[] nums, int target) {
        int doubleTarget = target * 2;
        List<List<Integer>> combinations = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (sum == doubleTarget) {
                    List<Integer> pair = Arrays.asList(nums[i], nums[j]);
                    combinations.add(pair);
                }
            }
        }

        int[][] result = new int[combinations.size()][2];
        for (int i = 0; i < combinations.size(); i++) {
            List<Integer> pair = combinations.get(i);
            result[i][0] = pair.get(0);
            result[i][1] = pair.get(1);
        }

        return result;
    }

    public static int[] mergeAndSort(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, merged, 0, nums1.length);
        System.arraycopy(nums2, 0, merged, nums1.length, nums2.length);
        Arrays.sort(merged);
        return merged;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 2, 2, -4, -6, -2, 8 };
        int target = 4;

        int[][] firstCombinations = findCombinations(nums, target);
        System.out.println("First Combination For \"" + target + "\":");
        for (int[] combination : firstCombinations) {
            System.out.println(Arrays.toString(combination));
        }

        int[] merged = mergeAndSort(nums, nums);
        System.out.println("Merge Into a single Array:");
        System.out.println(Arrays.toString(merged));

        int[][] secondCombinations = doubleTargetCombinations(merged, target);
        System.out.println("Second Combination For \"" + (target * 2) + "\":");
        for (int[] combination : secondCombinations) {
            System.out.println(Arrays.toString(combination));
        }
    }
}