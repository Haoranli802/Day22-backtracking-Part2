class Solution {
    List<List<Integer>> result;
    List<Integer> path;
    public List<List<Integer>> combinationSum3(int k, int n) {
        result = new ArrayList<>();
        path = new ArrayList<>();
        backTracking(k, n, 1);
        return result;
    }
    private void backTracking(int k, int n, int start){
        if(path.size() == k && n == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i = start; i <= 9 - (k - path.size()) + 1; i++){
            if(i > n) break;
            path.add(i);
            backTracking(k, n - i, i+1);
            path.removeLast();
        }
    }
}
// O(N * 2^N), O(N)
