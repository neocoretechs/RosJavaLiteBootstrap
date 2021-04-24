package org.ros.internal.message.field;

import java.io.ByteArrayOutputStream;
/**
 * Implementation of ByteArrayOutputStream that does NOT copy the backing store
 * @author Jonathan Groff Copyright (C) NeoCoreTechs 2015,2021
 *
 */
public final class DirectByteArrayOutputStream  extends ByteArrayOutputStream {
		  public DirectByteArrayOutputStream() {
		  }

		  public DirectByteArrayOutputStream(int size) {
		    super(size);
		  }

		  public int getCount() {
		    return count;
		  }

		  public byte[] getBuf() {
		    return buf;
		  }
}
