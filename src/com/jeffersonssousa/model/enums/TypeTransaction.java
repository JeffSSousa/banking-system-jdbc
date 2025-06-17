package com.jeffersonssousa.model.enums;

public enum TypeTransaction {
	
	SACAR(1),
	DEPOSITAR(2),
	TRANSFERIR(3);

	 private int id;

	    private TypeTransaction(int id) {
	        this.id = id;
	    }

	    public int getId() {
	        return id;
	    }

	    public static TypeTransaction valueOf(int id) {
	        for (TypeTransaction type : TypeTransaction.values()) {
	            if (type.getId() == id) {
	                return type;
	            }
	        }
	        throw new IllegalArgumentException("Id de TypeTransaction inválido: " + id);
	    }
}
