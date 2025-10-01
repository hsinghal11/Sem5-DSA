class Solution {
    public int buyChoco(int[] prices, int money) {
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for(int i: prices){
            if(i<firstMin){
                secondMin = firstMin;
                firstMin = i;
            }else if(i<secondMin){
                secondMin = i;
            }
        }
        int left = money - (firstMin + secondMin);
        return left<0? money: left;
    }
}