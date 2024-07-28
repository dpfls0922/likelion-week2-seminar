package yerin.crud.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import yerin.crud.Dto.MemberDto;

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {
    @RequestMapping(value = "/domain", method = RequestMethod.POST)
    public String postExample() {
        return "Hello Post API";
    }

    // http://localhost:8080/api/v1/post-api/member
    @PostMapping(value = "/member")
    @Operation(summary = "post body api", description = "map 객체로 정보 불러오기")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "요청에 성공하였습니다.", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "400", description = "이미 가입된 계정입니다.", content = @Content(mediaType = "application/json"))
    })
    @Parameters({
            @Parameter(name = "name", description = "이름", example = "Orange"),
            @Parameter(name = "email", description = "이메일", example = "Orange@naver.com"),
            @Parameter(name = "organization", description = "소속 기관", example = "숙멋")
    })
    public String postMember(@RequestBody Map<String, Object> postData) {
        StringBuilder sb = new StringBuilder();

        postData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });
        return sb.toString();
    }

    // http://localhost:8080/api/v1/post-api/member2$
    @PostMapping(value = "/member2")
    public String postMemberDto(@RequestBody MemberDto memberDto) {
        return memberDto.toString();
    }
}