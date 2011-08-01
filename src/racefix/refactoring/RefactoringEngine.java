package racefix.refactoring;

import java.util.Set;

import racefix.refactoring.ClassChangeSet.PrivatizeMethod;

import edu.uiuc.threadprivaterefactoring.ThreadPrivateRefactoring;

public class RefactoringEngine {
  
  private final ClassChangeSet changeSet;

  public RefactoringEngine(ClassChangeSet changeSet) {
    this.changeSet = changeSet;
  }
  
  public void applyRefactorings() {
    Set<PrivatizeMethod> privatizeMethods = changeSet.privatizeMethods;
    Set<String> threadLocal = changeSet.threadLocal;
    
    for (String string : threadLocal) {
      RefactoringElement element = new RefactoringElement(string, new ThreadPrivateRefactoring());
      element.apply();
    }
  }
}
