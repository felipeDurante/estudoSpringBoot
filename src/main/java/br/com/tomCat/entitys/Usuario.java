package br.com.tomCat.entitys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "OUTRA_TABELA")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "senha", nullable = false, length = 100)
	private String senha;

//	@Enumerated(EnumType.STRING)
//	@Column(name = "perfil", nullable = false)
//	private PerfilEnum perfil;

}
