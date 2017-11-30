import java.util.Iterator;
import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class TestRedis {
	
	public static void main(String[] args) {
		//预先启动redis，打开相应的端口
		Jedis jedis = new Jedis("192.168.161.128",6379);
//		jedis.auth("redis123456");
		System.out.println(jedis.ping());
		
		//String实例
		jedis.set("foo", "bars");
		jedis.append("foo", "bars");
		String value = jedis.get("foo");
		System.out.println(value);
		
		//java List(列表实例)
//		jedis.lpush("site-list", "baidu.com");
//		jedis.lpush("site-list", "goole.com.cn");
//		jedis.lpush("site-list", "tecent.com");
		// 获取存储的数据并输出
		List<String> list = jedis.lrange("site-list", 0, 5);
		for(int i=0;i<list.size();i++) {
			System.out.println("列表为"+list.get(i));
		}
		
		//获取所有数据并输出
		Set<String> keys = jedis.keys("*");
		Iterator<String> it = keys.iterator();
		while(it.hasNext()) {
			String key = it.next();
			System.out.println(key);
		}
		
	}
	
}
