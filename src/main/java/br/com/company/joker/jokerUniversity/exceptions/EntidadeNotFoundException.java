package br.com.company.joker.jokerUniversity.exceptions;

public class EntidadeNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public EntidadeNotFoundException(String EntityName,
                                     String msg, Integer id) {
        super(msg + EntityName + " by id : " + id);
    }

    public EntidadeNotFoundException(String msg) {
        super(msg);
    }
}