package edu.unisabana.dyas.tdd.registry;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {
    private Registry registry = new Registry();
    @Test
    public void validateRegistryResult() {
        Person person = new Person("Santiago", 123456789, 25,Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);
    }
    @Test
    public void validateRegistryInvalid(){
        Person person = new Person("Felipito", 4512, 14,Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.UNDERAGE, result);
    }
    @Test
    public void validateRegistryInvalidAge() {
        Person person = new Person("Juliana", 7849, -2,Gender.FEMALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
    }
    @Test
    public void validateRegistryInvalidAlive(){
        Person person = new Person("Alex", 123456789, 14,Gender.UNIDENTIFIED, false);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.DEAD, result);
    }
    @Test
    public void validateRegistryInvalidDuplicated(){
        Person person = new Person("Santiago", 123456789, 25,Gender.MALE, true);
        Person person2 = new Person("Santiago", 123456789, 25,Gender.MALE, true);
        registry.registerVoter(person);
        RegisterResult resultado = registry.registerVoter(person2);
        Assert.assertEquals(RegisterResult.DUPLICATED, resultado);
    }

    // TODO Complete with more test cases
}