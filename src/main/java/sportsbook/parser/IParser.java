package com.sportsbook.parser;

import com.sportsbook.parser.java.Game;

public interface IParser {
    String source =  null;
    Game[] parse();
    String readSource(); //for testing
}