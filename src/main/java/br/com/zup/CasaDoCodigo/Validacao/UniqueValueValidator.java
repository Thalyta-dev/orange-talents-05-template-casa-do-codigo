package br.com.zup.CasaDoCodigo.Validacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueValueValidator implements ConstraintValidator<ValorUnico,Object> {

    private String domainAttibute;
    private Class<?> aClass;

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void initialize(ValorUnico constraintAnnotation) {
        this.domainAttibute = constraintAnnotation.fieldName();
        this.aClass = constraintAnnotation.domainClass();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        Query query = manager.createQuery("select 1 from  " + aClass.getName() + " where " + domainAttibute + " =:value");
        query.setParameter("value", o);
        List<?> list  = query.getResultList();
        Assert.isTrue(list.size() <=1, "aconteceu algo bizarro e você tem mais de um "+aClass+" com o atributo "+domainAttibute+" com o valor = "+o);
        return  list.isEmpty();
    }
}
