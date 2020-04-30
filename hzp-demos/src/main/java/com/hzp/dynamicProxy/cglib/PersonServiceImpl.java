package com.hzp.dynamicProxy.cglib;

public class PersonServiceImpl {

    public String savePerson() {
        System.out.println("添加");
        return "保存成功！";
    }

    public void updatePerson() {
        System.out.println("修改");
    }

    public void deletePerson() {
        System.out.println("删除");
    }

}
