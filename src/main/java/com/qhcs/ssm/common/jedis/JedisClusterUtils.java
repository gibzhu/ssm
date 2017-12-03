package com.qhcs.ssm.common.jedis;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.qhcs.ssm.common.util.Exceptions;
import com.qhcs.ssm.common.util.ObjectUtils;
import com.qhcs.ssm.common.util.StringUtils;

import redis.clients.jedis.JedisCluster;

public class JedisClusterUtils {

	@Autowired
	private JedisCluster jedisCluster;

	private static Logger logger = LoggerFactory.getLogger(JedisClusterUtils.class);

	/**
	 * 获取缓存
	 * 
	 * @param key
	 *            键
	 * @return 值
	 */
	public static Object getObject(String key) {
		return null;
	}

	/**
	 * 获取byte[]类型Key
	 * 
	 * @param key
	 * @return
	 */
	public static byte[] getBytesKey(Object object) {
		if (object instanceof String) {
			return StringUtils.getBytes((String) object);
		} else {
			return ObjectUtils.serialize(object);
		}
	}

	/**
	 * Object转换byte[]类型
	 * 
	 * @param key
	 * @return
	 */
	public static byte[] toBytes(Object object) {
		return ObjectUtils.serialize(object);
	}

	/**
	 * byte[]型转换Object
	 * 
	 * @param key
	 * @return
	 */
	public static Object toObject(byte[] bytes) {
		return ObjectUtils.unserialize(bytes);
	}

	/**
	 * 功能：设置list值
	 *
	 * @version 2016年12月12日下午2:12:31
	 * @author baocheng.ren
	 * @param jedisCluster
	 * @param key
	 * @param list
	 */
	@SuppressWarnings("rawtypes")
	public static void setList(JedisCluster jedisCluster, String key, List list, int seconds) {
		try {
			byte[] bytesKey = key.getBytes();

			jedisCluster.del(bytesKey);
			if (list == null || list.isEmpty()) {
				return;
			}

			for (Object object : list) {
				jedisCluster.lpush(bytesKey, ObjectUtils.serialize(object));
			}
			jedisCluster.expire(bytesKey, seconds);
		} catch (Exception e) {
			logger.error(Exceptions.getStackTraceAsString(e));
		}
	}

	/**
	 * 功能：获取list值
	 *
	 * @version 2016年12月12日下午2:13:41
	 * @author baocheng.ren
	 * @param jedisCluster
	 * @param key
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List getList(JedisCluster jedisCluster, String key) {
		byte[] bytesKey = key.getBytes();
		List result = new ArrayList();
		List<byte[]> lrange = jedisCluster.lrange(bytesKey, 0, -1);
		for (byte[] bs : lrange) {
			result.add(ObjectUtils.unserialize(bs));
		}
		return result;
	}

	/**
	 * 
	 * 设置String类型数据
	 * 
	 * @version 2016年12月22日上午10:22:02
	 * @author wenbin.zhu
	 * @param jedisCluster
	 * @param key
	 * @param value
	 * @param seconds
	 */
	public static void setString(JedisCluster jedisCluster, String key, String value, int seconds) {
		jedisCluster.set(key, value);
		jedisCluster.expire(key, seconds);
	}

	/**
	 * 
	 * 获取String类型的数据
	 * 
	 * @version 2016年12月22日上午10:22:52
	 * @author wenbin.zhu
	 * @param jedisCluster
	 * @param key
	 * @return
	 */
	public static String getString(JedisCluster jedisCluster, String key) {
		return jedisCluster.get(key);
	}
}
