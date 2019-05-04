package br.com.gilmarioarantes.jdbccrudv1.persistencia.dml.inclusao;

import br.com.gilmarioarantes.jdbccrudv1.model.Professor;
import br.com.gilmarioarantes.jdbccrudv1.util.GeraListaProfessores;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class PersisteProfessorTeste {

    Logger logger = Logger.getLogger(PersisteProfessorTeste.class.getName());

    @Test
    public void persisteProfessorTest() {

        logger.info("Executando o método persisteProfessorTest() da classe: " + this.getClass().getSimpleName());

        List<Professor> professores = GeraListaProfessores.geraLista();

        logger.info("Quantidade de Professores na Lista: " + professores.size());

        boolean result = false;

        try {
            for (Professor professor : professores) {
                result = new PersisteProfessor().persisteProfessor(professor);
            }
        } catch (Exception e) {
            logger.error("Erro ao persistir o professor", e);
        }
        Assert.assertTrue(result);
    }

    @Test
    public void adicionarProfessor() {
        boolean result = false;

        try {
            Professor professor = new Professor();
            professor.setId(100L);
            professor.setEmail("email@email.com");
            professor.setNome("Carlos D.");
            professor.setTitulacao("Master");

            result = new PersisteProfessor().persisteProfessor(professor);
        } catch (Exception e) {
            logger.error("Erro ao persistir a disciplina!", e);
        }
        Assert.assertTrue(result);

    }
}
