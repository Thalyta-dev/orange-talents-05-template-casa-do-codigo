package br.com.zup.CasaDoCodigo;

import br.com.zup.CasaDoCodigo.Autor.Autor;
import br.com.zup.CasaDoCodigo.Autor.AutorRepository;
import br.com.zup.CasaDoCodigo.Autor.AutorRequest;
import br.com.zup.CasaDoCodigo.Categoria.Categoria;
import br.com.zup.CasaDoCodigo.Categoria.CategoriaRepository;
import br.com.zup.CasaDoCodigo.Categoria.CategoriaRequest;
import br.com.zup.CasaDoCodigo.livro.Livro;
import br.com.zup.CasaDoCodigo.livro.LivroRepository;
import br.com.zup.CasaDoCodigo.livro.LivroRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@AutoConfigureDataJpa
class CasaDoCodigoApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	private LivroRepository livroRepository ;

	@Autowired
	private AutorRepository autorRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	ObjectMapper objectMapper;

	@Test
	void deveRetornaLivroPeloTitulo() {

		Optional<Livro>  livroBuscado = livroRepository.findByTitulo("O bicho vai pegar");
		Assertions.assertEquals("O bicho vai pegar", livroBuscado.get().getTitulo());

	}

	@Test
	void nãoDeveRetornarLivroBuscado(){

		Optional<Livro>  livroBuscado = livroRepository.findByTitulo("O bicho vai pegar");
		Assertions.assertNotEquals("O bicho vai não pegar", livroBuscado.get().getTitulo());

	}

	@Test
	@Rollback
	@Transactional
	void deveRetornarAutor() throws Exception {

		String json = CriacaoJson(new AutorRequest("Thalyta", "thalyta@gmail.com", "Olá" ));

		mockMvc.perform(post("/autores")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json))
				.andExpect(status().isOk());

		Optional<Autor> autor = autorRepository.findByNome("Thalyta");


		Assertions.assertAll(
				() -> Assertions.assertEquals(autor.get().getNome(), "Thalyta"),
				() -> Assertions.assertEquals(autor.get().getDescricao(), "Olá")
		);

	}

	@Test
	void deveRetornarCategoria() throws Exception {

		String json = CriacaoJson(new CategoriaRequest("Terrorhuhuhuu"));

		mockMvc.perform(post("/categorias")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json))
				.andExpect(status().isOk());

	}

	@Test
	void deveRetornarUmLivro() throws Exception {

		String json = CriacaoJson(new LivroRequest("Livro teste", "Este é um livro de teste", "Olá" , "983493989yeihfifu89w84", 200, 30.0, new Date(), 1L, 1L));

		mockMvc.perform(post("/livros")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json))
				.andExpect(status().isOk());

	}
	private String CriacaoJson(Object autorRequest) throws JsonProcessingException {
		return objectMapper.writeValueAsString(autorRequest);
	}


}
