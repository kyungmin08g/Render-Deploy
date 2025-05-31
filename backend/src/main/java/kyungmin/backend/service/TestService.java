package kyungmin.backend.service;

import kyungmin.backend.domain.TestEntity;
import kyungmin.backend.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestService {
  private final TestRepository repository;

  public void save(TestEntity test) {
    repository.save(
      TestEntity.builder()
        .title("")
        .content("")
        .build()
    );
  }

  public String getContent(long id) {
    return repository.findById(id).get().getContent();
  }
}
