package com.example;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DemoApplicationTest {

	@Autowired
	DataSource dataSource;


	@Test
	public  void contextLoads() throws SQLException {
		System.out.println(dataSource.getClass());
		Connection connection = dataSource.getConnection();
		System.out.println(connection);

		DruidDataSource druidDataSource = (DruidDataSource) dataSource;
		System.out.println("druidDataSource 数据源最大连接数：" + druidDataSource.getMaxActive());
		System.out.println("druidDataSource 数据源初始化连接数：" + druidDataSource.getInitialSize());

		connection.close();
	}

//	@Test
//	public void contextLoads() throws SQLException {
//		System.out.println(dataSource.getClass());
//		Connection connection = dataSource.getConnection();
//		System.out.println(connection);
//		connection.close();
//	}

//	@Autowired
//	private RabbitAdmin rabbitAdmin;

//	@Test
//	public void test1() {
//
//		rabbitAdmin.declareExchange(new TopicExchange("test.topic.exchange", false, false, null));
//		rabbitAdmin.declareExchange(new DirectExchange("test.direct.exchange", false, false, null));
//		rabbitAdmin.declareExchange(new FanoutExchange("test.fanout.exchange", false, false, null));
//
//		rabbitAdmin.declareQueue(new Queue("topic.queue", false, false, false, null));
//		rabbitAdmin.declareQueue(new Queue("direct.queue", false, false, false, null));
//		rabbitAdmin.declareQueue(new Queue("fanout.queue", false, false, false, null));
//
//		//1将一个queue绑定到一个exchange
//		rabbitAdmin.declareBinding(new Binding(
//				"direct.queue",//目标：队列名
//				Binding.DestinationType.QUEUE,//绑定目标类型：队列
//				"test.direct.exchange",//交换机名称
//				"direct.key",//路由key
//				null));//扩展参数
//
//		//2.1将一个交换机绑定到另一个交换机(消息流转topic.exchange->fanout.exchange)
//		rabbitAdmin.declareBinding(new Binding(
//				"test.fanout.exchange",//目标：交换机名
//				Binding.DestinationType.EXCHANGE, //绑定目标类型：交换机
//				"test.topic.exchange", //发起绑定的交换机
//				"test", //路由key
//				null));
//		//2.2fanout.queue绑定到test.fanout.exchange
//		rabbitAdmin.declareBinding(new Binding("fanout.queue",//目标：fanout.queue
//				Binding.DestinationType.QUEUE,//绑定类型:队列
//				"test.fanout.exchange",//绑定到的exchange
//				"",//应为是fanout类型exchange所以不需要routingKey
//				null));
//
//		//发送消息
//		//正常的消息流转 从test.direct.exchange-》direct.queue
//		rabbitAdmin.getRabbitTemplate().convertAndSend("test.direct.exchange", "direct.key", "直连交换机消息111");
//		//消息先到test.topic.exchange-》test.fanout.exchange-》fanout.queue
//		rabbitAdmin.getRabbitTemplate().convertAndSend("test.topic.exchange", "test", "多级流转消息2222");
//	}

}
