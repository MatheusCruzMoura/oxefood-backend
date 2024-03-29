package br.com.ifpe.oxefood.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class EntityAlreadyExistsException extends RuntimeException {

    private static final long serialVersionUID = -4067366924562414602L;

	private static final String MSG_ENTITY_ALREADY_EXIST = "Já existe um(a) %s cadastrado(a) com esse(a) %s.";

    public EntityAlreadyExistsException(String label, String field) {

	super(String.format(MSG_ENTITY_ALREADY_EXIST, label, field));
    }

}

