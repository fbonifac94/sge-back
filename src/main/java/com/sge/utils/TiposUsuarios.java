package com.sge.utils;

public enum TiposUsuarios {
	ALUMNO("ALUMNO", "ROLE_ALUMNO"), PROFESOR("PROFESOR", "ROLE_PROFESOR"),
	ADMINISTRATIVO("ADMINISTRATIVO", "ROLE_ADMINISTRATIVO");

	private String tipo;

	private String rol;

	private TiposUsuarios(String tipo, String rol) {
		this.tipo = tipo;
		this.rol = rol;
	}

	public String getTipo() {
		return tipo;
	}

	public String getRol() {
		return rol;
	}

}
