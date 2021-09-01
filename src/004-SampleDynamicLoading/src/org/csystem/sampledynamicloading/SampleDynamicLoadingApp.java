package org.csystem.sampledynamicloading;

import org.csystem.util.Console;
import java.lang.annotation.Annotation;

public class SampleDynamicLoadingApp {
    private static boolean isDeprecated(Class<?> cls)
    {
        var deprecated = cls.getAnnotation(Deprecated.class);

        return deprecated != null;
    }

    private static boolean isAnnotated(Class<?> cls, Class<Annotation> clsA) throws ClassNotFoundException
    {
        var deprecated = cls.getAnnotation(clsA);

        return deprecated != null;
    }

    public static void run()
    {
        for (;;) {
            try {
                var className = Console.read("Sınıf ismini giriniz:");
                if (className.equals("quit"))
                    break;

                var annotationName = Console.read("Annonatation ismini giriniz:");

                var cls = Class.forName(className);
                var clsA = Class.forName(annotationName);

                if (isDeprecated(cls)) {
                    System.out.println("Deprecated");
                }
                else {
                    System.out.println("Deprecated değil");
                }

                Class<Annotation> clsAnnotation = (Class<Annotation>)clsA;

                if (isAnnotated(cls, clsAnnotation)) {
                    System.out.printf("Annoted by %s%n", clsAnnotation.getName());
                    var annotation = cls.getAnnotation(clsAnnotation);

                    for (var m : annotation.annotationType().getDeclaredMethods())
                        System.out.printf("%s=%s%n", m.getName(), m.invoke(annotation));
                }
                else {
                    System.out.println("CSD Deprecated değil");
                }
            }
            catch (Throwable ex) {
                System.out.printf("Exception Message:%s%n", ex.getMessage());
            }
        }

        Console.writeLine("Tekrar yapıyor musunuz?");

    }
}
