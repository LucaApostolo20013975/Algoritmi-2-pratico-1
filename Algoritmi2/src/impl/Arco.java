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
	
	public Arco(Vertex in, Vertex fin){
		this.info=null;
		this.in = in;
		this.fin = fin;
		this.weight=1;
	
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
	
}
