package com.didispace.service;

import com.didispace.domain.p.person.Person;
import com.didispace.domain.p.person.PersonRepository;
import com.didispace.domain.p.user.User;
import com.didispace.domain.p.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by liuhaiyang on 2017/3/3.
 */
@Service

public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private UserRepository userRepository;

    // public void testPerson() thorw Exeption {  这时不会回滚。
    @Transactional(rollbackFor = Exception.class)
    public void testPerson() {
        personRepository.save(new Person("liuhaiyang222222"));
        personRepository.save(new Person("guyingmin1222222"));
        throw new RuntimeException();
    }


    public void testupdateUserByName() throws Exception {
        userRepository.updateUserByName("c","ccccccccccccccc");
        List<User> list = userRepository.findByNameParam("c");
        for(User u : list){
            System.out.println(u.getName()+u.getAge());
        }
    }

}
