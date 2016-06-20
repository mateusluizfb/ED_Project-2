package GrafoBuscaEmProfundidade;

import java.util.HashMap;
import java.util.Stack;

import Lists.LinkedListGeneric;
import Lists.ListGeneric;
import Queue.QueueGeneric;

public class GrafoComBuscaEmProfundidade<T> implements GrafoInterface<T>{

	public static int INFINITO = -1;
	public HashMap<Vertice<T>, ListGeneric<Vertice<T>>> grafoMap;
	public boolean dirigido;
	
	public GrafoComBuscaEmProfundidade(boolean dirigido){
		this.dirigido = dirigido;
		grafoMap = new HashMap<Vertice<T>, ListGeneric<Vertice<T>>>();
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
	
	public void buscaEmProfundidade(Vertice<T> v){
		for (Vertice<T> u : grafoMap.keySet()){
			u.color = Color.WHITE;
			u.ancestor = null;
		}
		
		v.color = Color.SILVER;
		System.out.println(v.value);
		
		Stack<Vertice<T>> stack = new Stack<Vertice<T>>();
		stack.push(v);
		
		while(!stack.isEmpty()){
			
			for(int i = 0; i < verticesAdjacentes(stack.peek().value).size(); i++){	
				Vertice<T> v2 = verticesAdjacentes(stack.peek().value).elementAt(i);
					
				if(v2.color == Color.WHITE){
					System.out.println(v2.value);
					v2.color = Color.SILVER;
					stack.push(v2);
				} else if(v2.color == Color.SILVER){
					v2.color = Color.BLACK;
				} else {
					stack.pop();
				}
				
				if (stack.isEmpty()){
					break;
				}
			}
		}
	}
	

}
