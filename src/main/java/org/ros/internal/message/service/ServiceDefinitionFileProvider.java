package org.ros.internal.message.service;

import org.ros.internal.message.definition.MessageDefinitionFileProvider;

import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.ros.internal.message.StringFileProvider;

import java.io.File;
import java.io.FileFilter;

/**
 * @author Jonathan Groff Copyright (C) NeoCoreTechs 2015,2021
 */
public class ServiceDefinitionFileProvider extends MessageDefinitionFileProvider {

  private static final String PARENT = "srv";
  private static final String SUFFIX = "srv";

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

  public ServiceDefinitionFileProvider() {
    super(newStringFileProvider());
  }
}
