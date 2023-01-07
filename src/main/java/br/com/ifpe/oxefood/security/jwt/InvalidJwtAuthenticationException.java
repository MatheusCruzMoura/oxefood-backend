package br.com.ifpe.oxefood.security.jwt;

import org.springframework.security.core.AuthenticationException;

public class InvalidJwtAuthenticationException extends AuthenticationException {

	private static final long serialVersionUID = -3485511580368651122L;

	public InvalidJwtAuthenticationException(String e) {
		super(e);
	}
}
