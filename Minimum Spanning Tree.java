//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java

class Solution{
	int spanningTree(int V, int E, int edges[][]){
	     int res=0;
	     int mstSet[] = new int[V];
	     
	     ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
	     for(int i=0; i<V; i++) adj.add(new ArrayList<>());
	     for(int e[]: edges){
	         int u=e[0]; int v=e[1]; int w=e[2];
	         adj.get(u).add(new int[]{v,w}); 
	         adj.get(v).add(new int[]{u,w});
	     }
	     
	     int distToReach[] = new int[V];
	     Arrays.fill(distToReach,Integer.MAX_VALUE);
	     distToReach[0]=0;
	     
	     for(int i=0; i<V; i++){
	         int curNod=-1;
	         for(int j=0; j<V; j++){
	             if(mstSet[j]==0 && (curNod==-1 || distToReach[curNod]>distToReach[j])){
	                 curNod=j;
	             }
	         }
	         mstSet[curNod]=1; res+=distToReach[curNod];
	         for(int child[]: adj.get(curNod)){
	             if(mstSet[child[0]]==0 && distToReach[child[0]]>child[1]){
	                 distToReach[child[0]]=child[1];
	             }
	         }
	     }
	     
	     return res;
	}
}
