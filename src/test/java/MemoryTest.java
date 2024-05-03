import java.util.Arrays;
import java.util.EmptyStackException;

import org.junit.jupiter.api.Test;

public class MemoryTest {
	/*
		elements 배열 객체에서 사용하지 않는 Object 타입 객체도 들고있는 이슈
		실제 사용하지 않는 Object 객체를 GC에서 수거하지않음.
	 */
	public class Stack{
		private Object[] elements;
		private int size=0;
		private static final int DEFAULT_INITIAL_CAPACITY =16;
		public Stack(){
			elements = new Object[DEFAULT_INITIAL_CAPACITY];
		}
		public  void push(Object e){
			ensureCapacity();
			elements[size++] =e;
		}
		public Object wrongPop(){
			if(size==0)
				throw new EmptyStackException();
			// elemetens[size]에 해당하는 Object 객체를 GC에서 수거해가지않음.
			return elements[--size];
		}
		public Object pop(){
			if(size==0)
				throw new EmptyStackException();
			Object result= elements[--size];
			elements[size]=null;
			return result;
		}
		private void ensureCapacity(){
			if(elements.length==size){
				//크기증가 2배증가
				elements= Arrays.copyOf(elements,2*size+1);
			}
		}

	}
	@Test
	public void 매모리소거테스트(){
		Stack stack = new Stack();
		stack.push(1);
		stack.push(2);
		stack.pop();


	}
}
