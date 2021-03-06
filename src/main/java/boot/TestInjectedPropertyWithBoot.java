package boot;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {ApplicationConfig.class, PropertiesConfig.class})
@ActiveProfiles("injectedProperty")
public class TestInjectedPropertyWithBoot {

	private final Logger logger = LoggerFactory.getLogger(TestInjectedPropertyWithBoot.class);


	@Value("${customproperty}")
	private String customproperty;

    @Autowired
    private String clientName;

    @Test public void shouldReadPropertyFromCustomPropertiesFile() {
        assertThat(this.clientName).isEqualTo("tintin");
    }


	@Test public void shouldReadPropertyAndInjectIt() {
		assertThat(this.customproperty).isEqualTo("customPropValue");
	}
	

}

@Configuration
@PropertySource("classpath:boot/mytest.properties")
class PropertiesConfig {
    @Value("${clientName}")
    private String clientName;

    @Bean public String clientName() {
        return this.clientName;
    }


}

