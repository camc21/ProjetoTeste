package br.com.carlos.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO implements Serializable {

	private static final long serialVersionUID = -8688877898912248790L;

	private Long idLogin;

	private String username;

	private String password;
	
	private List<String> permissions;
	
	public LoginDTO(Long idLogin, String userName, String password, String description) {
		this.idLogin = idLogin;
		this.username = userName;
		this.password = password;
		List<String> permissions = new ArrayList<>();
		permissions.add(description);
		this.permissions = permissions;
	}
}
