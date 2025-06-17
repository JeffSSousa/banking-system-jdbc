package com.jeffersonssousa.model.factory;

import com.jeffersonssousa.model.entities.Transaction;
import com.jeffersonssousa.model.entities.transactions.BankTransfer;
import com.jeffersonssousa.model.entities.transactions.exception.TransactionErrorException;
import com.jeffersonssousa.model.enums.TypeTransaction;

public class TransactionFactory {
	
	public static Transaction create(int typeTransactionId) {
        TypeTransaction type = TypeTransaction.valueOf(typeTransactionId);
        
        return switch (type) {
        case TRANSFERIR -> new BankTransfer();
        // futuramente:
        // case PIX -> new PixTransfer();
        // case DOC -> new DocTransfer();
        default -> throw new TransactionErrorException("Tipo de transação desconhecido: " + type);
    };
}

}
