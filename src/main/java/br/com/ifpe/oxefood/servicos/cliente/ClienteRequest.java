package br.com.ifpe.oxefood.servicos.cliente;

import java.util.Arrays;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.ifpe.oxefood.modelo.acesso.Usuario;
import br.com.ifpe.oxefood.modelo.cliente.Cliente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteRequest {

	@NotNull(message = "O Chave Empresa é de preenchimento obrigatório")
	@NotBlank(message = "O Chave Empresa é de preenchimento obrigatório")
	private String chaveEmpresa;

	@NotNull(message = "O Nome é de preenchimento obrigatório")
	@NotBlank(message = "O Nome é de preenchimento obrigatório")
	@Length(max = 100, message = "O Nome deverá ter no máximo {max} caracteres")
	private String nome;
	
	@NotNull(message = "O Sobrenome é de preenchimento obrigatório")
	@NotBlank(message = "O Sobrenome é de preenchimento obrigatório")
	@Length(max = 100, message = "O Sobrenome deverá ter no máximo {max} caracteres")
	private String sobrenome;

	@NotBlank(message = "O e-mail é de preenchimento obrigatório")
	@Email
	private String email;

	@NotBlank(message = "A senha é de preenchimento obrigatório")
	private String password;

	@Length(min = 8, max = 20, message = "O campo Fone tem que ter entre {min} e {max} caracteres")
	private String fone;

	public Cliente buildCliente() {

		return Cliente.builder()
			.chaveEmpresa(chaveEmpresa)
			.usuario(buildUsuario())
			.nome(nome)
			.sobrenome(sobrenome)
			.fone(fone)
			.build();
	    }

	    public Usuario buildUsuario() {

		return Usuario.builder()
			.username(email)
			.password(password)
			.roles(Arrays.asList(Usuario.ROLE_CLIENTE))
			.build();
	    }


}
