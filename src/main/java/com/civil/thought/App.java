/**
 * Created by: Vitaliy Kovalevskyy
 * Date:06.01.2023
 */

package com.civil.thought;

import java.io.IOException;
import java.net.URISyntaxException;

public class App {

    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {

        String fileName1 = "files/cyrillic_1.txt";
        String fileName2 = "files/cyrillic_2.txt";

        Utility utility = new Utility();
        AsyncComputation asyncComputation = new AsyncComputation(utility);

        String statements = asyncComputation.computeFiles(fileName1, fileName2);
        System.out.println(statements);
    }

}
