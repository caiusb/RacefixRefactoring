package racefix.refactoring;

import java.util.Set;

import racefix.ClassChangeSet;
import racefix.PrivatizeMethod;
import edu.uiuc.threadlocalrefactoring.ThreadLocalRefactoring;

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
      element.apply();
    }
  }
  
  
}
