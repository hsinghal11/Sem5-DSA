class Solution {
    public boolean checkString(String s) {
        int first = s.indexOf('b');        
        int last = s.lastIndexOf('a');
        return first == -1? true :first > last;
    }
}