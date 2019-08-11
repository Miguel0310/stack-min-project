package br.univille.estd.stacks;

import java.util.Comparator;

import br.univille.estd.stacks.EmptyStackException;
import br.univille.estd.stacks.Stack;

public class StackMin<E> implements Stack<E> {

	protected int capacity;
	protected boolean flag = true;
	protected int min;
	public static final int CAPACITY = 1000;
	protected E S[];
	protected int top = -1;
	protected Comparator comparator;
	
	public StackMin(Comparator<E> comparator) {
		this(comparator,CAPACITY);
	}
	
	public StackMin(Comparator<E> comparator, int capacity) {
		this.capacity = capacity;
		this.comparator = comparator;
		S = (E[])new Object[this.capacity];
	}
	
	@Override
	public int size() {
		return top+1;
	}
	
	@Override
	public boolean isEmpty() {
		return (top<0);
	}

	@Override
	public E top() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException("pilha vazia");
		}
		return S[top];
	}

	@Override
	public void push(E  element) {
		
		if(size() == capacity) {
			throw new FullStackException("pilha cheia");
		}
		top = top + 1;
		S[top] = element;
		if (flag == true) {
			min = (int)element;
			flag = false;
			//System.out.println("Menor "+min);
		}
		if(comparator.compare(top(), min) == -1) {
			min = (int)element;
			System.out.println(S[top]);
			//System.out.println("Menor "+min);
		}
	}

	@Override
	public E pop() throws EmptyStackException {
		if (isEmpty() == true) {
			throw new EmptyStackException("pilha vazia");
		}
		E e = S[top];
		S[top] = null;
		top = top - 1;
		return e;
	}

	@Override
	public E min() throws EmptyStackException {
		System.out.println("Menor "+min);
		return null;
	}

}
