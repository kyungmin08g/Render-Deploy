package kyungmin.backend.controller.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
@Schema(description = "Test 내용 조회 응답 객체")
public class GetTestContentResponse {

  @Schema(description = "내용")
  private String content;
}
