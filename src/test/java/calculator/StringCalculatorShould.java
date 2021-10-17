package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorShould {
	 StringCalculator calculator = new StringCalculator();

    @Test
    void empty_string_should_return_0() throws Exception {
        assertEquals(0, calculator.add(""));
    }
    @Test
    void string_with_single_number_should_return_number_as_int() throws Exception {
        assertEquals(1, calculator.add("1"));
    }
    @Test
    public void addTwoNumberIsSumOfNumbers() throws Exception {
        assertEquals(3, calculator.add("1,2"));
    }
    @Test
    public void addUnknownAmountOfNumber() throws Exception {
        assertEquals(12, calculator.add("1,2,4,3,2"));
    }
	@Test
	public void acceptNewlineAsValidDelimiter() throws Exception{
		assertEquals(6, calculator.add("1\n2,3"));
	}
	@Test
	public void customDelimeter() throws Exception {
		assertEquals(3, calculator.add("//;\n1;2"));
	}
	@Test
    public void throwExceptionIfSingleNegativeNumber() throws Exception {
        try {
            calculator.add("//;\n1;-2;5");
        }catch (StringCalculatorException e) {
            assertEquals("negatives not allowed -2", e.getMessage());
        }
    }
	@Test
	public void throwExceptionIfMultipleNegativeNumber () throws RuntimeException  {
		try {
			calculator.add("-1,-2,3");
		} catch(Exception e){
			 assertEquals("negatives not allowed [-1, -2]", e.getMessage());
		} 
	}
	@Test
	public void validateCallCount(){
		assertEquals(calculator.getCallCount(), calculator.count);
	}
	@Test
	public void ignoreNumsGreaterThan1000() throws Exception {
		assertEquals(2, calculator.add("2,1001"));
	}
	@Test
	public void validateAnyLengthDelimeter() throws Exception {
		assertEquals(6, calculator.add("//[***]\n1***2***3"));
	}
	@Test
	public void multipleDelimeter() throws Exception	{
		assertEquals(6, calculator.add("//[*][%]\n1*2%3"));
	}
	@Test
	public void mulCustomDelWithAnyLength() throws Exception {
		assertEquals(6, calculator.add("//[**][%%]\n1**2%%3"));
	}
   
}
