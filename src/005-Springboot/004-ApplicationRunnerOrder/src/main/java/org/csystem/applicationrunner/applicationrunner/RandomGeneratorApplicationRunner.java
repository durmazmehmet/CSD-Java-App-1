package org.csystem.applicationrunner.applicationrunner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.stream.IntStream;

@Component
@Order(1)
public class RandomGeneratorApplicationRunner implements ApplicationRunner {
    private final Random m_random;

    public RandomGeneratorApplicationRunner(Random random)
    {
        m_random = random;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception
    {
        IntStream.generate(() -> m_random.nextInt(100)).limit(10).forEach(System.out::println);
    }
}
