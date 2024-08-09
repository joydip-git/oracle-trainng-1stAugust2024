package newfeatures;

public class SampleImplementation implements Sample {
	@Override
	public String getMessage(String name) {
		return "welcome " + name;
	}
}
