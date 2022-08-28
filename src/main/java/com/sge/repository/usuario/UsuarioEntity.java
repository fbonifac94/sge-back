package com.sge.repository.usuario;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.sge.repository.persona.PersonaEntity;
import com.sge.repository.rol.RolEntity;
import com.sge.utils.YNConverter;

import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuarios")
@NoArgsConstructor
@Setter
public class UsuarioEntity implements UserDetails {

	private static final long serialVersionUID = -7043354987302363300L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "usuario_id")
	private Long usuarioId;

	@OneToOne
	@JoinColumn(name = "persId")
	private PersonaEntity persona;

	@Column(name = "usuario_mail")
	private String mail;

	@Column(name = "usuario_username")
	private String username;

	@Column(name = "usuario_password")
	private String password;

	@Convert(converter = YNConverter.class)
	@Column(name = "usuario_enabled")
	private Boolean enabled;

	@ManyToOne
	@JoinColumn(name = "rolId")
	private RolEntity rol;

	public Long getUsuarioId() {
		return usuarioId;
	}

	public PersonaEntity getPersona() {
		return persona;
	}

	public String getMail() {
		return mail;
	}

	public UsuarioEntity(PersonaEntity persona, String mail, String username, String password, Boolean enabled,
			RolEntity rol) {
		this.persona = persona;
		this.mail = mail;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.rol = rol;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Stream.of(new SimpleGrantedAuthority(rol.getRolNombre())).collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	public RolEntity getRol() {
		return rol;
	}
}
