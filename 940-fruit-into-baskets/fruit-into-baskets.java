class Solution {
    public int totalFruit(int[] fruits) {
       int maxLen = 0;
        int start = 0;
        
        int basket1 = -1, basket2 = -1;
        
        int lastSeen1 = -1, lastSeen2 = -1;
        
        for (int end = 0; end < fruits.length; end++) {
            int currentFruit = fruits[end];
            
            if (currentFruit == basket1 || basket1 == -1) {
                basket1 = currentFruit;
                lastSeen1 = end;
            } else if (currentFruit == basket2 || basket2 == -1) {
                basket2 = currentFruit;
                lastSeen2 = end;
            } else {
                maxLen = Math.max(maxLen, end - start);
                
                if (lastSeen1 < lastSeen2) {
                    start = lastSeen1 + 1;
                    basket1 = currentFruit;
                    lastSeen1 = end;
                } else {
                    start = lastSeen2 + 1;
                    basket2 = currentFruit;
                    lastSeen2 = end;
                }
            }
        }
        
        return Math.max(maxLen, fruits.length - start);
    }
}