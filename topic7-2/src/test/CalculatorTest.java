package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import app.Calculator;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Assume;

@RunWith(Parameterized.class)
public class CalculatorTest {

	enum Type {ADD, SUBTRACT, MULTIPLY, DIVIDE};
	
	@Parameter(0)
	public Type type;
	@Parameter(1)
	public int a1;
	@Parameter(2)
	public int a2;
	@Parameter(3)
	public int result;
	
	@Parameters
	public static Collection<Object[]> data() 
		{
			Object[][] data = new Object[][] { 
				{Type.ADD,  2 , 1, 3 }, {Type.ADD, 5, 2 , 7},
				{Type.SUBTRACT,  2 , 1, 1 }, {Type.SUBTRACT, 5, 2 , 3},
				{Type.MULTIPLY,  2 , 1, 2 }, {Type.MULTIPLY, 5, 2 , 10},
				{Type.DIVIDE,  2 , 1, 2 }, {Type.DIVIDE, 5, 2 , 2}
																	};
				return Arrays.asList(data);}
	
	@Test
	public void testAdd() {
		Assume.assumeTrue(type == Type.ADD);
		Calculator calc = new Calculator();
		Assert.assertEquals(result, calc.add(a1, a2));

		
	}
	
	@Test
	public void testSubtract() {
		Assume.assumeTrue(type == Type.SUBTRACT);
		Calculator calc = new Calculator();
		Assert.assertEquals(result, calc.subtract(a1, a2));
		
	}
	
	@Test
	public void testMultiply() {
		Assume.assumeTrue(type == Type.MULTIPLY);
		Calculator calc = new Calculator();
		Assert.assertEquals(result, calc.multiply(a1, a2));
		
	}
	
	@Test
	public void testDivide() {
		Assume.assumeTrue(type == Type.DIVIDE);
		Calculator calc = new Calculator();
		Assert.assertEquals(result, calc.divide(a1, a2));

	}

}
