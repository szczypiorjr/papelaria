package br.org.szczypiorjr.papelaria.pagamentos.backend.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.szczypiorjr.papelaria.pagamentos.backend.dto.PagamentoDTO;
import br.org.szczypiorjr.papelaria.pagamentos.backend.facade.PagamentoFacade;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoApi {
    @Autowired private PagamentoFacade pagamentoFacade;

    @PostMapping
    public String processar (@RequestBody PagamentoDTO request) {
        return pagamentoFacade.solicitarPagamento(request);
    }

}
