package org.sonar.samples.java.checks;

import org.sonar.plugins.java.api.semantic.Symbol.MethodSymbol;
import org.sonar.plugins.java.api.semantic.Type;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.tree.Tree.Kind;
import org.sonar.plugins.java.api.tree.Tree;
import java.util.Collections;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.tree.IfStatementTree;
import org.sonar.plugins.java.api.tree.StatementTree;
import java.util.List;
import java.util.ArrayList;

@Rule(
	key = "AlwaysElse",
	name = "Else branch missing",
	description = "You should always write the else branch whenever there's an if statement ",
tags = {"code-smell"})
public class AlwaysElse extends IssuableSubscriptionVisitor {
	
	@Override
	public List<Kind> nodesToVisit() {
		return Collections.singletonList(Kind.IF_STATEMENT);
	}
	
	
	@Override
	public void visitNode(Tree tree) {
		IfStatementTree iftree = (IfStatementTree) tree;
		try{
			StatementTree elsebranch = iftree.elseStatement();
			if(elsebranch == null){
				reportIssue(iftree, "Always write else branch");
			}
		}
		catch(Exception e){
			reportIssue(iftree, "Always write else branch");
		}
		finally{
			// Done
		}
	}
	
}