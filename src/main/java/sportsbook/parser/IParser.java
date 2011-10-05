package sportsbook.parser;

import sportsbook.types.Game;

public interface IParser {
    Game[] parse(scala.xml.Node xml);
}