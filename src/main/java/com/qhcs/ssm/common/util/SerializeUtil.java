package com.qhcs.ssm.common.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: SerializeUtil
 * @Desc: 序列化、反序列化
 * @author John Gu
 * @date 2014-8-20下午2:21:41
 */
public class SerializeUtil {

	private static final Logger log = LoggerFactory.getLogger(SerializeUtil.class);

	/**
	 * @Description: 序列化
	 * @author John Gu
	 * @date 2013-9-14上午10:22:12
	 * @param object
	 * @return
	 */
	public static byte[] serialize(Object object) {
		ObjectOutputStream oos = null;
		ByteArrayOutputStream baos = null;
		try {
			// 序列化
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(object);
			byte[] bytes = baos.toByteArray();
			return bytes;
		} catch (Exception e) {
			log.error("【异常提示信息】" + e, e);
		}
		return null;
	}

	/**
	 * @Description: 反序列化
	 * @author John Gu
	 * @date 2013-9-14上午10:22:25
	 * @param bytes
	 * @return
	 */
	public static Object unSerialize(byte[] bytes) {
		ByteArrayInputStream bais = null;
		try {
			// 反序列化
			bais = new ByteArrayInputStream(bytes);
			ObjectInputStream ois = new ObjectInputStream(bais);
			return ois.readObject();
		} catch (Exception e) {
			log.error("【异常提示信息】" + e, e);
		}
		return null;
	}
}
