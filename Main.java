package Clases;

public class Main {
	public static void main (String args []) {
		Grafo gra = new Grafo();
		gra.removeEdge(5,2);
		
		gra.addEdge(2,3);
		
		gra.addNode(1);
		gra.addNode(2);
		
		gra.addEdge(1,2);
		gra.addEdge(1,3);
		gra.addEdge(2,1);
		
		gra.removeNode(2);
		gra.removeEdge(1,2);
		
		gra.addNode(1);
	}
}