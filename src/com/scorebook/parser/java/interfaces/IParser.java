package com.scorebook.parser.java.interfaces;

import com.scorebook.parser.java.interfaces.IGame;

public interface IParser {
    String source =  null;
    IGame[] parse();
}