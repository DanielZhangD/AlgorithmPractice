package Lesson7HW;
//If we do 2 BFS/DFS, and start the BFS from the furthest node
//How do we get a path?
//Have a distance array, which tells you distance from main node/furthest node
//you can also have a previous array, which tells you which node discovered the node
//i.e. started at node 1, pre array has -1. 3 discovered by 1, 3 has 1 in pre array.
//so forth
//Therefore, from 3, we can look and go to 1, which goes to -1, so end.
//Tree Diameter Property - for the furthest distance from ANY node, it will always end in a diameter endpoint
//Center - Point in which you take top most node, the depth of tree is MINIMIZED
//Radius - Minimum distance / depth - depth from where center is the main node

public class TreeDiameter {

}
