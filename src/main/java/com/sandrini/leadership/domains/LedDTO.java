package com.sandrini.leadership.domains;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LedDTO {
    private Long id;
    private String name;

    @JsonProperty(value = "team_id")
    private Long teamId;

    public Led toEntity(){
        return Led.builder()
                .id(this.id)
                .name(this.name)
                .team(Team.builder().id(this.teamId).build())
                .build();
    }
}
