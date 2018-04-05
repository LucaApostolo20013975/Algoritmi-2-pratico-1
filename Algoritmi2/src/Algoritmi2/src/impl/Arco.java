package impl;

import java.util.HashSet;
import java.util.Set;

import graph.DirectedEdge;
import graph.Edge;
import graph.Graph;
import graph.Vertex;

@SuppressWarnings("hiding")
public class Arco<Vertex,Edge> implements DirectedEdge {

	Edge info;
	Vertex in;
	Vertex fin;
	double weight;
	Graph graph;
	static boolean isDirected;
	
	public Arco(Vertex in, Vertex fin, boolean isDirected){
		this.info=null;
		this.in = in;
		this.fin = fin;
		this.weight=1;
	    this.isDirected=isDirected;
	}
	@Override
	public double getEdgeWeight() {
		if (this.weight==0)
			return Graph.DEFAULT_EDGE_WEIGHT;
		else
		return this.weight;
	}

	@Override
	public Set<graph.Vertex> getVertices() {
		Set<graph.Vertex> vertice = new HashSet<graph.Vertex>();
		vertice.add(getSource());
		vertice.add(getTarget());
		return vertice;
	}

	@Override
	public Graph getGraph() {
		
		return this.graph;
	}       

	@Override
	public graph.Vertex getSource() {
		
		return (graph.Vertex) in;
	}

	@Override
	public graph.Vertex getTarget() {
		
		return  (graph.Vertex) fin;
	}
	 public boolean equals(Object obj) {
	        if (this == obj)
	            return true;
	        if (obj == null)
	            return false;
	        if (getClass() != obj.getClass())
	            return false;
	        if (this.in == null) {
	            if (this.in != null)
	                return false;
	        } else if (!this.in.equals(in))
	            return false;
	        if (this.fin == null) {
	            if (this.fin != null)
	                return false;
	        } else if (!this.fin.equals(fin))
	            return false;
	        return true;
	    }
	
	 public static boolean isDirected(){
	        return isDirected;
	 }
	 
	
	
}
