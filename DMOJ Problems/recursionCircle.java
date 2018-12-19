package Lesson5HW;

import java.util.*;
import java.io.*;
/*class node{
    ArrayList<Integer> in;
    ArrayList<Integer> out;
    node(ArrayList<Integer> i,ArrayList<Integer> o){
        i=in;o=out;
    }
}*/

public class recursionCircle {
public static int vis[],adj [][], dis[], loop;

        public static void main(String[] args) throws IOException {
             for (int t=0;t<5;t++){
                 int n = readInt(); 
                 vis = new int[101]; dis = new int [101]; adj = new int[101] [101]; loop =0;
                 for(int i=1;i<=n;i++){
                     adj[readInt()][readInt()]=1;
                 }
                 dfs(1);System.out.println(loop);
             }
        }
        public static void dfs(int u){
            vis[u]=1;
            for(int v=1;v<=100;v++){
                if(adj[u][v]==0)continue;
                if (vis[v]==1){
                    loop = Math.max(loop, dis[u]-dis[v]+1);return;
                }
                else if(vis[v]==0){ dis[v]=dis[u]+1; dfs(v);}
                
            }
            vis[u]=2;
        }
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    static long readLong() throws IOException {
        return Long.parseLong(next());
    }

    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }

    static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }

    static char readCharacter() throws IOException {
        return next().charAt(0);
    }

    static String readLine() throws IOException {
        return br.readLine().trim();
    }
}