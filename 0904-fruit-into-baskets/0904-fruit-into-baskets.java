class Solution {
    public int totalFruit(int[] arr) {
        int l = 0, max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int r = 0; r < arr.length; r++) {
            map.put(arr[r], map.getOrDefault(arr[r], 0) + 1);

            while (map.size() > 2) {
                map.put(arr[l], map.get(arr[l]) - 1);

                if (map.get(arr[l]) == 0) {
                    map.remove(arr[l]);
                }

                l++;
            }

            max = Math.max(max, r - l + 1);
        }

        return max;
    }
}