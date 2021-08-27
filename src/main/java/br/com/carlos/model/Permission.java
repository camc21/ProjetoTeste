package br.com.carlos.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "permission")
public class Permission implements GrantedAuthority, Serializable {

	private static final long serialVersionUID = -6129350156452087702L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_permission")
	private Long idPermission;
	
	@Column(name = "description")
	private String description;

	@Override
	public String getAuthority() {
		return this.description;
	}
	
	public Permission(String description) {
		this.description = description;
	}

}
