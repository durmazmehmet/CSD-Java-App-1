package org.csystem.simpleframework;

import java.util.Scanner;

public class MyFramework {
    //...
    private boolean findInterface(Class<?> [] interfaces, Class<?> cls)
    {
        for (var clsInterface : interfaces)
            if (clsInterface == cls)
                return true;

        return false;
    }

    public void run()
    {
        for (;;) {
            try {
                Scanner kb = new Scanner(System.in);

                System.out.println("Sınıf ismini giriniz");
                String name = kb.nextLine();

                if (name.equals("quit"))
                    break;

                Class<?> cls = Class.forName(name);

                if (!findInterface(cls.getInterfaces(), IOperation.class)) {
                    System.out.println("Interface bulunamadı");
                    continue;
                }

                var ci = cls.getDeclaredConstructor();

                ci.setAccessible(true);
                IOperation io = (IOperation)ci.newInstance();

                ci.setAccessible(false);

                System.out.println("Birinci sayıyı giriniz");
                int a = Integer.parseInt(kb.nextLine());

                System.out.println("İkinci sayıyı giriniz");
                int b = Integer.parseInt(kb.nextLine());

                System.out.println(io.doOperation(a ,b));
            } catch (NoSuchMethodException ex) {
                System.out.println("int ve String parametreli ctor elemanı olan sınıf girmelisiniz");
            } catch (ClassNotFoundException ex) {
                System.out.println("Sınıf bulunamadı");
            }
            catch (Throwable ex) {
                System.out.println(ex.getMessage());
            }
        }

    }
}
