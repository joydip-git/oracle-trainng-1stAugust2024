package newfeatures;

import java.util.stream.Stream;

@FunctionalInterface
public interface Sample {
	String getMessage(String name);

	default String extra() {
		return "extra";
	}

	static String staticExtra() {
		return "static extra";
	}
}
