package racefix.refactoring;

import java.util.Set;

public class ClassChangeSet {
	public class PrivatizeMethod {
		public Set<String> privatizedFields;
	}
	public Set<String> threadLocal;
	public Set<PrivatizeMethod> privatizeMethods;
}