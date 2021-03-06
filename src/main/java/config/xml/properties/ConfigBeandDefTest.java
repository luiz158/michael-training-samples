package config.xml.properties;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration("config-bean-def.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ConfigBeandDefTest {
	
	@Autowired
	private ClientService clientService;
	
	@Test
	public void testClassPath() {
		Assert.assertTrue(clientService.getDbName().equals("dbName"));
	}

}
