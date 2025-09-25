class Solution {
    public List<Integer> majorityElement(int[] arr) {
        int n = arr.length;
        int times = n/3;
        int c1 =0, c2=0;
        int e1=0, e2=0;
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(c1==0 && e2 != arr[i]){
                c1=1;
                e1=arr[i];
            }
            else if(c2==0 && e1 != arr[i]){
                c2=1;
                e2=arr[i];
            }else if(e1 == arr[i]) c1++;
            else if(e2 == arr[i]) c2++;
            else{
                c1--;
                c2--;
            }
        }
        c1=0;
        c2=0;
        for(int i=0;i<n;i++){
            if(e1 == arr[i])c1++;
            else if(e2==arr[i]) c2++; 
        }
        if(c1 > times) ans.add(e1);
        if(c2 > times) ans.add(e2);
        return ans;
    }
}