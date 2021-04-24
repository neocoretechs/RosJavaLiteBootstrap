package org.ros.internal.message.definition;

import org.ros.internal.message.StringFileProvider;
import org.apache.commons.io.FilenameUtils;
import org.ros.message.MessageDefinitionProvider;
import org.ros.message.MessageIdentifier;

import java.io.File;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Jonathan Groff Copyright (C) NeoCoreTechs 2015,2021
 */
public class MessageDefinitionFileProvider implements MessageDefinitionProvider {

  private final StringFileProvider stringFileProvider;
  private final Map<String, Collection<MessageIdentifier>> messageIdentifiers;
  private final Map<String, String> definitions;

  public MessageDefinitionFileProvider(StringFileProvider stringFileProvider) {
    this.stringFileProvider = stringFileProvider;
    messageIdentifiers = new ConcurrentHashMap<String, Collection<MessageIdentifier>>();
    definitions = new ConcurrentHashMap<String, String>();
  }

  private static String getParent(String filename) {
    return FilenameUtils.getFullPathNoEndSeparator(filename);
  }

  protected static String getParentBaseName(String filename) {
    return FilenameUtils.getBaseName(getParent(filename));
  }

  private static MessageIdentifier fileToMessageIdentifier(File file) {
    String filename = file.getAbsolutePath();
    String name = FilenameUtils.getBaseName(filename);
    String pkg = getParentBaseName(getParent(filename));
    return MessageIdentifier.of(pkg, name);
  }

  private void addDefinition(File file, String definition) {
    MessageIdentifier topicType = fileToMessageIdentifier(file);
    if (definitions.containsKey(topicType.getType())) {
      // First definition wins.
      return;
    }
    definitions.put(topicType.getType(), definition);
    if (!messageIdentifiers.containsKey(topicType.getPackage())) {
      messageIdentifiers.put(topicType.getPackage(), new HashSet<MessageIdentifier>());
    }
    messageIdentifiers.get(topicType.getPackage()).add(topicType);
  }

  /**
   * Updates the topic definition cache.
   * 
   * @see StringFileProvider#update()
   */
  public void update() {
    stringFileProvider.update();
    for (Entry<File, String> entry : stringFileProvider.getStrings().entrySet()) {
      addDefinition(entry.getKey(), entry.getValue());
    }
  }

  /**
   * @see StringFileProvider#addDirectory(File)
   */
  public void addDirectory(File directory) {
    stringFileProvider.addDirectory(directory);
  }

  @Override
  public Collection<String> getPackages() {
    return messageIdentifiers.keySet();
  }

  @Override
  public Collection<MessageIdentifier> getMessageIdentifiersByPackage(String pkg) {
    return messageIdentifiers.get(pkg);
  }

  @Override
  public String get(String type) {
    return definitions.get(type);
  }

  @Override
  public boolean has(String type) {
    return definitions.containsKey(type);
  }
}