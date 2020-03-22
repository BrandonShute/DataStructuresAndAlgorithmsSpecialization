package personal.brandonshute.coursera.week1;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Unit tests for the {@link CodeTextTest} class
 */
public class CodeTextTest {

	@Test
	public void when_text_only_contains_opening_and_closing_bracket_then_return_negative_one() {
		assertThat(new CodeText("()").validateBrackets(), is(-1));
		assertThat(new CodeText("[]").validateBrackets(), is(-1));
		assertThat(new CodeText("{}").validateBrackets(), is(-1));
	}

	@Test
	public void when_text_only_contains_closing_bracket_then_return_index() {
		assertThat(new CodeText(")").validateBrackets(), is(1));
		assertThat(new CodeText("]").validateBrackets(), is(1));
		assertThat(new CodeText("}").validateBrackets(), is(1));
	}

	@Test
	public void when_text_only_contains_opening_bracket_then_return_index() {
		assertThat(new CodeText("(").validateBrackets(), is(1));
		assertThat(new CodeText("(").validateBrackets(), is(1));
		assertThat(new CodeText("(").validateBrackets(), is(1));
	}

	@Test
	public void when_text_contains_non_nested_valid_brackets_then_return_negative_one() {
		assertThat(new CodeText("{}[]").validateBrackets(), is(-1));
		assertThat(new CodeText("{}[]()()").validateBrackets(), is(-1));
		assertThat(new CodeText("{}()[]").validateBrackets(), is(-1));
	}

	@Test
	public void when_text_contains_nested_valid_brackets_then_return_negative_one() {
		assertThat(new CodeText("{[]}").validateBrackets(), is(-1));
		assertThat(new CodeText("[(){[]}]").validateBrackets(), is(-1));
		assertThat(new CodeText("{([][{}()[]])}").validateBrackets(), is(-1));
	}

	@Test
	public void when_text_is_valid_with_other_chars_then_return_negative_one() {
		assertThat(new CodeText("foo(bar);").validateBrackets(), is(-1));
		assertThat(new CodeText("if(x == y) { return -1; } else { return 1; }").validateBrackets(), is(-1));
		assertThat(
				new CodeText("public class Test { private static final char x = 'v';\n\npublic Test(x){this.x = x;} }").validateBrackets(),
				is(-1)
		);
	}

	@Test
	public void when_text_is_invalid_then_return_the_correct_index_of_the_first_invalid_closing_bracket() {
		assertThat(new CodeText("foo(bar[i);").validateBrackets(), is(10));
		assertThat(new CodeText("{[}").validateBrackets(), is(3));
		assertThat(new CodeText("({[]}}()").validateBrackets(), is(6));
	}

	@Test
	public void when_text_has_invalid_bracket_for_last_char_then_return_index_of_last_char() {
		assertThat(new CodeText("{()}}").validateBrackets(), is(5));
	}

	@Test
	public void when_text_has_is_missing_a_closing_bracket_then_return_index_of_opening_bracket() {
		assertThat(new CodeText("{foo(xx);").validateBrackets(), is(1));
	}
}
