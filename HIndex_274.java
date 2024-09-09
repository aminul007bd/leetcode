public class HIndex_274 {
    /*Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper, return the researcher's h-index.
    According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such that the given researcher has published
    at least h papers that have each been cited at least h times.

   Example 1:
    Input: citations = [3,0,6,1,5]
    Output: 3
    Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
    Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.*/

    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] buckets = new int[n+1];
        for(int c : citations) {
            if(c >= n) {
                buckets[n]++;
            } else {
                buckets[c]++;
            }
        }
        int count = 0;
        for(int i = n; i >= 0; i--) {
            count += buckets[i];
            if(count >= i) {
                return i;
            }
        }
        return 0;
    }
}

/*
This Java solution calculates the **H-index** of a researcher based on their citation counts.
The **H-index** is defined as the maximum value `h` such that the researcher has published `h` papers,
each of which has been cited at least `h` times.

### Explanation

#### 1. **Variables and Initialization:**

        - `n`: Stores the number of papers (i.e., the length of the `citations` array).
        - `buckets[]`: An array of size `n + 1` that is used to count the number of papers with a specific citation count.
        The `buckets` array is initialized with zeros.

#### 2. **Filling the `buckets[]` Array:**

        for(int c : citations) {
                if(c >= n) {
        buckets[n]++;
                } else {
        buckets[c]++;
                }
                }
        - For each citation `c` in the `citations` array:
        - If `c` (the number of citations) is **greater than or equal to** `n` (the number of papers), we increment `buckets[n]`.
        This is because any citation count greater than or equal to `n` is treated the same, as having more than `n` citations doesn't
        impact the H-index (since the H-index can only be as large as the number of papers `n`).
        - Otherwise, increment `buckets[c]` because the paper has exactly `c` citations.

#### 3. **Calculating the H-index:**

        int count = 0;
        for(int i = n; i >= 0; i--) {
        count += buckets[i];
                if(count >= i) {
                return i;
            }
                    }

            - Now we traverse the `buckets[]` array **backward** (from `n` to `0`):
        - We maintain a `count`, which accumulates the number of papers with `i` or more citations.
        - For each `i`, if `count` (the total number of papers with at least `i` citations) is **greater than or
        equal to `i`**, then `i` is the **H-index** because there are at least `i` papers with `i` or more citations.

        #### 4. **Return Value:**

        - The moment the condition `count >= i` is satisfied, we return `i` as the H-index.
        - If no such value `i` is found, the function returns `0`.

        ### Example
        If the input is `citations = [3, 0, 6, 1, 5]`:

        1. `n = 5` (5 papers).
        2. Initialize `buckets` to `[0, 0, 0, 0, 0, 0]`.
        3. Iterate through the `citations` array:
        - `3` → `buckets[3]++` → `[0, 0, 0, 1, 0, 0]`
        - `0` → `buckets[0]++` → `[1, 0, 0, 1, 0, 0]`
        - `6` → `buckets[5]++` (since `6 >= n`) → `[1, 0, 0, 1, 0, 1]`
        - `1` → `buckets[1]++` → `[1, 1, 0, 1, 0, 1]`
        - `5` → `buckets[5]++` → `[1, 1, 0, 1, 0, 2]`

        4. Traverse `buckets[]` from right to left:
        - `count = 0`
        - Start with `i = 5`: `count = 2`. Since `count < 5`, move on.
        - For `i = 4`: `count = 2`. Since `count < 4`, move on.
        - For `i = 3`: `count = 3` (now `count >= 3`), so return `3` as the H-index.

The output will be `3`, meaning the researcher has at least 3 papers with 3 or more citations.*/
