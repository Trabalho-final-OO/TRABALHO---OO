## UnB - Universidade de Brasilia
## FGA - Faculdade do Gama
## OO - Orientação por Objetos
## Prof. André Luiz Peron Martins Lanna
## Trabalho Prático de Orientação por Objetos

## Descrição

O objetivo deste trabalho prático é aplicar os conceitos fundamentais de Orientação por Objetos (OO), em especial os conceitos de Herança e Polimorfismo, no contexto de um sistema de gestão acadêmico. Utilizando o cenário descrito abaixo e o conjunto de classes presentes nesse diretório (como ponto de partida para o trabalho), os grupos de quatro alunos deverão implementar um sistema em Java que explore ao máximo os conceitos de Orientação por Objetos.


## Diagrama UML








![UML - TRAB OO](https://github.com/user-attachments/assets/3c3a30bb-2d50-4f46-9c99-efd3b3743a95)






## Cenário 
Um sistema de gestão acadêmica é responsável, basicamente, por realizar o cadastro de todos os elementos pertencentes ao domínio de uma universidade. Por exemplo, o sistema é responsável por cadastrar todos os alunos e professores, todas as disciplinas, todas as turmas de cada disciplina e, por fim, todas as salas de aulas.

Esse sistem deve também ser capaz de criar turmas para cada disciplina e, para cada turma, deve ser capaz de associar um professor e matricular os alunos, ambos já existentes no cadastro. Para cada turma, o sistema deverá ser capaz de imprimir a lista de presença que contenha, obrigatoriamente, o nome da disciplina, o nome do professor daquela turma, o código da turma e a lista de alunos (matricula e nome) matriculados.

O sistema deverá ainda ser capaz de impedir o cadastro de elementos do domínio que tenham valores em branco para qualquer um de seus atributos. Nesses casos deverá lançar uma exceção do tipo "CampoEmBrancoException", em que na mensagem do objeto de exceção seja informado qual o campo que ficou em branco. Com relação às turmas, essas não poderão serem cadastradas se não tiver uma disciplina e / ou um professor associado. Nesses casos deverão ser lançadas as exceções "DisciplinaNaoAtribuidaException" e "ProfessorNaoAtribuidoException", respectivamente.


### Integrantes:

|Foto|Nome|Matrícula|
|:-|:-|:-|
|<img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/144184007?v=4" width="150px;"/>|[GABRIEL SANTOS PINTO](https://github.com/GabrielSPinto)|222037675|
|<img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/164926129?v=4" width="150px;"/>|[GUILHERME AUGUSTO RODRIGUES DE SA](https://github.com/GuizinDeSa)|222006759|
|<img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/124108334?v=4" width="150px;"/>|[GUILHERME FERREIRA BRANDAO](https://github.com/Guibs969)|231030691|
|<img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/173406776?v=4" width="150px;"/>|[PEDRO ARAUJO LUCENA](https://github.com/PedroAraujo004)|222007077|
