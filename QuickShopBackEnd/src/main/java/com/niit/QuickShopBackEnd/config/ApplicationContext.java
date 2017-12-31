package com.niit.QuickShopBackEnd.config;



import java.util.Properties;



import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.QuickShopBackEnd.dao.AuthenticationDao;
import com.niit.QuickShopBackEnd.dao.BillingDao;
import com.niit.QuickShopBackEnd.dao.CartDao;
import com.niit.QuickShopBackEnd.dao.CartItemsDao;
import com.niit.QuickShopBackEnd.dao.CategoryDao;
import com.niit.QuickShopBackEnd.dao.OrderDao;
import com.niit.QuickShopBackEnd.dao.OrderItemsDao;
import com.niit.QuickShopBackEnd.dao.PayDao;
import com.niit.QuickShopBackEnd.dao.ProductDao;
import com.niit.QuickShopBackEnd.dao.ShippingDao;
import com.niit.QuickShopBackEnd.dao.SupplierDao;
import com.niit.QuickShopBackEnd.dao.UserDao;
import com.niit.QuickShopBackEnd.daoimpl.AuthenticationDaoImpl;
import com.niit.QuickShopBackEnd.daoimpl.BillingDaoImpl;
import com.niit.QuickShopBackEnd.daoimpl.CartDaoImpl;
import com.niit.QuickShopBackEnd.daoimpl.CartItemsDaoImpl;
import com.niit.QuickShopBackEnd.daoimpl.CategoryDaoImpl;
import com.niit.QuickShopBackEnd.daoimpl.OrderDaoImpl;
import com.niit.QuickShopBackEnd.daoimpl.OrderItemsDaoImpl;
import com.niit.QuickShopBackEnd.daoimpl.PayDaoImpl;
import com.niit.QuickShopBackEnd.daoimpl.ProductDaoImpl;
import com.niit.QuickShopBackEnd.daoimpl.ShippingDaoImpl;
import com.niit.QuickShopBackEnd.daoimpl.SupplierDaoImpl;
import com.niit.QuickShopBackEnd.daoimpl.UserDaoImpl;
import com.niit.QuickShopBackEnd.model.Authentication;
import com.niit.QuickShopBackEnd.model.Billing;
import com.niit.QuickShopBackEnd.model.Cart;
import com.niit.QuickShopBackEnd.model.CartItems;
import com.niit.QuickShopBackEnd.model.Category;
import com.niit.QuickShopBackEnd.model.Order;
import com.niit.QuickShopBackEnd.model.OrderItems;
import com.niit.QuickShopBackEnd.model.Pay;
import com.niit.QuickShopBackEnd.model.Product;
import com.niit.QuickShopBackEnd.model.Shipping;
import com.niit.QuickShopBackEnd.model.Supplier;
import com.niit.QuickShopBackEnd.model.User;



@Configuration
@ComponentScan("com.niit.*")
@EnableTransactionManagement
public class ApplicationContext 
{
	@Bean("dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test/QuickShop");
		dataSource.setUsername("sa");
		dataSource.setPassword("sa");
		return dataSource;
}
	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.connection.pool_size", "10");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		return properties;
	}
	
	@Autowired
	@Bean("sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource)
	{
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(Category.class);
		sessionBuilder.addAnnotatedClass(Product.class);
		sessionBuilder.addAnnotatedClass(Supplier.class);
		sessionBuilder.addAnnotatedClass(Authentication.class);
		sessionBuilder.addAnnotatedClass(Billing.class);
    	sessionBuilder.addAnnotatedClass(Order.class);
    	sessionBuilder.addAnnotatedClass(OrderItems.class);
		sessionBuilder.addAnnotatedClass(Cart.class);
		sessionBuilder.addAnnotatedClass(CartItems.class);
		sessionBuilder.addAnnotatedClass(Shipping.class);
		sessionBuilder.addAnnotatedClass(Pay.class);
		sessionBuilder.addAnnotatedClass(User.class);
		
		return sessionBuilder.buildSessionFactory();
	}
	
	@Autowired
	@Bean("transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}

	@Autowired
	@Bean("categoryDao")
	public CategoryDao getCategoryDao(SessionFactory sessionFactory) {
		return new CategoryDaoImpl(sessionFactory);
	}
    
	@Autowired
	@Bean("productDao")
	public ProductDao getProductDao(SessionFactory sessionFactory) {
		return new ProductDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean("supplierDao")
	public SupplierDao getSupplierDao(SessionFactory sessionFactory) {
		return new SupplierDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean("authenticationDao")
	public AuthenticationDao getAuthenticationDao(SessionFactory sessionFactory) {
		return new AuthenticationDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean("billingDao")
	public BillingDao getBillingDao(SessionFactory sessionFactory) {
		return new BillingDaoImpl(sessionFactory);
	}
	 @Autowired
     @Bean("orderDao")
     public OrderDao getOrderDao(SessionFactory sessionFactory) {
     return new OrderDaoImpl(sessionFactory); 
     }
	
	 @Autowired
     @Bean("orderItemsDao")
     public OrderItemsDao getOrderItemsDao(SessionFactory sessionFactory) {
     return new OrderItemsDaoImpl(sessionFactory); 
     }
	@Autowired
	@Bean("cartDao")
	public CartDao getCartDao(SessionFactory sessionFactory) {
		return new CartDaoImpl(sessionFactory);
	}

	@Autowired
	@Bean("cartItemsDao")
	public CartItemsDao getCartItemsDao(SessionFactory sessionFactory) {
		return new CartItemsDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean("shippingDao")
	public ShippingDao getShippingDao(SessionFactory sessionFactory) {
		return new ShippingDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean("payDao")
	public PayDao getPayDao(SessionFactory sessionFactory) {
		return new PayDaoImpl(sessionFactory);
	}
	

	@Autowired
	@Bean("userDao")
	public UserDao getUserDao(SessionFactory sessionFactory) {
		return new UserDaoImpl(sessionFactory);
	}

}
