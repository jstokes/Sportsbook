package com.sportsbook.test;

import com.sportsbook.parser.IParser;
import com.sportsbook.parser.scala.*;

public class Main {
    public static void main(String [] args) {
        IParser myParser = new ScoreParser();
        System.out.println(myParser.readSource());
    }
}
