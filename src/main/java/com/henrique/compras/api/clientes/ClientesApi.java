package com.henrique.compras.api.clientes;

import com.henrique.compras.api.response.ClienteFielDto;
import com.henrique.compras.api.response.ProdutoDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
@Tag(name = "Compras")
public interface ClientesApi {

  @GetMapping("/clientes-fieis")
  @Operation(summary = "Busca top 3 clientes fieis.",
      responses = {
          @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
          @ApiResponse(responseCode = "400", description = "Campos com valores inválidos", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
          @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
      }
  )
  List<ClienteFielDto> getClientesFieis();

  @GetMapping("/recomendacao/{clienteCpf}/tipo")
  @Operation(summary = "Retorna uma recomendação de vinho para o cliente referido.",
      responses = {
          @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
          @ApiResponse(responseCode = "400", description = "Campos com valores inválidos", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
          @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
      }
  )
  ProdutoDto getRecomendacaoVinho(@Valid @PathVariable String clienteCpf);

}
