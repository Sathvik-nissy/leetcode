// class Solution {
//     public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

//         int mat[][] = new int[n + 1][11];

//         for (int i = 0; i < reservedSeats.length; i++) {
//             mat[reservedSeats[i][0]][reservedSeats[i][1]] = 1;
//         }

//         int ck[] = new int[n];

//         for (int i = 1; i <= n; i++) {

//             // Left group: 2 3 4 5
//             boolean left = true;
//             for (int j = 2; j <= 5; j++) {
//                 if (mat[i][j] == 1) {
//                     left = false;
//                     break;
//                 }
//             }

//             // Right group: 6 7 8 9
//             boolean right = true;
//             for (int j = 6; j <= 9; j++) {
//                 if (mat[i][j] == 1) {
//                     right = false;
//                     break;
//                 }
//             }

//             if (left && right) {
//                 ck[i - 1] = 2;
//             }
//             else if (left || right) {
//                 ck[i - 1] = 1;
//             }
//             else {
//                 // Check middle: 4 5 6 7
//                 boolean middle = true;

//                 for (int j = 4; j <= 7; j++) {
//                     if (mat[i][j] == 1) {
//                         middle = false;
//                         break;
//                     }
//                 }

//                 if (middle) {
//                     ck[i - 1] = 1;
//                 }
//             }
//         }

//         int c = 0;

//         for (int i = 0; i < n; i++) {
//             c += ck[i];
//         }

//         return c;
//     }
// }



class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        HashMap<Integer, int[]> map = new HashMap<>();

        for (int i = 0; i < reservedSeats.length; i++) {

            int row = reservedSeats[i][0];
            int seat = reservedSeats[i][1];

            if (!map.containsKey(row)) {
                map.put(row, new int[11]);
            }

            map.get(row)[seat] = 1;
        }

        int c = (n - map.size()) * 2;

        for (int row : map.keySet()) {

            int[] mat = map.get(row);

            int left = 0;
            int right = 0;
            int middle = 0;

            for (int j = 2; j <= 5; j++) {
                if (mat[j] == 1)
                    left++;
            }

            for (int j = 6; j <= 9; j++) {
                if (mat[j] == 1)
                    right++;
            }

            for (int j = 4; j <= 7; j++) {
                if (mat[j] == 1)
                    middle++;
            }

            if (left == 0 && right == 0)
                c += 2;

            else if (left == 0 || right == 0)
                c += 1;

            else if (middle == 0)
                c += 1;
        }

        return c;
    }
}