package org.ros.exception;

/**
 * @author Jonathan Groff Copyright (C) NeoCoreTechs 2015,2021
 */
public class RosException extends Exception {
	private static final long serialVersionUID = 1445757554983743308L;

	public RosException(final Throwable throwable) {
		super(throwable);
	}
  
	public RosException(final String message, final Throwable throwable) {
		super(message, throwable);
	}
  
	public RosException(final String message) {
		super(message);
	}
}
