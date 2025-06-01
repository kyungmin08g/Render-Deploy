package kyungmin.backend.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class RedisService {

  private final RedisTemplate<String, Object> redisTemplate;

  public RedisService(RedisTemplate<String, Object> redisTemplate) { this.redisTemplate = redisTemplate; }

  public void saveRefreshToken() {
    redisTemplate.opsForValue().set("테스트", "테스트 캐시", Duration.ofSeconds(2628000));
  }

  public String getRefreshToken() {
    return (String) redisTemplate.opsForValue().get("테스트");
  }
}
