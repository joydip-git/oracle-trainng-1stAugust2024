package newfeatures;

public class App {

	public static void main(String[] args) {
		Sample sample = new SampleImplementation();
		System.out.println(sample.extra());
		System.out.println(sample.getMessage("anil"));
		Sample.staticExtra();

		Sample anonymousSample = new Sample() {
			@Override
			public String getMessage(String name) {
				return "welcome " + name;
			}

			@Override
			public String extra() {
				return "this is overriden extra";
			}
		};
		System.out.println(anonymousSample.extra());
	}

}
