package med.voll.api.domain.consulta.validacoes.cancelamento;

import med.voll.api.domain.consulta.DadosCancelamentoConsultaDTO;

public interface ValidadorCancelamentoConsulta {

    void validarCancelamento(DadosCancelamentoConsultaDTO dados);
}
