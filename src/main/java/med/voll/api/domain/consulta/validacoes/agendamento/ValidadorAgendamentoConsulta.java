package med.voll.api.domain.consulta.validacoes.agendamento;

import med.voll.api.domain.consulta.DadosAgendamentoConsultaDTO;

public interface ValidadorAgendamentoConsulta {

    void validar(DadosAgendamentoConsultaDTO dados);
}
