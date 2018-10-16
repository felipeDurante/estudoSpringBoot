package br.com.tomCat.configuracao;

import java.sql.SQLException;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import br.com.tomCat.entitys.Usuario;
import br.com.tomCat.repositories.UsuarioRepository;
import br.com.tomCat.security.SenhaUtils;
import br.com.tomCat.security.enums.PerfilEnum;
import oracle.jdbc.pool.OracleDataSource;

@SpringBootApplication
@ComponentScan(basePackages = { "br.com.tomCat.controllers", "br.com.tomCat.services", "br.com.tomCat.servicesImpl" })
@EnableJpaRepositories(basePackages = { "br.com.tomCat.repositories" })
@PropertySource("classpath:application.properties")
@EnableAutoConfiguration(exclude = {
		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class })
public class EstudoSpringApplication {

	private static final String driver = "oracle.jdbc.OracleDriver";
	private static final String database = "DBESTUDO";
	private static final String str_con = "jdbc:oracle:thin:@localhost:1521:xe";
	// + "(DESCRIPTION = (ADDRESS =(PROTOCOL = TCP)(HOST = 18.231.47.183)(PORT
	// =1533))(CONNECT_DATA = (SERVER = DEDICATED) (SERVICE_NAME =SIGPRD)))";
	private static final String user = "system";
	private static final String password = "admin";
	// private static final String serviceName = "SIG12HOM";

	public static void main(String[] args) {
		SpringApplication.run(EstudoSpringApplication.class, args);
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan(new String[] { "br.com.tomCat.entitys" });
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(additionalProperties());
		return em;
	}

	private Properties additionalProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.OracleDialect");
		properties.put("hibernate.cache.use_second_level_cache", true);
		properties.put("hibernate.cache.use_query_cache", true);
		properties.put("javax.persistence.sharedCache.mode", "ALL");
		properties.put("hibernate.cache.region.factory_class", "org.hibernate.cache.ehcache.EhCacheRegionFactory");
		properties.setProperty("hibernate.show_sql", "true");
		return properties;
	}

	@Bean
	DataSource dataSource() {
		OracleDataSource dataSource = null;

		try {
			dataSource = new OracleDataSource();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		dataSource.setUser(user);
		dataSource.setURL(str_con);
		dataSource.setDatabaseName(database);
		dataSource.setDriverType(driver);
		dataSource.setPassword(password);

		return dataSource;
		// dataSource.setServiceName(serviceName);
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		EntityManagerFactory factory = entityManagerFactory().getObject();
		return new JpaTransactionManager(factory);
	}

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {

			Usuario usuario = new Usuario();
			usuario.setEmail("usuario@email.com");
			usuario.setPerfil(PerfilEnum.ROLE_USUARIO);
			usuario.setSenha(SenhaUtils.gerarBCrypt("123456"));
			this.usuarioRepository.save(usuario);

			Usuario admin = new Usuario();
			admin.setEmail("admin@email.com");
			admin.setPerfil(PerfilEnum.ROLE_ADMIN);
			admin.setSenha(SenhaUtils.gerarBCrypt("123456"));
			this.usuarioRepository.save(admin);

		};
	}

}
