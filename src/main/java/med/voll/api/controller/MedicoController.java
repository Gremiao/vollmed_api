package med.voll.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import med.voll.api.domain.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/medicos")
@SecurityRequirement(name = "bearer-key")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    @Transactional
    @Secured({"ROLE_ADMINISTRATOR"})
    public ResponseEntity cadastrarMedico(@RequestBody @Valid DadosCadastroMedicoDTO dados, UriComponentsBuilder uriBuilder ) {
        var medico = new Medico(dados);
        medicoRepository.save(medico);
        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoMedicoDTO(medico));
    }

    @GetMapping()
    @Secured({"ROLE_USER","ROLE_ADMINISTRATOR"})
    public ResponseEntity<Page<DadosListagemMedicoDTO>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        var page = medicoRepository.findAllByAtivoTrue(paginacao).map(DadosListagemMedicoDTO::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualzarCadastroMedico(@RequestBody @Valid DadosAtualizacaoMedicoDTO dados){
        var medico = medicoRepository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoMedicoDTO(medico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluirMedico(@PathVariable Long id){
        var medico = medicoRepository.getReferenceById(id);
        medico.excluir();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @Secured({"ROLE_USER","ROLE_ADMINISTRATOR"})
    public ResponseEntity detalhar(@PathVariable Long id){
        var medico = medicoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoMedicoDTO(medico));
    }
}
