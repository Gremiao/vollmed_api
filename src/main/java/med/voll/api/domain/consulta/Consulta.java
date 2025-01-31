package med.voll.api.domain.consulta;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.paciente.Paciente;

import java.time.LocalDateTime;

@Entity(name = "Consulta")
@Table(name = "consultas")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Consulta {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_medico")
    private Medico medico;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;

    private LocalDateTime data;

    @NotNull
    private boolean ativo;

    @Column(name = "motivo_cancelamento")
    private String motivoCancelamento;

    public void cancelar(String justificativa) {
        this.motivoCancelamento = justificativa;
        this.ativo = false;
    }
}
