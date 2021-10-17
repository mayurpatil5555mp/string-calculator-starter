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
   
}
