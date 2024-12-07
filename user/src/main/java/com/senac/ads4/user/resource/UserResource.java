package com.senac.ads4.user.resource;

import com.senac.ads4.user.dto.UserDto;
import com.senac.ads4.user.interfaces.IResource;
import com.senac.ads4.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(value = "api/users")
@Tag(name = "User API", description = "API para gerenciamento de user")
public class UserResource implements IResource<UserDto, Integer> {

    @Autowired
    public UserService userService;

    /**
     * Mètodo para criar T
     *
     * @param entity
     * @return
     */
    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    @Operation(summary = "Criação de um novo user", description = "Endpoint para criação de user", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User criado com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválidos"),
            @ApiResponse(responseCode = "400", description = "Parâmetros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao criar o user")
    })
    public UserDto create(@RequestBody UserDto entity) {
        log.info("UserResource::create");
        return userService.create(entity);
    }

    /**
     * Método para consultar T baseado no identificador N informado
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    @Operation(summary = "Busca user pelo ID", description = "Busca um user específico baseado no ID informado", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "User não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro ao buscar o User")
    })
    public UserDto get(@PathVariable Integer id) {
        log.info("UserResource::get(id)");
        return userService.read(id);
    }

    /**
     * Retorna uma lista de T
     *
     * @return
     */
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    @Override
    @Operation(summary = "Busca todos os users", description = "Busca todos os users cadastrados", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Users encontrados com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao buscar os users")
    })
    public List<UserDto> get() {
        log.info("UserResource::get()");
        return userService.read();
    }

    /**
     * Iremos passar N(id) para buscar o registro e T(entity) para atualizar o objeto;
     *
     * @param id
     * @param entity
     * @return
     */
    @PutMapping(value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    @Operation(summary = "Atualiza um user", description = "Atualiza um user com base no ID informado", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "User não encontrado"),
            @ApiResponse(responseCode = "400", description = "Parâmetros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao atualizar o User")
    })
    public UserDto update(@PathVariable Integer id, @RequestBody UserDto entity) {
        log.info("UserResource::update(id,entity)");
        return userService.update(id, entity);
    }

    /**
     * Deleta um registro com base no identificador N(id)
     *
     * @param id
     */
    @DeleteMapping(value = "/{id}")
    @Override
    @Operation(summary = "Deleta um user", description = "Deleta um user com base no ID informado", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "User não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro ao deletar o user")
    })
    public void delete(@PathVariable Integer id) {
        log.info("UserResource::delete(id)");
        userService.delete(id);

    }
}
