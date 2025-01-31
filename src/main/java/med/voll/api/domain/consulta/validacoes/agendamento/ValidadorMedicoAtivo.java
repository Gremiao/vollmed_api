package med.voll.api.domain.consulta.validacoes.agendamento;

import med.voll.api.domain.consulta.DadosAgendamentoConsultaDTO;
import med.voll.api.domain.domain.ValidacaoException;
import med.voll.api.domain.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoAtivo implements ValidadorAgendamentoConsulta{

    @Autowired
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
