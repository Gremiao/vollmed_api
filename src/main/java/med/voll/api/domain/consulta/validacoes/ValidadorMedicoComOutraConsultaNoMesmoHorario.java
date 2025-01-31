package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosAgendamentoConsultaDTO;
import med.voll.api.domain.domain.ValidacaoException;

public class ValidadorMedicoComOutraConsultaNoMesmoHorario {

    private ConsultaRepository consultaRepository;

    public void validar(DadosAgendamentoConsultaDTO dados){
        if(consultaRepository.existsByMedicoIdAndData(dados.idMedico(),dados.data())){
            throw new ValidacaoException("Médico já possui outra consulta nesse mesmo horário");
        }
    }
}
