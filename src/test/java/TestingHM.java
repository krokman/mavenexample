import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;


public class TestingHM {

	@Parameter
	public String firstElement = "Roflan1";
	@Parameter
	public int firstElementKey = 0;

	@Parameter
	public String secondElement = "Roflan2";
	@Parameter
	public int secondElementKey = 1;

	@Parameter
	public String thirdElement = "Roflan3";
	@Parameter
	public int thirdElementKey = 2;

	@Parameter
	public String lastElement = "RoflanLast";
	@Parameter
	public int lastElementKey = 3;

	public MyHashMap<Integer, String> testData = mapInitializing();

	@Parameters
	private MyHashMap<Integer, String> mapInitializing() {
		MyHashMap<Integer, String> mapData = new MyHashMap<Integer, String>();
		mapData.put(firstElementKey, firstElement);
		mapData.put(secondElementKey, secondElement);
		mapData.put(thirdElementKey, thirdElement);
		return mapData;
	}

	@Test
	public void testingAllFunctionalityOfHashMap() {
		//testing size
		Assert.assertEquals(3, testData.size());
		//testing get of key
		Assert.assertEquals(firstElement, testData.get(0));
		//testing put
		testData.put(lastElementKey, lastElement);
		Assert.assertEquals(lastElement, testData.get(lastElementKey));
		//testing remove with key
		Assert.assertEquals(testData.remove(lastElementKey), lastElement);
		//testing toString
		StringBuilder bufferForTest = new StringBuilder();
		for (int i = 0; i < testData.size(); i++) {
			if(i != testData.size()- 1){
			bufferForTest.append("Key - " + i + " Value = " + testData.get(i) + ", ");}
			else{
				bufferForTest.append("Key - " + i + " Value = " + testData.get(i));
			}
		}
		Assert.assertEquals(bufferForTest.toString(), testData.toString());
		//testing clear
		testData.clear();
		Assert.assertEquals(new MyHashMap<Integer, String>().size(), testData.size());
	}
}

