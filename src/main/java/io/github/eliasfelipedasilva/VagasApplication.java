package io.github.eliasfelipedasilva;

import io.github.eliasfelipedasilva.domain.entity.Aplicada;
import io.github.eliasfelipedasilva.domain.entity.Usuario;
import io.github.eliasfelipedasilva.domain.entity.Vaga;
import io.github.eliasfelipedasilva.domain.repository.Aplicadas;
import io.github.eliasfelipedasilva.domain.repository.Usuarios;
import io.github.eliasfelipedasilva.domain.repository.Vagas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class VagasApplication {


  @Bean
  public CommandLineRunner init(@Autowired Usuarios usuarios, @Autowired Vagas vagas, @Autowired Aplicadas aplicadas){
      return  args -> {
          System.out.println("Salvando usuarios");
          Usuario usuario = new Usuario();
          usuario.setNome("Elias");
          usuario.setCpf(111231555);
          usuario.setEmail("elias@elias");
          usuario.setSenha("1234");
          usuario.setArea_atual("adsasdas");
          usuario.setCargo_atual("asdasdasd");
          usuarios.save(usuario);




          Vaga v = new Vaga();
          v.setCargo_vaga("Pedreiro");
          v.setData_vencimento_vaga("22323");
          v.setDescricao_vaga("asdasdasd");
          v.setLocacao_vaga("asdasdasd");
          v.setStatus_vaga("asdasd");
          v.setTipo_vaga("asdas");
          vagas.save(v);

          Aplicada a = new Aplicada();
          a.setData_aplicacao("12/12/12");
          a.setCpf_usuario(usuario.getCpf());
          a.setId_vaga(v.getId_vaga());
          aplicadas.save(a);

//          Aplicada a = new Aplicada();
////          a.setCpf_usuario(usuario2.getCpf());
////          a.setId_vaga(v.getId_vaga());
//          a.setData_aplicacao("31/22/22");

//            List<Usuario> todosUsuarios =  usuarios.findAll();
//            todosUsuarios.forEach(System.out::println);

//          System.out.println("Atualizandp usuarios");
//            todosUsuarios.forEach(u -> {
//                u.setNome(u.getNome()+ " atualziado");
//                usuarios.save(u);
//            });
//
//          todosUsuarios =  usuarios.findAll();
//          todosUsuarios.forEach(System.out::println);


          List<Usuario> result =  usuarios.findByNomeLike("Felipess");
          result.forEach(System.out::println);

//
//          System.out.println("Deletando usuario");
//          usuarios.findAll().forEach(c -> {
//              usuarios.delete(c);
//          });
//
//          todosUsuarios =  usuarios.findAll();
//          if(todosUsuarios.isEmpty()){
//              System.out.println("nenhum usuario encontrado");
//          }else {
//              todosUsuarios.forEach(System.out::println);
//          }
//
//


      };
  }


    public static void main(String[] args) {
        SpringApplication.run(VagasApplication.class, args);
    }

}
