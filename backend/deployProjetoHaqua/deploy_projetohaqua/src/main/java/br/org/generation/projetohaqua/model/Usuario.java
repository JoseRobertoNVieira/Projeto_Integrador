package br.org.generation.projetohaqua.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="tb_usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message="Adicione um nome")
	@Size(min=1,max=250)
	private String nome;
	
	@ApiModelProperty(example = "email@email.com.br")
	@NotNull(message="entre com um usuario")
	@Size(min=1,max = 250)
	private String usuario;
	
	@NotNull(message="Senha não pode ser em branco")
	@Size(min=6,max=200)
	private String senha;

	
	@OneToMany(mappedBy="usuarios", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("usuarios")
	private List<Postagem> postagem;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public List<Postagem> getPostagem() {
		return postagem;
	}


	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}
	
}

