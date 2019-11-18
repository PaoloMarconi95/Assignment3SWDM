package org.sonar.samples.java.checks;

import org.sonar.plugins.java.api.semantic.Symbol.MethodSymbol;
import org.sonar.plugins.java.api.semantic.Type;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.tree.Tree.Kind;
import org.sonar.plugins.java.api.tree.Tree;
import java.util.Collections;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.tree.SwitchStatementTree;
import java.util.List;


@Rule(
	key = "SwitchControl",
	name = "Switch statement too short",
	description = "You should not write a switch statement with less than 2 cases",
tags = {"code-smell"})
public class SwitchControl extends IssuableSubscriptionVisitor {
	
	@Override
	public List<Kind> nodesToVisit() {
		return Collections.singletonList(Kind.SWITCH_STATEMENT);
	}
	
	
	@Override
	public void visitNode(Tree tree) {
		SwitchStatementTree switches = (SwitchStatementTree) tree;
		if(switches.cases().size() <= 2){
			reportIssue(switches, "Consider switching to if-then-else statement");
			}
	}	
	
}