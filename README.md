# Sistema Acadêmico — Orientado a Objetos em Java

## Como rodar o projeto

### Pré-requisitos
- Java JDK 11 ou superior instalado
- Terminal (Linux/macOS) ou Prompt de Comando (Windows)

### Passos

1. Extraia o arquivo compactado e entre na pasta do projeto:
```bash
cd SistemaAcademico
```

2. Compile todos os arquivos `.java`:
```bash
javac -d out $(find src -name "*.java")
```
> No Windows (CMD), use: `javac -d out src\br\edu\instituicao\interfaces\*.java src\br\edu\instituicao\model\*.java src\br\edu\instituicao\service\*.java src\br\edu\instituicao\main\*.java`

3. Execute o programa:
```bash
java -cp out br.edu.instituicao.main.Main
```

---

## Por que `Pessoa` foi definida como abstrata?

A classe `Pessoa` foi definida como abstrata porque ela representa um conceito genérico e incompleto: não existe, no contexto do sistema, um indivíduo que seja "apenas uma Pessoa" sem ser especificamente um Aluno, Professor ou Coordenador. Torná-la abstrata impede que seja instanciada diretamente com `new Pessoa()`, garantindo que apenas subclasses concretas e bem definidas sejam utilizadas. Isso reforça o princípio da abstração em POO, onde a classe base serve como um molde comum — centralizando atributos compartilhados como `nome`, `cpf` e `email` — enquanto delega as particularidades para as classes filhas.

---

## Exemplo de saída do console

```
========================================
     SISTEMA ACADÊMICO - MENU           
========================================
  1. Cadastrar Aluno
  2. Cadastrar Professor / Coordenador
  3. Lançar Notas de Aluno
  4. Listar Comunidade Acadêmica
  5. Exibir Estatísticas (Média Geral)
  6. Acesso Administrativo (Login)
  7. Sair
========================================
Escolha uma opção: 1

--- CADASTRAR ALUNO ---
Nome: Maria Silva
CPF: 123.456.789-00
Email: maria@email.com
Matrícula: 2024001
Aluna Maria Silva cadastrada com sucesso!

Escolha uma opção: 3

--- LANÇAR NOTAS ---
Digite matrícula ou nome do aluno: 2024001
Aluno encontrado: Maria Silva
Quantas notas deseja lançar? 3
Nota 1 (0-10): 8.5
Nota 8.5 adicionada com sucesso para Maria Silva.
Nota 2 (0-10): 7.0
Nota 7.0 adicionada com sucesso para Maria Silva.
Nota 3 (0-10): 9.0
Nota 9.0 adicionada com sucesso para Maria Silva.

Escolha uma opção: 5

--- ESTATÍSTICAS ---
========================================
       RELATÓRIO ACADÊMICO              
========================================
  Total de alunos avaliados: 1
  Média Geral da Instituição: 8,17
========================================

Escolha uma opção: 6

--- ACESSO ADMINISTRATIVO ---
SIAPE do professor/coordenador: 54321
Senha: senha123
Login realizado com sucesso! Bem-vindo(a), João Costa.
Tipo: Coordenador | Horas de atividade: 30h
```

---

## Estrutura do Projeto

```
SistemaAcademico/
└── src/
    └── br/edu/instituicao/
        ├── interfaces/
        │   ├── Avaliavel.java
        │   └── Autenticavel.java
        ├── model/
        │   ├── Pessoa.java       (abstrata)
        │   ├── Aluno.java
        │   ├── Professor.java
        │   └── Coordenador.java
        ├── service/
        │   ├── Secretaria.java
        │   └── RelatorioAcademico.java
        └── main/
            └── Main.java
```

## Conceitos de POO aplicados

| Conceito | Onde é aplicado |
|---|---|
| Abstração | Classe `Pessoa` é abstrata |
| Herança | `Aluno` e `Professor` herdam de `Pessoa`; `Coordenador` herda de `Professor` |
| Encapsulamento | Todos os atributos são `private` com getters/setters |
| Polimorfismo | `RelatorioAcademico` usa `Avaliavel`; `getHorasAtividade()` sobrescrito em `Coordenador` |
| Interfaces | `Avaliavel` e `Autenticavel` definem contratos de comportamento |
