package med.voll.api.domain.consulta;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.medico.Especialidade;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosAgendamentoConsultaDTO(
        @JsonAlias({"idMedico","id_medico","medico_id"})
        Long idMedico,

        @NotNull
        @JsonAlias({"idPaciente","id_paciente","paciente_id"})
        Long idPaciente,

        @NotNull
        @Future
        //@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime data,

        Especialidade especialidade
) {
}
