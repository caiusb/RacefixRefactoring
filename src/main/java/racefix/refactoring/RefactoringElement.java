package racefix.refactoring;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.ILocalVariable;
import org.eclipse.jdt.core.search.FieldDeclarationMatch;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.core.search.IJavaSearchScope;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.core.search.SearchMatch;
import org.eclipse.jdt.core.search.SearchParticipant;
import org.eclipse.jdt.core.search.SearchPattern;
import org.eclipse.jdt.core.search.SearchRequestor;
import org.eclipse.ltk.core.refactoring.CheckConditionsOperation;
import org.eclipse.ltk.core.refactoring.PerformRefactoringOperation;
import org.eclipse.ltk.core.refactoring.Refactoring;

public class RefactoringElement {

  private final IField element;
  private final Refactoring refactoring;

  public RefactoringElement(String element, Refactoring refactoring) {
    this.element = findField(element);
    this.refactoring = refactoring;
  }

  private static class Requestor extends SearchRequestor {

    public IField field;

    @Override
    public void acceptSearchMatch(SearchMatch match) throws CoreException {
      if (match instanceof FieldDeclarationMatch) {
        FieldDeclarationMatch declarationMatch = (FieldDeclarationMatch) match;
        Object rawElement = declarationMatch.getElement();
        if (rawElement instanceof IField)
          field = (IField) rawElement;
      }
    }
  }
  
  public IField getField() {
    return element;
  }

  public static IField findField(String string) {
    SearchEngine engine = new SearchEngine();
    SearchPattern pattern = SearchPattern.createPattern(string, IJavaSearchConstants.FIELD,
        IJavaSearchConstants.DECLARATIONS, SearchPattern.R_EXACT_MATCH);
    IJavaSearchScope scope = SearchEngine.createWorkspaceScope();
    Requestor requestor = new Requestor();

    try {
      engine.search(pattern, new SearchParticipant[] { SearchEngine.getDefaultSearchParticipant() }, scope, requestor,
          new NullProgressMonitor());
    } catch (CoreException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    return requestor.field;
  }
  
  public static ILocalVariable findLocalVariable(String method, String name) {
  	SearchEngine engine = new SearchEngine();
//  	engine.search(ResourcesPlugin.getWorkspace(), string, IJavaSearchConstants., limitTo, scope, resultCollector)
  	return null;
  }
  
  public void apply() {
    PerformRefactoringOperation operation = new PerformRefactoringOperation(refactoring, CheckConditionsOperation.ALL_CONDITIONS);
    try {
      ResourcesPlugin.getWorkspace().run(operation, new NullProgressMonitor());
    } catch (CoreException e) {
      System.out.println("OOPS");
    }
  }
}
