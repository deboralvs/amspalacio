package br.com.sankhya.config;

import java.beans.PropertyVetoException;
import java.util.Arrays;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = "br.com.sankhya.*"  )
@EnableJpaRepositories({ "br.com.sankhya.*" })
@PropertySource({ "classpath:br/com/sankhya/resource/persistence.properties" })
@Import({ WebSecurityConfig.class, WebMvcConfig.class })
public class ApplicationConfig {

	@Autowired
	private Environment enviroment;

	// private final JpaProperties jpaProperties;

	@Primary
	@Bean
	public DataSource getDataSource() {
		ComboPooledDataSource myDataSource = new ComboPooledDataSource();

		try {
			myDataSource.setDriverClass(enviroment.getProperty("jdbc.driver"));
		} catch (PropertyVetoException exc) {
			throw new IllegalArgumentException("Property Environment jdbc.driver " + exc);
		}
		// set database connection props
		myDataSource.setJdbcUrl(enviroment.getProperty("jdbc.url"));
		myDataSource.setUser(enviroment.getProperty("jdbc.user"));
		myDataSource.setPassword(enviroment.getProperty("jdbc.password"));
		// set connection pool
		myDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		myDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		myDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
		myDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));

		return myDataSource;
	}


	private int getIntProperty(String propName) {

		String propVal = enviroment.getProperty(propName);
		return Integer.parseInt(propVal);
	}

	private Properties getHibernateProperties() {

		// set hibernate properties
		Properties props = new Properties();

		props.setProperty("hibernate.dialect", enviroment.getProperty("hibernate.dialect"));
		props.setProperty("hibernate.show_sql", enviroment.getProperty("hibernate.show_sql"));
		//props.setProperty("hibernete.default_schema", enviroment.getProperty("hibernate.default_schema"));
		return props;
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		return new HibernateJpaVendorAdapter();
	}

	@Bean(name = "entityManagerFactory")

	@Primary
	@Autowired
	public LocalSessionFactoryBean entityManagerFactory() {

		// create session factorys
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

		// set the properties
		sessionFactory.setDataSource(getDataSource());
		sessionFactory.setPackagesToScan(enviroment.getProperty("hibernate.packagesToScan"));
		sessionFactory.setHibernateProperties(getHibernateProperties());

		return sessionFactory;
	}

	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {

		// setup transaction manager based on session factory
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);

		return txManager;
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("http://localhost","http://localhost:8080","http://localhost:3000","http://localhost:4000"));
		configuration.setAllowedMethods(Arrays.asList("GET", "POST"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
}
