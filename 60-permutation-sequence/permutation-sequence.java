class Solution {
    public String getPermutation(int n, int k) {

        List<Integer> numbers = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        // factorial[i] = i!
        int[] factorial = new int[n + 1];
        factorial[0] = 1;

        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        // Convert k from 1-based to 0-based
        k--;

        StringBuilder result = new StringBuilder();

        for (int remaining = n; remaining > 0; remaining--) {

            int blockSize = factorial[remaining - 1];

            int index = k / blockSize;

            result.append(numbers.get(index));
            numbers.remove(index);

            k %= blockSize;
        }

        return result.toString();
    }
}