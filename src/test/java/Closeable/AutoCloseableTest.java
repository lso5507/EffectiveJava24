package Closeable;

import java.io.FileInputStream;
import java.io.IOException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AutoCloseableTest {
	public class Room implements AutoCloseable{
		public Room() throws IOException {
			ensureOpen();
		}
		private static boolean closed=false;
		public void hello() throws IOException {
			ensureOpen();
			System.out.println(" hello");
		}
		private void ensureOpen() throws IOException {
			if (closed) {
				throw new IOException("Stream closed");
			}
		}
		@Override
		public void close() throws IOException {
			System.out.println("autoClose");
			closed=true;
		}
	}
	@Test
	@DisplayName("AutoCloseableTest")
	public void AutoCloseTest() {
		/*
		Room room = null;
		try{
			room = new Room();
			room.hello();
		}catch(IOException e){
			e.printStackTrace();
		}finally {
			try {
				room.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		 */
		try(Room room =new Room()){
			room.hello();
			room.close();
			room.hello();
		}catch(IOException e){
			e.printStackTrace();
		}


	}
}
