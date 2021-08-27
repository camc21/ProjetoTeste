package br.com.carlos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -544391682404809250L;
	
	public ResourceNotFoundException(String exception) {
		super(exception);
	}

}
