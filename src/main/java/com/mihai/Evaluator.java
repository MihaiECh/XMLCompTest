package com.mihai;

import org.xmlunit.diff.Comparison;
import org.xmlunit.diff.ComparisonResult;
import org.xmlunit.diff.DifferenceEvaluator;
import org.w3c.dom.Node;


public class Evaluator implements DifferenceEvaluator {
    public ComparisonResult evaluate(Comparison comparison, ComparisonResult comparisonResult) {
        if (comparisonResult == ComparisonResult.EQUAL) {
            return comparisonResult;
        }
        Node controlNode = comparison.getControlDetails().getTarget();
        if(controlNode.getParentNode().getNodeName().equals("department")) {
            comparisonResult=ComparisonResult.EQUAL;
        }
        return comparisonResult;


    }
}
