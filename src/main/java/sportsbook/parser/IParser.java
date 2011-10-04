package sportsbook.parser;

import sportsbook.types.Game;

public interface IParser {
    String source =  null;
    Game[] parse(String src);
}