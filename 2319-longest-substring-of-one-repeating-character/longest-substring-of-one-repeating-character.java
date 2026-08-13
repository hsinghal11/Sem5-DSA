class Solution {
    char[] rMost, lMost;
    int[] freqOfPre, freqOfSuff;
    int[] overAllMAX;
    char[] str;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices){
        int n = s.length();
        rMost = new char[4*n];
        lMost = new char[4*n];
        freqOfSuff = new int[4*n];
        freqOfPre = new int[4*n];
        overAllMAX = new int[4*n];
        str = s.toCharArray();

        build(0, n-1, 0); // start, end, idx

//        for (int i = 0; i < 4 * n; i++) {
//
//            int left = 2 * i + 1;
//            int right = 2 * i + 2;
//
//            System.out.println(
//                    "Node [" + i + "]" +
//                            " | L=" + (left < 4 * n ? left : -1) +
//                            " | R=" + (right < 4 * n ? right : -1) +
//                            " | MAX=" + overAllMAX[i] +
//                            " | LMost=" + lMost[i] +
//                            "(" + freqOfPre[i] + ")" +
//                            " | RMost=" + rMost[i] +
//                            "(" + freqOfSuff[i] + ")"
//            );
//        }
        int[] ans = new int[queryIndices.length];
        for (int k = 0; k<queryIndices.length; k++){
            update(queryIndices[k], 0, n-1, 0,queryCharacters.charAt(k));
            ans[k] = overAllMAX[0];
        }
        return ans;
    }

    private void update(int queryIndex, int start, int end, int idx, char c) {
        if(start == end){
            lMost[idx] = c;
            rMost[idx] = c;
            return;
        }

        int leftChild = 2 * idx +1;
        int rightChild = 2*idx +2;

        int mid = (start+end) >> 1;
        if(queryIndex <= mid) update(queryIndex, start, mid, idx*2+1, c);
        else update(queryIndex, mid+1, end, idx*2+2, c);

        int leftLen = mid - start + 1;
        int rightLen = end - mid;

        int sum = 0;
        if (rMost[leftChild] == lMost[rightChild]) {
            sum = freqOfSuff[leftChild] + freqOfPre[rightChild];
        }

        // prefix
        if (freqOfPre[leftChild] == leftLen && lMost[leftChild] == lMost[rightChild]) {
            freqOfPre[idx] = leftLen + freqOfPre[rightChild];
        } else {
            freqOfPre[idx] = freqOfPre[leftChild];
        }

        // suffix
        if (freqOfSuff[rightChild] == rightLen && rMost[rightChild] == rMost[leftChild]) {
            freqOfSuff[idx] = rightLen + freqOfSuff[leftChild];
        } else {
            freqOfSuff[idx] = freqOfSuff[rightChild];
        }

        lMost[idx] = lMost[leftChild];
        rMost[idx] = rMost[rightChild];
        overAllMAX[idx] = Math.max(Math.max(overAllMAX[leftChild], overAllMAX[rightChild]), sum);
    }

    private void build(int start, int end, int idx) {
        if(start == end){
            rMost[idx] = str[start];
            lMost[idx] = str[start];
            freqOfSuff[idx] = 1;
            freqOfPre[idx] = 1;
            overAllMAX[idx] = 1;
            return;
        }
        int mid = (start+end)  >> 1;
        int leftChild = 2 * idx +1;
        int rightChild = 2*idx +2;

        build(start, mid, leftChild);
        build(mid+1, end, rightChild);

        resetTree(start, end, mid, leftChild, rightChild, idx);


    }

    private void resetTree(int start, int end, int mid, int leftChild, int rightChild, int idx){
        int leftLen = mid - start + 1;
        int rightLen = end - mid;

        int sum = 0;
        if (rMost[leftChild] == lMost[rightChild]) {
            sum = freqOfSuff[leftChild] + freqOfPre[rightChild];
        }

        // prefix
        if (freqOfPre[leftChild] == leftLen && lMost[leftChild] == lMost[rightChild]) {
            freqOfPre[idx] = leftLen + freqOfPre[rightChild];
        } else {
            freqOfPre[idx] = freqOfPre[leftChild];
        }

        // suffix
        if (freqOfSuff[rightChild] == rightLen && rMost[rightChild] == rMost[leftChild]) {
            freqOfSuff[idx] = rightLen + freqOfSuff[leftChild];
        } else {
            freqOfSuff[idx] = freqOfSuff[rightChild];
        }

        lMost[idx] = lMost[leftChild];
        rMost[idx] = rMost[rightChild];
        overAllMAX[idx] = Math.max(Math.max(overAllMAX[leftChild], overAllMAX[rightChild]), sum);
    }
}