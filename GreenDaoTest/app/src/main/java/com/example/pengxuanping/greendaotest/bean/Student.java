package com.example.pengxuanping.greendaotest.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Property;

@Entity(
        nameInDb = "TAB_STUDENT",// Table Name
        createInDb = true,             // if create a tablE
        generateConstructors = true,   // if generate constructors.
        generateGettersSetters = true  // If generate getters and setters' methods
)

public class Student {
    //@id auto increment
    @Id(autoincrement = true)
    private Long id;

    //@Property(name In Db = "STU_NANE" )
    @Property(nameInDb = "STU_NAME")
    private String name;
    @Property(nameInDb = "STU_AGE")
    private int age;
@Generated(hash = 352757281)
public Student(Long id, String name, int age) {
    this.id = id;
    this.name = name;
    this.age = age;
}
@Generated(hash = 1556870573)
public Student() {
}

public void setId(Long id) {
    this.id = id;
}
public String getName() {
    return this.name;
}
public void setName(String name) {
    this.name = name;
}
public int getAge() {
    return this.age;
}
public void setAge(int age) {
    this.age = age;
}
public Long getId() {
    return this.id;
}



}