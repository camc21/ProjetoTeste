package br.com.carlos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidJwtAuthenticationException extends AuthenticationException {
	
	private static final long serialVersionUID = -2929602966106254934L;

	public InvalidJwtAuthenticationException(String exception) {
		super(exception);
	}

	
}
