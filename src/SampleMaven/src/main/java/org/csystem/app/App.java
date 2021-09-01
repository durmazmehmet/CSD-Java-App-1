/*----------------------------------------------------------------------------------------------------------------------
    Properties sınıfı ve properties dosyası kullanmı:

    #Connection information file

    connection.hostname=jdbc:postgresql://localhost
    connection.port=5432
    connection.dbname=devicesdb
    connection.username=postgres
    connection.password=csd1993
----------------------------------------------------------------------------------------------------------------------*/
package org.csystem.app;

class App {
    public static void main(String [] args)
    {
        for (String cmd : args)
            System.out.println(cmd);
    }
}
