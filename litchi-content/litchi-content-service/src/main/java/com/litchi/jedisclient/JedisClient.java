package com.litchi.jedisclient;

public interface JedisClient {

	String get(String key);

	String set(String key, String value);

	Long hset(String key, String field, String value);

	String hget(String key, String field);

	Long incr(String key);

	Long expire(String key, int seconds);

	Long ttl(String key);

}
