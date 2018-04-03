package impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import graph.*;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class DirectedGraphAdjListImpl implements Graph {
	
	HashMap<Vertex, Set<Edge>> nodi;	
	HashMap<Vertex,Set<Edge>> archi;
	HashMap<Vertex,Set<Edge>> grafi;
	Set<Edge> arch;
	int n;
	int m;
	Vertex V;
	Edge E;
	Vertex in;
	Vertex fin;
	private Vertex[] elements;
	static HashMap<Vertex,Set<Edge>> adjacencyList = new HashMap<Vertex,Set<Edge>>();
	int elementi=0;
	
	public DirectedGraphAdjListImpl() {
		nodi = new HashMap<Vertex,Set<Edge>>();
		archi = new HashMap<Vertex,Set<Edge>>();
		n = 0;
		m = 0;
		
	}
	
	public DirectedGraphAdjListImpl(int numVertices) {
		nodi = new HashMap<Vertex,Set<Edge>>();
		archi = new HashMap<Vertex,Set<Edge>>();
		n = numVertices;
		m = 0;
	}

	@Override
	public Iterator<Vertex> iterator() {
		return new MyIterator(elements);
}

	@Override
	public Edge getEdge(Vertex sourceVertex, Vertex targetVertex) {
		@SuppressWarnings("unchecked")
		ArrayList<Edge> neighbors = (ArrayList<Edge>)archi.get(sourceVertex);
		Edge find = new Arco<Vertex,Edge>(sourceVertex, targetVertex);
		for(Edge a : neighbors) {
			if((a.getVertices().equals(find.getVertices()))&&(a.getVertices().equals(find.getVertices())))
				return a;
				}
		return null;
	}

	@Override
	public Edge addEdge(Vertex sourceVertex, Vertex targetVertex) {
		boolean flag = false, flag1 = false;
		if (!nodi.containsKey(sourceVertex))
			addVertex(sourceVertex);
		if ((!nodi.containsKey(targetVertex)))
			addVertex(targetVertex);
		Edge a = new Arco(sourceVertex,targetVertex);
		flag=(nodi.get(sourceVertex)).add(a);
		flag1=(nodi.get(targetVertex)).add(a);
		flag = flag && flag1;
		if (flag)
			m++;
		return addEdge(sourceVertex,targetVertex);
	}

	@Override
	public boolean addEdge(Edge e) {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean addVertex(Vertex v) {
		if(!nodi.containsKey(v)){
			((Set<Edge>) nodi).add((Edge) v);
			n++;
			ArrayList<Edge> neighbors = new ArrayList<Edge>();
			archi.put(v,(Set<Edge>) neighbors);
			return true;
		}
		
		else throw new NullPointerException();
	}

	@Override
	public boolean containsEdge(Vertex sourceVertex, Vertex targetVertex) {
		if(nodi.containsKey(sourceVertex)){
			if(nodi.containsKey(targetVertex)){
				Set<Edge> neighbors = archi.get(targetVertex);
				if(neighbors.contains(new Arco<Vertex, Edge>(V,targetVertex)));
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean containsEdge(Edge e) {
		e=getEdge(in,fin);
		if (grafi.containsKey(e))
        return true;
		else
			return false;
	}

	@Override
	public boolean containsVertex(Vertex v) {
		return  nodi.containsKey(v);
	}

	@Override
	public Set<Edge> edgeSet() {
		 
		return Collections.unmodifiableSet(arch);
	}

	@Override
	public int degreeOf(Vertex vertex) {
		Iterator it = archi.entrySet().iterator();
		while (it.hasNext()) {
			if (archi.containsKey(vertex)) 
				elementi++;
		}
		return elementi;
	}

	@Override
	public Set<Edge> edgesOf(Vertex vertex) {
		//HashMap<Vertex, Set<Edge>> map = new HashMap<Vertex, Set<Edge>>();
		Set<Edge> set = new HashSet<Edge>();
		for (Set<Edge> v : archi.values()) {
			if (archi.containsKey(vertex)) 
				set.add((Edge) v);
		}
		return set;
	}

	@Override
	public int inDegreeOf(Vertex vertex) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Set<Edge> incomingEdgesOf(Vertex vertex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int outDegreeOf(Vertex vertex) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Set<Edge> outgoingEdgesOf(Vertex vertex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeAllEdges(Collection<? extends Edge> edges) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<Edge> removeAllEdges(Vertex sourceVertex, Vertex targetVertex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeAllVertices(Collection<? extends Vertex> vertices) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Edge removeEdge(Vertex sourceVertex, Vertex targetVertex) {
		Edge a = getEdge(sourceVertex, targetVertex);
		if (!this.adjacencyList.containsKey(sourceVertex) || !this.adjacencyList.containsKey(targetVertex))
			return null;
		this.adjacencyList.remove(a);
		return a;
	}

	@Override
	public boolean removeEdge(Edge e) {
		
		return false;
	}

	@Override
	public boolean removeVertex(Vertex v) {
		if (!this.adjacencyList.containsKey(v)) {
            return false;
        }
        
        this.adjacencyList.remove(v);
        
        for (Vertex u: this.getAllVertices()) {
            this.adjacencyList.get(u).remove(v);
        }
        return true;
	}

	@Override
	public Set<Vertex> vertexSet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getEdgeWeight(Edge e) {
		
		return e.getEdgeWeight();
	}

	@Override
	public void setEdgeWeight(Edge e, double weight) {
	weight=e.getEdgeWeight();
		
	}

	@Override
	public boolean isDirected() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	 public Set<Vertex> getAllVertices() {
	        return this.adjacencyList.keySet();
	    }

}
