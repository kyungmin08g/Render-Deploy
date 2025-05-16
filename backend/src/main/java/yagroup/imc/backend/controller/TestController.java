package yagroup.imc.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

  @Value("${test}")
  private String test;

  @GetMapping(value = "/")
  public ResponseEntity<String> test() {
    return ResponseEntity.ok(test);
  }
}
