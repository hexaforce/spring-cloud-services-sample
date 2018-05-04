package io.hexaforce.core.services1;

import java.lang.reflect.Method;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableCaching
public class Core1RedisCache extends CachingConfigurerSupport {
	
	@Bean
	public JedisConnectionFactory redisConnectionFactory() {
		JedisConnectionFactory redisConnectionFactory = new JedisConnectionFactory();
		return redisConnectionFactory;
	}

	@Bean
	public RedisTemplate<String, ?> redisTemplate(RedisConnectionFactory cf) {
		RedisTemplate<String, ?> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(cf);
		return redisTemplate;
	}
	
	@Bean
	public CacheManager cacheManager(RedisConnectionFactory connectionFactory) {
		RedisCacheManager redisCacheManager = RedisCacheManager
				.builder(connectionFactory)
				.cacheDefaults(
					RedisCacheConfiguration
						.defaultCacheConfig()
						.serializeValuesWith(
							RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer())
						)
				).build();

		return redisCacheManager;
	}
	
	@Bean
	public KeyGenerator redisKeyGenerator() {
		return new KeyGenerator() {
			@Override
			public Object generate(Object o, Method method, Object... objects) {
				StringBuilder builder = new StringBuilder();
				builder.append(o.getClass().getName());
				builder.append(method.getName());
				for (Object obj : objects) {
					builder.append(obj.toString());
				}
				return builder.toString();
			}
		};
	}
	
}
