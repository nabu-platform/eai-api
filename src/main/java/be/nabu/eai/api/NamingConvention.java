package be.nabu.eai.api;

import java.util.function.Function;

public enum NamingConvention {
	UPPER_CAMEL_CASE(new Camelifier(true)),
	LOWER_CAMEL_CASE(new Camelifier(false)),
	UNDERSCORE(new Decamelifier("_")),
	DASH(new Decamelifier("-")),
	LOWER_CASE(new Decamelifier(null))
	;
	
	private Function<String, String> transformer;
	
	private NamingConvention(Function<String, String> transformer) {
		this.transformer = transformer;
	}
	
	public String apply(String originalString) {
		return apply(originalString, NamingConvention.LOWER_CAMEL_CASE);
	}
	
	public String apply(String originalString, NamingConvention originalConvention) {
		// we always roundtrip to camelcase
		if (originalConvention != LOWER_CAMEL_CASE && originalConvention != UPPER_CAMEL_CASE) {
			originalString = LOWER_CAMEL_CASE.transformer.apply(originalString);
		}
		return this.transformer.apply(originalString);
	}
	
	public static class Decamelifier implements Function<String, String> {
		private String sequence;
		public Decamelifier(String sequence) {
			this.sequence = sequence;
		}
		@Override
		public String apply(String string) {
			StringBuilder builder = new StringBuilder();
			boolean previousUpper = false;
			for (int i = 0; i < string.length(); i++) {
				String substring = string.substring(i, i + 1);
				if (substring.equals(substring.toLowerCase()) || i == 0) {
					previousUpper = !substring.equals(substring.toLowerCase());
					builder.append(substring.toLowerCase());
				}
				else {
					// if it is not preceded by the sequence or another capitilized
					if (sequence != null && !string.endsWith(sequence) && !previousUpper) {
						builder.append(sequence);
					}
					previousUpper = true;
					builder.append(substring.toLowerCase());
				}
			}
			return builder.toString();
		}
	}
	
	public static class Camelifier implements Function<String, String> {
		private boolean upperCase;
		
		public Camelifier(boolean upperCase) {
			this.upperCase = upperCase;
		}
		
		@Override
		public String apply(String t) {
			StringBuilder builder = new StringBuilder();
			String[] split = t.split("[^a-zA-Z0-9]+");
			for (int i = 0; i < split.length; i++) {
				if (!split[i].isEmpty()) {
					if (i > 0 || upperCase) {
						builder.append(split[i].substring(0, 1).toUpperCase() + split[i].substring(1));
					}
					else {
						builder.append(split[i]);
					}
				}
			}
			return builder.toString();
		}
	};
}
