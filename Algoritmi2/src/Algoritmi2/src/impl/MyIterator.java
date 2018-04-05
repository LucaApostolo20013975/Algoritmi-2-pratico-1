package impl;

import java.util.Iterator;
import java.util.NoSuchElementException;

import graph.Vertex;

public class MyIterator implements Iterator<Vertex> {

	int index;
	Vertex[] vertici;
	public MyIterator(Vertex[] elements) {
	this.index = 0;
	this.vertici = elements;
	}  
	
	
	@Override
	public boolean hasNext() {
		return index < vertici.length;
	}

	@Override
	public Vertex next() {
		if (this.hasNext()) {
			Vertex res = vertici[index];
			index++;
			return res;
			}
			else throw new NoSuchElementException();
	}

}
