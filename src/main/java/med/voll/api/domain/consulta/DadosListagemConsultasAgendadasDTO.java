package med.voll.api.domain.consulta;

import java.time.LocalDateTime;

public record DadosListagemConsultasAgendadasDTO(
        Long idConsulta,
        Long idMedico,
        String nomeMedico,
        String especialidade,
        Long idPaciente,
        String nomePaciente,
        LocalDateTime dataConsulta
) {
    public DadosListagemConsultasAgendadasDTO(Consulta consulta) {
        this(
            consulta.getId(),
            consulta.getMedico().getId(),
            consulta.getMedico().getNome(),
            consulta.getMedico().getEspecialidade().name(),
            consulta.getPaciente().getId(),
            consulta.getPaciente().getNome(),
            consulta.getData());
    }
}
