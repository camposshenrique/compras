package com.henrique.compras.api.compras;

import com.henrique.compras.api.response.CompraDto;
import com.henrique.compras.api.response.ProdutoDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
@Tag(name = "Compras")
public interface ComprasApi {


  @PostMapping("/preencher-dados")
  @Operation(summary = "Preenche todos os dados de acordo com o mock")
  void iniciate();

  @GetMapping("/compras")
  @Operation(summary = "Busca todas as compras ordenando de forma crescente de acordo com o valor total da compra.",
      responses = {
          @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
          @ApiResponse(responseCode = "400", description = "Campos com valores inválidos", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
          @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
      }
  )
  List<CompraDto> getAllCompras();

  @GetMapping("/maior-compra/{anoCompra}")
  @Operation(summary = "Busca a maior compra do ano indicado.",
      responses = {
          @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
          @ApiResponse(responseCode = "400", description = "Campos com valores inválidos", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
          @ApiResponse(responseCode = "500", description = "Erro interno do servidor", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
      }
  )
  CompraDto getMaiorCompraAno(@Valid @PathVariable int anoCompra);

}
