import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;


public class TestingAL {

	@Parameter
	public  String firstElement = "Roflan1";
	@Parameter
	public  String secondElement = "Roflan2";
	@Parameter
	public  String thirdElement = "Roflan3";
	@Parameter
	public  String lastElement = "RoflanLast";
	@Parameter
	public  String insideElement = "RoflanInside";
	@Parameter
	public  int insideElementIndex = 2;
	@Parameter
	public MyArrayList<String> testData = listInitializing();

	@Parameters
	private MyArrayList<String> listInitializing() {
		MyArrayList<String> listData = new MyArrayList<String>();
		listData.add(firstElement);
		listData.add(secondElement);
		listData.add(thirdElement);
		return listData;
	}

	@Test
	public void testingAllFunctionalityOfArrayList() {
		//testing get
		Assert.assertEquals(firstElement, testData.get(0));
		//testing add without index & size
		testData.add(lastElement);
		Assert.assertEquals(lastElement, testData.get(testData.size()-1));
		//testing add with index(inside)
		testData.add(insideElement, insideElementIndex);
		Assert.assertEquals(insideElement, testData.get(insideElementIndex));
		//testing set with index
		testData.set(firstElement, insideElementIndex);
		Assert.assertEquals(firstElement, testData.get(insideElementIndex));
		//testing remove with index
		Assert.assertEquals(testData.remove(insideElementIndex), firstElement);
		//testing remove Value
		testData.remove(firstElement);
		Assert.assertEquals(secondElement, testData.get(0));
		//testing isEmpty
		Assert.assertFalse(testData.isEmpty());
		//testing toString
		StringBuilder bufferForTest = new StringBuilder();
		for (int i = 0; i < testData.size(); i++) {
			bufferForTest.append(testData.get(i) + " ");
		}
		Assert.assertEquals(bufferForTest.toString(), testData.toString());
	}
}
