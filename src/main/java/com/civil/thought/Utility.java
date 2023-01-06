/**
 * Created by: Vitaliy Kovalevskyy
 * Date:06.01.2023
 */

package com.civil.thought;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Locale;
import java.util.Random;

public class Utility {

    private static final Logger log = LoggerFactory.getLogger(Utility.class);
    public static final String CYRILLIC_ALPHABET = "АаБбВвГгҐґДдЕеЄєЖжЗзИиІіЇїЙйКкЛлМмНнОоПпРрСсТтУуФфХхЦцЧчШшЩщЬьЮюЯя";
    public static final String LATIN_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";


    public String getLatinLettersFromText(String content) {
        String result="";

        log.info("Retrieving latin letters...");
        for (int i = 0; i < content.length(); i++){
            if(LATIN_ALPHABET.contains(Character.toString(content.charAt(i)))){
                result += content.charAt(i);
            }
        }
        log.info("Letters retrieved for {}!", result.charAt(0));
        return result;
    }

    public String enrichString(String content) {
        log.info("Enriching the content of {}", content.charAt(0));
        String result = content.toUpperCase(Locale.ROOT) + "!!!";
        log.info("Content enriched for {}!", content.charAt(0));
        return result;
    }

    public String combineTwoStrings(String str, String rts) {
        log.info("Combining the two statements");
        String result = "\n\n" + str + "\n" + rts;
        log.info("Statements combined!");
        return result;
    }

    public String modifyString(String str) {
        log.info("Enriching the content for  {}!", str.charAt(0));
        String result = str.replaceAll("Z", " ");
        log.info("Content enriched for  {}!", str.charAt(0));
        return result;
    }

    public String readFile(String fileName) {
        log.info("Retrieving content from {}", fileName);
        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            InputStream is = classloader.getResourceAsStream(fileName);
            ByteArrayOutputStream result = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            for (int length; (length = is.read(buffer)) != -1; ) {
                result.write(buffer, 0, length);
            }
            log.info("Content retrieved from {} ", fileName);
            return result.toString("UTF-8").replaceAll("\\s+", "");
        } catch (Exception ex){
           throw new RuntimeException("Stay Strong!");
        }
    }

    public static String splitStringWithStep(String text, int n) {

        String[] results = text.split("(?<=\\G.{" + n + "})");
        return convertStringArrayToString(results, "\n");
    }

    private void writeToFile(String fileName, String content) throws IOException, URISyntaxException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        URI path = classloader.getResource(fileName).toURI();
        FileOutputStream outputStream = new FileOutputStream(new File(path));
        byte[] strToBytes = content.getBytes();
        outputStream.write(strToBytes);
    }

    private static String convertStringArrayToString(String[] strArr, String delimiter) {
        StringBuilder sb = new StringBuilder();
        for (String str : strArr)
            sb.append(str).append(delimiter);
        return sb.substring(0, sb.length() - 1);
    }

    public static String randomString(String str, int x){

        //create an array for shuffling and a new array to store the result
        char[] arr = str.toCharArray();
        char[] ans = new char[x];

        //randomly shuffle
        Random random = new Random();
        for (int i = 0, j; i < x; i++) {
            j = random.nextInt(arr.length-1);
            ans[i] = arr[j];
        }

        return new String(ans);
    }
}
