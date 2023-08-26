package balachonov.dto.responses;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;


@Getter
@Builder
public class ErrorResponse {
    private String message;
    private String helpEmail;
    private LocalDateTime time;
}
