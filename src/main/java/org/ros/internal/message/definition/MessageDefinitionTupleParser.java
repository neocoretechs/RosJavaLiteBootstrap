package org.ros.internal.message.definition;

import java.util.ArrayList;
import java.util.List;

/**
 * Splits message definitions tuples (e.g. service definitions) into separate
 * message definitions. Multiple messages delimited by separator per file.
 * 
 * @author Jonathan Groff Copyright (C) NeoCoreTechs 2015,2021
 */
public class MessageDefinitionTupleParser {

  private static final String SEPARATOR = "---";

  /**
   * Splits the message definition tuple into a {@link List} of message
   * definitions. Split message definitions may be empty (e.g. std_srvs/Empty).
   * 
   * @param definition the message definition tuple
   * @param size the expected tuple size, or -1 to ignore this requirement
   * @return a {@link List} of the specified size
   */
  public static List<String> parse(String definition, int size) {
    assert(definition != null);
    List<String> definitions = new ArrayList<String>();
    StringBuilder current = new StringBuilder();
    for (String line : definition.split("\n")) {
      if (line.startsWith(SEPARATOR)) {
        definitions.add(current.toString());
        current = new StringBuilder();
        continue;
      }
      current.append(line);
      current.append("\n");
    }
    if (current.length() > 0) {
      current.deleteCharAt(current.length() - 1);
    }
    definitions.add(current.toString());
    assert(size == -1 || definitions.size() <= size) : String.format("Message tuple exceeds expected size: %d > %d", definitions.size(), size);
    while (definitions.size() < size) {
      definitions.add("");
    }
    return definitions;
  }
}
