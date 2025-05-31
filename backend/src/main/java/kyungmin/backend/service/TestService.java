package kyungmin.backend.service;

import kyungmin.backend.controller.request.CreateTestRequest;
import kyungmin.backend.domain.TestEntity;
import kyungmin.backend.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestService {
  private final TestRepository repository;

  public void save(CreateTestRequest request) {
    repository.save(
      TestEntity.builder()
        .title(request.title())
        .content(request.content())
        .build()
    );
  }

  public String getContent(long id) {
    return repository.findById(id).get().getContent();
  }
}
