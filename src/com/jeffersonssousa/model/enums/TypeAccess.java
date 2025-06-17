package com.jeffersonssousa.model.enums;

public enum TypeAccess {

	ADMINISTRADOR(1),
	CLIENTE(2);

	private int id;

    private TypeAccess(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static TypeAccess valueOf(int id) {
        for (TypeAccess type : TypeAccess.values()) {
            if (type.getId() == id) {
                return type;
            }
        }
        throw new IllegalArgumentException("Id de TypeTransaction inválido: " + id);
    }
}
