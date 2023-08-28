class Solution
{ 
    int celebrity(int M[][], int n)
    {
        int celeb=0;
        for(int i=1; i<n; i++){
            if(M[celeb][i]==1){
                celeb=i;
            }
        }
        for(int i=0; i<n; i++){
            if(i==celeb) continue;
            if(M[i][celeb]==0 || M[celeb][i]==1) return -1;
        }
        return celeb;
    }
}
