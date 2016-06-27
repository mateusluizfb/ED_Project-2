package ClassificacaoArestas;

import java.util.HashMap;
import Lists.LinkedListGeneric;
import Lists.ListGeneric;
import Queue.QueueGeneric;

public class Grafo<T> implements GrafoInterface<T>{

	public static int INFINITO = -1;
	public HashMap<Vertice<T>, ListGeneric<Vertice<T>>> grafoMap;
	public boolean dirigido;
	public ListGeneric<Aresta<T>> edges;
	
	public Grafo(boolean dirigido){
		this.dirigido = dirigido;
		grafoMap = new HashMap<Vertice<T>, ListGeneric<Vertice<T>>>();
		edges = new LinkedListGeneric<Aresta<T>>();
	}
	
	@Override
	public void addVertice(Vertice<T> vertice) {
		grafoMap.put(vertice, new LinkedListGeneric<Vertice<T>>());
	}
	
	public Vertice<T> find(T key){
		
		for (Vertice<T> v : grafoMap.keySet()){
			if (v.value == key){
				return v;
			}
		}
		return null;
	}

	@Override
	public void addAresta(T current, T target) {
		Vertice<T> atual  = find(current);
		Vertice<T> destino  = find(target);
		
		if(grafoMap.containsKey(atual) && grafoMap.containsKey(destino)) {
			
			grafoMap.get(atual).insert(0, destino);
			
			if(!dirigido) {
				grafoMap.get(destino).insert(0, atual);
			}
		}
	}

	@Override
	public ListGeneric<Vertice<T>> verticesAdjacentes(T v) {
		return grafoMap.get(find(v));
	}

	@Override
	public int quantidadeVertices() {
		return grafoMap.size();
	}

	@Override
	public int range(T current, T target) {
		Vertice<T> atual  = find(current);
		Vertice<T> destino  = find(target);
		
		buscaEmLargura(atual);
		
		return destino.range;
	}
	
	public void buscaEmLargura(Vertice<T> v){
		for (Vertice<T> u : grafoMap.keySet()){
			u.color = Color.WHITE;
			u.ancestor = null;
			u.range = INFINITO;
		}
		
		v.range = 0;
		v.ancestor = null;
		
		QueueGeneric<Vertice<T>> queue = new QueueGeneric<Vertice<T>>(); 
		queue.enqueue(v);
		
		while(!queue.isEmpty()){
			Vertice<T> u = queue.dequeue();
			
			for(int i = 0; i < verticesAdjacentes(u.value).size(); i++){
				Vertice<T> v2 = verticesAdjacentes(u.value).elementAt(i);
				
				if(v2.color == Color.WHITE){
					v2.color = Color.SILVER;
					v2.range = u.range + 1;
					v2.ancestor = u;
					queue.enqueue(v2);
				}	
			}
			u.color = Color.BLACK;
		}
		
	}
	int time = 0;
	
	public void dfs(){
		for (Vertice<T> u : grafoMap.keySet()){
			u.color = Color.WHITE;
			u.ancestor = null;
			u.range = INFINITO;
		}
		
		time = 0;
		for (Vertice<T> u : grafoMap.keySet()){
			if (u.color == Color.WHITE){
				visit(u);
			}
		} 
		time = 0;
	}
	
	protected void visit(Vertice<T> u){
		
		u.range = ++time;
		u.color = Color.SILVER;
		
		for(int i = 0;i < verticesAdjacentes(u.value).size();i++){
			Vertice<T> temp = verticesAdjacentes(u.value).elementAt(i);
			if(temp.color == Color.WHITE){
				temp.ancestor = u;
				
//				Aresta<T> newEdge = new Aresta<T>(u, temp);
//				newEdge.type = "TREE_EDGE";
//				edges.insert(0, newEdge);
				
				visit(temp);
			}
		}		
		u.color = Color.BLACK;
		u.finalRange = ++time;	
	}
	
	public void showEdges(){
		
		edges.show(false);
		
	}

}
