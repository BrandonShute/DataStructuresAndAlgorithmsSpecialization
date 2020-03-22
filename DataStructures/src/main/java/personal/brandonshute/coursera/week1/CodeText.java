package personal.brandonshute.coursera.week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Question 1 from assignment 1. Writing an implementation to check where brackets in a text editor are valid (each
 * opening bracket contains a corresponding closing bracket in the correct order. Brackets can be "[", "(", "{" and
 * their corresponding closing.
 */
public class CodeText {

	private static final String SUCCESS_MESSAGE = "Success";

	private static final Map<Character, Character> OPENING_TO_CLOSING_BRACKETS = new HashMap<Character, Character>() {{
		put('(', ')');
		put('[', ']');
		put('{', '}');
	}};

	private final String text;
	private final Stack<OpeningBracket> openingBracketsStack;

	public CodeText(final String text) {
		this.text = text;
		this.openingBracketsStack = new Stack<>();
	}

	/**
	 * Validates the brackets of an input text to ensure that each opening bracket has a corresponding closing bracket
	 * in the correct order.
	 *
	 * @return {@code -1} if the brackets are valid and the integer of the first invalid closing bracket.
	 */
	public int validateBrackets() {
		for (int position = 1; position <= this.text.length(); position++) {
			final char nextChar = this.text.charAt(position - 1);

			if (OPENING_TO_CLOSING_BRACKETS.containsValue(nextChar)) {
				if (this.openingBracketsStack.empty()) {
					return position;
				} else {
					final OpeningBracket openingBracket = this.openingBracketsStack.pop();
					if (!openingBracket.matchesClose(nextChar)) {
						return position;
					}
				}
			} else if (OPENING_TO_CLOSING_BRACKETS.containsKey(nextChar)) {
				this.openingBracketsStack.push(new OpeningBracket(nextChar, position));
			}
		}

		return (this.openingBracketsStack.empty()) ? -1 : this.openingBracketsStack.pop().position;
	}

	public static void main(String[] args) throws IOException {
		final InputStreamReader inputStream = new InputStreamReader(System.in);
		final BufferedReader reader = new BufferedReader(inputStream);
		final CodeText text = new CodeText(reader.readLine());
		final int validBrackets = text.validateBrackets();
		System.out.println((validBrackets == -1) ? SUCCESS_MESSAGE : validBrackets);
	}

	/**
	 * Data structure to contain the opening bracket and its position in the text
	 */
	private class OpeningBracket {

		private char bracketType;
		private int position;

		private OpeningBracket(final char bracketType, final int position) {
			this.bracketType = bracketType;
			this.position = position;
		}

		private boolean matchesClose(final char charToCheck) {
			return OPENING_TO_CLOSING_BRACKETS.get(this.bracketType) == charToCheck;
		}
	}
}
