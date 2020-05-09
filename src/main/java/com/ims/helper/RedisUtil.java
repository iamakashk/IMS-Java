package com.ims.helper;

import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ims.constant.CommonConstants;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public enum RedisUtil {

	INSTANCE;

	private final JedisPool pool;
	private static final Logger LOG = LogManager.getFormatterLogger();

	RedisUtil() {
		int RedisPortNo = CommonConstants.CACHE_SERVER_PORT_NO;// 6380
		String cacheServerIP=CommonConstants.CACHE_SERVER_IP;
		pool = new JedisPool(new JedisPoolConfig(), cacheServerIP, RedisPortNo);
	}

	public boolean getkey(String key, String value, String logId) {
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			return jedis.sismember(key, value);
		} catch (Exception e) {
			LOG.error(logId + CommonConstants.EXCEPTION_STRING_START);
			LOG.error(logId + e);
			LOG.error(logId + CommonConstants.EXCEPTION_STRING_END);
			return false;
		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}
	}

	public void deleteKeys(String key) {
		Jedis jedis = null;
		try {

			jedis = pool.getResource();
			jedis.del(key);
		} catch (Exception e) {
			LOG.error(CommonConstants.EXCEPTION_STRING_START);
			LOG.error(e);
			LOG.error(CommonConstants.EXCEPTION_STRING_END);
		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}

	}

	public void addwithExpiry(String key, String value, int expiryTime, String logId) {
		Jedis jedis = null;
		try {

			jedis = pool.getResource();
			jedis.sadd(key, value);
			jedis.expire(key, expiryTime);
		} catch (Exception e) {
			LOG.error(logId + CommonConstants.EXCEPTION_STRING_START);
			LOG.error(logId + e);
			LOG.error(logId + CommonConstants.EXCEPTION_STRING_END);
		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}
	}

	public void add(String key, String value, String logId) {
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			jedis.sadd(key, value);
		} catch (Exception e) {
			LOG.error(logId + CommonConstants.EXCEPTION_STRING_START);
			LOG.error(logId, e);
			LOG.error(logId + CommonConstants.EXCEPTION_STRING_END);
		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}
	}

	public boolean isKeyAvlbl(String key, String logId) {
		Jedis jedis = null;
		boolean isKeyPresent = false;
		Set<String> keys = null;
		try {
			jedis = pool.getResource();
			keys = jedis.keys(key);
			if (keys != null && !key.isEmpty()) {
				isKeyPresent = true;
			} else {
				isKeyPresent = false;
			}
		} catch (Exception e) {
			LOG.error(logId + CommonConstants.EXCEPTION_STRING_START);
			LOG.error(logId + e);
			LOG.error(logId + CommonConstants.EXCEPTION_STRING_END);
			isKeyPresent = false;
		} finally {
			if (jedis != null) {
				jedis.close();
			}
			keys = null;
		}
		return isKeyPresent;
	}

	/* DELETE KEY VALUE FROM REDIS */
	public void srem(String key, String value) {
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			jedis.srem(key, value);
		} catch (Exception e) {
			LOG.error(CommonConstants.EXCEPTION_STRING_START);
			LOG.error(e);
			LOG.error(CommonConstants.EXCEPTION_STRING_END);
		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}
	}

	public boolean get(String key, String value, String logId) {
		Jedis jedis = null;
		boolean isKeyPresent = false;
		try {
			jedis = pool.getResource();
			isKeyPresent = jedis.sismember(key, value);
		} catch (Exception e) {
			LOG.error(logId + CommonConstants.EXCEPTION_STRING_START);
			LOG.error(logId + e);
			LOG.error(logId + CommonConstants.EXCEPTION_STRING_END);
			isKeyPresent = false;
		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}
		return isKeyPresent;
	}

	public void deleteValuesOFKey(String key) {
		Jedis jedis = null;
		Set<String> keyValues = null;
		try {
			jedis = pool.getResource();
			keyValues = jedis.smembers(key);
			for (String nickname : keyValues) {
				System.out.println(nickname);
			}
			/* DELETE VALUES */
			for (String nickname : keyValues) {
				RedisUtil.INSTANCE.srem(key, nickname);
			}

		} catch (Exception e) {
			LOG.error(CommonConstants.EXCEPTION_STRING_START);
			LOG.error(e);
			LOG.error(CommonConstants.EXCEPTION_STRING_END);
		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}

	}

	public Set<String> getAllKeys(String logId) {
		Jedis jedis = null;
		Set<String> list = new HashSet<>();
		try {
			jedis = pool.getResource();
			// Set<String> list = jedis.keys("*");
			list = jedis.keys("*");

		} catch (Exception e) {
			LOG.error(logId + CommonConstants.EXCEPTION_STRING_START);
			LOG.error(logId + e);
			LOG.error(logId + CommonConstants.EXCEPTION_STRING_END);
		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}
		return list;
	}

	public Set<String> getValueByKey(String key, String logId) {
		Jedis jedis = null;
		Set<String> keyValues = null;
		try {
			jedis = pool.getResource();

			keyValues = jedis.smembers(key);

			/*
			 * Set<String> list = jedis.keys("*");
			 * System.out.println("SIZE: "+list.size()); Iterator<String> it =
			 * list.iterator(); while(it.hasNext()){
			 * System.out.println(it.next()); }
			 * 
			 * keyValues = jedis.smembers(key); for (String nickname :
			 * keyValues) { System.out.println(nickname); }
			 */

		} catch (Exception e) {
			LOG.error(logId + CommonConstants.EXCEPTION_STRING_START);
			LOG.error(logId + e);
			LOG.error(logId + CommonConstants.EXCEPTION_STRING_END);
		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}
		return keyValues;
	}
}
