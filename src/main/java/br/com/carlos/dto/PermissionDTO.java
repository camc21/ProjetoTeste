package br.com.carlos.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PermissionDTO implements Serializable {
	
	private static final long serialVersionUID = 6094485061835261827L;

	private Long idPermission;
	
	private String description;
	
	public PermissionDTO(String description) {
		this.description = description;
	}
}
