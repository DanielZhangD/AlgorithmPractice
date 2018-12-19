package Lesson7HW;
//given a directed graph, you want to order these vertices
//a topological sort is an ordering of vertices in a directed acyclic graph, such that if 
//there is a path from vi to vj, then vj appears after vi in ordering
//So if node I has a path to node J, I has to be visited before J gets visited
//Basically, if we make an ordering of paths, we say
//vi must be before vj if vi has a path to vj
//For example, if we have a graph with course prereqs
//we can use a topological sort to represetn this
//edges in such a graph represent dependencies
//topological rodering is not neccesarily unique; any legal ordering will do
//however, if there is a cycle, there  is a circle dependency, and you cannot make a topologic sort
//Topologic sort machine broke if cycle exists
//Topological sort can be used to detect if there is a cycle in the graph
//How do we do a topological sort
//Idea is symple - start from vertices with NO incoming edges
//we print this vertex, and remove it, along with its edges, from the graph
//we do this strategy for the rest of the graph untill all vertices have been output
//to do this, we can either use a stack or queue for it
// we start by marking the in degrees for all of them
//after we remove the one with 0, we remove that
//we then subtract one to each one that was connected by that
//whenever the in degree reaches 0, add it to the queue/stack


//start with in degrees

public class TopologicalSorting {

}
