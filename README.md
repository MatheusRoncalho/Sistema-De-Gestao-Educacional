Sistema Acadêmico Universitário  
Projeto desenvolvido para fins acadêmicos, utilizando Java, aplicada para modelar um sistema de gestão universitária com alunos, professores, cursos, turmas, avaliações e relatórios.
O objetivo é permitir o cadastro e gerenciamento básico das entidades principais de uma instituição de ensino.
----
Estrutura do projeto
model/
repository/
service/
ui/
Main.java
----
Descrição Geral
O sistema permite:
- Cadastro de cursos, alunos, professores e turmas
- Autenticação de usuários (aluno e professor)
- Atribuição de avaliações para alunos matriculados
- Geração de relatórios utilizando polimorfismo
- Armazenamento temporário via listas em memória (simulando banco de dados)
- Organização em camadas seguindo boas práticas de engenharia de software
----
Funcionalidades

Cursos:
- Cadastrar um curso EAD ou presencial
- Buscar curso por código
- Validação de duplicidade
  
Professores:
- Cadastrar professor
- Buscar professor por registro
- Associar a turma
  
Alunos:
- Cadastrar aluno
- Buscar aluno por matrícula
- Matrícula em turmas
- Recebimento de avaliações
  
Turmas:
- Criar turma vinculada a curso e professor
- Matricular aluno na turma
  
Avaliações:
- Registrar nota de um aluno em uma turma

Relatórios:
- Cada entidade implementa um método para gerar relatórios
- Relatórios polimórficos listados via interface
----
Como executar
Clone o repositório:
- git clone https://github.com/seu-usuario/seu-projeto.git
Compile:
- javac Main.java
Execute:
- Java main
