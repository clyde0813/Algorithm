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

        long evenValue = even.length() > 0 ? Long.parseLong(even.toString()) : 0;
        long oddValue = odd.length() > 0 ? Long.parseLong(odd.toString()) : 0;

        long sum = evenValue + oddValue;
        return (int) sum;
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
