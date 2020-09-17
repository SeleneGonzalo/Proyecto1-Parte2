package Clases;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

class Grafo {
	private static Logger logger;
	private LinkedList<Integer> nodos = new LinkedList<Integer>();
	private Map <Integer,Integer> arcos = new HashMap <Integer,Integer>();
	
	public Grafo () {
		if (logger == null){
			logger = Logger.getLogger(Grafo.class.getName());
			Handler hnd = new ConsoleHandler();
			hnd.setLevel(Level.FINE);
			logger.addHandler(hnd);
			logger.setLevel(Level.CONFIG);
			Logger rootLogger = logger.getParent();
			
			for (Handler h : rootLogger.getHandlers()){
				h.setLevel(Level.OFF);
			}
		}
	}
	
	private boolean isNode (int node) {
		boolean esta=false;
		for (int i=0; i < nodos.size() && !esta; i++) {
			if (nodos.get(i) == node)
				esta=true;
		}
		return esta;
	}
	
	public void addNode (int node) {
		if (!isNode(node)) {
			nodos.add(node);
			logger.info("El nodo " + node + " ha sido añadido");
		} else
			logger.warning("No ha sido posible añadir " + node + " al grafo");
	}

	public void removeNode (int node) {
		if (isNode(node)) {
			nodos.remove((Integer) node);
			logger.info("El nodo " + node + " ha sido removido");
			
			arcos.remove((Integer) node);
			arcos.remove(node);
			
			for (int i=0; i< nodos.size(); i++)
				arcos.remove(nodos.get(i), node);
			
			logger.info(node + "ha sido removido de arcos");
		}
	}
	
	public void addEdge (int node1, int node2) {
		if (isNode(node1) && isNode(node2)) {
			arcos.put(node1, node2);
			logger.info("Se creó un arco con origen en " + node1 + " y destino en " + node2);
		} else 
			logger.warning("No fue posible crear el arco ya que uno o los dos nodos no se encuentra(n) en el grafo");
	}
	
	public void removeEdge (int node1, int node2) {
		boolean removido=false;
		removido = arcos.remove(node1, node2);
		
		if (!removido)
			logger.warning("El arco no pudo ser removido");
		else
			logger.info("El arco ha sido removido con exito");
	}
}