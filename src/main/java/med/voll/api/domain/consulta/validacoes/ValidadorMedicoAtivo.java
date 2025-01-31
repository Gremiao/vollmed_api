package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.consulta.DadosAgendamentoConsultaDTO;
import med.voll.api.domain.domain.ValidacaoException;
import med.voll.api.domain.medico.MedicoRepository;

public class ValidadorMedicoAtivo {

    private MedicoRepository medicoRepository;

    public void validar(DadosAgendamentoConsultaDTO dados){
        if(dados.idMedico() == null){
            return;
        }
        if(!medicoRepository.findAtivoById(dados.idMedico())){
            throw new ValidacaoException("Consulta não pode ser agendada com médico excluído");
        }
    }
}
