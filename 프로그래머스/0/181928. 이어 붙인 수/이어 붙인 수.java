class Solution {
    public int solution(int[] num_list) {
        return intCalculate(num_list);
    }

    private int stringCalculate(int[] num_list) {
        StringBuilder even = new StringBuilder();
        StringBuilder odd = new StringBuilder();

        for (int num : num_list) {
            if (num % 2 == 0) even.append(num);
            else odd.append(num);
        }

        return Integer.valueOf(even.toString()) + Integer.valueOf(odd.toString());
    }

    private int intCalculate(int[] num_list) {
        int even = 0;
        int odd = 0;

        for (int num : num_list) {
            if (num % 2 == 0) {
                even = even * 10 + num;
            } else {
                odd = odd * 10 + num;
            }
        }

        return even + odd;
    }
}
