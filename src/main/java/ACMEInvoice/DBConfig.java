package ACMEInvoice;

//import org.hibernate.ejb.HibernatePersistence;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration @EnableTransactionManagement @ComponentScan("ACMEInvoice")
@PropertySource("classpath:application.properties")
@EnableJpaRepositories("ACMEInvoice.repository")
public class DBConfig {
    private static final String PROP_DATABASE_DRIVER = "org.h2.Driver";
    private static final String PROP_DATABASE_PASSWORD = "";
    private static final String PROP_DATABASE_URL = "jdbc:h2:~/test";
    private static final String PROP_DATABASE_USERNAME = "sa";
    private static final String PROP_HIBERNATE_DIALECT = "org.hibernate.dialect.H2Dialect";
    private static final String PROP_HIBERNATE_SHOW_SQL = "false";
    private static final String PROP_ENTITYMANAGER_PACKAGES_TO_SCAN = "ACMEInvoice.domain";
    private static final String PROP_HIBERNATE_HBM2DDL_AUTO = "create";

    @Resource
    private Environment env;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName((PROP_DATABASE_DRIVER));
        dataSource.setUrl((PROP_DATABASE_URL));
        dataSource.setUsername((PROP_DATABASE_USERNAME));
        dataSource.setPassword((PROP_DATABASE_PASSWORD));

        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        entityManagerFactoryBean.setPackagesToScan((PROP_ENTITYMANAGER_PACKAGES_TO_SCAN));

        entityManagerFactoryBean.setJpaProperties(getHibernateProperties());

        return entityManagerFactoryBean;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

        return transactionManager;
    }

    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", (PROP_HIBERNATE_DIALECT));
        properties.put("hibernate.show_sql", (PROP_HIBERNATE_SHOW_SQL));
        properties.put("hibernate.hbm2ddl.auto", (PROP_HIBERNATE_HBM2DDL_AUTO));

        return properties;
    }
}