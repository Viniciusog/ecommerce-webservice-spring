package com.viniciusogbr.webservice.resources;

import com.viniciusogbr.webservice.entities.User;
import com.viniciusogbr.webservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.ServletRequestParameterPropertyValues;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> users = userService.findAll();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User user) {
       User u = userService.insert(user);
       //Envia 201 para quando inserir um usuário com sucesso
       //Cria em Headers da requisição, o valor de 'Location', que mostra o local do usuário inserido
       URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
               .buildAndExpand(u.getId()).toUri();
       return ResponseEntity.created(uri).body(u);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        //Retorna uma requisição sem conteúdo, apenas para mostrar que deletou com sucesso
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj) {
        //obj no parâmetro é o usuário atualizado
        //Já o obj abaixo vem da confirmação da atualização no banco de dados
        obj = userService.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
