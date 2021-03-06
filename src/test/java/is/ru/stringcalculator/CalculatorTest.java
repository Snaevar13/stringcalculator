package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;


public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}	

	@Test
    public void testMultipleNumbers(){
    	assertEquals(6, Calculator.add("1,2,3"));
    }
    @Test
    public void testFourNumbers(){
    	assertEquals(10, Calculator.add("1,2,3,4"));
    }
    @Test
    public void testNewLine(){
    	assertEquals(6, Calculator.add("1\n2,3"));
    }
    @Test
    public void testDelimiter(){
    	assertEquals(3, Calculator.add("//;\n1;2"));
    }
    @Test
    public void testNegativeNumbers() {
    	try{
    		Calculator.add("-1,2,-3"); 
    	}
    	catch(IllegalArgumentException e){
    		assertTrue(e.getMessage(), 
    		e.getMessage().contains("Negatives not allowed:"));
    	}
    }
    @Test 
    public void testLargerThan1000(){
    	assertEquals(2, Calculator.add("1001,2"));
    }
    @Test 
    public void testLargeDelimiter(){
    	assertEquals(6, Calculator.add("//[;;;]\n1;;;2;;;3"));
    }
 }  