package org.csystem;

import org.csystem.util.Console;

public class sampledynamicloadingapp {

    private static boolean isDepretaced(Class<?> cls)
    {
        //var cksDeprecated = Class.forName("java.lang.Deprecated");
        var deprecated = cls.getDeclaredAnnotation(Deprecated.class);
        return deprecated != null;
    }

    public static void run()
    {
        for(;;) {
            try {
                var className = Console.readLine("SInıf ismi gir:");

                if(className.equals("quit"))
                    break;

                var cls = Class.forName((className));
                if (isDepretaced(cls)) {
                    System.out.println("Deprecated");
                } else {
                    System.out.println("Not Deprecated");
                }

            } catch (Throwable ex) {
                System.out.printf("exception %s%n", ex.getMessage());
            }
        }
        Console.writeLine("tekrar yap bitch");

    }
}

