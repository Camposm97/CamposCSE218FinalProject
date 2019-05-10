package camposfx.util;

public class Random {
	private static final String[] errArr = { "Uh oh.  Something went wrong...", "I didn't do it! I swear!",
			"Oh no! I am error!", "You broke my program!", "I let you down. Sorry :(", "I'm not suppose to be here...",
			"This doesn't make any sense!", "You found me! :D", "Hello, I'm a message for your error :)",
			"ERROR ERROR ERROR", "Aw geez, this wasn't suppose to happen.", "Woopsy daisy!", "My bad.",
			"I didn't do it! I swear!" };

	public static String emitErrorMsg() {
		return errArr[(int) (Math.random() * errArr.length)];
	}
}
