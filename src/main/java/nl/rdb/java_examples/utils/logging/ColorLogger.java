package nl.rdb.java_examples.utils.logging;

import static nl.rdb.java_examples.utils.logging.TextColor.GREEN;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ColorLogger {

    private static final String START = "\u001B[";
    private static final String END = "\u001B[0m";

    private static Logger log;

    private ColorLogger(Class<?> clazz) {
        log = LoggerFactory.getLogger(clazz);
    }

    public static ColorLogger getLogger(Class<?> clazz) {
        return new ColorLogger(clazz);
    }

    public void info(String logging, Object... args) {
        log.info("{}{}m{}{}", START, GREEN.getValue(), logging, END);
    }
}

@Getter
@RequiredArgsConstructor
enum TextColor {
    DEFAULT(0),
    BLACK(30),
    RED(31),
    GREEN(32),
    YELLOW(33),
    BLUE(34),
    MAGENTA(35),
    CYAN(36),
    WHITE(37);

    private final int value;
}

@Getter
@RequiredArgsConstructor
enum TextStyle {
    BOLD(1),
    ITALIC(3),
    UNDERLINE(4);

    private final int value;
}

@Getter
@RequiredArgsConstructor
enum BackgroundColor {
    DEFAULT(0),
    BLACK(40),
    RED(41),
    GREEN(42),
    YELLOW(43),
    BLUE(44),
    MAGENTA(45),
    CYAN(46),
    WHITE(47);

    private final int value;
}