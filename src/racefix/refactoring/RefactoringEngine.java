package racefix.refactoring;

import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.search.FieldDeclarationMatch;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.core.search.IJavaSearchScope;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.core.search.SearchMatch;
import org.eclipse.jdt.core.search.SearchParticipant;
import org.eclipse.jdt.core.search.SearchPattern;
import org.eclipse.jdt.core.search.SearchRequestor;

import edu.uiuc.threadlocalrefactoring.ThreadLocalRefactoring;

import racefix.ClassChangeSet;
import racefix.PrivatizeMethod;

public class RefactoringEngine {
  
  private final ClassChangeSet changeSet;

  public RefactoringEngine(ClassChangeSet changeSet) {
    this.changeSet = changeSet;
  }
  
  public void applyRefactorings() {
    Set<PrivatizeMethod> privatizeMethods = changeSet.privatizeMethods;
    Set<String> threadLocal = changeSet.threadLocal;
    
    for (String string : threadLocal) {
      RefactoringElement element = new RefactoringElement(string, new ThreadLocalRefactoring());
      
    }
  }
  
  
}
