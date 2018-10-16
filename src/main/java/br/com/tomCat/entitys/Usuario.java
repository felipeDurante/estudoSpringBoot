package br.com.tomCat.entitys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.tomCat.security.enums.PerfilEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "USUARIO")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Usuario implements Serializable {

	private static final long serialVersionUID = -5417355136835981539L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "senha", nullable = false, length = 100)
	private String senha;

	@Enumerated(EnumType.STRING)
	@Column(name = "perfil", nullable = false)
	private PerfilEnum perfil;

}
