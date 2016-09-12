package com.litchi.jedis;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.litchi.jedisclient.JedisClient;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

public class JedisTest {

	@Test
	public void testJeset() {
		// 第一步：把jedis的jar包添加到工程中。
		// 第二步：创建一个测试类。
		// 第三步：创建Jedis对象，需要知道redis服务的ip及端口。

		Jedis jedis = new Jedis("192.168.224.112", 6379);
		// 第四步：调用jedis对象的方法，方法和redis命令一一对应。
		jedis.set("name", "222");
		String name = jedis.get("name");
		System.out.println("name:" + name); // 第五步：关闭jedis对象。
		jedis.close();
	}

	@Test
	public void testJedisPool() {
		// 创建一个连接池对象
		JedisPool jedisPool = new JedisPool("192.168.224.112", 6379);
		// 从连接池中获得连接
		Jedis jedis = jedisPool.getResource();
		String result = jedis.get("test1");
		System.out.println(result);
		jedis.close();
		// 程序关闭时，关闭连接池
		jedisPool.close();

	}

	@Test
	public void testJedisCluster() {
		Set<HostAndPort> nodes = new HashSet<>();
		nodes.add(new HostAndPort("192.168.224.112", 7001));
		nodes.add(new HostAndPort("192.168.224.112", 7002));
		nodes.add(new HostAndPort("192.168.224.112", 7003));
		nodes.add(new HostAndPort("192.168.224.112", 7004));
		nodes.add(new HostAndPort("192.168.224.112", 7005));
		nodes.add(new HostAndPort("192.168.224.112", 7006));
		JedisCluster jedisCluster = new JedisCluster(nodes);

		jedisCluster.set("cp", "test001111");
		// 使用JedisCluster对象操作集群
		String string = jedisCluster.get("cp");
		System.out.println(string);
		// 程序结束是关闭JedisCluster对象
		jedisCluster.close();

	}

	@Test
	public void testJedisClient() throws Exception {
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"classpath:spring/applicationContext-*.xml");
		JedisClient jedisClient = applicationContext.getBean(JedisClient.class);
		jedisClient.set("first", "1000");
		String string = jedisClient.get("first");
		System.out.println(string);

	}

}
