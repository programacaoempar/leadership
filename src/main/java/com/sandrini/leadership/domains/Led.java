package com.sandrini.leadership.domains;

import com.sandrini.leadership.dtos.LedDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Led {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name="team_id", nullable=false)
    private Team team;

    public LedDTO toDTO() {
        return LedDTO.builder()
                .id(this.id)
                .name(this.name)
                .teamId(team.getId())
                .build();
    }

}
