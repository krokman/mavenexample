import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestingAL {

	private String firstElement;
	private String secondElement;
	private String thirdElement;
	private String lastElement;
	private String insideElement;
	private int insideElementIndex;
	private MyArrayList<String> testData;

	@Before
	public void dataInitializing() {
		firstElement = "Roflan1";
		secondElement = "Roflan2";
		thirdElement = "Roflan3";
		lastElement = "RoflanLast";
		insideElement = "RoflanInside";
		insideElementIndex = 2;
		testData = new MyArrayList<String>();
		testData.add(firstElement);
		testData.add(secondElement);
		testData.add(thirdElement);
	}

	@Test
	public void get() {
		//testing get
		Assert.assertEquals(firstElement, testData.get(0));
	}

	@Test
	public void add() {
		//testing add without index & size
		testData.add(lastElement);
		Assert.assertEquals(lastElement, testData.get(testData.size() - 1));
	}

	@Test
	public void addWithIndex() {
		//testing add with index(inside)
		testData.add(insideElement, insideElementIndex);
		Assert.assertEquals(insideElement, testData.get(insideElementIndex));
	}

	@Test
	public void set() {
		//testing set with index
		testData.set(firstElement, insideElementIndex);
		Assert.assertEquals(firstElement, testData.get(insideElementIndex));
	}

	@Test
	public void remove() {
		//testing remove with index
		Assert.assertEquals(testData.remove(insideElementIndex), thirdElement);
	}

	@Test
	public void removeValue() {
		//testing remove Value
		testData.remove(firstElement);
		Assert.assertEquals(secondElement, testData.get(0));
	}

	@Test
	public void isEmpty() {
		//testing isEmpty
		Assert.assertFalse(testData.isEmpty());
	}

	@Test
	public void toStringTest() {
		//testing toString
		StringBuilder bufferForTest = new StringBuilder();
		for (int i = 0; i < testData.size(); i++) {
			bufferForTest.append(testData.get(i) + " ");
		}
		Assert.assertEquals(bufferForTest.toString(), testData.toString());
	}
}