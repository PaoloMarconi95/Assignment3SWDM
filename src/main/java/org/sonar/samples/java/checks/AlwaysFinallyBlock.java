package org.sonar.samples.java.checks;

import org.sonar.plugins.java.api.semantic.Symbol.MethodSymbol;
import org.sonar.plugins.java.api.semantic.Type;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.tree.Tree.Kind;
import org.sonar.plugins.java.api.tree.Tree;
import java.util.Collections;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.tree.TryStatementTree;
import org.sonar.plugins.java.api.tree.BlockTree;
import java.util.List;
import java.util.Collections;

@Rule(
	key = "AlwaysFinallyBlock",
	name = "Always write Finally block",
	description ="Good practice is to always write finally statement in a try-catch block",
tags = {"code-smell"})
public class AlwaysFinallyBlock extends IssuableSubscriptionVisitor {
	
	@Override
	public List<Kind> nodesToVisit() {
		return Collections.singletonList(Kind.TRY_STATEMENT);
	}
	
	@Override
	public void visitNode(Tree tree) {
		TryStatementTree tryblock = (TryStatementTree) tree;
		try{
			BlockTree finallyblock = tryblock.finallyBlock();
			if(finallyblock == null){
				reportIssue(tryblock, "Good practice is to always write finally statement in a try-catch block");
			}
		}
		catch(Exception e){
			reportIssue(tryblock, "Good practice is to always write finally statement in a try-catch block");
		}
		finally{
			// Work done
		}
		
	}
}