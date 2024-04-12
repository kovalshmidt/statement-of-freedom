package com.civil.thought.utils;

import com.civil.thought.AsyncComputation;
import com.civil.thought.Utility;
import org.junit.Test;

import java.util.Base64;

import static org.junit.Assert.*;

public class AsyncComputationTest {

    private final String fileName1 = "files/cyrillic_1.txt";
    private final String fileName2 = "files/cyrillic_2.txt";
    private final String expected = "CgpSVVNTSUEgSVMgQSBURVJST1JJU1QgU1RBVEUhISEKU1RBTkQgV0lUSCBVS1JBSU5FISEh";

    @Test
    public void computeFiles() {

        Utility utility = new Utility();
        AsyncComputation asyncComputation = new AsyncComputation(utility);

        String result = asyncComputation.computeFiles(fileName1, fileName2);
        String encoded = Base64.getEncoder().encodeToString(result.getBytes());
        System.out.println(result);

        assertEquals(encoded, expected);
    }

    @Test
    public void computeFilesException() {

        Utility utility = new Utility();
        AsyncComputation asyncComputation = new AsyncComputation(utility);

        String result = asyncComputation.computeFiles(fileName1, "wrongFile.txt");
        String expected = "Stay Strong!";

        assertEquals(result, expected);
    }
}