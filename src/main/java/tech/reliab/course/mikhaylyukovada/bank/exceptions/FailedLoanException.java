package tech.reliab.course.mikhaylyukovada.bank.exceptions;

/**
 * Исключение для случая, когда не удалось выдать кредит
 */
public class FailedLoanException extends Exception{
    public FailedLoanException(String string) {
        super(string);
    }

    public FailedLoanException() {
        super();
    }
}
