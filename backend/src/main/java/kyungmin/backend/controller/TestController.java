package kyungmin.backend.controller;

import jakarta.validation.Valid;
import kyungmin.backend.controller.request.CreateTestRequest;
import kyungmin.backend.service.RedisService;
import kyungmin.backend.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TestController {
  private final TestService testService;
  private final RedisService redisService;

  @Value("${test}")
  private String test;

  @GetMapping(value = "/")
  public ResponseEntity<String> test() {
    return ResponseEntity.ok(test);
  }

  @PostMapping(value = "/test")
  public ResponseEntity<Void> save(@RequestBody @Valid CreateTestRequest request) {
    testService.save(request);
    return ResponseEntity.ok().build();
  }

  @GetMapping(value = "/test/content/{id}")
  public ResponseEntity<String> getContent(@PathVariable("id") String id) {
    return ResponseEntity.ok(testService.getContent(Long.parseLong(id)));
  }

  @PostMapping(value = "/test/redis/save")
  public ResponseEntity<Void> saveRedis() {
    redisService.saveRefreshToken();
    return ResponseEntity.ok().build();
  }

  @GetMapping(value = "/test/redis/get")
  public ResponseEntity<String> getKey() {
    return ResponseEntity.ok(redisService.getRefreshToken());
  }
}
