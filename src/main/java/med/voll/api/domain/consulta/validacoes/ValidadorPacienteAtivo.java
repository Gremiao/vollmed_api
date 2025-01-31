package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.consulta.DadosAgendamentoConsultaDTO;
import med.voll.api.domain.domain.ValidacaoException;
import med.voll.api.domain.paciente.PacienteRespository;

public class ValidadorPacienteAtivo {

    private PacienteRespository pacienteRespository;

    public void validar(DadosAgendamentoConsultaDTO dados){
        if(pacienteRespository.findAtivoById(dados.idPaciente())){
            throw new ValidacaoException("Consulta não pode ser agendada com paciente excluído");
        }
    }
}
