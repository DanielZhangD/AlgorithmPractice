package Lesson10HW;

public class MinimumSpanningTree {
	//spanning tree is a subgraph in which all vertices are connected and is a tree
	//spanning tree uses the edges from the total graph and makes a graph to connect all vertices with
	//the edges of initial graph
	//Minimum Spanning Tree, or MST, is a given spanning tree that has the minimum cost for a weighted graph
	//Various applications-i.e. connect all cities, but make the total cost minimum
	//STORING A WEIGHTED GRAPH
	//To store a weighted graph, you need to use pairs in each adjacency list
	//i.e from node 1 - (2,10), (3,15)
	//i.e. 1 is connected to 2, which has a cost 10, 1 is connected to 3, with cost 15
	
	//CREATING A MINIMUM SPANNING TREE FROM AN WEIGHTED GRAPH
	//Minimum Spanning tree of an undirected graph G is a tree formed from graph edes that connects ALL
	//vertices of G at lowest cost
	//Minimum spanning tree ONLY occurs if all edges are connected in graph G
	//Also, there are no cycles in a MST, as it is a tree
	//# of edges is |V| - 1 (vertices - 1)
	//MSTs are trees as they are acyclic
	//There are two basic algorithms to solve/create a MST - both based on greedy idea
	
	//ALGORITHM 1-> PRIM's ALGORITHM
	//idea - > We begin to grow up a tree in successive stages
	//we start from one node, we grow a bit, we choose a new node, we grow more, and so forth
	//PRIM ALGORITHM
	//When we have a weighted graph for a Prim Algorithm, we don't care from which node we start
	//In graph in the powerpoint, lets start with A
	//A is in the tree, rest are not in treee
	//Tree = {A}
	//Now, we look at the edges where one end point is in the tree (right now, A), and one endpoint does not
	//belong in the tree (a -> b, a -> f, a -> c)
	//now, we choose the edge with the MINIMUM cost
	//a - > f is the current lowest cost, so we grow the tree
	//Tree : {A, F}
	//Again, check all edges, see what the minimum cost is for an edge in which one end point belongs, other does not
	//We can find (f -> c) to have the minimum cost, add c to the tree
	//Keep on doing this until ALL vertices are within the tree
	//Eventually, we get {A F C D E B}
	//Note: We can start from ANY edge for this minimum spanning tree to create a minimum spanning tree
	//I.e. starting from B : {B E F A D C}
	//CODING
	//Make a distance array and a visited array
	//Make all distances start at infinity, and all vis false
	//First, choose a start point
	//set distance there to o
	//now, you have an empty tree, etc.
	//First command: Select
	//Command 1 checks to select the node with a minimum distance that has NOT been visited prior
	//Update - Update distances based on tree nodes
	//FIRST ROUND OF A B C D E F
	//ALl distances are infinity
	//set A to base, distance to 0
	//SELECT - > A is minimum distance and not been visited, add A to the tree
	//Mark A visited and use the update command, which updates the distance of all connected verticies
	//therefore, based on new distance -> A, C, F have better distancee
	//DE are no connected and remain Infinity
	//ABCDEF -> |0|34|46|infinity|infinity|19|
	//Now, we use Select once more, and we choose edge with minimum cost
	//We choose f, as it has 19, and add it to the tree, while marking it visited
	//therefore, we have tree {A, F}, and we can update
	//Now, we look at distance -> F is connected to C with 25, which is better than 46, updating
	//F is connected to D, 25 < infinity, change it
	//F is connected to E, 26 < infinity, change it
	//Others are not connected
	//We now have: ABCDEF|0|34|25|25|26|19|
	//Visited: |T|F|F|F|F|T|
	//Now, looking at the above , C will be visited, as it is first in the dis array with lowest value
	//Now, select C, and use C to update (C is added to tree, C is marked Visited, C updates distances)
	//After using select and update we have:
	//Tree: {A,F,C} Dis: |0|34|25|17|26|19|, Vis: |T|F|T|F|F|T|
	//D is best, we select D, and end up with:
	//Tree: {A,F,C,D} Dis: |0|34|25|17|26|19|. Vis: |T|F|T|T|F|T|
	//Now, we can select E
	//Tree : {A,F,C,D, E} Dis: |0|12|25|17|26|19|. Vis: |T|F|T|T|T|T|
	//WE select B and finish
	//Tree: {A,F,C,D,E,B}, Dos: |0|12|25|17|26|19| Vis: |T|T|T|T|T|T|
	//Prim algorithm has a time of O(n^2)
	//NOTE-Prim is super similar to djikstra
	//PSUEDO CODE
	//Initialize two arrays, lowcost[] and adjvex[]
	//Output uo and uo into u set
	//Repeat until V_U is empty
	
	//KRUSKAL'S ALGORITHM
	//add one edge each time with smallest weight and accept an edge if it does not cause a cycle
	//sort all edges, and go through it to add all edges until enough edges are accepted such that all
	//vertices are added in
	//FOr example, using the same graph we've always used
	//Edge BE is the lowest cost, so we add that edge
	//Next, we find second minimum cost -> CD. Does it cause loop? No, so add it
	//THerefore, we have {BE, CD}
	//Next lowest -> AF (no cycle, so add it)
	//{BE,CD,AF}
	//Next minimum -> CF FD, don't matter, take one
	//{BE, CD, AF, CF}
	//Next minimum -> DF, it makes a cycle, so we discard it D:
	//Next minimum edge - > EF, which doesn't make a cycle
	//This now reaches N - 1 edges, so we have enough
	//Therefore, we have {BE, CD, AF, CF, EF} and we're good
	//Now the question is... how do we check for cycles or loops?
	//We make arraylists of the edges
	//therefore, we start with BE, and make an arraylist containing {BE} in that arraylist
	//next, we add AF, -> its not connected to BE, so we make a new one
	//{AF}
	//next we get FC, which is connected by AF, so we get {AFC}
	//Next, we add CD, so {AFCD}
	//However, the next one based on weights is FD, but those are already connected, as shown by the 
	
}
