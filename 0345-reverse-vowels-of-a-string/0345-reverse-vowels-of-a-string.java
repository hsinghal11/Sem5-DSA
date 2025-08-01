class Solution {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int i=0;
        int j=arr.length-1;
        while(i<j){
            if (check(arr[i]) == false){
                i++;
                continue;
            }else if (check(arr[j]) == false){
                j--;
                continue;

            }else{
                swap(arr,i,j);
                i++;
                j--;
            }
        }
        String str = new String(arr);
        return str;
    }
    public void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public boolean check(char c){
        c=Character.toLowerCase(c);
        return c=='a' || c=='e' || c=='i' || c=='o' || c=='u';
    }
}