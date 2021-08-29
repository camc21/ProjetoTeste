package br.com.carlos.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.carlos.dto.LoginDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "login")
public class Login implements UserDetails, Serializable {

	private static final long serialVersionUID = -213864562139748411L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_login")
	private Long idLogin;

	@Column(name = "user_name", unique = true)
	private String userName;

	@Column(name = "full_name")
	private String fullName;

	@Column(name = "password")
	private String password;

	@Column(name = "account_non_expired")
	private Boolean accountNonExpired;

	@Column(name = "account_non_locked")
	private Boolean accountNonLocked;

	@Column(name = "credentials_non_expired")
	private Boolean credentialsNonExpired;

	@Column(name = "enabled")
	private Boolean enabled;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "login_permission", joinColumns = { @JoinColumn(name = "id_login") }, inverseJoinColumns = {
			@JoinColumn(name = "id_permission") })
	private List<Permission> permissions;
	
	public List<String> getRoles(){
		List<String> roles = new ArrayList<String>();
		for (Permission p : this.permissions) {
			roles.add(p.getDescription());
		}
		return roles;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.permissions;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}
	
	public Login(Long idLogin, String userName, String password, String description) {
		this.idLogin = idLogin;
		this.userName = userName;
		this.password = password;
		List<Permission> permissions = new ArrayList<>();
		permissions.add(new Permission(description));
		this.permissions = permissions;
	}
	
	public Login(LoginDTO loginDto) {
		this.idLogin = loginDto.getIdLogin();
		this.userName = loginDto.getUsername();
		this.password = loginDto.getPassword();
		List<Permission> permissions = new ArrayList<>();
		for (String permissionDto : loginDto.getPermissions()) {
			permissions.add(new Permission(permissionDto));
		}
		this.permissions = permissions;
	}

}
