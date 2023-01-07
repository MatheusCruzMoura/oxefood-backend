package br.com.ifpe.oxefood.servicos.acesso;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationRequest implements Serializable {

	private static final long serialVersionUID = 674782052306617122L;

	private String username;

	private String password;

}
