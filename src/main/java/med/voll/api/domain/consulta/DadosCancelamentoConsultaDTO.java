package med.voll.api.domain.consulta;

public record DadosCancelamentoConsultaDTO(
        Long idConsulta,
        String justificativa
) {
    public DadosCancelamentoConsultaDTO(Consulta consulta) {
        this(consulta.getId(), consulta.getMotivoCancelamento());
    }
}
