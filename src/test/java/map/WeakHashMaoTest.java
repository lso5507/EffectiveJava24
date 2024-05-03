package map;

import java.util.Map;
import java.util.WeakHashMap;

import org.junit.jupiter.api.Test;

public class WeakHashMaoTest {
	@Test
	public void 약한참조Map테스트(){
		Map<Long, String> weakHashMap = new WeakHashMap<>();
		Long key1 = 1000L;
		Long key2 = 2000L;
		weakHashMap.put(key1,"1000");
		weakHashMap.put(key2,"2000");
		System.out.println("weakHashMap.size() = " +weakHashMap.size());
		key1=null;
		System.gc();
		System.out.println("weakHashMap.size() = " +weakHashMap.size());
		weakHashMap.entrySet().stream().forEach(item->System.out.println(item));


	}
}
