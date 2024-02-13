package example;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args)
            throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException,
            InvocationTargetException, InstantiationException {

        SecretAgent secretAgent = new SecretAgent("James Bond", 007);

        // 1st way to access the class
        Class<?> clazz = Class.forName("example.SecretAgent");
        // 2nd way to access the class
        Class<?> clazz2 = SecretAgent.class;

        /*
        /////////////////////////////////////////////////////////////
        1. Accessing private fields
        ////////////////////////////////////////////////////////////
        */

        Field secretNameField = clazz.getDeclaredField("secretName");
        Field secretNumberField = clazz.getDeclaredField("secretNumber");

        secretNameField.setAccessible(true);
        secretNumberField.setAccessible(true);

        secretNameField.set(secretAgent, "Somapala");
        secretNumberField.setInt(secretAgent, 100);

        System.out.println(secretAgent.getSecretName());
        System.out.println(secretAgent.getSecretNumber());

        /*
        /////////////////////////////////////////////////////////////
        2. Invoking private methods
        ////////////////////////////////////////////////////////////
        */

        Method secretMethod = clazz.getDeclaredMethod("emitSecretMessage");
        secretMethod.setAccessible(true);
        secretMethod.invoke(secretAgent);

        /*
        /////////////////////////////////////////////////////////////
        3. Invoking constructors
        ////////////////////////////////////////////////////////////
        */

        Constructor<?> secretConstructor = clazz.getConstructor(String.class, int.class);
        secretConstructor.setAccessible(true);
        SecretAgent reflectedSecretAgent = (SecretAgent) secretConstructor.newInstance("MirrorAgent", 69);
        System.out.println(reflectedSecretAgent.getSecretName());;
        System.out.println(reflectedSecretAgent.getSecretNumber());;
    }
}