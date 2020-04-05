/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pironet.tda;

import com.pironet.tda.utils.DateMatcher;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

public class CatalinaOutFileParser extends SunJDKParser {

    public CatalinaOutFileParser(BufferedReader bis, Map threadStore, int lineCounter,
            boolean withCurrentTimeStamp, int startCounter, DateMatcher dm) {
        super(bis, threadStore, lineCounter, withCurrentTimeStamp, startCounter, dm);
    }

    public static boolean checkForSupportedThreadDump(String logLine) {
        return logLine.matches("\\[.*\\] \\[.*\\] Full thread dump.*");
    }

    @Override
    protected String getNextLine() throws IOException {
        // remove the timestamp: [2020-04-03 13:42:03] [info] 
        return getBis().readLine().replaceFirst("\\[.*\\] \\[.*\\] ", "");
    }
}
