📊 Sudoku Solver em Java - Documentação Completa
🧩 O que é Sudoku?
Sudoku é um jogo de lógica japonesa onde o objetivo é preencher uma grade 9x9 com números de 1 a 9, seguindo três regras básicas:

Nenhuma repetição em linhas

Nenhuma repetição em colunas

Nenhuma repetição nas sub-grades 3x3 (chamadas de "regiões" ou "caixas")

O tabuleiro começa com algumas células preenchidas (dicas) e o jogador deve completar o resto. Existem diferentes níveis de dificuldade, dependendo da quantidade de números iniciais.

🚀 Sobre o Projeto
Este Sudoku Solver é um programa em Java que resolve automaticamente quebra-cabeças Sudoku usando o algoritmo de backtracking (retrocesso). Ele foi desenvolvido como um projeto educacional para demonstrar:

Como aplicar conceitos de recursão

Técnicas de resolução de problemas com restrições

Boas práticas de programação em Java

🔧 Como o Projeto foi Desenvolvido?
Linguagem: Java 8+ (sem dependências externas)

Abordagem: Algoritmo de backtracking otimizado

Estrutura:

SudokuSolver: Classe principal com a lógica de resolução

BoardUtils: Utilitários para manipulação do tabuleiro

Main: Classe de entrada com exemplos prontos

Testes: Inclui testes unitários para validar a solução

⚙️ Como Rodar o Projeto?
Pré-requisitos:
JDK 8+ instalado

Git (opcional)

Passo a Passo:
Clone o repositório:

bash
git clone https://github.com/PedroBRB/Sudoku.git
cd Sudoku
Compile e execute:

bash
javac src/main/java/br/com/pedrobrb/sudoku/*.java -d target/classes
java -cp target/classes br.com.pedrobrb.sudoku.Main
Saída esperada:

text
Tabuleiro inicial:
5 3 0 |0 7 0 |0 0 0 
6 0 0 |1 9 5 |0 0 0 
0 9 8 |0 0 0 |0 6 0 
------+-------+------
8 0 0 |0 6 0 |0 0 3 
4 0 0 |8 0 3 |0 0 1 
7 0 0 |0 2 0 |0 0 6 
------+-------+------
0 6 0 |0 0 0 |2 8 0 
0 0 0 |4 1 9 |0 0 5 
0 0 0 |0 8 0 |0 7 9 

Solução encontrada:
5 3 4 |6 7 8 |9 1 2 
6 7 2 |1 9 5 |3 4 8 
1 9 8 |3 4 2 |5 6 7 
------+-------+------
8 5 9 |7 6 1 |4 2 3 
4 2 6 |8 5 3 |7 9 1 
7 1 3 |9 2 4 |8 5 6 
------+-------+------
9 6 1 |5 3 7 |2 8 4 
2 8 7 |4 1 9 |6 3 5 
3 4 5 |2 8 6 |1 7 9 
🎯 Para que Serve o Projeto?
Resolução automática de Sudoku: Basta inserir o tabuleiro inicial e o programa encontra a solução.

Fins educacionais: Ideal para aprender:

Algoritmos de backtracking

Recursão em Java

Manipulação de matrizes

Base para projetos maiores: Pode ser integrado em:

Aplicativos mobile de Sudoku

Geradores de tabuleiros

Ferramentas de aprendizado de lógica

📚 O que Podemos Aprender com Este Projeto?
Conceitos Chave:
✔ Backtracking:

Técnica de "tentativa e erro" que retrocede quando encontra um caminho inválido.

✔ Recursão:

A função solve() chama a si mesma para explorar possibilidades.

✔ Validação de Restrições:

Verifica se um número é válido em determinada posição.

✔ Manipulação de Matrizes:

Como percorrer e modificar grades 2D eficientemente.

✔ Boas Práticas em Java:

Organização de classes

Métodos estáticos para utilitários

Classe separada para testes

Exemplo de Código Educativo:
java
// Método principal de resolução (SudokuSolver.java)
public boolean solve() {
    for (int row = 0; row < 9; row++) {
        for (int col = 0; col < 9; col++) {
            if (board[row][col] == 0) {  // Célula vazia
                for (int num = 1; num <= 9; num++) {
                    if (isValidPlacement(row, col, num)) {
                        board[row][col] = num;
                        if (solve()) {  // Chamada recursiva
                            return true;
                        }
                        board[row][col] = 0; // Backtrack
                    }
                }
                return false;
            }
        }
    }
    return true; // Tabuleiro completo
}
🌟 Próximos Passos (Para Evoluir o Projeto)
Interface Gráfica: Adicionar GUI com JavaFX ou Swing

Gerador de Tabuleiros: Criar puzzles aleatórios com níveis de dificuldade

Solução Passo a Passo: Mostrar o processo de resolução animado

Input de Usuário: Ler tabuleiros de arquivos ou entrada manual

🤝 Como Contribuir?
Contribuições são bem-vindas! Siga estes passos:

Faça um fork do projeto

Crie sua branch (git checkout -b minha-melhoria)

Commit suas mudanças (git commit -m 'Adiciona feature X')

Push para a branch (git push origin minha-melhoria)

Abra um Pull Request

📄 Licença
Distribuído sob licença MIT. Consulte o arquivo LICENSE para detalhes.
