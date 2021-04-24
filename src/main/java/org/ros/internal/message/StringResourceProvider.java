package org.ros.internal.message;

import org.ros.exception.RosRuntimeException;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Jonathan Groff Copyright (C) NeoCoreTechs 2015,2021
 */
public class StringResourceProvider {

  private final Map<String, String> cache;

  public StringResourceProvider() {
    cache = new ConcurrentHashMap<String, String>();
  }

  public String get(String resourceName) {
    if (!has(resourceName)) {
      throw new NoSuchElementException("Resource does not exist: " + resourceName);
    }
    if (!cache.containsKey(resourceName)) {
      InputStream in = getClass().getResourceAsStream(resourceName);
      StringBuilder out = new StringBuilder();
      Charset charset = Charset.forName("US-ASCII");
      byte[] buffer = new byte[8192];
      try {
        for (int bytesRead; (bytesRead = in.read(buffer)) != -1;) {
          out.append(new String(buffer, 0, bytesRead, charset));
        }
      } catch (IOException e) {
        throw new RosRuntimeException("Failed to read resource: " + resourceName, e);
      }
      cache.put(resourceName, out.toString());
    }
    return cache.get(resourceName);
  }

  public boolean has(String resourceName) {
    return cache.containsKey(resourceName) || getClass().getResource(resourceName) != null;
  }

  public Map<String, String> getCachedStrings() {
    return cache;
  }

  public void addStringToCache(String resourceName, String resourceContent) {
    cache.put(resourceName, resourceContent);
  }
}
