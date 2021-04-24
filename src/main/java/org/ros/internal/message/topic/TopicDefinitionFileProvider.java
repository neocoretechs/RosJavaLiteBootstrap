package org.ros.internal.message.topic;

import org.ros.internal.message.definition.MessageDefinitionFileProvider;

import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.ros.internal.message.StringFileProvider;

import java.io.File;
import java.io.FileFilter;

/**
 * @author Jonathan Groff Copyright (C) NeoCoreTechs 2015,2021
 */
public class TopicDefinitionFileProvider extends MessageDefinitionFileProvider {

  private static final String PARENT = "msg";
  private static final String SUFFIX = "msg";

  @SuppressWarnings("deprecation")
private static StringFileProvider newStringFileProvider() {
    IOFileFilter extensionFilter = FileFilterUtils.suffixFileFilter(SUFFIX);
    IOFileFilter parentBaseNameFilter = FileFilterUtils.asFileFilter(new FileFilter() {
      @Override
      public boolean accept(File file) {
        return getParentBaseName(file.getAbsolutePath()).equals(PARENT);
      }
    });
    IOFileFilter fileFilter = FileFilterUtils.andFileFilter(extensionFilter, parentBaseNameFilter);
    return new StringFileProvider(fileFilter);
  }

  public TopicDefinitionFileProvider() {
    super(newStringFileProvider());
  }
}
