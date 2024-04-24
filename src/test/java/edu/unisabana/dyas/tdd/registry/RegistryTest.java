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
        Assert.assertNotEquals(RegisterResult.UNDERAGE, result);
        Assert.assertNotEquals(RegisterResult.INVALID_AGE, result);
        Assert.assertNotEquals(RegisterResult.DEAD, result);
        Assert.assertNotEquals(RegisterResult.DUPLICATED, result);
    }

    @Test
    public void validateRegistryInvalid(){
        Person person = new Person("Felipito", 4512, 14,Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.UNDERAGE, result);
        Assert.assertNotEquals(RegisterResult.VALID, result);
        Assert.assertNotEquals(RegisterResult.INVALID_AGE, result);
        Assert.assertNotEquals(RegisterResult.DEAD, result);
        Assert.assertNotEquals(RegisterResult.DUPLICATED, result);
    }
    
    @Test
    public void validateRegistryInvalidAge() {
        Person person = new Person("Juliana", 7849, -2,Gender.FEMALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
        Assert.assertNotEquals(RegisterResult.VALID, result);
        Assert.assertNotEquals(RegisterResult.UNDERAGE, result);
        Assert.assertNotEquals(RegisterResult.DEAD, result);
        Assert.assertNotEquals(RegisterResult.DUPLICATED, result);
    }
    @Test
    public void validateRegistryInvalidAlive(){
        Person person = new Person("Alex", 123456789, 19,Gender.UNIDENTIFIED, false);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.DEAD, result);
        Assert.assertNotEquals(RegisterResult.VALID, result);
        Assert.assertNotEquals(RegisterResult.UNDERAGE, result);
        Assert.assertNotEquals(RegisterResult.INVALID_AGE, result);
        Assert.assertNotEquals(RegisterResult.DUPLICATED, result);
    }
    @Test
    public void validateRegistryInvalidDuplicated(){
        Person person = new Person("Santiago", 123456789, 25,Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);
        result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.DUPLICATED, result);
        Assert.assertNotEquals(RegisterResult.VALID, result);
        Assert.assertNotEquals(RegisterResult.UNDERAGE, result);
        Assert.assertNotEquals(RegisterResult.INVALID_AGE, result);
        Assert.assertNotEquals(RegisterResult.DEAD, result);
    }

}