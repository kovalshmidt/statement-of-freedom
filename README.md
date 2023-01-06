
## The Task
In `AsyncComputation.class`, implement method `computeFiles` by writing a CompletableFuture chain 
that asynchronously processes two files and returns two statements. Execute the following actions:
  - read the file `utility.readFile(String fileName)`
  - retrieve latin letters from the content of the file `utility.getLatinLettersFromText(String s)`
  - modify the retrieved latin letters `utility.modifyString(String s)`
  - enrich modified string `utility.enrichString(String s)`
  - combine the processed result of the two files `utility.combineTwoStrings(String x, String y)`
  - in case an exception occurs, return `exception.getMessage()`

A plus would be to run `combineTwoString` in a separate thread-pool.
  
Return the result of CompletableFuture chain by calling .join() at the end.

## Test
To test your code, run the tests in `AsyncComputationTest.class`
