package com.mybatis.helloworld;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.mybatis.helloworld.bean.Merchant;

/**
 * SqlSessionFactoryBuilder(局部变量，创建SqlSessionFactory后立即释放)
	这个类可以被实例化、使用和丢弃，一旦创建了 SqlSessionFactory，就不再需要它了。因此 SqlSessionFactoryBuilder 实例的最佳作用域是方法作用域
	（也就是局部方法变量）。你可以重用 SqlSessionFactoryBuilder 来创建多个 SqlSessionFactory 实例，但是最好还是不要让其一直存在以保证所有的 XML 
	解析资源开放给更重要的事情。
	
	SqlSessionFactory(应用运行期间)	
	SqlSessionFactory 一旦被创建就应该在应用的运行期间一直存在，没有任何理由对它进行清除或重建。使用 SqlSessionFactory 的最佳实践是在应用运行期间
	不要重复创建多次，多次重建 SqlSessionFactory 被视为一种代码“坏味道（bad smell）”。因此 SqlSessionFactory 的最佳作用域是应用作用域。有很多
	方法可以做到，最简单的就是使用单例模式或者静态单例模式。
	
	SqlSession(每个线程，http请求对应一个sqlSession)
	每个线程都应该有它自己的 SqlSession 实例。SqlSession 的实例不是线程安全的，因此是不能被共享的，所以它的最佳的作用域是请求或方法作用域。绝对不能将 
	SqlSession 实例的引用放在一个类的静态域，甚至一个类的实例变量也不行。也绝不能将 SqlSession 实例的引用放在任何类型的管理作用域中，比如 Servlet 
	架构中的 HttpSession。如果你现在正在使用一种 Web 框架，要考虑 SqlSession 放在一个和 HTTP 请求对象相似的作用域中。换句话说，每次收到的 HTTP 请求，
	就可以打开一个 SqlSession，返回一个响应，就关闭它。这个关闭操作是很重要的，你应该把这个关闭操作放到 finally 块中以确保每次都能执行关闭。
 * @author wj
 *
 */
public class TestSqlSessionFactory {
	/**
	 * 从xml中构建SqlSessionFactory,mybatis-config.xml中配置mybatis设置
	 * @throws IOException
	 */
	@Test
	public void getSqlSessionFactoryByXML() throws IOException{
		String resource="mybatis/mybatisXML文件配置详细解析.xml";
		InputStream in=Resources.getResourceAsStream(resource);
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
	}
	
	@Test
	public void getSqlSessionFactoryByCode(){
		/*DataSource dataSource = BlogDataSourceFactory.getBlogDataSource();
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		Environment environment = new Environment("development", transactionFactory, dataSource);
		Configuration configuration = new Configuration(environment);
		configuration.addMapper(BlogMapper.class);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);*/
	}
	
	/**
	 * mapper.xml形式执行sql
	 * @throws IOException
	 */
	@Test
	public void TestSqlSession() throws IOException{
		String resource="mybatis/mybatis-config.xml";
		InputStream in=Resources.getResourceAsStream(resource);
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
		SqlSession session=factory.openSession();
		//使用指定的完全限定名“org.mybatis.example.BlogMapper.selectBlog”来调用映射语句
		Merchant m=session.selectOne("com.mybatis.helloworld.selectMerchant", 75384);
		System.out.println(m);
		session.close();
	}
	
	/**
	 * mapper.xml形式执行sql，接口的方式,对应MerchantMapperInterface.xml文件，namespace对应接口全路径，id对应接口方法名
	 * @throws IOException
	 */
	@Test
	public void TestSqlSession2() throws IOException{
		String resource="mybatis/mybatis-config.xml";
		InputStream in=Resources.getResourceAsStream(resource);
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
		SqlSession session=factory.openSession();
		
	/*	命名可以直接映射到在命名空间中同名的 Mapper 类，并在已映射的 select 语句中的名字、参数和返回类型匹配成方法。
		这样你就可以向上面那样很容易地调用这个对应 Mapper 接口的方法*/
		MerchantMapper merchant=session.getMapper(MerchantMapper.class);
		Merchant m=merchant.selectMerchant("75384");
		System.out.println(m);
		session.close();
	}
	
	@Test
	public void TestSqlSession3() throws IOException{
		String resource="mybatis/mybatisXML文件配置详细解析.xml";
		InputStream in=Resources.getResourceAsStream(resource);
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
		SqlSession session=factory.openSession();
		
		/*使用mapper接口和注解的方式,接口+注解的方式需要在mybatis-config.xml配置对应的接口类	
		 * mapper class="com.mybatis.helloworld.MerchantMapperAnnotation" />*/
		MerchantMapperAnnotation merchant=session.getMapper(MerchantMapperAnnotation.class);
		Merchant m=merchant.selectMerchant("75384");
		System.out.println(m);
		session.close();
	}
}
