package org.csystem.util.function;

import java.util.Optional;

public class FunctionalUtil {
    private FunctionalUtil() {}

    public static int copyIfInt(int [] src, int [] dest, IIntPredicate pred)
    {
        int index = 0;

        for (int val : src)
            if (pred.test(val))
                dest[index++] = val;

        return index;
    }

    public static <T> int copyIf(T [] src, T [] dest, IPredicate<T> pred)
    {
        int index = 0;

        for (T t : src)
            if (pred.test(t))
                dest[index++] = t;

        return index;

    }

    public static void forEach(int [] a, IIntConsumer con)
    {
        forEach(a, a.length, con);
    }

    public static void forEach(int [] a, int count, IIntConsumer con)
    {
        for (int i = 0; i < count; ++i)
            con.accept(a[i]);
    }


    public static void forEach(double [] a, IDoubleConsumer con)
    {
        forEach(a, a.length, con);
    }

    public static void forEach(double [] a, int count, IDoubleConsumer con)
    {
        for (int i = 0; i < count; ++i)
            con.accept(a[i]);
    }
    public static <T> void forEach(T [] a, IConsumer<T> con)
    {
        forEach(a, a.length, con);
    }

    public static <T> void forEach(T [] a, int count, IConsumer<T> con)
    {
        for (int i = 0; i < count; ++i)
            con.accept(a[i]);
    }

    public static <S, T> void map(S [] src, T [] dest, IFunction<S, T> fun)
    {
        for (int i = 0; i < src.length; ++i)
            dest[i] = fun.apply(src[i]);
    }

    public static <S> void mapToDouble(S [] src, double [] dest, IDoubleFunction<S> fun)
    {
        for (int i = 0; i < src.length; ++i)
            dest[i] = fun.apply(src[i]);
    }

    public static <T> void transform(T [] src, T [] dest, IUnaryOperator<T> con)
    {
        for (int i = 0; i < src.length; ++i)
            dest[i] = con.apply(src[i]);

    }

    public static void transform(int [] src, int [] dest, IIntUnaryOperator con)
    {
        for (int i = 0; i < src.length; ++i)
            dest[i] = con.apply(src[i]);
    }

    public static int reduce(int [] a, int initial, IIntBinaryOperator op)
    {
        int result = initial;

        for (int val : a)
            result = op.apply(result, val);

        return result;
    }

    public static Optional<Integer> reduce(int [] a, IIntBinaryOperator op)
    {
        if (a.length == 0)
            return Optional.empty();

        return Optional.of(reduce(a, 0, op));
    }

    public static <T> int transformIf(T [] src, T [] dest, IPredicate<T> pred, IUnaryOperator<T> con)
    {
        int index = 0;

        for (T elem : src)
            if (pred.test(elem))
                dest[index++] = con.apply(elem);

        return index;
    }

    public static int transformIf(int [] src, int [] dest, IIntPredicate pred, IIntUnaryOperator con)
    {
        int index = 0;

        for (int elem : src)
            if (pred.test(elem))
                dest[index++] = con.apply(elem);

        return index;
    }


}
