package com.waylau.dynamicProxy.cglib;

public class Test {

    public static void main(String[] args) {
        Object target = new PersonServiceImpl();
        MyTransaction myTransaction = new MyTransaction();
        PersonServiceInterceptor interceptor = new PersonServiceInterceptor(target, myTransaction);
        PersonServiceImpl personService = (PersonServiceImpl) interceptor.createProxy();
        String returnValue = personService.savePerson();
        System.out.println(returnValue);
    }
}
