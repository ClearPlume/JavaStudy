package top.fallenangel._22lambdareflect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.function.Function;

@SuppressWarnings("ResultOfMethodCallIgnored")
@CustomAnnotation(name = "Lambda的注解", dead = true)
public class LambdaReflectTest {
    public static void main(String[] args) {
        System.out.println(calc(arg -> arg.getA() + arg.getB(), new Arguments(10, 20)));
        System.out.println(calc(arg -> arg.getA() * arg.getB(), new Arguments(45, 2)));
        LambdaReflectTest.class.isAnnotationPresent(CustomAnnotation.class);
        CustomAnnotation annotation = LambdaReflectTest.class.getAnnotation(CustomAnnotation.class);
        System.out.println(annotation.name() + " : " + annotation.dead());

        for (Method method : CustomAnnotation.class.getDeclaredMethods()) {
            System.out.println(method.getName() + " : " + method.getDefaultValue());
        }
    }

    private static Integer calc(Function<Arguments, Integer> function, Arguments args) {
        return function.apply(args);
    }
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface CustomAnnotation {
    String name();

    boolean dead() default false;
}