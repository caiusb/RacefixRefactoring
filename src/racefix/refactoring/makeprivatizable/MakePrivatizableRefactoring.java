package racefix.refactoring.makeprivatizable;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.Refactoring;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;

import racefix.refactoring.ClassChangeSet;

/**
 * This refactoring makes a class privatizable
 * 
 * It implements the Privatizable interface and correctly privatizes the classes
 * fields based on the information it receives from the analysis.
 * 
 * @author caius
 * 
 */
public class MakePrivatizableRefactoring extends Refactoring {

	private ClassChangeSet change;

	public MakePrivatizableRefactoring(ClassChangeSet change) {
		this.change = change;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RefactoringStatus checkInitialConditions(IProgressMonitor pm)
			throws CoreException, OperationCanceledException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RefactoringStatus checkFinalConditions(IProgressMonitor pm)
			throws CoreException, OperationCanceledException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Change createChange(IProgressMonitor pm) throws CoreException,
			OperationCanceledException {
		// TODO Auto-generated method stub
		return null;
	}

}
