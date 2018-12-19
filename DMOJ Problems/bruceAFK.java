package Lesson5HW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class bruceAFK {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int n = 1;n<=t; n++) {
			String[] cr = br.readLine().split(" ");
			int c = Integer.parseInt(cr[0]), r = Integer.parseInt(cr[1]); char[][]g = new char[r][c];
			int sr=0,sc=0,er=0,ec=0;
			for(int i=0; i<r;i++) {
				g[i] = br.readLine().toCharArray();
				for(int j = 0; j<c; j++) {
					if(g[i][j]=='C') {sr=i;sc=j;}
					if(g[i][j]=='W') {er=i;ec=j;}
				}
			}
			Queue<Integer> qr = new LinkedList<Integer>(),qc=new LinkedList<Integer>();
			boolean vis[][] = new boolean[r][c]; int dis[][] = new int[r][c];
			int d[][]= {{-1,0},{1,0},{0,-1},{0,1}};
			qr.add(sr);qc.add(sc); vis[sr][sc] = true;
			while(!qr.isEmpty()) {
				int R = qr.poll(), C = qc.poll();
				for(int i=0; i<4;i++) {
					int nr = R+d[i][0], nc = C+d[i][1];
					if(nr>=0&&nc>=0&&nr<r&&nc<c&&!vis[nr][nc]&&g[nr][nc]!='X') {
						qr.add(nr); qc.add(nc); vis[nr][nc] = true;
						dis[nr][nc] = dis[R][C]+1;
					}
				}
			}
			if(vis[er][ec]&&dis[er][ec]<60)System.out.println(dis[er][ec]);
			else System.out.println("#notworth");
		}
	}
}