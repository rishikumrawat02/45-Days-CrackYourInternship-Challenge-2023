class GfG{
   public long multiplyTwoLists(Node l1,Node l2){
          long num1=0l; long num2=0l; long mod=(long)1e9+7;
          while(l1!=null){
              num1=num1*10+l1.data; num1%=mod; l1=l1.next;
          }
          while(l2!=null){
              num2=num2*10+l2.data; num2%=mod; l2=l2.next;
          }
          long res=(num1*num2)%mod;
          return (int)res;
   }
}
