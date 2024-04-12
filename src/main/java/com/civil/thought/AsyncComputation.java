/**
 * Created by: Vitaliy Kovalevskyy
 * Date:06.01.2023
 */

package com.civil.thought;

public class AsyncComputation {

    private Utility utility;

    public AsyncComputation(Utility utility) {
        this.utility = utility;
    }

    /**
       Write a CompletableFuture processing chain that asynchronously executes the following actions:
           - reads the file
               - utility.readFile(String s)
           - retrieves latin letters from the content of the file
               - utility.getLatinLettersFromText(String s)
           - modifies the retrieved latin letters
               - utility.modifyString(String s)
           - enriches modified string
               - utility.enrichString(String s)
           - combines the processed result of the two files
               - utility.combineTwoStrings(String x, String y)
           - in case an exception occurs, return new RuntimeException("Stay Strong!").getMessage()
           - return computation result value when complete by calling .join()
     */
    public String computeFiles(String fileName1, String fileName2) {

        return null;
    }
}
