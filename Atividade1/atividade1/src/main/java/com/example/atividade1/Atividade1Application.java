package com.example.atividade1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.atividade1.models.Aluno;
import com.example.atividade1.models.Curso;
import com.example.atividade1.repositories.AlunoRepository;
import com.example.atividade1.repositories.CursoRepository;

@SpringBootApplication
public class Atividade1Application implements CommandLineRunner {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    public static void main(String[] args) {
        SpringApplication.run(Atividade1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Inserir dois cursos
        Curso curso1 = cursoRepository.salvar(new Curso(null, "Java", "Curso de Java"));
        Curso curso2 = cursoRepository.salvar(new Curso(null, "Spring", "Curso de Spring"));

        // Inserir dois alunos
        alunoRepository.salvar(new Aluno(null, "João", 20, curso1));
        alunoRepository.salvar(new Aluno(null, "Maria", 22, curso2));

        // Exibir todos os cursos
        System.out.println("Cursos:");
        cursoRepository.listar().forEach(System.out::println);

        // Exibir todos os alunos
        System.out.println("Alunos:");
        alunoRepository.listar().forEach(System.out::println);
    }
}