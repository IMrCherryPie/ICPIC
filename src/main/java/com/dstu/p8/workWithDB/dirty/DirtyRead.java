package com.dstu.p8.workWithDB.dirty;

import com.dstu.p8.workWithDB.CustomConnection;

import java.sql.SQLException;
import java.sql.Connection;

public class DirtyRead {
    /**
     * @param args
     * @throws SQLException
     * @throws InterruptedException
     */
    public static void main(String[] args) {

        CustomConnection customConnection = new CustomConnection();

        Connection connPymt = customConnection.getConnection();
        Connection connReader = customConnection.getConnection();
        try {
            connPymt.setAutoCommit(false);
//            Запрет на «грязное чтение» (dirty read). Данный уровень блокирует транзакциям чтение строк с неподтвержденными изменениями в них.
            connPymt.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);

            connReader.setAutoCommit(false);
            // Разрешение на «dirty read». Данный уровень позволяет изменять строку с помощью одной транзакции и прочесть
            // ее другой прежде, чем изменения в этой строке будут подтверждены (dirty read). Если изменения будут отменены
            // с помощью rollback(), вторая транзакция вернет неправильную строку.
            connReader.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
//            connReader.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        Thread pymtThread = new Thread(new PaymentRunImpl(connPymt));
        Thread readerThread = new Thread(new ReaderRunImpl(connReader));

        pymtThread.start();
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        readerThread.start();

    }
}
