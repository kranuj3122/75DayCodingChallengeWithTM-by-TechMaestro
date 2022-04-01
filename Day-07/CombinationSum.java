
public class CombinationSum {
    static List<List<Integer>> ans;
    static void backtrack(int[] nums, int ind, int sum, List<Integer> temp, int target) {
        if(sum == target) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(ind == nums.length) {
            return;
        }
        if(sum + nums[ind] <= target) {
            sum += nums[ind];
            temp.add(nums[ind]);
            backtrack(nums, ind, sum, temp, target);
            sum -= nums[ind];
            temp.remove(temp.size()-1);
        }
        
        backtrack(nums, ind+1, sum, temp, target);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        backtrack(candidates, 0, 0, new ArrayList<>(), target);
        return ans;
    }
}
