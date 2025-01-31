package med.voll.api.domain.consulta.validacoes.agendamento;

import med.voll.api.domain.consulta.DadosAgendamentoConsultaDTO;
import med.voll.api.domain.domain.ValidacaoException;
import med.voll.api.domain.paciente.PacienteRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteAtivo implements ValidadorAgendamentoConsulta{

    @Autowired
    private PacienteRespository pacienteRespository;

    public void validar(DadosAgendamentoConsultaDTO dados){
        if(!pacienteRespository.findAtivoById(dados.idPaciente())){
            throw new ValidacaoException("Consulta não pode ser agendada com paciente excluído");
        }
    }
}
