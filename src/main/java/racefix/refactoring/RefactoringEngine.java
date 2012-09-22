package racefix.refactoring;

import java.util.Set;

import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.search.IJavaSearchConstants;

import racefix.refactoring.makeprivatizable.MakePrivatizableRefactoring;

import edu.uiuc.threadprivaterefactoring.ThreadPrivateRefactoring;

public class RefactoringEngine {

	private final Set<ClassChangeSet> changeSet;

	public RefactoringEngine(Set<ClassChangeSet> changeSet) {
		this.changeSet = changeSet;
	}

	public void applyRefactorings() {
		for (ClassChangeSet change : changeSet) {

			String classToMakePrivatizable = change.clazz;

			new MakePrivatizableRefactoring(change);

			Set<String> threadLocal = change.threadLocal;

			for (String string : threadLocal) {
				RefactoringElement element = new RefactoringElement(
						string,
						new ThreadPrivateRefactoring(
								(IField) RefactoringElement.findElement(string, IJavaSearchConstants.FIELD)));
				element.apply();
			}
		}
	}
}
