package com.misky.maven.account.persist;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by CHILI_USER on 2017/11/22.
 */
public class AccountPersistServiceTest {
    private AccountPersistService service;
    @Before
    public void prepare() throws Exception{
        File persistDataFile = new File("target/persist-classes/persist_data.xml");
        if(persistDataFile.exists()){
            persistDataFile.delete();
        }
        ApplicationContext ctx = new ClassPathXmlApplicationContext("account-persist.xml");
        service = (AccountPersistService) ctx.getBean("accountPersistService");
        Account account = new Account();
        account.setId("misky");
        account.setName("Misky Shi");
        account.setEmail("miskyshi@163.com");
        account.setPassword("123456");
        account.setActivated(true);

        service.createAccount(account);
    }
    @Test
    public void testReadAccount() throws Exception{
        Account account = service.readAccount("misky");
        assertEquals("misky",account.getId());
        assertEquals("Misky Shi",account.getName());
        assertEquals("miskyshi@163.com",account.getEmail());
        assertEquals("123456",account.getPassword());
        assertTrue(account.isActivated());
    }
}
