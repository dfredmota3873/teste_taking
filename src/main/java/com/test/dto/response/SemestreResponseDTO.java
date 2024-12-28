package com.test.dto.response;

import lombok.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SemestreResponseDTO {
    private Long id;
    private String numero;
    private List<Long> disciplinasIds;
}