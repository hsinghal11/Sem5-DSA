class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] arr = text.split(" ");
        int ans = arr.length;
        System.out.println(Arrays.toString(arr));
        for(int j=0; j<arr.length; j++){
            for(char i: brokenLetters.toCharArray()){
                System.out.println((arr[j]));
                if(arr[j].contains(i+"")) {
                    ans--;
                    arr[j] = "";
                }
            }
        }
        return ans;
    }
}