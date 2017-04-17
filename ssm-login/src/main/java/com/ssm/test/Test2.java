package com.ssm.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import redis.clients.jedis.Jedis;

public class Test2 {
	public static void main(String[] args) {
	//连接 redis 服务
	Jedis jedis =  new Jedis("localhost" ,6379);
	//密码验证-如果你没有设置 redis 密码可不验证即可使用相关命令
	//jedis.auth(" abcdefg ");
	//简单的key-value 存储
	
	/*
	 * string
	 */
	
//	jedis.set( "redis" ,  "redis" );
//	System. out .println(jedis.get( "redis" ));
	//在原有值得基础上添加,如若之前没有该key，则导入该key
	//之前已经设定了 redis 对应" myredis ",此句执行便会使 redis 对应" myredisyourredis "
	//key相同怎视为给这个key追加value
//	jedis.append( "redis" ,  "yourredis" );   
	/*jedis.append( "content" ,  "rabbit" );*/
	// mset  是设置多个key-value值   参数（key1,value1,key2,value2,..., keyn , valuen ）
	// mget  是获取多个key所对应的value值  参数（key1,key2,key3,..., keyn ）  返回的是个list
	// mget  根据多个key获取对应的value
//	jedis.mset( "name1" , "yangw" , "name2" , "demon" , "name3" , "elena" );
//	jedis.del( "name2");
//	System. out .println(jedis.mget( "name1" , "name2" , "name3" ));
	
	/*
	 * map
	 */
	
/*	Map<String,String> user =  new HashMap<String,String>();
	user.put( "name" ,  "cd" );
	user.put( "password" ,  "123456" );
	//map存入 redis
	jedis.hmset( "user" , user);
	// mapkey 个数 hlen  havalength
	System. out .println(String. format ( "len:%d" , jedis.hlen( "user" )));
	//map中的所有键值 hkeys  have keys
	System. out .println(String. format ( "keys: %s" , jedis.hkeys( "user" ) ));
	//map中的所有value hvals have values
	System. out .println(String. format ( "values: %s" , jedis.hvals( "user" ) ));*/
	
	//map的保存数据的另一种方法
	
    /*jedis.hset("website", "google", "www.google.cn");
    jedis.hset("website", "baidu", "www.baidu.cn");
    jedis.hset("website", "sina", "www.sina.cn");*/
	
	//取出map中的name字段值
//	List<String> rsmap = jedis.hmget( "user" ,  "name" , "password" );
//	System. out .println(rsmap);
	//删除map中的某一个键值 password
//	jedis.hdel( "user" ,  "password" );
//	jedis.hdel( "user" ,  "name" );
//	System. out .println(jedis.hmget( "user" ,  "name" ,  "password" ));
	
	/*
	 * list
	 */
	
//	jedis.del( "listDemo" );
//	System. out .println(jedis.lrange( "listDemo" , 0, -1));
	jedis.lpush( "listDemo" ,  "A" );
	jedis.lpush( "listDemo" ,  "B" );
	jedis.lpush( "listDemo" ,  "C" );
//	System. out .println(jedis.lrange( "listDemo" , 0, -1));
//	System. out .println(jedis.lrange( "listDemo" , 0, 1));
	
	/*
	 * set
	 */
/*	jedis.sadd( "sname" ,  "wobby" );
	jedis.sadd( "sname" ,  "kings" );
	jedis.sadd( "sname" ,  "demon" );
	System. out .println(String. format ( "set num: %d" , jedis.scard( "sname" )));
	System. out .println(String. format ( "all members: %s" , jedis.smembers( "sname" )));
	System. out .println(String. format ( "is member: %B" , jedis.sismember( "sname" ,  "wobby" )));
	System. out .println(String. format ( "rand member: %s" , jedis.srandmember( "sname" )));
	*/
	//删除一个对象
/*	jedis.srem( "sname","kings" );
	jedis.srem( "sname","demon" );
	jedis.srem( "sname","wobby" );
	System. out .println(String. format ( "all members: %s" , jedis.smembers( "sname" )));    */    

	}
}
