class Solution {
    StringBuilder sb;
    List<String> result;
    public List<String> letterCombinations(String digits) {
        String[] dict = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        sb = new StringBuilder();
        result = new ArrayList<>();
        if(digits == null || digits.length() == 0) return result;
        backTracking(digits, 0, dict);
        return result;
    }
    private void backTracking(String digits, int start, String[] dict){
        if(sb.length() == digits.length()){
            result.add(sb.toString());
        }
        for(int i = start; i < digits.length(); i++){
            String temp = dict[digits.charAt(i) - '0'];
            for(int j = 0; j < temp.length(); j++){
                sb.append(temp.charAt(j));
                backTracking(digits, i + 1, dict);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}

//时间复杂度: O(3^m * 4^n)，其中 m 是对应四个字母的数字个数，n 是对应三个字母的数字个数
//空间复杂度: O(3^m * 4^n)
