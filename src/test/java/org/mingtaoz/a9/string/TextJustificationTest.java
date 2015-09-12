package org.mingtaoz.a9.string;

import static org.truth0.Truth.ASSERT;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mingtaoz.a9.string.TextJustification;

public class TextJustificationTest {

	private TextJustification sut;

	@Before
	public void setup() {
		sut = new TextJustification();
	}

	@Test
	public void testFullJustify2() {
		String[] i = { "What", "must", "be", "shall", "be." };
		List<String> o = new LinkedList<String>();
		o.add("What must be");
		o.add("shall be.   ");

		ASSERT.that(sut.fullJustify(i, 12)).iteratesAs(o);
	}

	@Test
	public void testFullJustify1() {
		String[] i = { "This", "is", "an", "example", "of", "text",
				"justification." };
		List<String> o = new LinkedList<String>();
		o.add("This    is    an");
		o.add("example  of text");
		o.add("justification.  ");

		ASSERT.that(sut.fullJustify(i, 16)).iteratesAs(o);
	}
}
