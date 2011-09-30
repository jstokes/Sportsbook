package com.scorebook.parser.java.interfaces;

import com.scorebook.parser.java.Game;

public interface IParser {
    String source =  null;
    Game[] parse();
}