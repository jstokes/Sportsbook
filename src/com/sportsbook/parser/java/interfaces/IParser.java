package com.sportsbook.parser.java.interfaces;

import com.sportsbook.parser.Game;

public interface IParser {
    String source =  null;
    Game[] parse();
}