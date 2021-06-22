package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TT {
	
	public static void main(String args[]) {
		
	}

}

class GGraph{
	boolean visited[];
	List<List<Integer>> list;
	
	GGraph(int nodes){
		visited = new boolean[nodes];
		
		for(int i=0; i<nodes; i++)
			list.add(i, new ArrayList<>());
	}
	
	void addEdges(int a, int b) {
		list.get(a).add(b);
		list.get(b).add(a);
	}
	
	void dfs(int start) {
		visited[start] = true;
		Stack<Integer> st = new Stack<Integer>();
		st.push(start);
		
		while(!st.isEmpty()) {
			int node = st.pop();
			System.out.println(node);
			
			for(int neighbour : list.get(node)) {
				if(!visited[neighbour]) {
					st.add(neighbour);
					visited[neighbour] = true;
				}
			}
		}
	}
}
