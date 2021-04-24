package org.ros.exception;

/**
 * RosJavaLite exceptions that may terminate the system.
 * @author Jonathan Groff Copyright (C) NeoCoreTechs 2015,2021
 */
public class RosRuntimeException extends RuntimeException {
	private static final long serialVersionUID = 2394258627672370517L;

	public RosRuntimeException(final Throwable throwable) {
		super(throwable);
	}

	public RosRuntimeException(final String message, final Throwable throwable) {
		super(message, throwable);
	}

	public RosRuntimeException(final String message) {
		super(message);
	}
}
