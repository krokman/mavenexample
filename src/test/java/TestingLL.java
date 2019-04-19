import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestingLL {

	private String firstElement;
	private String secondElement;
	private String thirdElement;
	private String lastElement;
	private String insideElement;
	private int insideElementIndex;
	private MyLinkedList<String> testData;

	@Before
	public void dataInitializing() {
		firstElement = "Roflan1";
		secondElement = "Roflan2";
		thirdElement = "Roflan3";
		lastElement = "RoflanLast";
		insideElement = "RoflanInside";
		insideElementIndex = 2;
		testData = new MyLinkedList<String>();
		testData.add(firstElement);
		testData.add(secondElement);
		testData.add(thirdElement);
	}

	@Test
	public void testingAllFunctionalityOfLinkedList() {
		//testing get
		Assert.assertEquals(firstElement, testData.get(0));
		//testing add without index & size
		testData.add(lastElement);
		Assert.assertEquals(lastElement, testData.get(testData.size() - 1));
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
