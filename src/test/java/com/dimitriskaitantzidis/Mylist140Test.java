package com.dimitriskaitantzidis;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Mylist140Test {

	Mylist140 list;
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalErr = System.err;

	@BeforeEach
	void setUp() {

		System.setErr(new PrintStream(errContent));

		list = new Mylist140();
		for (int i = 0; i < 6; i++) {
			list.addLast(1);
		}
	}

	@AfterEach
	void restore() {
		System.setErr(originalErr);
	}

	@Test
	void printsErrorMessageIfPositionIsNegative() {
		// Given
		int position = -1;
		int value = 999;
		String expectedErrorMsg = "The value of position given is negative. No add operation was performed. Please use a zero or positive value\r\n";



		// When
		list.add(value, position);

		// Then
		assertEquals(expectedErrorMsg, errContent.toString() );

	}

	@Test
	void shouldAddValueToGivenPositionThatIsSmallerThanSize() {
		// Given
		int position = 3;
		int value = 999;

		int actualValue = -1;

		int expectedValue = 999;



		// When
		list.add(value, position);

		// Then
		actualValue = list
				.getHead()
				.getNext()
				.getNext()
				.getNext()
				.getData();

		assertEquals(expectedValue, actualValue);
	}

	@Test
	void shouldAddValueToGivenPositionThatIsBiggerThanSize() {
		// Given
		int position = 10;
		int value = 999;

		int actualValue = -1;

		int expectedValue = 999;



		// When
		list.add(value, position);

		// Then

		Node current = list.getHead();
		for (int i = 0; i < position; i++) {
			current = current.getNext();
		}

		actualValue = current.getData();

		assertEquals(expectedValue, actualValue);
	}

	@Test
	void shouldAddValueToGivenPositionThatIsZero() {
		// Given
		int position = 0;
		int value = 999;

		int actualValue = -1;

		int expectedValue = 999;



		// When
		list.add(value, position);

		// Then

		Node current = list.getHead();

		actualValue = current.getData();

		assertEquals(expectedValue, actualValue);
	}

	@Test
	void shouldAddValueToGivenPositionThatIsTheLast() {
		// Given
		int position = 10;
		int value = 999;

		int actualValue = -1;

		int expectedValue = 999;



		// When
		list.add(value, position);

		// Then

		Node current = list.getHead();
		for (int i = 0; i < position; i++) {
			current = current.getNext();
		}

		actualValue = current.getData();

		assertEquals(expectedValue, actualValue);
	}
}