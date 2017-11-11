package com.mihai;

import org.xmlunit.diff.Comparison;
import org.xmlunit.diff.ComparisonFormatter;
import org.xmlunit.diff.ComparisonType;

public class CustomFormatter implements ComparisonFormatter{
    public String getDescription(Comparison comparison) {
        StringBuilder result = new StringBuilder("DIfference found at: ");
        result.append(comparison.getControlDetails().getParentXPath());
        result.append(" between ");
        result.append("expected value: ").append(comparison.getControlDetails().getValue().toString());
        result.append(" and actual value: ").append(comparison.getTestDetails().getValue().toString());
        return result.toString();
    }

    public String getDetails(Comparison.Detail detail, ComparisonType comparisonType, boolean b) {
        return null;
    }
}
