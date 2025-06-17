package com.jeffersonssousa.model.enums;

public enum TypeAccount {
	

	POUPANCA(1),
	CORRENTE(2);

	private int id;

    private TypeAccount(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static TypeAccount valueOf(int id) {
        for (TypeAccount type : TypeAccount.values()) {
            if (type.getId() == id) {
                return type;
            }
        }
        throw new IllegalArgumentException("Id de TypeTransaction inválido: " + id);
    }
}
