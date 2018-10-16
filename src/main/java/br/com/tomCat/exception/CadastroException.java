package br.com.tomCat.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CadastroException extends RuntimeException {

	private static final long serialVersionUID = 7029190359584510452L;

	public CadastroException() {
	}

	public CadastroException(String message) {
		super(message);
	}

	public CadastroException(String message, Throwable cause) {
		super(message, cause);
	}

}
