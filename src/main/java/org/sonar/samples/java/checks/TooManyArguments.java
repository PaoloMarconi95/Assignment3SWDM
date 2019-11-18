package org.sonar.samples.java.checks;

import org.sonar.plugins.java.api.semantic.Symbol.MethodSymbol;
import org.sonar.plugins.java.api.semantic.Type;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.tree.Tree.Kind;
import org.sonar.plugins.java.api.tree.Tree;
import java.util.Collections;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.tree.MethodTree;
import java.util.List;
import java.util.ArrayList;

@Rule(
	key = "TooManyArgumentsSameType",
	name = "Too Many Arguments of the same Type",
	description = "You should not write a method with more than 5 arguments of the same type.\n Consider passing them as an array",
tags = {"code-smell"})
public class TooManyArguments extends IssuableSubscriptionVisitor {
	
	@Override
	public List<Kind> nodesToVisit() {
		return Collections.singletonList(Kind.METHOD);
	}
	
	@Override
	public void visitNode(Tree tree) {
		MethodTree method = (MethodTree) tree;
		if (method.parameters().size() >= 5) {
			MethodSymbol symbol = method.symbol();
			ArrayList<Type> allTypes = new ArrayList<>();
			ArrayList<Type> types = new ArrayList<>();
			for (int i = 0; i < method.parameters().size(); i++) {
				Type param = symbol.parameterTypes().get(i);
				if (!types.contains(param)) {
					types.add(param);
					allTypes.add(param);
					} else {
					allTypes.add(param);
				}
			}
			// Count how many different typology of param there are
			for(int i = 0; i < types.size(); i++) {
				int occurrences = Collections.frequency(allTypes, types.get(i));
				if(occurrences >= 5 ) {
					reportIssue(method.simpleName(), "More than 5 arguments of the same type as method input");
				}
				else{
					// look for other parameters
				}
			}
		}
		else {
			//No problem found
		}
	}
}