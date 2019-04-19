import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestingHM {

	private String firstElement;
	private int firstElementKey;
	private String secondElement;
	private int secondElementKey;
	private String thirdElement;
	private int thirdElementKey;
	private String lastElement;
	private int lastElementKey;
	private MyHashMap<Integer, String> testData;

	@Before
	public void dataInitializing() {
		firstElement = "Roflan1";
		firstElementKey = 0;
		secondElement = "Roflan2";
		secondElementKey = 1;
		thirdElement = "Roflan3";
		thirdElementKey = 2;
		lastElement = "RoflanLast";
		lastElementKey = 3;
		testData = new MyHashMap<Integer, String>();
		testData.put(firstElementKey, firstElement);
		testData.put(secondElementKey, secondElement);
		testData.put(thirdElementKey, thirdElement);
	}

	@Test
	public void size() {
		//testing size
		Assert.assertEquals(3, testData.size());
	}

	@Test
	public void get() {
		//testing get of key
		Assert.assertEquals(firstElement, testData.get(0));
	}

	@Test
	public void put() {
		//testing put
		testData.put(lastElementKey, lastElement);
		Assert.assertEquals(lastElement, testData.get(lastElementKey));
	}

	@Test
	public void remove() {
		//testing remove with key
		Assert.assertEquals(testData.remove(firstElementKey), firstElement);
	}

	@Test
	public void toStringTest() {
		//testing toString
		StringBuilder bufferForTest = new StringBuilder();
		for (int i = 0; i < testData.size(); i++) {
			if (i != testData.size() - 1) {
				bufferForTest.append("Key - " + i + " Value = " + testData.get(i) + ", ");
			} else {
				bufferForTest.append("Key - " + i + " Value = " + testData.get(i));
			}
		}
		Assert.assertEquals(bufferForTest.toString(), testData.toString());
	}

	@Test
	public void clear() {
		//testing clear
		testData.clear();
		Assert.assertEquals(new MyHashMap<Integer, String>().size(), testData.size());
	}
}

