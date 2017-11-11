package com.mihai;



import org.xmlunit.builder.DiffBuilder;
import org.xmlunit.diff.ComparisonFormatter;
import org.xmlunit.diff.Diff;
import org.xmlunit.diff.Difference;
import org.xmlunit.diff.DifferenceEvaluator;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.*;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )

    {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream1 = classLoader.getResourceAsStream("file1.xml");
        InputStream inputStream2 = classLoader.getResourceAsStream("file2.xml");

        Source source = new StreamSource(inputStream1);
        Source target = new StreamSource(inputStream2);

        DifferenceEvaluator evaluator = new Evaluator();
       Diff diff = DiffBuilder.compare(source).withTest(target).withDifferenceEvaluator(evaluator).build();

        ComparisonFormatter formatter = new CustomFormatter();
        for(Difference difference:diff.getDifferences()) {
            System.out.println(difference.getComparison().toString(formatter));
        }




    }
}
