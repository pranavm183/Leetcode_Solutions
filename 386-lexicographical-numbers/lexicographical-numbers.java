class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> l=new ArrayList<>();
        for(int i=1;i<=9;i++){
            find(i,n,l);
        }
       return l;
    }
    public static void find(int num,int n,List<Integer> l){
        if(num>n)return;
        l.add(num);
        num=num*10;

        for(int i=0;i<=9;i++){
            find(num+i,n,l);
        }
    }
}