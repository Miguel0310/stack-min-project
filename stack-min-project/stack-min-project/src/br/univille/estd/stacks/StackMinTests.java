package br.univille.estd.stacks;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Comparator;

import org.junit.Test;

import br.univille.estd.stacks.StackMin;

public class StackMinTests {
	
	private Comparator<Integer> comparator = new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o1.compareTo(o2);
		}
	};
	
	@Test
	public void isEmpty() {
		Stack<Integer> stack = new StackMin<Integer>(comparator);
		assertEquals("A pilha deve estar vazia",true,stack.isEmpty());
	}
	
	@Test
	public void size() {
		Stack<Integer> stack = new StackMin<Integer>(comparator);
		assertEquals("O tamanho da pilha deve ser zero",0,stack.size());
	}
	
	@Test
	public void push() {
		Stack<Integer> stack = new StackMin<Integer>(comparator);
		stack.push(2);
		stack.push(12);
		stack.push(1);
		stack.min();
		assertEquals("Pilha deve conter um elemento",1,stack.size());
	}
	
	@Test
	public void top() {
		Stack<Integer> stack = new StackMin<Integer>(comparator);
		stack.push(10);
		stack.push(15);
		stack.push(3);
		stack.push(5);
		stack.push(15);
		stack.min();
		assertEquals("Top deve retornar o elemento 15",15,(int)stack.top());
	}
	
	@Test
	public void pop() {
		Stack<Integer> stack = new StackMin<Integer>(comparator);
		stack.push(10);
		stack.push(15);
		assertEquals("Top deve retornar o elemento 15",15,(int)stack.pop());
		assertEquals("Pilha deve conter um elemento",1,stack.size());
	}
	
	@Test
	public void popThrowsException() {
		Stack<Integer> stack = new StackMin<Integer>(comparator);
		try {
			stack.pop();
			fail("Pilha deve gerar exceçao EmptyStackException");
		}catch(Exception ignored) {
		}
	}
	
	@Test
	public void topThrowsException() {
		Stack<Integer> stack = new StackMin<Integer>(comparator);
		try {
			stack.top();
			fail("Pilha deve gerar exceçao EmptyStackException");
		}catch(Exception ignored) {
		}
	}

}
