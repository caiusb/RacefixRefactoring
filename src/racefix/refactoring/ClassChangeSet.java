package racefix.refactoring;

import java.util.Set;

public class ClassChangeSet {
	/**
	 * Describes the class that must be made provatizable.
	 */
	public String clazz;

	/**
	 * The fields that should be privatized.
	 */
	public Set<String> privatizedFields;

	/**
	 * The fields that should be made ThreadLocal.
	 */
	public Set<String> threadLocal;
}