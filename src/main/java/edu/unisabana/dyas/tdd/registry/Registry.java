package edu.unisabana.dyas.tdd.registry;

import java.util.ArrayList;
import java.util.List;

public class Registry {
    List<Person> VotantesValidos;
    public Registry(){
        this.VotantesValidos = new ArrayList<>();
    }
    public RegisterResult registerVoter(Person p) {
        if(!p.isAlive()){
            return RegisterResult.DEAD;
        }
        if(p.getAge() < 1 || p.getAge() > 121){
            return RegisterResult.INVALID_AGE;
        }
        if(p.getAge() < 18 && p.getAge() > 0){
            return RegisterResult.UNDERAGE;
        }
        for(Person pe:VotantesValidos){
            if(pe.getId() == p.getId()){
                return RegisterResult.DUPLICATED;
            }
        }
        VotantesValidos.add(p);
        return RegisterResult.VALID;
    }
}